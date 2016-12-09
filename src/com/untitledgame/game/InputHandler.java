package com.untitledgame.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{

	public InputHandler(Render render){
		render.addKeyListener(this);
	}
	
	public class Key{
		private boolean keyPressed = false;
		
		public void toggleKey(boolean isPressed){
			keyPressed = isPressed;
		}
		
		public boolean isPressed(){
			return keyPressed;
		}
	}
	
	public Key upKey = new Key();
	public Key downKey = new Key();
	public Key leftKey = new Key();
	public Key rightKey = new Key();
	public Key spaceKey = new Key();
	
	public void keyPressed(KeyEvent e) {
		keyToggled(e.getKeyCode(), true);
	}
	
	public void keyReleased(KeyEvent e) {
		keyToggled(e.getKeyCode(), false);
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyToggled(int keyCode, boolean isPressed){
		if (keyCode == KeyEvent.VK_W){upKey.toggleKey(isPressed);}
		if (keyCode == KeyEvent.VK_S){downKey.toggleKey(isPressed);}
		if (keyCode == KeyEvent.VK_A){leftKey.toggleKey(isPressed);}
		if (keyCode == KeyEvent.VK_D){rightKey.toggleKey(isPressed);}
		if (keyCode == KeyEvent.VK_SPACE){spaceKey.toggleKey(isPressed);}
	}

}
