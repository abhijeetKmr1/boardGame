var baseUrl = "http://localhost:9000/BoardGame-1.0/board/carrom";
var canvas = document.getElementById('myCanvas');
var ctx = canvas.getContext("2d");
var playerName ="";
var numberOfcoins=0;
ctx.lineWidth = 3;
var boards = [];
//var listOfCoins = [];

$(function(){

	$("#myCanvas").hide();
	$("#hit").hide();
	//init(40, 40, 610, 570);
	//placeStriker(325,520,0*Math.PI, 2*Math.PI);
})

$("#striker").change(function(){
	clear();
	var sPos = $("#strikerVal").val();
	init(x1, y1, x2, y2);
	placeStriker(sPos,y2-50,0*Math.PI, 2*Math.PI);
	drawInitCoins(listOfCoins);

});
$("#angle").change(function(){
	clear();
	var sPos = $("#strikerVal").val();
	init(x1, y1, x2, y2);
	drawStriker(sPos,y2-50,0*Math.PI, 2*Math.PI);
	var angle = $("#angleVal").val();
	placeDirection(sPos,y2-50, angle); 
	drawInitCoins(listOfCoins);
});

function hit(){
	init(x1, y1, x2, y2);
	var sPosx = $("#strikerVal").val();
	var sPosy = y2-50;
	var ang = $("#angleVal").val();
	var forc = $("#forceVal").val();
	var timeS = $("#sliceVal").val();
	var data = {
		"strikePos" : sPosx +":" +sPosy,
		"angle" : ang,
		"force" : forc,
		"timeSlice" : timeS
	};
	var dataStng = JSON.stringify(data);

	$.ajax({
		contentType : 'application/json',
		type : 'POST',
		url : baseUrl +"/strike_hit",
		success : function(responseJson){
			listOfBoard = responseJson;
			drawBoard(listOfBoard);
		}
	})
}
function submit(){
	//alert(baseUrl);
	playerName = $("#usr").val();
	numberOfcoins = parseInt($("#coin").val());
	if (playerName == "" || numberOfcoins <= 0) { 
		alert("Can not be Empty"); 
		return;
	} 
	else {		
		$("#init").hide();
		$("#myCanvas").show();
		$("#hit").show();
		init(x1, y1, x2, y2);
		placeStriker((x1+(x2-x1)/2),y2-50,0*Math.PI, 2*Math.PI);
	}
	$.ajax({
		contentType:'application/json',
		type :'GET',
		url : baseUrl +"/initializeBoard/"+numberOfcoins +"/" +playerName,
		success : function(responseJson){
			listOfCoins = responseJson;
			drawCoins(listOfCoins);
		}
	})

}






