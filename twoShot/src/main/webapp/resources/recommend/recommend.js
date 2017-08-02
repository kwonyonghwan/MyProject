/**
 * Created by Bitcamp on 2016-05-19.
 */

/////////////////////////////////////////////////////////////////////////////////////
// some colour variables
var tcBlack = "#130C0E";

function update() {
	
	// json데이터를 파싱한 변수 root를 이용하여 tree형태의 데이터를 만들어 트리노드 nodes를 만든다.
    // 이 생성된 nodes를 데이터로 하는 트리 링크를 생성하여 변수 links에 담는다.
	var nodes = flatten(root),
		links = d3.layout.tree().links(nodes);

	// 생성된 노드 nodes와 링크인 links로 forcelayout의 노드와 링크를 지정하고 메서드체인을 이용하여 각종 설정을 한다.
	force.nodes(nodes)
		.links(links)
		.gravity(0.05)
		.charge(-1500)
		.linkDistance( function(d) {
				return 600 * d.target.confidence;
			})
		.friction(0.5)
		.linkStrength( function(l, i) {
				return 1;
			})
		.size([ w, h ])
		.on("tick", tick)
		.start();
	
	 // 이제 설정된 노드와 링크들을 그려야 한다.
	
	

	/*  링크를 그린다.   => 먼저 링크를 그려주는 이유가 링크를 그려주고 노드를 그려줘야 노드가 더 위에 그려진다. */
	
    // 1. path 요소 중 클래스가 link인 요소들을 모두 선택하고 데이터셋 links와 바인딩한다.
    var path = vis.selectAll("path.link")
            .data(links, function(d) { return d.target.id; });
    
    
    // 2. 1에서 선택한 path들을 순회하며 path요소 append 및 설정
    path
            .enter()
            .append("svg:path")
            .attr("class", "link")
            .style("stroke", "#eee");
    
    // 3. 패스 데이터가 삭제될 때
    path
            .exit() // 삭제 대상 요소 추출
            .remove(); // 요소 삭제
    

    /*  노드를 그린다.    */
    
    // 1. g 요소 중, 클래스가 node인 요소들을 모두 선택하고 데이터셋 nodes와 바인딩한다.
    var node = vis
            .selectAll("g.node")
            // 데이터셋과 선택된 요소를 바인딩시킬 때 key값을 같이 넘겨 준다.
            .data(nodes, function(d) {
                return d.id; }
            );
    
	
    // 2. 1에서 선택한 노드들을 모두 순회하며 설정한다. ( g요소 생성 )
    var nodeEnter = node
            .enter()
            .append("svg:g")    // g 요소 append
            .attr("class", "node")  // class 부여(css)
            // g로 감싼 요소들을 함께 위치 이동시키기 위해 transform 속성을 설정한다.
            .attr("transform", function(d) { return "translate(" + d.x  + "," + d.y + ")"; })
            .on("click", click) // click 이벤트 리스너를 등록한다.
            .call(force.drag); // dragable
    
    

    // 3.  2에서 생성한 g요소에 circle요소를 생성하고 설정한다. 이때 반지름의 크기를 1(이미지 밖으로 튀어나오지 않게 그냥 적당히 작게 정한 것)로 한다.
    nodeEnter.append("svg:circle")
            .attr("r", function(d) {return 1; })
            .style("fill", "#eee");
    
    
    // 4. 2에서 생성한 g요소에 image요소를 생성하고 설정한다.
    var images = nodeEnter.append("svg:image")
            // 데이터의 img속성에 있는 이미지를 보여준다.(해당 구두 이미지)
            .attr("xlink:href",  function(d) { return d.productthumimage;})
            .attr("x", function(d) { return -(60 + (80 * d.confidence)) / 2 ;})
            .attr("y", function(d) { return -(60 + (80 * d.confidence)) / 2 ;})
            .attr("height", function(d) {return 60 + (80 * d.confidence);})
            .attr("width", function(d) {return  60 + (80 * d.confidence);});
    
    
    // Append productname name on roll over next to the node as well
	nodeEnter.append("text")
			.attr("class", "nodetext")
			.attr("x", function(d){ return -(60 + (80 * d.confidence)) / 4 ;;})
			.attr("y", function(d){ return -(80 + (80 * d.confidence)) / 2 ;})
			.attr("fill", tcBlack)
			.text(function(d) {
				if(d.pno==-1){
					return d.productname;
				}else{
					return d.productname  +" "+ Math.floor(d.confidence*100) +"%";
				}
			});
	

    // 5. 노드 데이터가 삭제될 때
    node
            .exit() // 삭제 대상 요소 추출
            .remove(); // 요소 삭제

  
    /* 이벤트 등록 */
    // 생성한 이미지에 마우스 이벤트 리스너를 등록한다.
    
	var ab_x, ab_y;
	var setEvents = images
			// 클릭된 이미지에 바인딩된 데이터의 rootdata속성이 없는 경우(즉, 루트노드가 아닌 경우) 해당 제품 페이지로 이동한다.
			.on('dblclick', function(d) {
					if (d.rootdata == "false") {
						location.href = 'http://localhost:8081/product/productDetail?pno='+ d.pno;
					}
			})// on()
					
			// 이미지에 마우스 포인터가 들어갔을때 루트 노드가 아닌경우에만 div(360도 뷰)를 display 해준다.		
			.on('mouseenter', function(d) {
				// 마우스가 이미지로 들어왔을때 마우스 포인터의 좌표를 얻어온다.( 360도 뷰를 보여줄 위치 )
				if(d.pno != -1){
				
					d3.select( this )
	                  .transition()
	                  .duration(750)
	                  .attr("x", function(d) { return -(60 + (80 * d.confidence)) / 2 ;})
	                  .attr("y", function(d) { return -(60 + (80 * d.confidence)) / 2 ;})
	                  .attr("height", function(d) {return 200;})
	                  .attr("width", function(d) {return  200;})
				};
				
				
				
			})// mouseenter()

			// 이미지에서 마우스 포인터가 들어갔다가 나올때 원래 이미지의 사이즈로 복귀
			.on( 'mouseleave', function() {
                    d3.select( this )
                            .transition()
                            .duration(750)
                            .attr("x", function(d) { return -(60 + (80 * d.confidence)) / 2 ;})
                            .attr("y", function(d) { return -(60 + (80 * d.confidence)) / 2 ;})
                            .attr("height", function(d) {return 60 + (80 * d.confidence);})
                            .attr("width", function(d) {return  60 + (80 * d.confidence);})
             });// on()


	// 다시 그리기 위해(업데이트) 모든 노드와 패스를 다시 선택해준다.
	path = vis.selectAll("path.link");
	node = vis.selectAll("g.node");

	// tick 이벤트 수행 로직
    function tick() {
        // 패스 좌표 설정
        path.attr("d", function(d) {

            var dx = d.target.x - d.source.x,
                    dy = d.target.y - d.source.y,
                    dr = Math.sqrt(dx * dx + dy * dy);
            return   "M" + d.source.x + ","
                    + d.source.y
                    + "A" + dr + ","
                    + dr + " 0 0,1 "
                    + d.target.x + ","
                    + d.target.y;
        });

        /**
         * Gives the coordinates of the border for keeping the nodes inside a frame
         * http://bl.ocks.org/mbostock/1129492
         */
        // 노드 좌표 설정
        node.attr("transform", function(d){
            d.x =  Math.max(maxNodeSize, Math.min(w - (d.imgwidth/2 || 16), d.x));
            d.y =  Math.max(maxNodeSize, Math.min(h - (d.imgheight/2 || 16), d.y));
            return "translate(" + d.x  + "," + d.y + ")";
        });
    }// tick()
}

	 // 노드 클릭시 children노드들 토글 (현재는 루트 노드만 children 노드들을 가지는 상태이므로 루트노드에만 해당되는 이벤트)
	function click(d) {
		// children있으면 없앰
		if (d.children) {
			d._children = d.children;
			d.children = null;
		} else {// chileren 없으면 생성
			d.children = d._children;
			d._children = null;
		}
		update();
	}// click()

	/**
	 * Returns a list of all nodes under the root.
	 */
	function flatten(root) {
		var nodes = [];
		var i = 0;
	
		function recurse(node) {
			if (node.children)
				node.children.forEach(recurse);
			if (!node.id)
				node.id = ++i;
			nodes.push(node);
		}
		recurse(root);
		return nodes;
	}

