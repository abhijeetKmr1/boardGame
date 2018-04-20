var canvas = document.getElementById('myCanvas');
var ctx = canvas.getContext("2d");
ctx.lineWidth = 3;

$(function(){
	init(40, 40, 610, 570);
	placeStriker(325,520,0*Math.PI, 2*Math.PI);
})

$("#striker").change(function(){
	clear();
	var sPos = $("#strikerVal").val();
	init(40, 40, 610, 570);
	placeStriker(sPos,520,0*Math.PI, 2*Math.PI);

});
$("#angle").change(function(){
	clear();
	var sPos = $("#strikerVal").val();
	init(40, 40, 610, 570);
	drawStriker(sPos,520,0*Math.PI, 2*Math.PI);
	var angle = $("#angleVal").val();
	placeDirection(sPos,520, angle); 
});






