package a3;

public class TransformedPicture implements PixelTransformation {

	private Picture source2;
	private PixelTransformation zform;
	
	public TransformedPicture (Picture source, PixelTransformation xform) {		
		source2 = source;
		zform = xform;
	}

	@Override
	public Pixel transform(Pixel p) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
