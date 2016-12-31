package com.untitledgame.game;

public class Stage implements Runnable{
	
	private String levelFilePath;
	private int[][] square;
	private int squareSize;
	private int xStart, yStart;
	private Render gameRenderer;
	
	public Stage(){
		gameRenderer = new Render();
		gameRenderer.start();
		
		squareSize = 100;
		square = new int[squareSize][squareSize];
		
		xStart = 350;
		yStart = 423;
		
		for (int i=0; i<squareSize; i++)
		{
			for (int j=0; j<squareSize; j++)
			{
				square[i][j] = 0x27AD29;
			}
		}
		
		gameRenderer.drawEntity(square, xStart, yStart, squareSize, squareSize);
		gameRenderer.drawEntity(square, 112, 230, squareSize, squareSize);
		gameRenderer.drawEntity(square, 540, 648, squareSize, squareSize);
	}
	
	
	public void run(){
		
	}
		
	
}
//putArray(entity1.getPixels());