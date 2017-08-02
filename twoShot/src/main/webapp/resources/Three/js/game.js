// Constructor
RacingGame = function()
{
	Sim.App.call(this);
}

// Subclass Sim.App
RacingGame.prototype = new Sim.App();

// Our custom initializer
RacingGame.prototype.init = function(param)
{
	// Call superclass init code to set up scene, renderer, default camera
	Sim.App.prototype.init.call(this, param);

	this.camera = camera;

	param = param || {};
	this.param = param;
	this.mouse = mouse;
	this.player = player;
	// this.hud = param.hud;
	// this.sounds = param.sounds;

	//this.scene.fog = new THREE.FogExp2(0xffffff, 0.002 );
	// this.scene.fog = new THREE.Fog(0xefd1b5, 0,1500 );
	this.createEnvironment();
	this.loadCars();
	this.loadRacer();
	
	this.curTime = Date.now();
	this.deltat = 0;
	
	this.running = false;
	this.state = RacingGame.STATE_LOADING;	

	// Make sure the game has keyboard focus
	this.focus();

	this.addContextListener();

	var store = new Store();
	store.init({ id : "1", url : "/resources/Three/images/shop2.jpg", x:10, y:-7, z:180, header:"The Custom", content:"남성수제화전문<br>" +
	"30년 장인의 기술과 디자이너의 감각<br>" +
	"맞춤형 제작 및 AS 가능<br>", img:"<a href='/product/thecustomid'><img style='height: 100%;' src='/resources/Three/images/TheCustom1.jpg'></a>", etc: "<a href=javascript:openNewWindow('/resources/Three/images/m1.png')>위치 보기</a>" });
	this.addObject(store);

	var store = new Store();
	store.init({ id : "2", url : "/resources/Three/images/4.jpg", x:-10, y:-7, z:180, header:"KIP SPACE", content:"남성 신사 구두 수제 제작업체로 신사정장 슈트를 입는 고객이라면 누구든지 한 번쯤은 신어볼 만한 신사정장 구두입니다.<br>" +
		"항상 과감한 색상과 편안하고 견고한 구두로 저희 경서원에서 구매하신 구두라면 1년이 지나도 10년이 지나도 언제든지 A/S 가능하십니다.<br>", img:"<a href='/product/kipspaceid'><img style='height: 100%;' src='/resources/Three/images/KS.jpg'></a>", etc: "<a href=javascript:openNewWindow('/resources/Three/images/m2.png')>위치 보기</a>" });
	this.addObject(store);

	var store = new Store();
	store.init({ id : "3", url : "/resources/Three/images/1.jpg", x:10, y:-7, z:160, header:"QUEENSHEEL", content:"여성 수제화 맞춤제작 전문<br>" +
		"35년 이상 장인들이 함께 합니다.<br>" +
		"원하시는 장식. 원하시는 가죽. 원하시는 디자인 등으로 트렌드에 맞춰 제작 가능 합니다.<br>", img:"<a href='/product/queensheelid'><img style='height: 100%;' src='/resources/Three/images/QS.jpg'></a>", etc: "<a href=javascript:openNewWindow('/resources/Three/images/m3.png')>위치 보기</a>" });
	this.addObject(store);

	var store = new Store();
	store.init({ id : "4", url : "/resources/Three/images/3.jpg", x:-10, y:-7, z:160, header:"The Custom", content:"남성적인 투박함과 독창적인 특수화를 전문으로 제작합니다. <br>" +
		"발형태에 따른 보완성과 맞춤으로 제작하여 디자인과 편안함을 두루 갖춘 수제화입니다.<br>"
		, img:"<a href='/product/roshoemanid'><img style='height: 100%;' src='/resources/Three/images/rm.jpg'></a>", etc: "<a href=javascript:openNewWindow('/resources/Three/images/m4.png')>위치 보기</a>" });
	this.addObject(store);

	var store = new Store();
	store.init({ id : "5", url : "/resources/Three/images/4.jpg", x:10, y:-7, z:140, header:"select", content:"Store NO.5"  });
	this.addObject(store);

	var store = new Store();
	store.init({ id : "6", url : "/resources/Three/images/1.jpg", x:-10, y:-7, z:140, header:"select", content:"Store NO.6"  });
	this.addObject(store);

	var store = new Store();
	store.init({ id : "7", url : "/resources/Three/images/2.jpg", x:10, y:-7, z:120, header:"select", content:"Store NO.7"  });
	this.addObject(store);

	var store = new Store();
	store.init({ id : "8", url : "/resources/Three/images/3.jpg", x:-10, y:-7, z:120, header:"select", content:"Store NO.8"  });

	this.addObject(store);

	store = new Store();
	store.init({ id : "9", url : "/resources/Three/images/close.jpg", x:-10, y:-7, z:100, header:"select", content:"Store NO.8"  });

	this.addObject(store);

	store = new Store();
	store.init({ id : "10", url : "/resources/Three/images/close2.jpg", x:10, y:-7, z:100, header:"select", content:"Store NO.8"  });

	this.addObject(store);

	store = new Store();
	store.init({ id : "11", url : "/resources/Three/images/close2.jpg", x:-10, y:-7, z:80, header:"select", content:"Store NO.8"  });

	this.addObject(store);
	store = new Store();
	store.init({ id : "12", url : "/resources/Three/images/close.jpg", x:10, y:-7, z:80, header:"select", content:"Store NO.8"  });

	this.addObject(store);

	store = new Store();
	store.init({ id : "13", url : "/resources/Three/images/close.jpg", x:-10, y:-7, z:60, header:"select", content:"Store NO.8"  });

	this.addObject(store);

	store = new Store();
	store.init({ id : "14", url : "/resources/Three/images/close2.jpg", x:10, y:-7, z:60, header:"select", content:"Store NO.8"  });

	this.addObject(store);

	store = new Store();
	store.init({ id : "15", url : "/resources/Three/images/close2.jpg", x:-10, y:-7, z:40, header:"select", content:"Store NO.8"  });

	this.addObject(store);
	store = new Store();
	store.init({ id : "16", url : "/resources/Three/images/close.jpg", x:10, y:-7, z:40, header:"select", content:"Store NO.8"  });

	this.addObject(store);
 	// var testtree = new Mtree();
	// testtree.init();
	// console.log(testtree)
	// this.addObject(testtree);

}


RacingGame.prototype.createEnvironment = function()
{
	this.environment = new Environment();
	this.environment.init({app:this,
		textureSky:true,
		textureGround:true,
		textureFinishLine:true,
		displaySigns:true});
	this.addObject(this.environment);
}

RacingGame.prototype.loadCars = function()
{
	this.carModels = [];
	this.nMakesLoaded = 3;
	this.nMakesTotal = 3;

	var that = this;
	var model = new JSONModel;
	model.init(
			{
				url : "/resources/Three/models/Nova Car/NovaCar.js",
				callback: function(model) { that.onCarLoaded(model, "nova",
				{
					scale:0.7,
					position:{x:0, y:.1, z:Car.CAR_LENGTH},
					rotation:{x:-Math.PI / 2, y:0, z:0},
				}); }
			}
			);

    model = new JSONModel;
	model.init(
			{
				url : "/resources/Three/models/Camaro-1/Camaro.js",
				callback: function(model) { that.onCarLoaded(model, "camaro",
				{
					scale:0.17,
					position:{x:1, y:-.5, z:Car.CAR_LENGTH},
					rotation:{x:-Math.PI / 2, y:0, z:0},
				}); }
			}
			);

    model = new JSONModel;
	model.init(
			{
				url : "/resources/Three/models/Camaro-1/Camaro.js",
				callback: function(model)
				{ that.onCarLoaded(model, "camaro_silver",
				{
					scale:0.17,
					position:{x:1, y:-.5, z:Car.CAR_LENGTH},
					rotation:{x:-Math.PI / 2, y:0, z:0},
					map:"/resources/Three/models/Camaro-1/camaro_4.jpg",
					mapIndex:0
				}); }
			}
			);

}

RacingGame.prototype.onCarLoaded = function(model, make, options)
{
	this.carModels[this.nMakesLoaded++] = { make: make, model : model, options : options };

	if (this.nMakesLoaded >= this.nMakesTotal)
	{
		this.createCars();
	}
}


RacingGame.prototype.loadRacer = function()
{
	var that = this;
	var model = new JSONModel;
	model.init({ url : "/resources/Three/models/Nissan GTR OBJ/Objects/NissanOBJ1.js", scale:0.0254,
		callback: function(model) { that.onRacerLoaded(model); }
	});
}

RacingGame.prototype.onRacerLoaded = function(model)
{
	// Turn away from camera
	model.mesh.rotation.y = Math.PI;
	//this.player = new Player;
	//console.log(this)
	this.player.init({ mesh : model.object3D, camera : camera, exhaust:true	});
	this.addObject(this.player);
	this.player.setPosition(0, RacingGame.CAR_Y + Environment.GROUND_Y+2,
			Environment.ROAD_LENGTH / 2 - RacingGame.PLAYER_START_Z);
	this.player.start();
	
	if (this.cars)
	{
		this.startGame();
	}
}

RacingGame.prototype.startGame = function()
{
	this.running = true;
	this.state = RacingGame.STATE_RUNNING;
	this.startTime = Date.now();

}

RacingGame.prototype.finishGame = function()
{
	this.running = false;
	this.player.stop();
	
	var i, len = this.cars.length;
	for (i = 0; i < len; i++)
	{
		this.cars[i].stop();
	}
	
	this.state = RacingGame.STATE_COMPLETE;
	this.showResults();
}

RacingGame.prototype.createCars = function()
{
	this.cars = [];

	var i = 0, nCars = 5;
	for (i = 0; i < nCars; i++)
	{
		var object = this.createCar(i % this.nMakesLoaded);

		var car = new Car;
		car.init({ mesh : object });
		this.addObject(car);
		var randx = (Math.random() -.5 ) * (Environment.ROAD_WIDTH - Car.CAR_WIDTH);
		var randz = (Math.random()) * Environment.ROAD_LENGTH / 2 - RacingGame.CAR_START_Z;
		car.setPosition(randx, RacingGame.CAR_Y + Environment.GROUND_Y, randz);

		this.cars.push(car);
		car.start();
	}

	if (this.player)
	{
		this.startGame();
	}
}

RacingGame.prototype.createCar = function(makeIndex)
{
	var model = this.carModels[makeIndex].model;
	var options = this.carModels[makeIndex].options;

	var group = new THREE.Object3D;
	group.rotation.y = Math.PI;

	var mesh = new THREE.Mesh(model.mesh.geometry, model.mesh.material);
	mesh.rotation.set(options.rotation.x, options.rotation.y, options.rotation.z)
	mesh.scale.set(options.scale, options.scale, options.scale);
	mesh.position.set(options.position.x, options.position.y, options.position.z);

	if (options.map)
	{
		var material = mesh.geometry.materials[options.mapIndex];
		material.map = THREE.ImageUtils.loadTexture(options.map);
	}

	group.add(mesh);

	return group;
}

RacingGame.prototype.update = function()
{
	if (this.running)
	{
		this.elapsedTime = (Date.now() - this.startTime) / 1000;
		
		this.testCollision();

	}
	
	Sim.App.prototype.update.call(this);
}


RacingGame.prototype.testCollision = function()
{
	var playerpos = this.player.object3D.position;
	
	if (playerpos.x > (Environment.ROAD_WIDTH / 2 - (Car.CAR_WIDTH/2)))
	{
		this.player.bounce();
		this.player.object3D.position.x -= 0.1;
	}
	
	if (playerpos.x < -(Environment.ROAD_WIDTH / 2 - (Car.CAR_WIDTH/2)))
	{
		this.player.bounce();
		this.player.object3D.position.x += 0.1;
	}
	
	var i, len = this.cars.length;
	for (i = 0; i < len; i++)
	{
		var carpos = this.cars[i].object3D.position;
		var dist = playerpos.distanceTo(carpos);
	}
}


RacingGame.prototype.handleKeyDown = function(keyCode, charCode)
{
	if (this.player)
	{
		this.player.handleKeyDown(keyCode, charCode);
	}
}

RacingGame.prototype.handleKeyUp = function(keyCode, charCode)
{
	if (this.player)
	{
		this.player.handleKeyUp(keyCode, charCode);
	}
}

RacingGame.prototype.handleMouseDown = function(x, y)
{
	var callout = document.getElementById("callout");
	callout.style.display = "none";
}

RacingGame.prototype.restart = function(e)
{
	var overlay = document.getElementById("overlay");
	overlay.style.display = 'none';

	this.container.removeChild(this.renderer.domElement);
	this.init( this.param );
}



RacingGame.prototype.addContextListener = function()
{
	var that = this;
	
	this.renderer.domElement.addEventListener("webglcontextlost", 
			function(e) { 
				that.handleContextLost(e);
				}, 
			false);
}


RacingGame.COLLIDE_RADIUS = Math.sqrt(2 * Car.CAR_WIDTH);
RacingGame.STATE_LOADING = 0;
RacingGame.STATE_RUNNING = 1;
RacingGame.STATE_COMPLETE = 2;
RacingGame.STATE_CRASHED = 3;
RacingGame.CAR_Y = 1.5;
RacingGame.CAR_START_Z = 10;
RacingGame.PLAYER_START_Z = 4;
RacingGame.best_time = Number.MAX_VALUE;
