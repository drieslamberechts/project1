package com.EminusStudios.theunnamed;

import org.andengine.audio.sound.Sound;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.region.ITextureRegion;

public class ResourceManager 
{
	private static ResourceManager INSTANCE;
	
	// VARIABLES
	
	/* The variables listed should be kept public, allowing us easy
	access to them when creating new Sprites, Text objects and to play soundfiles */
	
	public ITextureRegion mGameBackgroundTextureRegion;
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
}
