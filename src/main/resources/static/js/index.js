let canvas = document.getElementById("plant-canvas")
// let run = document.getElementById("run")
let ctx = canvas.getContext("2d")

// run.addEventListener("click", function() {
    // get the code from the box and turn it into json to pass to the server
// })

function drawPot() {
    ctx.fillStyle = "brown"

}

function setupCanvas() {
    let targetHeight = document.documentElement.clientHeight / 2
    let targetWidth = document.documentElement.clientWidth / 2
    canvas.height = targetHeight
    canvas.width = targetWidth
    console.log("hello")
}

setupCanvas()