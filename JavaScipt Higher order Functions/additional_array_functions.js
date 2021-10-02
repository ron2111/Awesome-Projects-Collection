const arr = ['raj', 'mahesh', 'sheetal', 'shita', 'suresh'];
const arr1 = ['1', '2', '3'];


// Array concat()
// The concat() method does not change the existing arrays, 
// but returns a new array, containing the values of the joined arrays
// this will returns a new array, containing the values of the joined arrays
const concat_arr = arr.concat(arr1);
console.log(concat_arr);

//this will concat same array 3 times
const self_concat = arr1.concat(arr1, arr1, arr1);
console.log('string array', self_concat);
//this give convert string to integer 
console.log('integer array', self_concat.map(Number));
console.log("assign direct value to concat function");
console.log(arr1.concat("we can add manually values like this too"));


// Array.copyWithin()
// This method will never add more items to the array and overwrites the original array.
const arr2 = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"];
//it will remove 3,4,5 form 3th position
console.log(arr2.copyWithin(2, 5));


//Array entries()
const fruits = ["Banana", "Orange", "Apple", "Mango"];
const f = fruits.entries();
console.log("\nfrom entries function\n");
for (let x of f)
    console.log(x);

//above thing can be acheve by doing the below code
console.log("\nFrom map method\n");
const ff = fruits.map((x, list) => Object.values({ list, x }));
ff.forEach(x => console.log(x));


//Array.every()
// returns true if all elements in an array pass a test (provided as a function)
const ages = [32, 33, 16, 40];
console.log("\nfrom every method", ages.every(checkAge => checkAge >= 18));   // Returns false
//above thing can be acheve by find method
let temp = ages.find(x => x <= 18);
temp = !temp ? true : false;
console.log("\nfrom find method", temp);    // Returns false


//Array.fill()
// Syntax array.fill(value, start, end)
// Array will be overwrite 
//if start and end isn't provided it will apply to all the elements
const arr4 = ['1', '2', '3', '4', '5'];
const arr3 = arr4.fill('111');
console.log('\nMain arr4', arr4, '\narr3 from fill', arr3);
console.log('\nwhen start=>1 and end=>-1 fill=123\n', arr4.fill('123', 1, -1));


//Array filter()
//creates an array filled with all array elements that pass a test 
//does not change the original array.
console.log('\nfrom this array below age 18 will removed\n', ages, '\nFiltered array\n', ages.filter(x => x >= 18));


//Array find()
//returns the single value of the array element that passes a test
//find() does not change the original array
const women_data = [
    { name: "jaya", isMarried: false },
    { name: 'sustima', isMarried: true },
    { name: 'rekha', isMarried: true },
    { name: 'rahima', isMarried: false }
];
const Married_woman_data = women_data.find(x => x.isMarried === true);
//this is fecth the first matching condition from array
console.log(`\n${Married_woman_data.name} is married (${Married_woman_data.isMarried})`);


//Array findIndex()
//returns the single result of index which value pass the test
console.log("\nProvided array\n", ages);
console.log('the index of array where value is 33 is ', ages.findIndex(x => x === 33));


//Array for each
//return the array once for each element in an array, in order
const numbers = [65, 44, 12, 4];
console.log('\nArray before Foreach', numbers)
numbers.forEach((x, list, arr) => arr[list] = (x * 10));
console.log('Array after Foreach', numbers);


//Array.from()
//create an array from a str
const str = 'we can win a game!';
const arr5 = Array.from(str);
//it will convert str to array
console.log(arr5);


//Array includes()
// method returns true if an array contains a specified element, otherwise false
//includes() is case sensitive
const search_val = 'Banana';
console.log('required array', fruits);
console.log('will search for', search_val, fruits.includes(search_val), '\n');


//Array indexOf()
//searches an array for a specified item and returns its position(index)
//Syntax array.indexOf(item, start)
//returns -1 if the item is not found.
const search_index = 'Mango';
console.log('required array', fruits);
console.log('will return index of', search_index, ' is', fruits.indexOf(search_index));


//Array splice()
//Syntax array.splice(index, howmany, item1, ....., itemX)
console.log("\nremove int 3 and add string '3'")
const arr_ = ['1', '2', 3, '4', '5'];
console.log("\nbefore splice", arr_);
arr_.splice(2, 1, '3');
console.log("after splice", arr_);
