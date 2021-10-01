import React, { useState, useEffect } from 'react'
import "./submissions.css"
import { app, storage, db } from "../firebase-config"
import { getStorage, ref, uploadBytes, getDownloadURL } from "firebase/storage";
import { doc, setDoc, getDocs, collection } from "firebase/firestore";

export default function Submissions() {

    const [Submissions, setSubmissions] = useState([])

    // to fetch all the submissions from the firestore
    useEffect(() => {
        const fetchUsers = async () => {
          const SubmissionCollection = await getDocs(collection(db, "submissions"));
          setSubmissions(SubmissionCollection.docs.map(doc => {
            return doc.data()
          }))
          console.log(SubmissionCollection);
        }
        fetchUsers()
      }, [])


    return (
        <div className="Submissions-body">
            <h3 className="heading">All Submissions</h3>
            {
               Submissions.map((item) => {
                   return (
                       <div className="collection" key={item.number}>
                           <h6><span className="sub">Name:</span> {item.CandidateName}</h6>
                           <h6><span className="sub">Email:</span> {item.Email}</h6>
                           <h6><span className="sub">Mobile Number:</span> {item.MobileNumber}</h6>
                           <h6><span className="sub">College:</span> {item.College}</h6>
                           <h6><span className="sub">Track:</span> {item.Track}</h6>
                           <h6><span className="sub">Assignment Link:</span> <a href={item.Assignment} target="_blank">Open Assignment</a></h6>
                       </div>
                   )
               })
            }
        </div>
    )
}