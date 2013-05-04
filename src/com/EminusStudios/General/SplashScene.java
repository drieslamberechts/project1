package com.EminusStudios.General;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.EminusStudios.General.SceneManager.SceneType;

public class SplashScene extends BaseScene 
{
	
	// SPRITES
	private Sprite m_Splash;

	@Override
	public void CreateScene() 
	{
		m_Splash = new Sprite(0, 0, RESOURCE_MANAGER.mGameBackgroundTextureRegion, vbom);
		attachChild(m_Splash);
		
	}

	@Override
	public void OnBackKeyPressed() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public SceneType GetSceneType() 
	{
		// Fill in with appropriate SceneType + Add in SceneManager
		return SceneType.SCENE_SPLASH;
	}

	@Override
	public void DisposeScene() 
	{
		m_Splash.detachSelf();
		m_Splash.dispose();
	    this.detachSelf();
	    this.dispose();
	}
	
	

}