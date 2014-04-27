package com.fullsail.etmg.torreydaniel.jumpman;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.BoundCamera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.fullsail.etmg.torreydaniel.jumpman.SceneManager.SceneType;

import android.app.Activity;

public abstract class BaseScene extends Scene
{
	/********************************
	 * VARIABLES
	 *******************************/
	
	protected Engine engine;
	protected Activity activity;
	protected ResourceManager resourceManager;
	protected VertexBufferObjectManager vbom;
	protected BoundCamera camera;
	
	/********************************
	 * CONSTRUCTOR
	 *******************************/
	
	public BaseScene()
	{
		this.resourceManager = ResourceManager.getInstance();
		this.engine = resourceManager.engine;
		this.activity = resourceManager.activity;
		this.vbom = resourceManager.vbom;
		this.camera = resourceManager.camera;
		createScene();
	}

	/********************************
	 * ABSTRACTION
	 *******************************/
	
	public abstract void createScene(); 
	
	public abstract void onBackKeyPressed(); 
	
	public abstract SceneType getSceneType(); 
	
	public abstract void disposeScene(); 
}
