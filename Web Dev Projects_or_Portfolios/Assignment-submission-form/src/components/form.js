import React, { useState, useEffect, useRef } from 'react'
import Dropzone from 'react-dropzone';
import "./form.css"
import { app, storage, db } from "../firebase-config"
import { getStorage, ref, uploadBytes, getDownloadURL } from "firebase/storage";
import { doc, setDoc, getDocs, collection } from "firebase/firestore";
import { useHistory } from "react-router-dom";

export default function FormPage() {

    const [file, setFile] = useState(null)
    const [fileUrl, setFileUrl] = useState(null)
    const [disable, setDisable] = useState(true)
    const [loading, setLoading] = useState(false)
    const [user, setUser] = useState({
        name: "",
        email: "",
        number: "",
        college: "",
        track: ""
    });
    const history = useHistory();
    const dropRef = useRef(); // React ref for managing the hover state of droppable area

    // function to get the user details
    const getUserDetails = (e) => {
        const name = e.target.name
        const value = e.target.value
        setUser({ ...user, [name]: value })
    }

    // function to get and upload the file on drop to firebase storage
    const onDrop = async (files) => {
        const [selectedFile] = files;
        await setFile(selectedFile)
        dropRef.current.style.border = '3px solid black';
        setLoading(true)
        const storageRef = ref(storage)
        const fileRef = ref(storageRef, selectedFile.name);
        await uploadBytes(fileRef, selectedFile).then((snapshot) => {
            console.log('Uploaded a file!', selectedFile.name);
        });
        const Url = await getDownloadURL(fileRef)
        setFileUrl(Url)
        setDisable(false)
        console.log(Url);
        setLoading(false)
    };

    const updateBorder = (dragState) => {
        if (dragState === 'over') {
          dropRef.current.style.border = '3px solid #6cb0f0';
        } else if (dragState === 'leave') {
          dropRef.current.style.border = '3px solid black';
        } 
      };

    // function to get and upload the file choosen to firebase storage
    const AddFile = async (e) => {
        const selectedFile = e.target.files[0];
        await setFile(selectedFile)
        setLoading(true)
        const storageRef = ref(storage)
        const fileRef = ref(storageRef, selectedFile.name);
        await uploadBytes(fileRef, selectedFile).then((snapshot) => {
            console.log('Uploaded a file!', selectedFile.name);
        });
        const Url = await getDownloadURL(fileRef)
        setFileUrl(Url)
        setDisable(false)
        console.log(Url);
        setLoading(false)
    }

    // to submit the user details and file url to firestore
    const onSubmit = async (e) => {
        e.preventDefault();
        if (user.name && user.email && user.number && user.college && user.track) {
            await setDoc(doc(db, "submissions", user.name), {
                CandidateName: user.name,
                Email: user.email,
                MobileNumber: user.number,
                College: user.college,
                Track: user.track,
                Assignment: fileUrl
            });
            await history.push('/success')
            setUser({
                name: "",
                email: "",
                number: "",
                college: "",
                track: ""
            })
            setDisable(true)
            setFileUrl(null)
        } else {
            alert("Please enter all fields....")
        }
    }


    return (
        <div className="form-body" >
            <h4 className="heading">Welcome to Hackathon</h4>
            <form className="form" onSubmit={onSubmit}>


                <div className="section-left z-depth-3">
                    <div className="input-field col s11 ">
                        <h6 className="label">Enter your name:</h6>
                        <input type="text" className="validate" placeholder="Name" name="name" value={user.name} onChange={getUserDetails} />
                    </div>
                    <div className="input-field col s11 ">
                        <h6 className="label">Enter your email:</h6>
                        <input type="email" className="validate" placeholder="Email" name="email" value={user.email} onChange={getUserDetails} />
                        <span class="helper-text" data-error="enter a valid email"></span>
                    </div>
                    <div className="input-field col s11 ">
                        <h6 className="label">Enter your Phone Number:</h6>
                        <input type="number" className="validate" placeholder="Number" name="number" value={user.number} onChange={getUserDetails} />
                    </div>
                    <div className="input-field col s11 ">
                        <h6 className="label">Enter your College Name:</h6>
                        <input type="text" className="validate" placeholder="Your Answer" name="college" value={user.college} onChange={getUserDetails} />
                    </div>
                    <div>
                        <h6 className="label">Choose your track:</h6>
                        <p>
                            <label>
                                <input className="with-gap" type="radio" name="track" value="Web Development" onChange={getUserDetails} />
                                <span>Web Development</span>
                            </label>
                        </p>
                        <p>
                            <label>
                                <input className="with-gap" type="radio" name="track" value="Android Development" onChange={getUserDetails} />
                                <span>Android Development</span>
                            </label>
                        </p>
                        <p>
                            <label>
                                <input className="with-gap" type="radio" name="track" value="UI/UX design" onChange={getUserDetails} />
                                <span>UI/UX design</span>
                            </label>
                        </p>
                    </div>
                </div>



                <div className="section-right z-depth-3">

                    <h6 className="label">Submit and upload your assignment here in pdf format:</h6>

                    <div class="file-field input-field row">
                        <div class="btn col s1">
                            <span>File</span>
                            <input type="file" onChange={AddFile} />
                        </div>
                        <div class="file-path-wrapper col s10">
                            <input class="file-path validate" type="text" value={file && file.name} />
                        </div>
                        <div className="preloader-wrapper small active" style={{ display: `${loading ? '' : "none"}` }}>
                            <div class="spinner-layer spinner-green-only">
                                <div class="circle-clipper left">
                                    <div class="circle"></div>
                                </div><div class="gap-patch">
                                    <div class="circle"></div>
                                </div><div class="circle-clipper right">
                                    <div class="circle"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="or"><h5>Or</h5></div>

                    <div className="upload-section">
                        <Dropzone
                            onDrop={onDrop}
                            onDragEnter={() => updateBorder('over')}
                            onDragLeave={() => updateBorder('leave')}
                            className="dropzone">
                            {({ getRootProps, getInputProps }) => (
                                <div {...getRootProps({ className: 'drop-zone' })} ref={dropRef}>
                                    <input {...getInputProps()} />
                                    <p>Drag and drop a file OR click here to select a file</p>
                                    {file && (
                                        <div>
                                            <span>Selected file:</span> {file.name}
                                        </div>
                                    )}
                                </div>
                            )}
                        </Dropzone>
                    </div>

                </div>
            </form>
            <button className={`btn waves-effect waves-light ${disable ? "" : "pulse"} submit-btn`} type="submit" name="action" disabled={disable}
                onClick={onSubmit}>Submit
                <i className="material-icons right">send</i>
            </button>
        </div>
    )
}