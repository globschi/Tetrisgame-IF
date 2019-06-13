package com.hoffrogge.tetris.model;

import java.awt.Graphics;

/**
 * @author Kurs
 *
 */
public class Rechteck {

	private int xKoordinate;
	private int yKoordinate;
	private int kantenlaenge = 100;

	public Rechteck(int xKoordinate, int yKoordinate, int kantenLaenge) {
		this.xKoordinate = xKoordinate;
		this.yKoordinate = yKoordinate;
		this.kantenlaenge = kantenLaenge;

	}

	public void zeichnen(Graphics graphics) {
		graphics.fillRect(xKoordinate, yKoordinate, kantenlaenge, kantenlaenge);
	}
}
