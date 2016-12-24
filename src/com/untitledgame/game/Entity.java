package com.untitledgame.game;

public class Entity{
	/*
	 * when a new entity is created it need a xy, a z (draw priority)
	 * an entity code (entity code)
	 * 
	 *set xyz, get xyz
	 *
	 *it write to the render
	 */
	
	// Coordinates of the entity
	private int entityXLoc, entityYLoc, entityZPri;
	private int entityLength, entityHeight;
	private int entityNum;
	private String entityFilePath;
	
	public Entity (int x,int y,int zPriority,int entityCode){
		
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
}
