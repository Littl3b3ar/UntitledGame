package com.untitledgame.game;

public class Physics {

	private final double gravityConst = 9.8;
	
	public Physics(){
		
	}
	
	public boolean testCollision(){
		return false;
	}
	
	
}
//Example stage collision test:
//physics.testCollision(entity1.getBounds(),entity2.getBounds());