package EngineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;
import entities.Entity;
import entities.Light;
import Models.RawModel;
import Models.TexturedModel;
import Shaders.StaticShader;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import renderEngine.EntityRenderer;
import terrains.Terrain;
import textures.ModelTexture;
import textures.TerrainTexture;
import textures.TerrainTexturePack;

public class MainGameLoop {

	public static void main(String[] args) {
		DisplayManager.createDisplay();
		
		Loader loader= new Loader();	

		TerrainTexture backgroundTexture=new TerrainTexture(loader.loadTexture("grassy"));
		TerrainTexture rTexture=new TerrainTexture(loader.loadTexture("dirt"));
		TerrainTexture gTexture=new TerrainTexture(loader.loadTexture("grassFlowers"));
		TerrainTexture bTexture=new TerrainTexture(loader.loadTexture("path"));
		TerrainTexturePack texturePack=new TerrainTexturePack(backgroundTexture,rTexture,gTexture,bTexture);
		
		TerrainTexture blendMap=new TerrainTexture(loader.loadTexture("blendMap"));

		
		Terrain terrain=new Terrain(-1,-1,loader,texturePack,blendMap);
		
		RawModel model=OBJLoader.loadObjModel("dragon", loader);
		ModelTexture texture=new ModelTexture(loader.loadTexture("whiteTexture"));
		TexturedModel staticModel= new TexturedModel(model,texture);
		texture.setShinedamper(10);
		texture.setReflectivity(1);
		
		RawModel grassModel=OBJLoader.loadObjModel("grassModel", loader);
		ModelTexture grassTexture= new ModelTexture(loader.loadTexture("grassTexture"));
		TexturedModel grass= new TexturedModel(grassModel,grassTexture);
		grassTexture.setHasTransparency(true);
		grassTexture.setUsefakeLightning(true);
		
		Light light =new Light(new Vector3f(0,0,-20) , new Vector3f(1,1,1));
		Entity entity= new Entity(staticModel,new Vector3f(0,0,-50),0,0,0,1);
		Entity grassEntity= new Entity(grass,new Vector3f(10,0,50),0,0,0,1);

		Camera camera= new Camera();
		
		MasterRenderer renderer = new MasterRenderer();
		
		while(!Display.isCloseRequested())
		{	
			entity.increaseRotation(0, 1, 0);
			camera.move();
			
			renderer.processEntity(entity);
			renderer.processEntity(grassEntity);
			renderer.processTerrain(terrain);
			renderer.render(light, camera);
			
			DisplayManager.updateDisplay();
		}
		
		loader.cleanUP();
		DisplayManager.closeDisplay();
	}

}
