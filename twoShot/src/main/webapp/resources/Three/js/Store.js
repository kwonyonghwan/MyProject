
Store = function()
{
	Sim.Object.call(this);
}

Store.prototype = new Sim.Object();

Store.prototype.init = function(param)
{
	// Create a group to contain model
	this.id = param.id;
	var url = param.url;
	this.header = param.header;
	this.content = param.content;
	this.img = param.img;
	this.etc = param.etc;
	var x = param.x;
	var y = param.y;
	var z = param.z;

	// Tell the framework about our object


	// Load the model
	var texture = THREE.ImageUtils.loadTexture(url);
	texture.wrapS = texture.wrapT = THREE.RepeatWrapping;

	var cubeGeometry = new THREE.CubeGeometry(8, 6, 8);
	var cubeMaterial = new THREE.MeshLambertMaterial({map:texture});
	var cube = new THREE.Mesh(cubeGeometry, cubeMaterial);

	cube.position.x = x;
	cube.position.y = y;
	cube.position.z = z;

	this.setObject3D(cube);
}

Store.prototype.handleMouseUp = function(x, y, position)
{
	console.log(this);
	console.log("-----------------------")

	var headerHtml = this.header;
	var contentsHtml = this.content;
	var imgHtml = this.img;
	var etcHtml = this.etc;

	var callout = document.getElementById("callout");
	var calloutHeader = document.getElementById("header");
	var calloutContents = document.getElementById("contents");
	var calloutimg = document.getElementById("img");
	var calloutetc = document.getElementById("etc")
	calloutHeader.innerHTML = headerHtml;
	calloutContents.innerHTML = contentsHtml;
	calloutimg.innerHTML = imgHtml;
	calloutetc.innerHTML = etcHtml
	callout.style.display = "block";

}