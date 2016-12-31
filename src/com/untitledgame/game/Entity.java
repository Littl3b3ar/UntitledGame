package com.untitledgame.game;

public class Entity extends Physics{
	
	/*
	 * TODO:
	 * 
	 * -this thread needs to be syncronized with the game tick
	 * -the entity will apply physics to itself DONE
	 * -the entity will draw itself onto a gameboard array
	 * -the gameboard array will be selectivly rendered by the renderer depending
	 *  upon which elements are in view
	 *  
	 */
	
	//Entity Properties
	private boolean entityVisible = false;
	private boolean entityColliding = false;
	private boolean fixedEntity = false;
	
	// Coordinates of the entity
	private int entityXLoc, entityYLoc, entityZPri;
	private int entityLength, entityHeight;
	private int entityNum;
	private String entityFilePath;
	
	public Entity (int x,int y,int zPriority,int entityCode){
		
	}
	
	public void setEntityVisibility(boolean entityVisibility){
		this.entityVisible = entityVisibility;
	}
	
	public boolean getEntityVisibility(){
		return this.entityVisible;
	}
	
	public void setEntityColliding(boolean entityCollide){
		this.entityColliding = entityCollide;
	}
	
	public boolean getEntityColliding(){
		return this.entityColliding;
	}
	
	/*
	 * A fixed entity will ignore the effects of gravity
	 * but will still inherent other physics attributes
	 */
	public void setEntityFixed(boolean entityFixed){
		this.fixedEntity = entityFixed;
	}
	
	public boolean getEntityFixed(){
		return this.fixedEntity;
	}
	
	public int getEntityXLoc( )
	{
		return this.entityXLoc;
	}
	
	public int getEntityYLoc( )
	{
		return this.entityYLoc;
	}
	
	public int getEntityZPri( )
	{
		return this.entityZPri;
	}
	
	public int getEntityLength( )
	{
		return this.entityLength;
	}
	
	public int getEntityHeight( )
	{
		return this.entityHeight;
	}
	
	public String getEntityFilePath( )
	{
		return this.entityFilePath;
	}
	
	public int getEntityNum( )
	{
		return this.entityNum;
	}
	
	public void setEntityXLoc(int newEntityXLoc)
	{
		this.entityXLoc = newEntityXLoc;
	}
	
	public void setEntityYLoc(int newEntityYLoc)
	{
		this.entityYLoc = newEntityYLoc;
	}
	
	public void setEntityZPri(int newEntityZPri)
	{
		this.entityZPri = newEntityZPri;
	}
	
	public void setEntityLength(int newEntityLength)
	{
		this.entityLength = newEntityLength;
	}
	
	public void setEntityHeight(int newEntityHeight)
	{
		this.entityHeight = newEntityHeight;
	}
	
	public void setEntityFilePath(String newEntityFilePath)
	{
		this.entityFilePath = newEntityFilePath;
	}
	
	public void setEntityNum(int newEntityNum)
	{
		this.entityNum = newEntityNum;
	}
	
	public void run(){
		
	}
	
	private void updateEntity(){
		
	}
	
	protected void finalize(){
		
	}
}
