package textures;

public class ModelTexture {

	private int textureID;
	
	private float shineDamper=1;
	private float reflectivity = 0;
	
	private boolean hasTransparency=false;
	private boolean usefakeLightning=false;
	
	
	public boolean isUsefakeLightning() {
		return usefakeLightning;
	}

	public void setUsefakeLightning(boolean usefakeLightning) {
		this.usefakeLightning = usefakeLightning;
	}
	public boolean isHasTransparency() {
		return hasTransparency;
	}

	public void setHasTransparency(boolean hasTransparency) {
		this.hasTransparency = hasTransparency;
	}

	public float getShinedamper() {
		return shineDamper;
	}

	public void setShinedamper(float shinedamper) {
		this.shineDamper = shinedamper;
	}

	public float getReflectivity() {
		return reflectivity;
	}

	public void setReflectivity(float reflectivity) {
		this.reflectivity = reflectivity;
	}

	public ModelTexture(int id)
	{
		this.textureID=id;
	}
	
	public int getID()
	{
		return this.textureID;
	}
	
}
