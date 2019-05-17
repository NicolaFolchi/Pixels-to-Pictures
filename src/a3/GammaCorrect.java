package a3;

public class GammaCorrect implements PixelTransformation {

	private double gamma;
	private Pixel old, new1;
	
	public GammaCorrect (double gamma) {
		this.gamma = gamma; 
	}
	@Override
	public Pixel transform(Pixel p) {
		// TODO Auto-generated method stub
		
		p = old;
		//new1 = Math.pow(old, (1.0/gamma));
		return null;
	}

}
