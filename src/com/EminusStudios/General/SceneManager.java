package com.EminusStudios.General;

import java.util.Vector;

import org.andengine.engine.Engine;
import com.EminusStudios.theunnamed.ResourceManager;

public class SceneManager
{
    //---------------------------------------------
    // SCENES
    //---------------------------------------------
	
	/* Note: Add new scenes here. I'll make this better eventually */
    
    private BaseScene m_SplashScene;
    private BaseScene m_MenuScene;
    
    private Vector<BaseScene> m_SceneList;
    
    //---------------------------------------------
    // VARIABLES
    //---------------------------------------------
    
    private static final SceneManager INSTANCE = new SceneManager();  
    private SceneType m_CurrentSceneType = SceneType.SCENE_SPLASH;
    private BaseScene m_CurrentScene;   
    private Engine m_Engine = ResourceManager.GetInstance().engine;
    
    public enum SceneType
    {
    	/* Add types when adding scenes */
        SCENE_SPLASH,
        SCENE_MENU,
    }
    
    //---------------------------------------------
    // METHODS
    //---------------------------------------------
    
    public void setScene(BaseScene scene)
    {
    	m_Engine.setScene(scene);
    	m_CurrentScene = scene;
    	m_CurrentSceneType = scene.GetSceneType();
    }
    
    public void setScene(SceneType sceneType)
    {
        switch (sceneType)
        {
            case SCENE_MENU:
                setScene(m_MenuScene);
                break;
            case SCENE_SPLASH:
                setScene(m_SplashScene);
                break;
            default:
                break;
        }
    }
    
    //---------------------------------------------
    // GETTERS AND SETTERS
    //---------------------------------------------
    
    public static SceneManager GetInstance()
    {
        return INSTANCE;
    }
    
    public SceneType GetCurrentSceneType()
    {
        return m_CurrentSceneType;
    }
    
    public BaseScene GetCurrentScene()
    {
        return m_CurrentScene;
    }
    
    public void AddScene(BaseScene scene)
    {
    	m_SceneList.add(scene);    	
    }
}
