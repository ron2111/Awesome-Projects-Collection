// the Calculator application to use  most of devices 

console.log('calculator')

// to scan all numbers and notation 
let numbers = document.getElementsByClassName('numbers')
let operators = document.getElementsByClassName('operator')
let screen = document.getElementById('screen')

// any numbers click than stor numbers as string 
// any numbers click than show the screen of numbers
for (const number of numbers) {

  number.addEventListener('click', () => {

    let num = parseInt(number.innerText)
    // console.log(num, typeof (num))
    screen.value += num
  })

  //   number.addEventListener('keypress', (e) => {

  //     let num = parseInt(e.key)
  //     console.log(e.key)
  //     screen.value += num

//   })
}

// when click operator than show operator to the screen
for (const operator of operators) {

  operator.addEventListener('click', () => {

    let sign = operator.innerText

    if (sign === '=') {
    }else {
      screen.value += sign
    }
  // console.log(sign, typeof (sign))
  })
}

let equals = document.getElementById('=')

// when click equals than event occur and opration perform
equals.addEventListener('click', () => {

  let postfixStr = infixToPost(screen.value)
  console.log(postfixStr)

  let answer = reversePolishSolution(postfixStr)
  console.log(answer, typeof (answer))
  screen.value = answer
})

// precedance of operator
function priorityOfOperator (operatorSign) {
  if (operatorSign === '-') {
    return 1
  }
  else if (operatorSign === '+') {
    return 1
  }
  else if (operatorSign === '/') {
    return 3
  }
  else if (operatorSign === '*') {
    return 4
  }
}

// infix to postfix conversaion 
function infixToPost (infixString) {
  let stack = []
  let postfixString = ''
  for (let index = 0; index < infixString.length; index++) {
    const element = infixString[index]

    if ((element === '+') || (element === '-') || (element === '*') || (element === '/')) {
      if (stack[0] === undefined) {
        stack.push(element)
      }else {
        if (priorityOfOperator(element) > priorityOfOperator(stack[stack.length - 1])) {
          stack.push(element)
        }else {
          while ((stack.length > 0) && (priorityOfOperator(element) <= priorityOfOperator(stack[stack.length - 1]))) {
            postfixString += stack.pop()
          }
          stack.push(element)
        }
      }
    }else {
      postfixString += element
    }
  }

  for (let index = stack.length - 1; index >= 0; index--) {
    const element = stack[index]
    postfixString += element
  }

  console.log(infixString, postfixString)

  return postfixString
}

function reversePolishSolution (postfixString) {
  stack = []
  ans = 0
  for (let index = 0; index < postfixString.length; index++) {
    const element = postfixString[index]

    if (!((element === '+') || (element === '-') || (element === '*') || (element === '/'))) {
      stack.push(parseInt(element))
    }else {
      let num2 = stack.pop()
      let num1 = stack.pop()

      switch (element) {
        case '+':
          ans = num1 + num2
          break
        case '-':
          ans = num1 - num2
          break
        case '*':
          ans = num1 * num2
          break
        case '/':
          ans = num1 / num2
          break

        default:
          break
      }
      stack.push(ans)
    }
  }

  ans = stack.pop()
  console.log(ans)
  return ans
}


function keypress () {
    for (const number of numbers) {

        // number.addEventListener('click', () => {

            let num = parseInt(number.target.innerText)
            // console.log(num, typeof (num))
            screen.value += num

        // })

    }
}

 document.addEventListener('keypress', (event) => {
   
    let num = event.key 
    console.log(num,event.key)
     screen.value += num

  }, false);

let ac = document.getElementById('ac')

ac.addEventListener('click',()=>{
    screen.value = ''
})

