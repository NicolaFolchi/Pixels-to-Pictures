package a3;

public class HorizontalStackPicture implements Picture{
	private Picture leftPic;
	private Picture rightPic;
	
	public HorizontalStackPicture(Picture left, Picture right) {
		
		if (left == null) {
			throw new IllegalArgumentException("left cant be null");
		}
		if (right == null) {
			throw new IllegalArgumentException("right cant be null");
		}
		
		if (left.getHeight() != right.getHeight()) {
			throw new IllegalArgumentException("Picture A and B heights are not equal");
		}
		
		
		leftPic = left;
		rightPic = right;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return leftPic.getWidth()+ rightPic.getWidth();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return leftPic.getHeight();
	}

	@Override
	public Pixel getPixel(int x, int y) {
		// TODO Auto-generated method stub
		
		if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
			throw new IllegalArgumentException("");
		}
		if(x < leftPic.getWidth()) {
			return leftPic.getPixel(x, y);
		} else {
			return rightPic.getPixel(x - leftPic.getWidth(), y);
		}
	}

	@Override
	public Picture paint(int x, int y, Pixel p) {
		// TODO Auto-generated method stub
		if(x >= leftPic.getWidth()) {
			rightPic = rightPic.paint(x - leftPic.getWidth(), y, p);
		} else {
			leftPic =  leftPic.paint(x, y, p);
		}
		return this;
	}

	@Override
	public Picture paint(int x, int y, Pixel p, double factor) {
		// TODO Auto-generated method stub
		if (p == null) {
			throw new IllegalArgumentException("Pixel cant be null");
		}

		if (x >= leftPic.getWidth() || y >= getHeight()) {
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
		if ( x >= leftPic.getWidth() ) {
			if (factor == 1) {
				rightPic = rightPic.paint(x, y, p);
			} else if (factor > 0 && factor < 1) {
				rightPic = rightPic.paint(x, y, p, factor);
			}
		}
		else {
			leftPic = leftPic.paint(x, y, p, factor);
		}

		return this;
	}

	@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
		// TODO Auto-generated method stub
		Picture newPicture = new HorizontalStackPicture(leftPic, rightPic);

		return newPicture.paint(ax, ay, bx, by, p);
	}

	@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
		// TODO Auto-generated method stub
		Picture newPicture = new HorizontalStackPicture(leftPic, rightPic);

		return newPicture.paint(ax, ay, bx, by, p, factor);
	}

	@Override
	public Picture paint(int cx, int cy, double radius, Pixel p) {
		// TODO Auto-generated method stub
		Picture newPicture = new HorizontalStackPicture(leftPic, rightPic);

		return newPicture.paint(cx, cy, radius, p);
	}

	@Override
	public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
		// TODO Auto-generated method stub
		Picture newPicture = new HorizontalStackPicture(leftPic, rightPic);

		return newPicture.paint(cx, cy, radius, p, factor);
	}

}
