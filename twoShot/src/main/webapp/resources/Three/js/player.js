//Custom Car class
Player = function()
{
	Car.call(this);
}

Player.prototype = new Car();

Player.prototype.init = function(param)
{
	Car.prototype.init.call(this, param);



	this.camera = param.camera;
	this.speed = 0;
	this.acceleration = 0;
	this.rpm = 0;
	this.revStartTime = 0;
		
	
	this.keysDown = [];
	this.keysDown[Sim.KeyCodes.KEY_LEFT] = false;
	this.keysDown[Sim.KeyCodes.KEY_RIGHT] = false;
	this.keysDown[Sim.KeyCodes.KEY_UP] = false;
	this.keysDown[Sim.KeyCodes.KEY_DOWN] = false;

	this.keysUp = [];
	this.keysUp[Sim.KeyCodes.KEY_UP] = false;
	this.keysUp[Sim.KeyCodes.KEY_DOWN] = false;
}

Player.prototype.updateCamera = function()
{
	

	var camerapos = new THREE.Vector3(Player.CAMERA_OFFSET_X, 
			Player.CAMERA_OFFSET_Y, Player.CAMERA_OFFSET_Z);
			
	camerapos.addSelf(this.object3D.position);
	this.camera.position.copy(camerapos);
	this.camera.lookAt(this.object3D.position);


	// Rotate particle system to view-aligned to avoid nasty alpha sorting artifacts
	if (this.exhaust1)
	{
		this.exhaust1.object3D.rotation.x = this.camera.rotation.x;
	}
	
	if (this.exhaust2)
	{
		this.exhaust2.object3D.rotation.x = this.camera.rotation.x;
	}


}

Player.prototype.update = function()
{
	if (this.running)
	{

		// if (this.crashed)
		// {
		// 	this.speed -= (1000 / 3600);
		// 	if (this.speed < 0)
		// 	{
		// 		this.speed = 0;
		// 		this.running = false;
		// 	}
        //
		// }		

		var now = Date.now();
		var deltat = now - this.curTime;
		this.curTime = now;
		
		var turning = false;
		if (this.keysDown[Sim.KeyCodes.KEY_LEFT]) {
			// this.turn(-0.1);
			// turning = true;

			if (ang > 30/(180 / Math.PI)) {

			ang -= 1 / (180 / Math.PI);
			Player.CAMERA_OFFSET_X = 5 * Math.cos(ang);
			Player.CAMERA_OFFSET_Z = 5 * Math.sin(ang);
		}

		}
		
		if (this.keysDown[Sim.KeyCodes.KEY_RIGHT])
		{
			// this.turn(0.1);
			// turning = true;

			if (ang < 150/(180 / Math.PI)) {
				ang += 1 / (180 / Math.PI);
				Player.CAMERA_OFFSET_X = 5 * Math.cos(ang);
				Player.CAMERA_OFFSET_Z = 5 * Math.sin(ang);
			}
		}

		if (!turning)
		{
			this.turn(0);
		}
		
		if (this.keysDown[Sim.KeyCodes.KEY_UP])
		{
			this.speed=50;
		}
		else if (this.keysDown[Sim.KeyCodes.KEY_DOWN])
		{
			this.speed = -50;
		}


		if (this.keysUp[Sim.KeyCodes.KEY_UP])
		{
			this.speed = 0;
		}
		else if (this.keysUp[Sim.KeyCodes.KEY_DOWN])
		{
			this.speed = 0;
		}

		var dist = deltat / 1000 * this.speed / this.speedFactor;
		
		this.object3D.position.z -= dist;
		
		if(this.object3D.position.z>205){
			this.object3D.position.z = 204.8;
		}
		
		if(this.object3D.position.z<78){
			this.object3D.position.z = 78.2;
		}
		
		this.updateCamera();
		

	}	

	Sim.Object.prototype.update.call(this);

}

Player.prototype.turn = function(delta)
{
	this.object3D.position.x += delta;
	if (delta < 0)
	{
		this.object3D.rotation.y = Math.PI / 8;
	}
	else if (delta > 0)
	{
		this.object3D.rotation.y = -Math.PI / 8;
	}
	else
	{
		this.object3D.rotation.y = 0;
	}
}


Player.prototype.handleKeyDown = function(keyCode, charCode)
{
	this.keysDown[keyCode] = true;
}

Player.prototype.handleKeyUp = function(keyCode, charCode)
{
	this.keysDown[keyCode] = false;
	this.speed = 0;
}

ang = 90/(180/Math.PI);
//console.log(ang);
Player.CAMERA_OFFSET_X = 5*Math.cos(ang);
Player.CAMERA_OFFSET_Z = 5*Math.sin(ang);
Player.CAMERA_OFFSET_Y = .1;


// Player.CAMERA_OFFSET_X = 0;		// meters
// Player.CAMERA_OFFSET_Y = 3;
// Player.CAMERA_OFFSET_Z = 20;


Player.REV_LONG_THRESHOLD = 500; // ms