package com.UntitledGame.game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("UntitledGame");
		
		//frame.setSize(800, 600);
		//frame.setResizable(false);
		
		ImageIcon icon = new ImageIcon("gandalf.jpg");
		JLabel label = new JLabel(icon);
		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
