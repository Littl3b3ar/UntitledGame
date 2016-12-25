package com.untitledgame.game;

public class Player extends Physics{
	
	//Player properties
	private boolean playerVisible = false;
	private boolean playerColliding = false;
	
	// Coordinates of the player
	private int playerXLoc, playerYLoc, playerZPri;
	private int playerLength, playerHeight;
	private String playerFilePath;
	
	public Player (int x,int y,int zPriority){
		
	}
	
	public void setPlayerVisibility(boolean playerVisibility){
		this.playerVisible = playerVisibility;
	}
	
	public boolean getPlayerVisibility(){
		return this.playerVisible;
	}
	
	public void setPlayerColliding(boolean playerCollide){
		this.playerColliding = playerCollide;
	}
	
	public boolean getPlayerColliding(){
		return this.playerColliding;
	}
	
	public int getPlayerXLoc( )
	{
		return this.playerXLoc;
	}
	
	public int getPlayerYLoc( )
	{
		return this.playerYLoc;
	}
	
	public int getPlayerZPri( )
	{
		return this.playerZPri;
	}
	
	public int getPlayerLength( )
	{
		return this.playerLength;
	}
	
	public int getPlayerHeight( )
	{
		return this.playerHeight;
	}
	
	public String getPlayerFilePath( )
	{
		return this.playerFilePath;
	}
	
	public void setPlayerXLoc(int newPlayerXLoc)
	{
		this.playerXLoc = newPlayerXLoc;
	}
	
	public void setPlayerYLoc(int newPlayerYLoc)
	{
		this.playerYLoc = newPlayerYLoc;
	}
	
	public void setPlayerZPri(int newPlayerZPri)
	{
		this.playerZPri = newPlayerZPri;
	}
	
	public void setPlayerLength(int newPlayerLength)
	{
		this.playerLength = newPlayerLength;
	}
	
	public void setPlayerHeight(int newPlayerHeight)
	{
		this.playerHeight = newPlayerHeight;
	}
	
	public void setPlayerFilePath(String newPlayerFilePath)
	{
		this.playerFilePath = newPlayerFilePath;
	}

	private void updatePlayer(){
		//TODO: Write code to update the player draw on the gameboard array
	}
	
	protected void finalize(){
		
	}
	
}
