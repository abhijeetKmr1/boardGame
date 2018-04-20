
function createOuterBorder(x1, y1, x2, y2) { 
   	drawLine(x1, y1, x2, y1);  
   	drawLine(x1, y1, x1, y2);
    drawLine(x1, y2, x2, y2);
    drawLine(x2, y2, x2, y1);
}

function createInerBorder(x1, y1, x2, y2) { 
    var a = 10;
    drawInerLine(x1 + a, y1, x2-a, y1);  
    drawInerLine(x1, y1+a, x1, y2-a);
    drawInerLine(x1+a, y2, x2-a, y2);
    drawInerLine(x2, y2-a, x2, y1+a);
}

function drawLine(sx, sy, ex, ey) {
  ctx.beginPath();
  ctx.moveTo(sx, sy);
  ctx.lineTo(ex, ey);
  ctx.strokeStyle = 'black';
  ctx.stroke();
}

function drawPockets(x1, y1, x2, y2){
  drawPocket(x1, y1, 0*Math.PI,.5*Math.PI);
  drawPocket(x2, y1, 0.5*Math.PI, 1*Math.PI);
  drawPocket(x2, y2, 1*Math.PI, 1.5*Math.PI);
  drawPocket(x1, y2, 1.5*Math.PI, 2*Math.PI);

}

function drawPocket(x1, y1, r1, r2){
  ctx.beginPath();
  ctx.arc(x1, y1, 50, r1, r2);
  ctx.strokeStyle = 'blue';
  ctx.stroke();
}
function drawInerLine(sx, sy, ex, ey) {
  ctx.beginPath();
  ctx.moveTo(sx, sy);
  ctx.lineTo(ex, ey);
  ctx.strokeStyle = 'red';
  ctx.stroke();
}

function drawStriker(x1, y1, r1, r2){
  ctx.beginPath();
  ctx.arc(x1, y1, 25, r1, r2);
  ctx.fillStyle = 'blue';
  ctx.fill();
  ctx.stroke();
}
