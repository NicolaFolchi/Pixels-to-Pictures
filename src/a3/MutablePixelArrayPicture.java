package a3;

//import com.sun.glass.ui.Pixels;

public class MutablePixelArrayPicture implements Picture {

	private Pixel[][] _pixels;

	// Creates new object using values provided by pixel_array, matching in size.
	public MutablePixelArrayPicture(Pixel[][] pixel_array) {

		if (pixel_array == null) {
			throw new IllegalArgumentException("array must not be null");
		}
		int _w = pixel_array.length;
		int _h = pixel_array[0].length;

		// if (_w > pixel_array.length || _h > pixel_array[0].length) {
		// throw new IllegalArgumentException("width or heightmust be less than 1");
		// }
		if (_w == 0) {
			throw new IllegalArgumentException("cant be 0");
		}

		for (int i = 0; i < _w; i++) {
			if (pixel_array[i] == null)
				throw new IllegalArgumentException(" width cant be null");
		}
		if (_h == 0) {
			throw new IllegalArgumentException("");
		}
		for (int h = 0; h < _w; h++) {
			if (pixel_array[h].length != _h) {
				throw new IllegalArgumentException("w and h are not equal");
			}
		}
		for (int j = 0; j < _w; j++) {
			for (int k = 0; k < _h; k++) {
				if (pixel_array[j][k] == null)
					throw new IllegalArgumentException("values in the array cant be null");
			}
		}

		/*
		 * if (_w < 0 || _h < 0) { throw new
		 * IllegalArgumentException("width or height must be greater than 0"); }
		 */

		_pixels = new Pixel[_w][_h];

		for (int l = 0; l < _w; l++) {
			for (int m = 0; m < _h; m++) {
				_pixels[l][m] = pixel_array[l][m];
			}
		}
	}

	// Creates new object by providing geometry of picture and an initial value for
	// all pixels.
	public MutablePixelArrayPicture(int width, int height, Pixel initial_value) {
		int _w = width;
		int _h = height;

		/*
		 * if (_pixels == null) { throw new
		 * IllegalArgumentException("array must not be null"); } if (_w > _pixels.length
		 * || _h > _pixels[0].length) { throw new
		 * IllegalArgumentException("width or heightmust be less than 1"); }
		 */

		if (_w < 1 || _h < 1) {
			throw new IllegalArgumentException("width or height must be greater than 0");
		}

		_pixels = new Pixel[_w][_h];

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				_pixels[i][j] = initial_value;
			}
		}
	}

	// Creates new object by providing geometry of picture.
	// Initial value of all pixels should be medium gray (i.e., a grayscale pixel
	// with intensity 0.5)
	public MutablePixelArrayPicture(int width, int height) {

		/*
		 * if (_pixels == null) { throw new
		 * IllegalArgumentException("array must not be null"); }
		 * 
		 * if (_w < 0 || _h < 0) { throw new
		 * IllegalArgumentException("width or height must be greater than 0"); }
		 */
		this(width, height, new GrayPixel(0.5));

	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		/*
		 * if (_pixels.length < 0) { throw new
		 * IllegalArgumentException("width must be greater than 0"); } if (_w >
		 * _pixels.length) { throw new
		 * IllegalArgumentException("width must be less than 1"); }
		 */
		return _pixels.length;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		/*
		 * if (_h < 0) { throw new
		 * IllegalArgumentException("height must be greater than 0"); } if (_h >
		 * _pixels[0].length) { throw new
		 * IllegalArgumentException("height must be less than 1"); }
		 */
		return _pixels[0].length;
	}

	@Override
	public Pixel getPixel(int x, int y) {
		// TODO Auto-generated method stub
		if (_pixels == null) {
			throw new IllegalArgumentException("array must not be null");
		}
		if (x < 0 || x >= this.getWidth()) {
			throw new IllegalArgumentException("x is illegal");
		}
		if (y < 0 || y >= this.getHeight()) {
			throw new IllegalArgumentException("y is illegal");
		}

		return this._pixels[x][y];
	}

	@Override
	public Picture paint(int x, int y, Pixel p) {
		// TODO Auto-generated method stub
		if (p == null) {
			throw new IllegalArgumentException("Pixel cant be null");
		}

		if (x > _pixels.length || y > _pixels[0].length) {
			throw new IllegalArgumentException("width or heightmust be less than 1");
		}

		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("width or height must be greater than 0");
		}

		_pixels[x][y] = p;

		return this;
	}

	@Override
	public Picture paint(int x, int y, Pixel p, double factor) {
		// TODO Auto-generated method stub

		if (p == null) {
			throw new IllegalArgumentException("Pixel cant be null");
		}

		if (x >= _pixels.length || y >= _pixels[0].length) {
			throw new IllegalArgumentException("width or heightmust be less than 1");
		}

		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("width or height must be greater than 0");
		}

		if (factor > 1 || factor < 0) {
			throw new IllegalArgumentException("factpr cant be null");
		}

		if (factor == 0) {
			return this;
		}
		if (factor == 1) {
			_pixels[x][y] = p;
		}
		if (factor > 0 && factor < 1) {
			_pixels[x][y].blend(p, factor);
		}

		return this;
	}

	@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
		// TODO Auto-generated method stub


		if (p == null) {
			throw new IllegalArgumentException("Pixel cant be null");
		}
		if (ax < 0) {
			ax = 0;
		}
		if (ay < 0) {
			ay = 0;
		}
		if (ax >= _pixels.length) {
			ax = _pixels.length - 1;
		}
		if (ay >= _pixels[0].length) {
			ay = _pixels[0].length - 1;
		}
		if (bx >= _pixels.length) {
			bx = _pixels.length - 1;
		}
		if (by >= _pixels[0].length) {
			by = _pixels[0].length - 1;
		}
		if (bx < 0) {
			bx = 0;
		}
		if (by < 0) {
			by = 0;
		}

		int minX=0;
		int maxX=0;
		int minY=0;
		int maxY=0;

		if (bx > ax) {
			maxX = bx;
			minX = ax;
		}
		else if (ax > bx) {
			maxX = ax;
			minX = bx;
		}
		if (by < ay) {
			maxY = ay;
			minY = by;
		}
		else if (ay < by) {
			maxY = by;
			minY = ay;
		}
			for (int i = minX; i <= maxX; i++) {
				for (int j = minY; j <= maxY; j++) {
					_pixels[i][j] = p;
				}
			}
			return this;
		}

		@Override
		public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
			// TODO Auto-generated method stub
			if (p == null) {
				throw new IllegalArgumentException("Pixel cant be null");
			}
			if (ax < 0) {
				ax = 0;
			}
			if (ay < 0) {
				ay = 0;
			}
			if (bx >= _pixels.length) {
				bx = _pixels.length - 1;
			}
			if (by >= _pixels[0].length) {
				by = _pixels[0].length - 1;
			}

			if (factor == 0) {
				return this;
			}
			if (factor == 1) {
				for (int i = ax; i <= bx; i++) {
					for (int j = ay; i <= by; j++) {
						_pixels[i][j] = p;
					}
				}
			}

			if (factor > 0 && factor < 1) {
				for (int i = ax; i <= bx; i++) {
					for (int j = ay; i <= by; j++) {
						_pixels[i][j].blend(p, factor);
					}
				}
			}
			return this;
		}

		@Override
		public Picture paint(int cx, int cy, double radius, Pixel p) {
			// TODO Auto-generated method stub
			int x = _pixels.length;
			int y = _pixels[0].length;
			if (radius < 0.0) {
				throw new IllegalArgumentException("Radius cannot be negative");
			}
			// pixelFactorCheck(p);
			for (int i = 0; i < _pixels.length; i++) {
				for (int j = 0; j < _pixels[0].length; j++) {
					double distance = Math.sqrt(((i - cx) * (i - cx)) + ((j - cy) * (j - cy)));
					if (distance <= radius) {
						_pixels[i][j] = p;
					}
				}
			}

			return this;
		}

		@Override
		public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
			// TODO Auto-generated method stub
			int x = _pixels.length;
			int y = _pixels[0].length;
			if (radius < 0.0) {
				throw new IllegalArgumentException("Radius cannot be negative");
			}

			if (factor == 0) {
				return this;
			}
			// pixelFactorCheck(p);
			if (factor == 1) {
				for (int i = 0; i < _pixels.length; i++) {
					for (int j = 0; j < _pixels[0].length; j++) {
						double distance = Math.sqrt(((i - cx) * (i - cx)) + ((j - cy) * (j - cy)));
						if (distance <= radius) {
							_pixels[i][j] = p;
						}
					}
				}
			}

			if (factor > 0 && factor < 1) {
				for (int i = 0; i < _pixels.length; i++) {
					for (int j = 0; j < _pixels[0].length; j++) {
						double distance = Math.sqrt(((i - cx) * (i - cx)) + ((j - cy) * (j - cy)));
						if (distance <= radius) {
							_pixels[i][j].blend(p, factor);
						}
					}
				}
			}

			return this;
		}
	}
