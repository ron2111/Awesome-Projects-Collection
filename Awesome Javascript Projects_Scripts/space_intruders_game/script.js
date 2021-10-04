// Helper Functions
function AABBIntersect(ax, ay, aw, ah, bx, by, bw, bh) {

	return ax < bx + bw && bx < ax + aw && ay < by + bh && by < ay + ah;

};

function Bullet(x, y, vely, w, h, color) {

	this.x = x;

	this.y = y;

	this.vely = vely;

	this.width = w;

	this.height = h;

	this.color = color;

};

Bullet.prototype.update = function() {

	this.y += this.vely;

};

// Screen
function Screen(width, height) {

	this.canvas = document.createElement("canvas");

	this.canvas.width = this.width = width;

	this.canvas.height = this.height = height;

	this.ctx = this.canvas.getContext("2d");

	document.body.appendChild(this.canvas);

};

Screen.prototype.clear = function() {

	this.ctx.clearRect(0, 0, this.width, this.height);

};

Screen.prototype.drawSprite = function(sp, x, y) {

	this.ctx.drawImage(sp.img, sp.x, sp.y, sp.w, sp.h, x, y, sp.w, sp.h);

}; 

Screen.prototype.drawBullet = function(bullet) {

	this.ctx.fillStyle = bullet.color;

	this.ctx.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);

};

// Sprite
function Sprite(img, x, y, w, h) {

	this.img = img;

	this.x = x;

	this.y = y;

	this.w = w;

	this.h = h;

};

// Input Handler
function inputHandler() {

	this.down = {};

	this.pressed = {};

	var _this = this;

	document.addEventListener("keydown", function(evt) {

		_this.down[evt.keyCode] = true;

	});

	document.addEventListener("keyup", function(evt) {

		delete _this.down[evt.keyCode];

		delete _this.pressed[evt.keyCode];

	});

};

inputHandler.prototype.isDown = function(code) {

	return this.down[code];

};

inputHandler.prototype.isPressed = function(code) {

	if (this.pressed[code]) {

		return false; 

	} else if (this.down[code]) {

		return this.pressed[code] = true;

	}

	return false;

};

var display, input, frames, spFrame, lvFrame;

var alSprite, taSprite, ciSprite;

var aliens, dir, tank, bullets, cities;

function main() {

	display = new Screen(504, 600);

	input = new inputHandler();

	var img = new Image();

	img.addEventListener("load", function() {

		alSprite = [

			[new Sprite(this, 0, 0, 22, 16), new Sprite(this, 0, 16, 22, 16)],

			[new Sprite(this, 22, 0, 16, 16), new Sprite(this, 22, 16, 16, 16)],

			[new Sprite(this, 38, 0, 24, 16), new Sprite(this, 38, 16, 24, 16)]

		]; 

		taSprite = new Sprite(this, 62, 0, 22, 16);

		ciSprite = new Sprite(this, 84, 8, 36, 24);

		init();

		run();

	});

	img.src = "intruders.png";


};

function init() {

	frames = 0;

	spFrame = 0;

	lvFrame = 60;

	dir = 1;

	tank = {

		sprite: taSprite,
		x: (display.width - taSprite.w) / 2,
		y: display.height - (30 + taSprite.h),

	};

	bullets = [];

	cities = {

		canvas: null,

		ctx: null,

		y: tank.y - (30 + ciSprite.h),

		h: ciSprite.h,

		init: function() {

			this.canvas = document.createElement("canvas");

			this.canvas.width = display.width;

			this.canvas.height = this.h;

			this.ctx = this.canvas.getContext("2d");

			for (var i = 0; i < 4; i++) {

				this.ctx.drawImage(ciSprite.img, ciSprite.x, ciSprite.y, ciSprite.w, ciSprite.h, 
					68 + 111 * i, 0, ciSprite.w, ciSprite.h);

			}

		},

		generateDamage: function(x, y) {

			x = Math.floor(x / 2) * 2;

			y = Math.floor(y / 2) * 2;

			this.ctx.clearRect(x-2, y-2, 4, 4);
			this.ctx.clearRect(x+2, y-4, 2, 4);
			this.ctx.clearRect(x+4, y, 2, 2);
			this.ctx.clearRect(x+2, y+2, 2, 2);
			this.ctx.clearRect(x-4, y+2, 2, 2);
			this.ctx.clearRect(x-6, y, 2, 2);
			this.ctx.clearRect(x-4, y-4, 2, 2);
			this.ctx.clearRect(x-2, y-6, 2, 2);

		},

		hits: function(x, y) {

			y -= this.y;

			var data = this.ctx.getImageData(x, y, 1, 1);

			if (data.data[3] !== 0) {

				this.generateDamage(x, y);

				return true;

			}

			return false;

		}

	};

	cities.init();

	aliens = [];

	var rows = [1, 0, 0, 2, 2];

	for (var i = 0, len = rows.length; i < len; i++) {

		for (var j = 0; j < 10; j++) {

			var a = rows[i];

			aliens.push({

				sprite: alSprite[a],
				x: 30 + j * 30 + [0, 4, 0][a],
				y: 30 + i * 30,
				w: alSprite[a][0].w,
				h: alSprite[a][0].h

			});
		}
	}
};

function run() {

	var loop = function() {

		update();

		render();

		window.requestAnimationFrame(loop, display.canvas);

	};

	window.requestAnimationFrame(loop, display.canvas);

};

function update() {

	if (input.isDown(37)) {

		tank.x -= 4;

	}

	if (input.isDown(39)) {

		tank.x += 4;

	}

	tank.x = Math.max(Math.min(tank.x, display.width - (30 + taSprite.w)), 30);

	if (input.isPressed(32)) {

		bullets.push(new Bullet(tank.x + 10, tank.y, -8, 2, 6, "#fff"));

	}

	for (var i = 0, len = bullets.length; i < len; i++) {

		var b = bullets[i];

		b.update();

		if (b.y + b.height < 0 || b.y > display.height) {

			bullets.splice(i, 1);

			i--;

			len--;

			continue;

		}

		var h2 = b.height * 0.5;

		if (cities.y < b.y + h2 && b.y + h2 < cities.y +cities.h) {

			if (cities.hits(b.x, b.y + h2)) {

				bullets.splice(i, 1);

				i--;

				len--;

				continue;

			}
		} 

		for (var j = 0, len2 = aliens.length; j < len2; j++) {

			var a = aliens[j];

			if (AABBIntersect(b.x, b.y, b.width, b.height, a.x, a.y, a.w, a.h)) {

				aliens.splice(j, 1);

				j--;

				len2--;

				bullets.splice(i, 1);

				i--;

				len--;

				switch (len2) {

					case 30: {
						this.lvFrame = 40;
						break;
					}

					case 10: {
						this.lvFrame = 20;
						break;
					}

					case 5: {
						this.lvFrame = 15;
						break;
					}

					case 1: {
						this.lvFrame = 6;
						break;
					}
				}
			}
		}
	}

	if (Math.random() < 0.03 && aliens.length > 0) {

		var a = aliens[Math.round(Math.random() * (aliens.length - 1))];

		for (var i = 0, len = aliens.length; i < len; i++) {

			var b = aliens[i];

			if (AABBIntersect(a.x, a.y, a.w, 100, b.x, b.y, b.w, b.h)) {

				a = b;

			}

		}

		bullets.push(new Bullet(a.x + a.w * 0.5, a.y + a.h, 4, 2, 4, "#fff"));
		
	}

	frames++;

	if (frames % lvFrame === 0) {

		spFrame = (spFrame + 1) % 2;

		var _max= 0, _min = display.width;

		for (var i = 0, len = aliens.length; i < len; i++) {

			var a = aliens[i];

			a.x += 30 * dir;

			_max = Math.max(_max, a.x + a.w);

			_min = Math.min(_min, a.x);

		}

		if (_max > display.width - 30 || _min < 30) {

			dir += -1;

			for (var i = 0, len = aliens.length; i < len; i++) {

				aliens[i].x += 30 * dir;

				aliens[i].y += 30;

			}
		}
	}

};

function render() {

	display.clear();

	for (var i = 0, len = aliens.length; i < len; i++) {

		var a = aliens[i];

		display.drawSprite(a.sprite[spFrame], a.x, a.y);

	}

	display.ctx.save();

	for (var i = 0, len = bullets.length; i < len; i++) {

		display.drawBullet(bullets[i]);

	}

	display.ctx.restore();

	display.ctx.drawImage(cities.canvas, 0, cities.y);

	display.drawSprite(tank.sprite, tank.x, tank.y);

};

main();
