package com.EminusStudios.General;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.app.Activity;

import com.EminusStudios.General.SceneManager.SceneType;
import com.EminusStudios.theunnamed.ResourceManager;

public abstract class BaseScene extends Scene 
{
	//---------------------------------------------
    // VARIABLES
    //---------------------------------------------
    
	protected ResourceManager RESOURCE_MANAGER;
    protected Engine engine;
    protected Activity activity;
    protected VertexBufferObjectManager vbom;
    protected Camera camera;
    
    //---------------------------------------------
	// CONSTRUCTOR
	//---------------------------------------------

    public BaseScene()
    {
    	this.RESOURCE_MANAGER = ResourceManager.GetInstance();
        this.engine = RESOURCE_MANAGER.engine;
        this.activity = RESOURCE_MANAGER.activity;
        this.vbom = RESOURCE_MANAGER.vbom;
        this.camera = RESOURCE_MANAGER.camera;
        CreateScene();
    }
    
  //---------------------------------------------
    // ABSTRACTION
    //---------------------------------------------
    
    public abstract void CreateScene();
    
    public abstract void OnBackKeyPressed();
    
    public abstract SceneType GetSceneType();
    
    public abstract void DisposeScene();
}
