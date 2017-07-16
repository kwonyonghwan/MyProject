<!DOCTYPE html>
<meta charset="utf-8">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file=".\include\tempHeader.jsp"%>
<html class="no-js js-html" lang="ko">
<!--<![endif]-->
<head>
   <!-- Main style -->
<link rel="stylesheet" type="text/css"
	href="/resources/bootstrap_goodshoes/css/cardio.css">
	
	
	<script language="JavaScript">
		function openNewWindow(window) {
			open (window,"NewWindow","left=0, top=0, toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, width=639, height=581");
		}
	</script>

	<script src="/resources/Three/libs/jquery-1.6.4.js"></script>
	<script src="/resources/Three/libs/jquery.mousewheel.js"></script>
	<link href="/resources/Three/css/webglbook.css" rel="stylesheet" /> 
    <link rel="stylesheet" type="text/css" href="/resources/Three/css/game.css" />
	<link href="/resources/Three/css/integration-div.css" rel="stylesheet" />
	<script src="/resources/Three/libs/Three.js"></script>
	<script src="/resources/Three/libs/RequestAnimationFrame.js"></script>
	<script src="/resources/Three/libs/sim.js"></script>
	<script src="/resources/Three/libs/animation.js"></script>
	<script src="/resources/Three/libs/webGLDetector.js"></script>	
	<script src="/resources/Three/js/jsonModel.js"></script>
	<script src="/resources/Three/js/car.js"></script>
	<script src="/resources/Three/js/player.js"></script>
	<script src="/resources/Three/js/exhaust.js"></script>
	<script src="/resources/Three/js/environment.js"></script>
	<script src="/resources/Three/js/game.js"></script>
	<script src="/resources/Three/js/Store.js"></script>
	<script src="/resources/Three/js/twin.js"></script>
	<script type="text/javascript" src="/resources/Three/js/xcanvas.js"></script>
    <script type="text/javascript" src="/resources/Three/js/tbe.js"></script>

	<script>

	
	var app = null;
	var mouse = new THREE.Vector2(), INTERSECTED;
	var player = new Player;
	
	$(document).ready(
		function() {

			var container = document.getElementById("container");
			
			try {

				Sim.WebGLDetector.detectWebGL();

				app = new RacingGame();
				app.init({ container: container,
					mouse: mouse,
					player: player
				});

	        	app.focus();            
				app.run();
	
			}
			catch(e)
			{
				container.innerHTML = e.toString();		
			}			
		}	
	);

	function onRestartClicked()
	{
		app.restart();
	}

	var arrow_keys_handler = function(e) {
		console.log("zzz");
		app.handleKeyDown(e.keyCode, e.charCode);
	};

	var arrow_keys_handler2 = function(e) {
		console.log("aaa");
		app.handleKeyUp(e.keyCode, e.charCode);
	};

	window.addEventListener("keydown", arrow_keys_handler, true);
	window.addEventListener("keyup", arrow_keys_handler2, true )

	</script>

</head>
<body>

<script src="//cdn.cquotient.com/js/v2/gretel.min.js" type="text/javascript" async="true"></script>

<div>
<div id="container" style="margin-top:1%; margin-left:5%; margin-bottom:1%; width:90%; height:80%; position:absolute; outline:none;">
	<div id="callout" class="callout"style="position:absolute; top:20%; left:30%; width: 40%; height: 50%; z-index: 1000" >
		<div id="header" class="header"></div>
		<div id="contents" class="contents" style="margin-bottom:10px;"></div>
		<div id="img" class="img" style="height: 50%">
		</div>
		<div id="etc" class="etc"></div>
	</div>

</div>

</body>

</html>
