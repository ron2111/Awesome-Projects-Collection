package com.example.expansemanager.login
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.expansemanager.R

import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.fragment_firebase_google_login.*

class FirebaseGoogleLoginFragment : Fragment() {


    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }

    private lateinit var auth: FirebaseAuth
    private lateinit var mGoogleSignInClient: GoogleSignInClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        auth = FirebaseAuth.getInstance()

        if (this.auth.currentUser != null) {
            findNavController().navigate(FirebaseGoogleLoginFragmentDirections.actionFirebaseGoogleLoginFragmentToTransactionListFragment())
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
    }


    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        UpdateUI(currentUser)
    }

    private fun UpdateUI(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            findNavController().navigate(FirebaseGoogleLoginFragmentDirections.actionFirebaseGoogleLoginFragmentToTransactionListFragment())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_firebase_google_login, container, false)
    }

    private fun signIn() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val exception = task.exception
            if (task.isSuccessful) {
                try {
                    val account = task.getResult(ApiException::class.java)!!
                    Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                    firebaseAuthWithGoogle(account.idToken!!)
                } catch (e: ApiException) {

                    Log.w(TAG, "Google sign in failed", e)
                }
            } else {
                println("signInActivity ${exception.toString()}")
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    findNavController().navigate(FirebaseGoogleLoginFragmentDirections.actionFirebaseGoogleLoginFragmentToLoginFragment2())
                    Log.d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                } else {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        guest_login.setOnClickListener{
            findNavController().navigate(FirebaseGoogleLoginFragmentDirections.actionFirebaseGoogleLoginFragmentToLoginFragment2())
        }

        buttonuseless.setOnClickListener {
            findNavController().navigate(FirebaseGoogleLoginFragmentDirections.actionFirebaseGoogleLoginFragmentToFirebaseLoginFragment())
        }

        button_sign_in.setOnClickListener {
            signIn()
        }
    }
}