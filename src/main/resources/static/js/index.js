let canvas = document.getElementById("plant-canvas")
let terminal = document.getElementById("terminal")
let runBtn = document.getElementById("run-command-button")
let ctx = canvas.getContext("2d")

let lastCodeRan = ""

function run() {
    let codeBlocks = getTextInputCodeBlocks()
    terminal.value += "\n> "
    runCode(codeBlocks)
}

runBtn.addEventListener("click", run)

terminal.addEventListener("input", function(event) {
    if (event.inputType === "insertLineBreak"){
        terminal.value = terminal.value.substring(0, terminal.value.length - 1)
        run()
    }
    let endValue = "end"
    let value = terminal.value.substring(terminal.value.length - endValue.length - 1)
    if (value === " end") {
        run()
    } else if (terminal.value.substring(terminal.value.length - 2, terminal.value.length) === "\n>") {
        terminal.value += " "
    }
})

function setupCanvas() {
    let targetHeight = document.documentElement.clientHeight * 0.8
    let targetWidth = document.documentElement.clientWidth / 2
    canvas.height = targetHeight
    canvas.width = targetWidth
}

function setupTerminal() {
    let targetHeight = document.documentElement.clientHeight / 2
    let targetWidth = document.documentElement.clientWidth / 2
    terminal.height = targetHeight
    terminal.width = targetWidth
}

// used for code blocks that are not in the text input
function getAllCodeBlocks() {
    let codeBlocks = document.getElementsByClassName("code-block")
    let codeBlockArray = []
    for (let i = 0; i < codeBlocks.length; i++) {
        codeBlockArray.push(codeBlocks[i].innerText)
    }
    return codeBlockArray
}

function getTextInputCodeBlocks() {
    let codeInput = terminal.value.substring(lastCodeRan.length + 2)
    lastCodeRan = terminal.value + "\n"
    return codeInput.split(" ")
}

/**
 *  Sends each individual word to the server to be validated and then ran
  * @param codeBlocks - a list of strings that represent each individual word in the code
 */
function runCode(codeBlocks) {
    let results = fetch("/code", {
        method: "POST",
        body: JSON.stringify(codeBlocks),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
    })
    console.log(results)
}

function getRndInteger(min, max) {
    return Math.floor(Math.random() * (max - min + 1) ) + min;
}

function drawCactusPixel(x, y) {
    ctx.strokeStyle = `rgb(0, ${getRndInteger(200, 232)}, 0)`;
    ctx.lineWidth = "1";
    ctx.beginPath();
    ctx.moveTo(x, y);
    ctx.lineTo(x + 1, y+1);
    ctx.stroke();
}

setupCanvas()