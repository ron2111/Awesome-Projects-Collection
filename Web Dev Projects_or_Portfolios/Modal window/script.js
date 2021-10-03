'use strict';
const modal = document.querySelector('.modal'); //selector like selector in css to select elements of html
const overlay = document.querySelector('.overlay');
const btnCloseModal = document.querySelector('.close-modal');
const btnsOpenModal = document.querySelectorAll('.show-modal');
console.log(btnsOpenModal);

for (let i = 0; i < btnsOpenModal.length; i++) {
  btnsOpenModal[i].addEventListener('click', function () {
    //"click is a event listner"
    //whenever we click on any of three button it should display the modal
    console.log('Button clicked');
    modal.classList.remove('hidden'); //classes are used to add some elemnts or remove them
    overlay.classList.remove('hidden'); //we are removing hidden class whenever we click on any button
    // modal.style.display = 'block';
  });

  //it is close model function which will be called by javascript internally whenever we click on any "show modal button"
  const closeModal = function () {
    modal.classList.add('hidden');
    overlay.classList.add('hidden');
  };

  //this will close the modal whenever we will click on the cross button
  //or it is just adding the hidden class back
  btnCloseModal.addEventListener('click', closeModal);

  //we can hide the modal by just clicking outside the modal
  overlay.addEventListener('click', closeModal);
}
