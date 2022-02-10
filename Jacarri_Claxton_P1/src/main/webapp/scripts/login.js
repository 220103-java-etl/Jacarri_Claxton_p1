let ent =document.getElementById("Employee").value
let go = document.getElementById("Financial Manager").value
let userInput = document.getElementById('userInput');

let button = document.getElementById("myButton");

function printInput() {
    button.addEventListener('click', printInput)

    let userInput = document.getElementById('userInput.value').value;
    console.log(userInput);
}

console.log(ent,go);

let log = document.getElementById("log")
log.addEventListener('click',printInput)
function printInput () {
    let a = document.getElementById("Employee").value
    let b = document.getElementById("Financial Manager").value
    console.log(a)
    console.log(b)
}

//userInput.addEventListener('', printInput);