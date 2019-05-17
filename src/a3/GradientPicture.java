package a3;

public class GradientPicture implements Picture{
	
	private int _w, _h;
	private Pixel upperLeft, upperRight, lowerLeft, lowerRight;
	//Pixel[][] myPicture;
	
	public GradientPicture(int width, int height, Pixel upper_left, Pixel upper_right, Pixel lower_left, Pixel lower_right) {
		
		if (width < 2 || height < 2) {
			throw new IllegalArgumentException("width or height must be greater than 1");
		}

		/*if (width < 0 || height < 0) {
			throw new IllegalArgumentException("width or height must be greater than 0");
		}*/
		
		if (upper_left  == null || upper_right == null || lower_left == null || lower_right == null) {
			throw new IllegalArgumentException("cant be less than 0");
		}
		
		_w = width;
		_h = height;			
		
		
		upperLeft = upper_left;
		upperRight = upper_right;
		lowerLeft = lower_left;
		lowerRight = lower_right;
	
		
		
		//myPicture = new Pixel[_w][_h];

	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return _w;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return _h;
	}

	@Override
	public Pixel getPixel(int x, int y) {
		// TODO Auto-generated method stub
		/*if (myPicture == null) {
			throw new IllegalArgumentException("array must not be null");
		}*/
		if (x < 0 || x >= getWidth()) {
			throw new IllegalArgumentException("x is illegal");
		}
		if (y < 0 || y >= getHeight()) {
			throw new IllegalArgumentException("y is illegal");
		}
		double factor = (y*1.0) / (getHeight()-1);
		
		Pixel start_of_row = upperLeft.blend(lowerLeft, factor);
		Pixel end_of_row = upperRight.blend(lowerRight, factor);
		
		return start_of_row.blend(end_of_row, ((x*1.0) / (getWidth()-1)));
		
		
		/*double factor;
		int row_num = _h;
		int col_num = _w;
		
		if (_h == 0) {
			factor = 0.0;
			Pixel start_of_row = upperLeft.blend(lowerLeft, factor);
			Pixel end_of_row = upperRight.blend(lowerRight, factor);
			factor = 0;
			factor = (1.0 / (getWidth()-1.0)) * col_num;
			return start_of_row.blend(end_of_row, ( factor));
		}
		
		if (_h == getHeight()) {
			factor = 1.0;
			Pixel start_of_row = upperLeft.blend(lowerLeft, factor);
			Pixel end_of_row = upperRight.blend(lowerRight, factor);
			factor = 0;
			factor = (1.0 / (getWidth()-1.0)) * col_num;
			return start_of_row.blend(end_of_row, ( factor));
			
		}
		else {
		//when the pixel is in the middle of the row and we need to blend it:::
		factor = (1.0 / (getHeight()-1.0)) * row_num;
		
		
		//blending the four sides to find the actual pixel to work with
		Pixel start_of_row = upperLeft.blend(lowerLeft, factor);
		Pixel end_of_row = upperRight.blend(lowerRight, factor);
		
		
		factor = 0;
		factor = (1.0 / (getWidth()-1.0)) * col_num;
		return start_of_row.blend(end_of_row,  factor);
		}*/
		//return myPicture[x][y];	*/
		
	}

	@Override
	public Picture paint(int x, int y, Pixel p) {
		// TODO Auto-generated method stub
		Pixel[][] myPicture = new Pixel[getWidth()][getHeight()];
		
		for(int i = 0; i < getWidth(); i++) {
			for(int h = 0; h < getHeight(); h++) {
				myPicture[i][h] = getPixel(i,h);
			}
		}

		Picture newPicture = new MutablePixelArrayPicture(myPicture);
		
		 return newPicture.paint(x, y, p);
	}

	@Override
	public Picture paint(int x, int y, Pixel p, double factor) {
		// TODO Auto-generated method stub
		Pixel[][] myPicture = new Pixel[getWidth()][getHeight()];
				
		for(int i = 0; i < getWidth(); i++) {
			for(int h = 0; h < getHeight(); h++) {
				myPicture[i][h] = getPixel(i,h);
			}
		}
		Picture newPicture = new MutablePixelArrayPicture(myPicture);

		return newPicture.paint(x, y, p, factor);
	}

	@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
		// TODO Auto-generated method stub
		Pixel[][] myPicture = new Pixel[getWidth()][getHeight()];
		
		for(int i = 0; i < getWidth(); i++) {
			for(int h = 0; h < getHeight(); h++) {
				myPicture[i][h] = getPixel(i,h);
			}
		}

		Picture newPicture = new MutablePixelArrayPicture(myPicture);
		
		 return newPicture.paint(ax, ay, bx, by, p);
	}

	@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
		// TODO Auto-generated method stub
		Pixel[][] myPicture = new Pixel[getWidth()][getHeight()];
		
		for(int i = 0; i < getWidth(); i++) {
			for(int h = 0; h < getHeight(); h++) {
				myPicture[i][h] = getPixel(i,h);
			}
		}

		Picture newPicture = new MutablePixelArrayPicture(myPicture);
		
		return newPicture.paint(ax, ay, bx, by, p, factor);
	}

	@Override
	public Picture paint(int cx, int cy, double radius, Pixel p) {
		// TODO Auto-generated method stub
		Pixel[][] myPicture = new Pixel[getWidth()][getHeight()];
		
		for(int i = 0; i < getWidth(); i++) {
			for(int h = 0; h < getHeight(); h++) {
				myPicture[i][h] = getPixel(i,h);
			}
		}

		Picture newPicture = new MutablePixelArrayPicture(myPicture);
		
		 return newPicture.paint(cx, cy, radius, p);
	}

	@Override
	public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
		// TODO Auto-generated method stub
		return null;
	}

}
