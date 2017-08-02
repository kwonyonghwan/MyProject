//Custom Exhaust class
Exhaust = function()
{
	Sim.Object.call(this);
}

Exhaust.prototype = new Sim.Object();

Exhaust.prototype.init = function(param)
{
	this.setObject3D(new THREE.Object3D);
	
	this.initParticles();
}

Exhaust.prototype.initParticles = function()
{
	var sphereRadius = 1;
	
	var particleCount = 100;
	var particles = new THREE.Geometry();


	var pMaterial = new THREE.ParticleBasicMaterial({
			color: 0xffffff,
			size: 1,
			opacity:.05,
			transparent:true
		});

	// create the particle system
	var particleSystem = new THREE.ParticleSystem(
		particles,
		pMaterial);

	particleSystem.position.y = sphereRadius*-0.2;

	particleSystem.sortParticles = false;

	// add it to the scene
	this.object3D.add(particleSystem);

	this.particleCount = particleCount;
	this.particles = particles;
	this.particleSystem = particleSystem;
	this.sphereRadius = sphereRadius;
}