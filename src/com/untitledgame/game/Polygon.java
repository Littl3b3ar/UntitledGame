package com.untitledgame.game;

public class Polygon {
	
	private int numOfVertices;
	private int numOfEdges;
	private String shape;
	private int[][] polyMap;
	private int[] polyXCoor;
	private int[] polyYCoor;
	
	//Default polygon
	public Polygon()
	{
		numOfVertices = 0;
		numOfEdges = 0;
		polyMap = new int[1][1];
	}
	
	public Polygon(String shape)
	{
		this.shape = shape;
		
		if (shape == "Square")
		{
			this.numOfVertices = 4;
			this.numOfEdges = 4;
			
			for (int i=0; i<200; i++)
			{
				for(int j=0; j<200; j++)
				{
					
				}
			}
		}
	}
	
	public int getNumOfVertices()
	{
		return this.numOfVertices;
	}
	
	public int getNumOfEdges()
	{
		return this.numOfEdges;
	}
	
	public int[][] getPolyMap()
	{
		return polyMap;
	}
}
