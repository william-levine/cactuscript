let canvas = document.getElementById("plant-canvas")
let terminal = document.getElementById("terminal")
//let run = document.getElementById("run")
let ctx = canvas.getContext("2d")

/*
run.addEventListener("click", function() {
    let codeBlocks = getTextInputCodeBlocks()
    runCode(codeBlocks)
})
*/
function drawPot() {
    ctx.fillStyle = "brown"

}

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
    let textCodeInput = document.getElementById("code-console")
    return textCodeInput.split(" ")
}

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


setupCanvas()
// setupTerminal()