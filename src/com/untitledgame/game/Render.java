package com.untitledgame.game;
/*
 * The rendering class is a thread
 */

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Render extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final int SCALE = 1;
	public static final String TITLE = "Untitled Game";
	public static boolean FRAME_LIMIT = true; //Limit FPS to 60
	public static int BUFFER_SIZE = 3; //How many times the render is buffered
	private JFrame frame;
	
	public int color = 0xffffff;
	public boolean running = false;
	public int tickCount = 0;
	
	//stage
	public int backgroundColor = 0x9B59B6;
	
	//Test Object
	public int squareXLoc = 400;
	public int squareYLoc = 300;
	public int squareHeight = 100;
	public int squareLength = 100;
	public int squareColor = 0xE8EB2B;
	
	public int square2object[][] = new int[100][100];
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public InputHandler input;
	
	public Render(){
		frame = new JFrame(TITLE);
		ImageIcon titleIcon = new ImageIcon("./assets/icon/icon.png");
		frame.setIconImage(titleIcon.getImage());
		frame.setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		input = new InputHandler(this);
	}
	
	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}
	
	private synchronized void stop() {
		running = false;
	}
		
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/60D;
		
		int ticks = 0;
		int frames = 0;
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		
		while(running){
			long now = System.nanoTime();
			delta +=(now - lastTime) / nsPerTick;
			lastTime = now;
			boolean doRender = true;
			
			if(FRAME_LIMIT){
				doRender = false;
			}			
			
			while(delta >= 1){
				ticks++;
				tick();
				delta -=1;
				doRender = true;
			}
			
			if(doRender){
				frames++;
				render();	
			}
			
			
			if(System.currentTimeMillis() - lastTimer > 1000){
				lastTimer += 1000;
				System.out.println("FPS: " + frames +","+ "TicksPS: " + ticks);
				frames = 0;
				ticks = 0;
			}
			
		}
		
	}
	
	public void tick(){
		tickCount++;
		
		/*
		 * This next line is just for testing drawing images
		 * In this case the array of pixels is 480000 in length
		 * which is 800 x 600 each pixel can take the color code
		 * pressing WASD + space will change the color.
		 * You need to click to window first to ?focus it?
		 */
	   	
		/*TODO: -i needs to be x and j needs to be y
		 *      -remove hard coded pixel lengths
		 *      -see repository for more
		 */
		
		for(int i = 0; i < 600; i++){
			for(int j = 0; j < 800; j++){
				if(((i >= squareYLoc) && (i <= (squareYLoc + squareHeight))) &&
				   ((j >= squareXLoc) && (j <= (squareXLoc + squareLength)))){
					pixels[800*i+j] = squareColor;
				}else{
					pixels[800*i+j] = backgroundColor;
				}
			}
		}
		
		
		if (input.upKey.isPressed()){squareYLoc-=2;}
		if (input.downKey.isPressed()){squareYLoc+=2;}
		if (input.leftKey.isPressed()){squareXLoc-=2;}
		if (input.rightKey.isPressed()){squareXLoc+=2;}
		if (input.spaceKey.isPressed()){
			squareXLoc = 400;
			squareYLoc = 300;
		}
	}
	
	public void drawEntity(int entity[][]){
		
	}
	
	public void render(){
		BufferStrategy bufferStrat = getBufferStrategy();
		if(bufferStrat == null){
			createBufferStrategy(BUFFER_SIZE);
			return;
		}
		
		Graphics g = bufferStrat.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bufferStrat.show();
	}

}

