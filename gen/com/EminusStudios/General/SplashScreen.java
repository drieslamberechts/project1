package com.EminusStudios.General;

import org.andengine.engine.FixedStepEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.BaseGameActivity;

import com.EminusStudios.theunnamed.ResourceManager;

public class SplashScreen extends BaseGameActivity 
{
	// CAMERA
	public static int WIDTH = 800;
	public static int HEIGHT = 480;
	
	private Camera mCamera;
	
	// SPRITES
	private Sprite splash;
	
	@Override
	public EngineOptions onCreateEngineOptions() 
	{
		mCamera = new Camera(0, 0, WIDTH, HEIGHT);
		
		EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(), mCamera);	
		engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
		mEngine = new FixedStepEngine(engineOptions, 60);
		
		return engineOptions;
	}

	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception 
	{
		// Load resources from resourceManager
		ResourceManager.GetInstance().LoadSplashScreenResources(mEngine, this);
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception 
	{
		splash = new Sprite(0, 0, ResourceManager.mGameBackgroundTextureRegion, mEngine.getVertexBufferObjectManager());
	}

	@Override
	public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception 
	{
		// TODO Auto-generated method stub
		
	}

}
