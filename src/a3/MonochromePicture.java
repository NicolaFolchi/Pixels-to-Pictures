package a3;

public class MonochromePicture implements Picture {

	private int _w, _h;
	private Pixel value;
	Pixel[][] myPicture;
	
	
	public MonochromePicture(int width, int height, Pixel value) {

		_w = width;
		_h = height;
		
		this.value = value;
		
		if (this.value == null) {
			throw new IllegalArgumentException("value cant be null");
		}
		
		if (_w < 1 || _h < 1) {
			throw new IllegalArgumentException("width or height must be greater than 1");
		}

		if (_w < 0 || _h < 0) {
			throw new IllegalArgumentException("width or height must be greater than 0");
		}
		
		myPicture = new Pixel[_w][_h];
		
		for (int i = 0; i < width; i++) {
			for (int h = 0; h < height; h++) {
				myPicture[i][h] =  value;
			}
		}
	}
	
	
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		if (_w < 0) {
			throw new IllegalArgumentException("width must be greater than 0");
		}
		if (_w > myPicture.length) {
			throw new IllegalArgumentException("width must be less than 1");
		}
		return this._w;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		if (_h < 0) {
			throw new IllegalArgumentException("height must be greater than 0");
		}
		if (_h > myPicture[0].length) {
			throw new IllegalArgumentException("height must be less than 1");
		}
		return this._h;
	}

	@Override
	public Pixel getPixel(int x, int y) {
		// TODO Auto-generated method stub
		if (myPicture == null) {
			throw new IllegalArgumentException("array must not be null");
		}
		if (x < 0 || x >= this.getWidth()) {
			throw new IllegalArgumentException("x is illegal");
		}
		if (y < 0 || y >= this.getHeight()) {
			throw new IllegalArgumentException("y is illegal");
		}

		return myPicture[x][y];	
		}

	@Override
	public Picture paint(int x, int y, Pixel p) {
		// TODO Auto-generated method stub
		//Pixel [][] newPixels = new Pixel[_w][_h];
		
		Picture newPicture = new MutablePixelArrayPicture(myPicture);
		
		 return newPicture.paint(x, y, p);
		
		
	/*	if (p == null) {
			throw new IllegalArgumentException("Pixel cant be null");
		} else if (x < 1 || y < 1) {
			throw new IllegalArgumentException("width or heightmust be greater than 1");
		}

		else if (x < 0 || y < 0) {
			throw new IllegalArgumentException("width or height must be greater than 0");
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				newPixels[i][j] = p;
			}
		}
		return new MutablePixelArrayPicture(newPixels);*/
	}

	@Override
	public Picture paint(int x, int y, Pixel p, double factor) {
		// TODO Auto-generated method stub
		Pixel [][] newPixels = new Pixel[x][y];

		
		if (p == null) {
			throw new IllegalArgumentException("Pixel cant be null");
		}
		
		if (x > newPixels.length || y > newPixels[0].length) {
			throw new IllegalArgumentException("width or heightmust be less than 1");
		}

		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("width or height must be greater than 0");
		}
		
		if (factor == 0) {
			return this;
		} 
		if (factor == 1) {
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					newPixels[i][j] = p;
				}
			}
		}

		if (factor > 0 && factor < 1) {
			newPixels[x][y].blend(p, factor);
		}

		return new MutablePixelArrayPicture(newPixels);
	}

	@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
		// TODO Auto-generated method stub
		
		Picture newPicture = new MutablePixelArrayPicture(myPicture);
		
		 return newPicture.paint(ax, ay, bx, by, p);
		
		/*Pixel [][] newPixels = new Pixel[_w][_h];
		
		if (p == null) {
			throw new IllegalArgumentException("Pixel cant be null");
		}
		if (ax < 0) {
			ax = 0;
		}
		if (ay < 0) {
			ay = 0;
		}
		if (bx >= newPixels.length) {
			bx = newPixels.length - 1;
		}
		if (by >= newPixels[0].length) {
			by = newPixels[0].length - 1;
		}

		for (int i = ax; i <= bx; i++) {
			for (int j = ay; j <= by; j++) {
				newPixels[i][j] = p;
			}
		}

		return new MutablePixelArrayPicture(newPixels);*/
	}

	@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
		// TODO Auto-generated method stub
		Pixel [][] newPixels = new Pixel[_w][_h];

		
		if (p == null) {
			throw new IllegalArgumentException("Pixel cant be null");
		}
		if (ax < 0) {
			ax = 0;
		}
		if (ay < 0) {
			ay = 0;
		}
		if (bx >= newPixels.length) {
			bx = newPixels.length - 1;
		}
		if (by >= newPixels[0].length) {
			by = newPixels[0].length - 1;
		}

		if (factor == 0) {
			return this;
		}
		if (factor == 1) {
		for (int i = ax; i <= bx; i++) {
			for (int j = ay; i <= by; j++) {
				newPixels[i][j] = p;
			}
		}
		}
		
		if (factor > 0 && factor < 1) {
			for (int i = ax; i <= bx; i++) {
				for (int j = ay; i <= by; j++) {
					newPixels[i][j].blend(p, factor);
				}
			}
		}
		return new MutablePixelArrayPicture(newPixels);
	}

	@Override
	public Picture paint(int cx, int cy, double radius, Pixel p) {
		// TODO Auto-generated method stub

		Picture newPicture = new MutablePixelArrayPicture(myPicture);
		
		 return newPicture.paint(cx, cy, radius, p);
		
		/*int x = _w;
		int y = _h;
		if (radius < 0.0) {
			throw new IllegalArgumentException("Radius cannot be negative");
		}
		// pixelFactorCheck(p);
		for (int i = 0; i < _w; i++) {
			for (int j = 0; j < _h; j++) {
				double distance = Math.sqrt(((i - cx) * (i - cx)) + ((j - cy) * (j - cy)));
				if (distance <= radius) {
					newPixels[i][j] = p;
				}
			}
		}

		return new MutablePixelArrayPicture(newPixels);*/
		
	}

	@Override
	public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
		// TODO Auto-generated method stub
		Pixel [][] newPixels = new Pixel[_w][_h];

		int x = _w;
		int y = _h;
		if (radius < 0.0) {
			throw new IllegalArgumentException("Radius cannot be negative");
		}

		if (factor == 0) {
			return this;
		}
		// pixelFactorCheck(p);
		if (factor == 1) {
			for (int i = 0; i < _w; i++) {
				for (int j = 0; j < _h; j++) {
					double distance = Math.sqrt(((i - cx) * (i - cx)) + ((j - cy) * (j - cy)));
					if (distance <= radius) {
						newPixels[i][j] = p;
					}
				}
			}
		}
		
		if (factor > 0 && factor < 1) {
			for (int i = 0; i < _w; i++) {
				for (int j = 0; j < _h; j++) {
					double distance = Math.sqrt(((i - cx) * (i - cx)) + ((j - cy) * (j - cy)));
					if (distance <= radius) {
						newPixels[i][j].blend(p, factor);
					}
				}
			}
		}

		return new MutablePixelArrayPicture(newPixels);
	}

}
