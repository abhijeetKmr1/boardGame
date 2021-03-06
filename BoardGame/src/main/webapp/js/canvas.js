
function init(x1, y1, x2, y2) {
  var a = 20;
  var b = 50;
  clear();
  createOuterBorder(x1, y1, x2, y2);
  createOuterBorder(x1+a, y1+a, x2-a, y2-a);

  ctx.lineWidth = 1;
  drawPockets(x1+a, y1+a, x2-a, y2-a);
  createInerBorder(x1+b, y1+b, x2-b, y2-b);
  drawInerCircle((x1 + (x2-x1)/2), y1 + (y2 -y1)/2);
  drawQueenCircle((x1 + (x2-x1)/2), y1 + (y2 -y1)/2);
}

function placeStriker(x1, y1, r1, r2){
  drawStriker(x1, y1, r1, r2);
  drawLine(x1,y1, x1, y1-70);
}

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
function drawBoard(boardList){
  for (var i = 0; i < boardList.length; i++) {
    clear();
    init(x1, y1, x2, y2);
    drawCoins(boardList[i]);
  }
}
function drawCoins(coinList){
  for (var i = 0; i < coinList.length; i++) {
      var cp = coinList[i].position;
      var color = coinList[i].coinType;
      var cpx = x1 + parseFloat(cp.split(":")[0]);
      var cpy = y1 + parseFloat(cp.split(":")[1]);
      //alert(cpx + ":" + cpy);
      drawCoin(cpx,cpy,0*Math.PI, 2*Math.PI,color);
  }
}
function drawCoin(x1,y1,r1,r2,color){
  ctx.beginPath();
  ctx.arc(x1, y1, 20, r1, r2);
  ctx.fillStyle = color;
  ctx.fill();
  ctx.stroke(); 
}

function drawInerCircle(x1,y1){
  ctx.beginPath();
  ctx.arc(x1, y1, 100, 0*Math.PI, 2*Math.PI);
  ctx.stroke();
}
function drawQueenCircle(x1,y1){
  ctx.beginPath();
  ctx.arc(x1, y1, 20, 0*Math.PI, 2*Math.PI);
  ctx.strokeStyle = 'black';
  ctx.stroke();
}
function clear(){
  ctx.clearRect(0, 0, 800, 600);
}
function placeDirection(x1, y1,r1){
  ctx.beginPath();
  ctx.moveTo(x1, y1);
  var ex;
  var ey;
  var lcos =  Math.ceil(Math.cos(r1 * (Math.PI/180)) * 70);
  var lsin =  Math.ceil(Math.sin(r1 * (Math.PI/180)) * 70);
  if (lcos >= 0) {
    ex = Math.abs(x1) + Math.abs(lcos);
  } else {
    ex = Math.abs(x1) - Math.abs(lcos);
  }
  if (lsin >= 0) {
    ey = Math.abs(y1) - Math.abs(lsin);
  }
  else {
    ey = Math.abs(y1) + Math.abs(lsin);
  }
  ctx.lineTo(ex, ey);
  ctx.strokeStyle = 'black';
  ctx.stroke();
}
