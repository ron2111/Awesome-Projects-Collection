//JavaScript Higher Order Functions & Arrays

//short hand for object
const raj = 123;
const data1 = [{ raj }];
console.log('short hand for object', data1);

//data json
const data = [

    { name: 'mahi', birth: 1940, death: 2020, city: 'jamanagar', gender: 1, married: 1 },
    { name: 'ravi', birth: 1956, death: 2010, city: 'rajkot', gender: 1, married: 0 },
    { name: 'chanagn', birth: 1939, death: 2012, city: 'ahmedabad', gender: 1, married: 1 },
    { name: 'magan', birth: 1979, death: 2013, city: 'jamanagar', gender: 1, married: 0 },
    { name: 'surabh', birth: 2000, death: 2030, city: 'rajokt', gender: 1, married: 1 },
    { name: 'ravi shankar', birth: 2009, death: 2070, city: 'ahmedabad', gender: 1, married: 0 },
    { name: 'lana', birth: 1998, death: 2010, city: 'dhoraji', gender: 2, married: 1 },
    { name: 'priya', birth: 1980, death: 2050, city: 'dhoraji', gender: 2, married: 0 },
    { name: 'shurbhi', birth: 1995, death: 2056, city: 'virpur', gender: 2, married: 1 },
    { name: 'pratap', birth: 1934, death: 2080, city: 'jamanagar', gender: 1, married: 0 },
    { name: 'alexa', birth: 1984, death: 2073, city: 'rajkot', gender: 2, married: 1 },
    { name: 'roman', birth: 1967, death: 2045, city: 'ahemdabad', gender: 1, married: 0 },
    { name: 'undertaker', birth: 1977, death: 2036, city: 'surendranagar', gender: 1, married: 0 },

];// gender=1=male,gender=2=female

// console.log("DATA", data);

//for each method
console.log('\nList of all available users with birth and death');
data.forEach(x => console.log(`${x.name} [${x.death} - ${x.birth}]`));

//find method
const find_married_Woman = data.find(x => x.gender === 2 && x.married === 1);
//this will print only single object
console.log('\nsingle first list of married woman!', find_married_Woman);

//filter method
const filter_married_women = data.filter(x => x.gender === 2 && x.married === 1);
//this will print all womans name who is married
console.log('\nAll list of married women');
filter_married_women.forEach(x => console.log(x.name, 'is married woman'));

//map method
const mapped_name_birth_array = data.map(({ name, birth, death }) => Object.values({ name, birth, death }));
//name and birth and death with all converted in array
console.log('name and birth and death with all converted in new array');
console.log(mapped_name_birth_array);

const mapped_name_birth_object = data.map(({ name, birth, death }) => ({ name, birth, death }));
//name and birth and death with all converted in object and give new array
console.log('\nname and birth and death with all converted in object and give new array of object\n');
console.log(mapped_name_birth_object);

const user_years_old = data.map(x => `${x.name} is ${x.death - x.birth} years old!`);
//here it will print user name with its lifespan in array
console.log("\nuser name with its lifespan\n");
console.log(user_years_old);
console.log("\nconversion of above array to string\n");
//it will print user name with its lifespan as a strings
console.log(user_years_old.join('\n'));

//sort method
const sort_by_birth = data.sort((a, b) => a.birth - b.birth);
//this will sort array with asseneding birthdate
console.log('\nsorted with Assending order by birth', sort_by_birth);

//reduce method
const count_of_all_life = data.reduce((a, b) => a + (b.death - b.birth), 0);
//it will count lifespan of users
console.log("\nAll lifespan of users is ", count_of_all_life);

//combined method
const combined_method = data
    .filter(x => x.death - x.birth >= 50)
    .sort((a, b) => (a.death - a.birth) - (b.death - b.birth));

console.log("\nhuman life span with assending order where lifespan is more then 50\n");
combined_method.forEach(x => console.log(`${x.name} lived ${x.death - x.birth} years`));