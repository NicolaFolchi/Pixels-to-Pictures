package a3;

public class ImmutablePixelArrayPicture implements Picture {


	private int _w;
	private int _h;
	private Pixel initial_value;
	private Pixel[][]myPicture;

	// Creates new object using values provided by pixel_array, matching in size.
	public ImmutablePixelArrayPicture(Pixel[][] pixel_array) {
		if (pixel_array == null) {
			throw new IllegalArgumentException("array must not be null");
		}
		_w = pixel_array.length;
		_h = pixel_array[0].length;


		//	if (_w > pixel_array.length || _h > pixel_array[0].length) {
		//	throw new IllegalArgumentException("width or heightmust be less than 1");
		//}
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

		myPicture = pixel_array;
	}

	// Creates new object by providing geometry and initial value for all pixels.
	public ImmutablePixelArrayPicture(int width, int height, Pixel initial_value) {

		_w = width;
		_h = height;

		this.initial_value = initial_value;

		if (this.initial_value == null) {
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
				myPicture[i][h] =  initial_value;
			}
		}
	}

	// Creates new object by providing geometry. Initial value should be medium gray.
	public ImmutablePixelArrayPicture(int width, int height) {
		this(width, height, new GrayPixel(0.5));
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return myPicture.length;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return myPicture[0].length;
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
		Picture newPicture = new MutablePixelArrayPicture(myPicture);

		return newPicture.paint(x, y, p);
	}

	@Override
	public Picture paint(int x, int y, Pixel p, double factor) {
		// TODO Auto-generated method stub
		Picture newPicture = new MutablePixelArrayPicture(myPicture);

		return newPicture.paint(x, y, p, factor);
	}

	@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
		// TODO Auto-generated method stub
		Picture newPicture = new MutablePixelArrayPicture(myPicture);

		return newPicture.paint(ax, ay, bx, by, p);
	}

	@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
		// TODO Auto-generated method stub
		Picture newPicture = new MutablePixelArrayPicture(myPicture);

		return newPicture.paint(ax, ay, bx, by, p, factor);
	}

	@Override
	public Picture paint(int cx, int cy, double radius, Pixel p) {
		// TODO Auto-generated method stub
		Picture newPicture = new MutablePixelArrayPicture(myPicture);

		return newPicture.paint(cx, cy, radius, p);
	}

	@Override
	public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
		// TODO Auto-generated method stub
		Picture newPicture = new MutablePixelArrayPicture(myPicture);

		return newPicture.paint(cx, cy, radius, p, factor);
	}

}

