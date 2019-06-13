package com.hoffrogge.tetris.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.hoffrogge.tetris.logik.Spiel;
import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;

public class MyKeyListener implements KeyListener {

	private Spiel spiel;

	public MyKeyListener(Spiel spiel) {
		this.spiel = spiel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		TetrominoSpielstein fallenderSpielstein = spiel.getFallenderSpielstein();
		if (fallenderSpielstein == null) {
			return;
		} else {
			if (KeyEvent.VK_LEFT == e.getKeyCode())
				fallenderSpielstein.bewegeNachLinks();
			if (KeyEvent.VK_RIGHT == e.getKeyCode())
				fallenderSpielstein.bewegeNachRechts();
			if (KeyEvent.VK_DOWN == e.getKeyCode())
				fallenderSpielstein.bewegeNachUnten();

		}
		/*
		 * int Keycode = e.getKeyCode(); switch (Keycode) {
		 * 
		 * case KeyEvent.VK_LEFT: fallenderSpielstein.bewegeNachLinks();
		 * 
		 * case KeyEvent.VK_RIGHT: fallenderSpielstein.bewegeNachRechts();
		 * 
		 * case KeyEvent.VK_DOWN: fallenderSpielstein.bewegeNachUnten();
		 * 
		 * }
		 */

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
