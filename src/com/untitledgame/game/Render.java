package com.untitledgame.game;

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
	
	public boolean running = false;
	public int tickCount = 0;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
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
		
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = i * tickCount;
		}
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

