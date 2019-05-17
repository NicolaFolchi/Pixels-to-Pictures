package a3;

public class VerticalStackPicture implements Picture{

	Picture topPic;
	Picture bottomPic;
	
	public VerticalStackPicture(Picture top, Picture bottom) {
		if (top == null) {
			throw new IllegalArgumentException("top cant be null");
		}
		if (bottom == null) {
			throw new IllegalArgumentException("bottom cant be null");
		}
		if(top.getWidth() != bottom.getWidth()) {
			throw new IllegalArgumentException("picture A and B widths are not equal");
		}
		/*if (top.getHeight() != bottom.getHeight()) {
			throw new IllegalArgumentException("Picture A and B heights are not equal");
		}*/
		
		
		topPic = top;
		bottomPic = bottom;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return topPic.getWidth();
	}


	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return topPic.getHeight() + bottomPic.getHeight();
	}
	
	@Override
	public Pixel getPixel(int x, int y) {
		// TODO Auto-generated method stub
		if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
			throw new IllegalArgumentException("");
		}
		if(y < topPic.getHeight()) {
			return topPic.getPixel(x, y);
		} else {
			return bottomPic.getPixel(x, y - topPic.getHeight());
		}
	}

	@Override
	
	public Picture paint(int x, int y, Pixel p) {
		// TODO Auto-generated method stub
		//Picture newPicture = new VerticalStackPicture(topPic, bottomPic);
		if (p == null) {
			throw new IllegalArgumentException("Pixel cant be null");
		}

		if (x > topPic.getWidth() || y > getHeight()) {
			throw new IllegalArgumentException("width or heightmust be less than 1");
		}

		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("width or height must be greater than 0");
		}
		if(y >= topPic.getHeight()) {
			bottomPic = bottomPic.paint(x, y - topPic.getHeight(), p);
		} else {
			topPic =  topPic.paint(x, y, p);
		}
		return this;
	}

	@Override
	public Picture paint(int x, int y, Pixel p, double factor) {
		// TODO Auto-generated method stub
		if (p == null) {
			throw new IllegalArgumentException("Pixel cant be null");
		}

		if (x >= topPic.getWidth() || y >= getHeight()) {
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
		if ( y >= topPic.getHeight() ) {
			if (factor == 1) {
				bottomPic = bottomPic.paint(x, y, p);
			} else if (factor > 0 && factor < 1) {
				bottomPic = bottomPic.paint(x, y, p, factor);
			}
		}
		else {
			topPic = topPic.paint(x, y, p, factor);
		}

		return this;
	}

	@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
		// TODO Auto-generated method stub
		if(ay >= topPic.getHeight() || by >= topPic.getHeight()) {
			bottomPic = bottomPic.paint(ax, ay, bx, by, p);
		} else {
			topPic =  topPic.paint(ax, ay, bx, by, p);
		}
		return this;
	}

	@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
		// TODO Auto-generated method stub
		Picture newPicture = new VerticalStackPicture(topPic, bottomPic);

		return newPicture.paint(ax, ay, bx, by, p, factor);
	}

	@Override
	public Picture paint(int cx, int cy, double radius, Pixel p) {
		// TODO Auto-generated method stub
		Picture newPicture = new VerticalStackPicture(topPic, bottomPic);

		return newPicture.paint(cx, cy, radius, p);
	}

	@Override
	public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
		// TODO Auto-generated method stub
		Picture newPicture = new VerticalStackPicture(topPic, bottomPic);

		return newPicture.paint(cx, cy, radius, p, factor);
		
	}


	
}
