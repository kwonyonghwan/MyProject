<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src='http://code.jquery.com/jquery-1.9.1.min.js' type='text/javascript'></script>
    <script src='/resources/360ZoomLib/jquery.reel.withzoom.js' type='text/javascript'></script>
    <script src='/resources/360ZoomLib/jquery.mousewheel.min.js' type='text/javascript'></script>
    <script src="/resources/360ZoomLib/jquery-ui.custom.min.js" type="text/javascript"></script>
    <script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
    <script src="/resources/recommend/360zoomINDrawGraph.js" charset="utf-8"></script>
    <script src="/resources/recommend/recommend.js" charset="utf-8"></script>
    <!-- Common examples style (gray background, thin fonts etc.) -->
    <link href="/resources/css/recommendAND360.css" rel="stylesheet" type="text/css" />

</head>
<body>

<!-- 제품의 360도뷰를 보여줄 div와 image 요소
	마우스 이벤트가 있을때  활성화시켜 보여줄 것이기 때문에 현재는 display 속성을 none으로 하여 화면에 보여주지 않는 상태이다.-->
<!-- <div id ="test" style=" border: 1px solid gold;  width: 300px; height: 300px; display: none">
    <image id="360zoomINDrawGraph" src='/resources/mini/001.jpg' style="  width: 300px; height: 300px;"> </image>
</div> -->

<section id="vis"></section>
<script>
    // rest of vars
    var     w = 960,
            h = 800,
            maxNodeSize = 50,
            x_browser = 20,
            y_browser = 25,
            root;
    var vis;
    
    // force-layout 을 생성한다.
    var force = d3.layout.force();

    // DOM의 id가 vis인 요소를 선택하여 svg 요소를 추가한다.
    vis = d3.select("#vis").append("svg").attr("width", w).attr("height", h);

    // json 데이터 파일을 읽어온다.
    d3.json("/recommend/read", function(json) {

        root = json;
        root.fixed = true;
        root.x = w / 2;
        root.y = h / 4;

        update();
    });
	
    //div에서 나올떄 이벤트 
    $('#test').on( 'mouseleave', function(e){
        $("#test").css({
            "position" : "absolute",
            "top" : 900+"px",
            "left" : 900+"px",
            "height" : 1,
            "width" :1
        });
        $("#image").css({
            "position" : "absolute",
            "top" : 900+"px",
            "left" : 900+"px",
            "height" : 1,
            "width" :1
        });
    });

    
    
    
</script>
</body>
</html>