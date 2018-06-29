package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	
	private static final int width =1280;
	private static final int height =720;
	private static final int FPS_CAP=120;

	
	public static void createDisplay()
	{
		
		ContextAttribs attribs = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(width,height));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle("Game Engine Test");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		GL11.glViewport(0, 0, width, height);
		
	}
	
	public static void updateDisplay()
	{
		Display.sync(FPS_CAP);
		Display.update();
	}

	public static void closeDisplay()
	{
		Display.destroy();
	}


}
