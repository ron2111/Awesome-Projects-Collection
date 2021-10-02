
import firebase from 'firebase';

const firebaseConfig = {
    apiKey: "AIzaSyBr5QCF1rceqjMU6cfl34NxXy3tZGY_1yI",
    authDomain: "to-do-4cd9a.firebaseapp.com",
    projectId: "to-do-4cd9a",
    storageBucket: "to-do-4cd9a.appspot.com",
    messagingSenderId: "1066939250374",
    appId: "1:1066939250374:web:ca6147b593da4ac1b889c7",
    measurementId: "G-H4QJLG5Q4B"
  };
  
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);

  export default firebase;