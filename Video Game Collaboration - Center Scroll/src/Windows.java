
public class Windows {

	private int fireLevel;
	private int xCordinate; 
	private int yCordinate; 

	public Windows(int xCordinate, int yCordinate, int fireLevel) {
		this.fireLevel = fireLevel;
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate; 
	}

	public Windows() {
		this(0,0,0);
	}

	public int getFireLEvel() {
		return this.fireLevel;
	}
	public void setFireLevel(int fireLevel) {
		this.fireLevel= fireLevel;
	}

	public int getxCordinate() {
		return xCordinate;
	}

	public void setxCordinate(int xCordinate) {
		this.xCordinate = xCordinate;
	}

	public int getyCordinate() {
		return yCordinate;
	}

	public void setyCordinate(int yCordinate) {
		this.yCordinate = yCordinate;
	}
	
}
