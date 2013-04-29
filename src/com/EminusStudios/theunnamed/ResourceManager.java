package com.EminusStudios.theunnamed;

import org.andengine.audio.sound.Sound;
import org.andengine.engine.Engine;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.util.debug.Debug;

import android.content.Context;

public class ResourceManager 
{
	private static ResourceManager INSTANCE;
	
	// VARIABLES
	
	/* The variables listed should be kept public, allowing us easy
	access to them when creating new Sprites, Text objects and to play soundfiles */
	
	public static ITextureRegion mGameBackgroundTextureRegion;
	public ITextureRegion mMenuBackgroundTextureRegion;
	public Sound mSound;
	public Font mFont;
	
	//The constructor does not do anything for this singleton
	ResourceManager()
	{
	}
	
	public static ResourceManager GetInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new ResourceManager();
		}
		return INSTANCE;
	}
	
	// LOOK AT THE BOOK TO ADD FUNCTIONS TO LOAD RESOURCES
	
	public void LoadSplashScreenResources(Engine pEngine, Context pContext)
	{
		// Set our game assets folder in "assets/gfx/splash/"
		// BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/splash/");
		
		BuildableBitmapTextureAtlas mBitmapTextureAtlas = new BuildableBitmapTextureAtlas(pEngine.getTextureManager(), 800, 480);
		
		mGameBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlas, pContext, "splash.jpg");
		
		try 
		{
			mBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 1));
			mBitmapTextureAtlas.load();
		} 
		catch (TextureAtlasBuilderException e) 
		{
			Debug.e(e);
		}
	}
}
