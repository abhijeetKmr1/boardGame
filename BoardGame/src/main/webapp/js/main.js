var canvas = document.getElementById('myCanvas');
var ctx = canvas.getContext("2d");
ctx.lineWidth = 3;

createOuterBorder(40, 40, 610, 570);
createOuterBorder(60, 60, 590, 550);

ctx.lineWidth = 1;
drawPockets(60, 60, 590, 550);
createInerBorder(90, 90, 560, 520);
drawStriker(325,520,0*Math.PI, 2*Math.PI);

