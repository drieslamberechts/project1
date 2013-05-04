package com.EminusStudios.theunnamed;

import org.andengine.audio.sound.Sound;
import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import com.EminusStudios.theunnamed.MainGameActivity;

import android.content.Context;

public class ResourceManager 
{
	private static ResourceManager INSTANCE;
	
	//---------------------------------------------
    // VARIABLES
    //---------------------------------------------    
	
	/* The variables listed should be kept public, allowing us easy
	access to them when creating new Sprites, Text objects and to play soundfiles */
	
    public Engine engine;
    public MainGameActivity activity;
    public Camera camera;
    public VertexBufferObjectManager vbom;
	
	//---------------------------------------------
    // TEXTURES & TEXTURE REGIONS, SOUNDS, FONTS
    //---------------------------------------------
    public static ITextureRegion mGameBackgroundTextureRegion;
	public ITextureRegion mMenuBackgroundTextureRegion;
	public Sound mSound;
	public Font mFont;
	
	//---------------------------------------------
    // CLASS LOGIC
    //---------------------------------------------
	
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
	
    public static void PrepareManager(Engine engine, MainGameActivity activity, Camera camera, VertexBufferObjectManager vbom)
    {
        GetInstance().engine = engine;
        GetInstance().activity = activity;
        GetInstance().camera = camera;
        GetInstance().vbom = vbom;
    }
	
	// LOOK AT THE BOOK TO ADD FUNCTIONS TO LOAD RESOURCES
	
	public void LoadSplashScreenResources(Engine pEngine, Context pContext)
	{
		// Set our game assets folder in "assets/gfx/splash/"
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		
		BuildableBitmapTextureAtlas mBitmapTextureAtlas = new BuildableBitmapTextureAtlas(pEngine.getTextureManager(), 1024, 1024);
		
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
