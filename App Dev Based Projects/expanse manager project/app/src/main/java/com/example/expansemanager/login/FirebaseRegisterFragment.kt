package com.example.expansemanager.login

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.expansemanager.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_firebase_register.*


class FirebaseRegisterFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

    }

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        UpdateUI(currentUser)
    }

    private fun UpdateUI(currentUser: FirebaseUser?) {

        if (currentUser != null) {
            findNavController().navigate(FirebaseRegisterFragmentDirections.actionFirebaseRegisterFragmentToLoginFragment())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_firebase_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AlreadyRegistered_buttonID.setOnClickListener {
            findNavController().navigate(FirebaseRegisterFragmentDirections.actionFirebaseRegisterFragmentToFirebaseLoginFragment2())
        }

        register_buttonID.setOnClickListener {
            firebaseEmailRegisterID.error = null
            firebasePasswordRegisterID.error = null

            val email = firebaseEmailRegisterID.editText?.text.toString()
            val pass = firebasePasswordRegisterID.editText?.text.toString()

            if (validateInput(email, pass)) {
                progressBar2_o.visibility = View.VISIBLE

                // authenticating user
                auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                    progressBar2_o.visibility = View.INVISIBLE

                    if (task.isSuccessful) {
                        findNavController().navigate(FirebaseRegisterFragmentDirections.actionFirebaseRegisterFragmentToLoginFragment())
                    } else {
                        val toast = Toast.makeText(
                            requireActivity(),
                            "Authentication failed: ${task.exception?.message}",
                            Toast.LENGTH_LONG
                        )
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                        toast.show()
                    }
                }

            }
        }
    }

    private fun validateInput(email: String, pass: String): Boolean {
        var valid = true
        if (email.isBlank()) {
            firebaseEmailRegisterID.error = "Please enter an email address"
            valid = false
        } else if (pass.length < 8) {
            firebasePasswordRegisterID.error = "Password show 8 character or more"
            valid = false
        }

        return valid
    }

}