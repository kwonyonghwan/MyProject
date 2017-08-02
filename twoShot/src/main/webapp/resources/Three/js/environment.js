// Constructor
Environment = function()
{
	Sim.Object.call(this);
}

// Subclass Sim.App
Environment.prototype = new Sim.Object();

// Our custom initializer
Environment.prototype.init = function(param)
{
	// Call superclass init code to set up scene, renderer, default camera
	Sim.Object.prototype.init.call(this, param);
	
	param = param || {};
	
	var app = param.app;
	if (!app)
		return;

	// var modelGroup = new THREE.Object3D();
    //
	// // Tell the framework about our object
	// this.setObject3D(modelGroup);
	
	this.textureSky = param.textureSky;
	this.textureGround = param.textureGround;
	this.textureFinishLine = param.textureFinishLine;

    // Create a headlight to show off the model
	this.headlight = new THREE.DirectionalLight( 0xffffff, 1);
	this.headlight.position.set(100, 100, 100);
	app.scene.add(this.headlight);

	this.headlight1 = new THREE.DirectionalLight( 0xffffff, 1);
	this.headlight1.position.set(-100, 100, 100);
	app.scene.add(this.headlight1);

	this.headlight2 = new THREE.DirectionalLight( 0xffffff, 1);
	this.headlight2.position.set(100, 100, -100);
	app.scene.add(this.headlight2);

	this.headlight3 = new THREE.DirectionalLight( 0xffffff, 1);
	this.headlight3.position.set(-100, 100, -100);
	app.scene.add(this.headlight3);

	this.ambient = new THREE.AmbientLight( 0xffffff, 1);
	app.scene.add(this.ambient);


	this.app = app;
	
	this.createSky();
	this.createGround();
	this.createRoad();
	this.createSprite();
	// this.createFinishLine();

	this.curTime = Date.now();
}

Environment.prototype.createSky = function()
{
	var texture = null;
	
	// Clouds by moodflow
	// http://www.turbosquid.com/Search/Artists/moodflow
	// http://www.turbosquid.com/FullPreview/Index.cfm/ID/433395		
	if (this.textureSky)
	{
		texture = THREE.ImageUtils.loadTexture('/resources/Three/images/clouds1273.jpg');
	    texture.wrapS = texture.wrapT = THREE.MirroredRepeatWrapping;
	    texture.repeat.set(1, 1);
		texture1 = THREE.ImageUtils.loadTexture('/resources/Three/images/clouds1274.jpg');
		texture1.wrapS = texture.wrapT = THREE.MirroredRepeatWrapping;
		texture1.repeat.set(1, 1);
	}
	else
	{
		texture = null;
	}
		
	var sky = new THREE.Mesh( new THREE.PlaneGeometry( Environment.SKY_WIDTH,
			Environment.SKY_HEIGHT),
			new THREE.MeshBasicMaterial( 
			{ color: this.textureSky ? 0xffffff : 0x3fafdd, map:texture } 
			) 
	);
	sky.position.y = 300 + Environment.GROUND_Y;
	sky.position.z = -Environment.GROUND_LENGTH / 2;
	this.app.scene.add( sky );
	this.sky = sky;

	var sky1 = new THREE.Mesh( new THREE.PlaneGeometry( Environment.SKY_WIDTH,
		Environment.SKY_HEIGHT ),
		new THREE.MeshBasicMaterial(
			{ color: this.textureSky ? 0xffffff : 0x3fafdd, map:texture1 }
		)
	);
	sky1.position.y = 300 + Environment.GROUND_Y;
	sky1.position.x = -1000;
	sky1.position.z = 1100;
	sky1.rotation.y = 90/(180/Math.PI);
	this.app.scene.add(sky1);
	this.sky1 = sky1;

	var sky2 = new THREE.Mesh( new THREE.PlaneGeometry( Environment.SKY_WIDTH,
		Environment.SKY_HEIGHT ),
		new THREE.MeshBasicMaterial(
			{ color: this.textureSky ? 0xffffff : 0x3fafdd, map:texture1 }
		)
	);
	sky2.position.y = 300 + Environment.GROUND_Y;
	sky2.position.x = 1000;
	sky2.position.z = 1100;
	sky2.rotation.y = -90/(180/Math.PI);
	this.app.scene.add(sky2);

}

Environment.prototype.createGround = function()
{
	var texture = null;

	// Sand texture
	if (this.textureGround)
	{
		texture = THREE.ImageUtils.loadTexture('/resources/Three/images/b7.jpg');
	    texture.wrapS = texture.wrapT = THREE.RepeatWrapping;
	    texture.repeat.set(1000, 1000);
	}
	else
	{
		texture = null;
	}

	var ground = new THREE.Mesh( new THREE.PlaneGeometry( Environment.GROUND_WIDTH, 
			Environment.GROUND_LENGTH ),
			new THREE.MeshBasicMaterial(
			{ map:texture }
			)
	);
	//color: this.textureGround ? 0xffffff : 0xaaaaaa, ambient: 0x333333,
	ground.rotation.x = -Math.PI/2;
	ground.position.y = -.02 + Environment.GROUND_Y;


	this.app.scene.add( ground );
	this.ground = ground

}

Environment.prototype.createSprite = function() {

	var texture = THREE.ImageUtils.loadTexture('/resources/Three/images/Building2.jpg');
	texture.wrapS = texture.wrapT = THREE.RepeatWrapping;
	texture.repeat.set(1, 1);
	var texture1 = THREE.ImageUtils.loadTexture('/resources/Three/images/building11.jpg');
	texture1.wrapS = texture1.wrapT = THREE.RepeatWrapping;
	texture1.repeat.set(1, 1);
	var texture2 = THREE.ImageUtils.loadTexture('/resources/Three/images/building5.jpg');
	texture2.wrapS = texture2.wrapT = THREE.RepeatWrapping;
	texture2.repeat.set(1, 1);
	var texture3 = THREE.ImageUtils.loadTexture('/resources/Three/images/building6.png');
	texture3.wrapS = texture3.wrapT = THREE.RepeatWrapping;
	texture3.repeat.set(1, 1);
	var texture4 = THREE.ImageUtils.loadTexture('/resources/Three/images/building7.jpg');
	texture4.wrapS = texture4.wrapT = THREE.RepeatWrapping;
	texture4.repeat.set(1, 1);
	var texture5 = THREE.ImageUtils.loadTexture('/resources/Three/images/building8.jpg');
	texture5.wrapS = texture5.wrapT = THREE.RepeatWrapping;
	texture5.repeat.set(1, 1);
	var texture6 = THREE.ImageUtils.loadTexture('/resources/Three/images/building9.jpg');
	texture6.wrapS = texture6.wrapT = THREE.RepeatWrapping;
	texture6.repeat.set(1, 1);
	var texture7 = THREE.ImageUtils.loadTexture('/resources/Three/images/building10.jpg');
	texture7.wrapS = texture7.wrapT = THREE.RepeatWrapping;
	texture7.repeat.set(1, 1);

	var cubeGeometry = new THREE.CubeGeometry(12, 18, 15);
	var cubeMaterial = new THREE.MeshLambertMaterial({map:texture});
	var cube = new THREE.Mesh(cubeGeometry, cubeMaterial);

	var cubeGeometry1 = new THREE.CubeGeometry(12, 30, 12);
	var cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);

	cube.position.x = 25;
	cube.position.y = -1;
	cube.position.z = 180;

	this.app.scene.add(cube);

	cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.position.x = -25;
	cube.position.y = -1;
	cube.position.z = 100;

	this.app.scene.add(cube);

	cube1.position.x = -40;
	cube1.position.y = 5;
	cube1.position.z = 190;

	this.app.scene.add(cube1);

	cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);

	cube1.position.x = -40;
	cube1.position.y = 5;
	cube1.position.z = 110;

	this.app.scene.add(cube1);

	cubeMaterial = new THREE.MeshLambertMaterial({map:texture1});
	cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.position.x = -25;
	cube.position.y = -1;
	cube.position.z = 180;

	this.app.scene.add(cube);

	cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.position.x = 25;
	cube.position.y = -1;
	cube.position.z = 100;

	this.app.scene.add(cube);

	cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);
	cube1.position.x = 40;
	cube1.position.y = 5;
	cube1.position.z = 190;

	this.app.scene.add(cube1);

	cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);

	cube1.position.x = 40;
	cube1.position.y = 5;
	cube1.position.z = 110;
	this.app.scene.add(cube1);

	cubeMaterial = new THREE.MeshLambertMaterial({map:texture2});
	cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.position.x = -25;
	cube.position.y = -1;
	cube.position.z = 160;

	this.app.scene.add(cube);

	cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.position.x = 25;
	cube.position.y = -1;
	cube.position.z = 80;

	this.app.scene.add(cube);

	cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);
	cube1.position.x = 40;
	cube1.position.y = 5;
	cube1.position.z = 170;

	this.app.scene.add(cube1);

	cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);

	cube1.position.x = -40;
	cube1.position.y = 5;
	cube1.position.z = 90;
	this.app.scene.add(cube1);

	cubeMaterial = new THREE.MeshLambertMaterial({map:texture3});
	cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.position.x = 25;
	cube.position.y = -1;
	cube.position.z = 160;

	this.app.scene.add(cube);

	cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.position.x = -25;
	cube.position.y = -1;
	cube.position.z = 80;

	this.app.scene.add(cube);

	cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);
	cube1.position.x = -40;
	cube1.position.y = 5;
	cube1.position.z = 170;

	this.app.scene.add(cube1);

	cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);

	cube1.position.x = 40;
	cube1.position.y = 5;
	cube1.position.z = 90;
	this.app.scene.add(cube1);

	cubeMaterial = new THREE.MeshLambertMaterial({map:texture4});
	cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.position.x = -25;
	cube.position.y = -1;
	cube.position.z = 140;

	this.app.scene.add(cube);

	cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.position.x = 25;
	cube.position.y = -1;
	cube.position.z = 60;

	this.app.scene.add(cube);

	cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);
	cube1.position.x = 40;
	cube1.position.y = 5;
	cube1.position.z = 150;

	this.app.scene.add(cube1);

	cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);

	cube1.position.x = -40;
	cube1.position.y = 5;
	cube1.position.z = 70;
	this.app.scene.add(cube1);

	cubeMaterial = new THREE.MeshLambertMaterial({map:texture5});
	cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.position.x = 25;
	cube.position.y = -1;
	cube.position.z = 140;

	this.app.scene.add(cube);

	cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.position.x = -25;
	cube.position.y = -1;
	cube.position.z = 60;

	this.app.scene.add(cube);

	cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);
	cube1.position.x = -40;
	cube1.position.y = 5;
	cube1.position.z = 150;

	this.app.scene.add(cube1);

	cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);

	cube1.position.x = 40;
	cube1.position.y = 5;
	cube1.position.z = 70;
	this.app.scene.add(cube1);

	cubeMaterial = new THREE.MeshLambertMaterial({map:texture6});
	cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.position.x = -25;
	cube.position.y = -1;
	cube.position.z = 120;

	this.app.scene.add(cube);

	cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.position.x = 25;
	cube.position.y = -1;
	cube.position.z = 40;

	this.app.scene.add(cube);

	cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);
	cube1.position.x = 40;
	cube1.position.y = 5;
	cube1.position.z = 130;

	this.app.scene.add(cube1);

	cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);

	cube1.position.x = -40;
	cube1.position.y = 5;
	cube1.position.z = 50;
	this.app.scene.add(cube1);

	cubeMaterial = new THREE.MeshLambertMaterial({map:texture7});
	cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.position.x = 25;
	cube.position.y = -1;
	cube.position.z = 120;

	this.app.scene.add(cube);

	cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.position.x = -25;
	cube.position.y = -1;
	cube.position.z = 40;

	this.app.scene.add(cube);

	cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);
	cube1.position.x = -40;
	cube1.position.y = 5;
	cube1.position.z = 130;

	this.app.scene.add(cube1);

	cube1 = new THREE.Mesh(cubeGeometry1, cubeMaterial);

	cube1.position.x = 40;
	cube1.position.y = 5;
	cube1.position.z = 50;
	this.app.scene.add(cube1);

	var map = THREE.ImageUtils.loadTexture( "/resources/Three/images/c1.png" );

	var sprite = new THREE.Sprite( { map: map, useScreenCoordinates: false, color: 0xffffff } );

	sprite.scale.set(0.016, 0.0043);

	sprite.position.x = 11;
	sprite.position.y = -1.5;
	sprite.position.z = 180;

	this.app.scene.add(sprite);

	map = THREE.ImageUtils.loadTexture( "/resources/Three/images/c2.png" );

	sprite = new THREE.Sprite( { map: map, useScreenCoordinates: false, color: 0xffffff } );

	sprite.scale.set(0.016, 0.0043);

	sprite.position.x = -11;
	sprite.position.y = -1.5;
	sprite.position.z = 180;

	this.app.scene.add( sprite );

	map = THREE.ImageUtils.loadTexture( "/resources/Three/images/c3.png" );

	sprite = new THREE.Sprite( { map: map, useScreenCoordinates: false, color: 0xffffff } );

	sprite.scale.set(0.016, 0.0043);

	sprite.position.x = 11;
	sprite.position.y = -1.5;
	sprite.position.z = 160;

	this.app.scene.add( sprite );
	
	map = THREE.ImageUtils.loadTexture( "/resources/Three/images/c4.png" );

	sprite = new THREE.Sprite( { map: map, useScreenCoordinates: false, color: 0xffffff } );

	sprite.scale.set(0.016, 0.0043);

	sprite.position.x = -11;
	sprite.position.y = -1.5;
	sprite.position.z = 160;

	this.app.scene.add( sprite );

	map = THREE.ImageUtils.loadTexture( "/resources/Three/images/c4.png" );
	sprite = new THREE.Sprite( { map: map, useScreenCoordinates: false, color: 0xffffff } );

	sprite.scale.set(0.01, 0.003);

	sprite.position.x = -10;
	sprite.position.y = -2;
	sprite.position.z = 140;

	this.app.scene.add( sprite );

	sprite = new THREE.Sprite( { map: map, useScreenCoordinates: false, color: 0xffffff } );

	sprite.scale.set(0.01, 0.003);

	sprite.position.x = 10;
	sprite.position.y = -2;
	sprite.position.z = 140;

	this.app.scene.add( sprite );

	map = THREE.ImageUtils.loadTexture( "/resources/Three/images/s4.jpg" );

	sprite = new THREE.Sprite( { map: map, useScreenCoordinates: false, color: 0xffffff } );

	sprite.scale.set(0.01, 0.003);

	sprite.position.x = -10;
	sprite.position.y = -2;
	sprite.position.z = 120;

	this.app.scene.add( sprite );

	sprite = new THREE.Sprite( { map: map, useScreenCoordinates: false, color: 0xffffff } );

	sprite.scale.set(0.01, 0.003);

	sprite.position.x = 10;
	sprite.position.y = -2;
	sprite.position.z = 120;

	this.app.scene.add( sprite );

}


	Environment.prototype.createRoad = function()
{    
	var texture = null;	

	// Road texture by Arenshi
	// http://www.turbosquid.com/Search/Artists/Arenshi
	// http://www.turbosquid.com/FullPreview/Index.cfm/ID/414729		
	var texture = THREE.ImageUtils.loadTexture('/resources/Three/images/road-rotated.jpg');
    texture.wrapS = texture.wrapT = THREE.RepeatWrapping;
    texture.repeat.set(1, 40);

	var road = new THREE.Mesh( new THREE.PlaneGeometry( Environment.ROAD_WIDTH, 
			Environment.ROAD_LENGTH * 2),
			new THREE.MeshBasicMaterial( 
					{ color: 0xaaaaaa, shininess:100, ambient: 0x333333, map:texture } 
			) 
	);
	road.rotation.x = -Math.PI/2;
	road.position.y = 0 + Environment.GROUND_Y;
	this.app.scene.add( road );
	this.road = road;

}

// Environment.prototype.createFinishLine = function()
// {
// 	var texture = null;
//
// 	if (this.textureFinishLine)
// 	{
// 		texture = THREE.ImageUtils.loadTexture('/resources/Three/images/game-finish-line.png');
// 	}
// 	else
// 	{
// 		texture = null;
// 	}
//
// 	var finishsign = new THREE.Mesh( new THREE.PlaneGeometry( Environment.FINISH_SIGN_WIDTH,
// 			Environment.FINISH_SIGN_HEIGHT ),
// 			new THREE.MeshBasicMaterial(
// 			{ color: this.textureFinishLine ? 0xFFFFFF : 0xaaaaaa,
// 					shininess:100, ambient: 0x333333, map:texture }
// 			)
// 	);
// 	finishsign.position.z = -Environment.ROAD_LENGTH / 2 - Car.CAR_LENGTH * 2;
// 	finishsign.position.y = Environment.FINISH_SIGN_Y + Environment.GROUND_Y;
//
// 	this.app.scene.add( finishsign );
// 	this.finishsign = finishsign;
// }


Environment.prototype.update = function()
{
	if (this.textureSky)
	{
		this.sky.material.map.offset.x += 0.00005;
		this.sky1.material.map.offset.x += 0.00005;
	}
	
	if (this.app.running)
	{
		var now = Date.now();
		var deltat = now - this.curTime;
		this.curTime = now;

	}
		
	Sim.Object.prototype.update.call(this);
}

// Environment.prototype.handleMouseDown = function(x, y)
// {
// 	console.log(this);
// }

Environment.SKY_WIDTH = 3000;
Environment.SKY_HEIGHT = 600;
Environment.GROUND_Y = -10;
Environment.GROUND_WIDTH = 2000;
Environment.GROUND_LENGTH = 800;
Environment.ROAD_WIDTH = 10;
Environment.ROAD_LENGTH = 400;
Environment.RAIL_WIDTH = .2;
Environment.RAIL_LENGTH = Environment.ROAD_LENGTH;
Environment.ANIMATE_ROAD_FACTOR = 2;
Environment.FINISH_SIGN_WIDTH = 4.333;
Environment.FINISH_SIGN_HEIGHT = 1;
Environment.FINISH_SIGN_Y = 2.22;
Environment.NUM_SIGNS = 8;
Environment.SIGN_SCALE = .5;