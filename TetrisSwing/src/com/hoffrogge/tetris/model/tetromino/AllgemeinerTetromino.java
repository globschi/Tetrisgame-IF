package com.hoffrogge.tetris.model.tetromino;

import java.awt.Graphics;
import java.util.List;

import com.hoffrogge.tetris.model.Farbe;
import com.hoffrogge.tetris.model.Rechteck;
import com.hoffrogge.tetris.model.TetrisKonstanten;

//in diese Klasse können Methoden rein, die bei allen Tetrominos identisch sind, dann muss nicht jede Klasse sie implementieren
public abstract class AllgemeinerTetromino implements TetrominoSpielstein {

	private int kantenlaenge = 40;
	private Farbe schwarz = new Farbe(0, 0, 0);

	public Farbe getLinienFarbe() {
		return schwarz;
	}

	protected int getKantenlaenge() {
		return kantenlaenge;
	}

	protected void zeichneRechteck(Graphics graphics, int x, int y, Farbe fuellFarbe) {

		graphics.setColor(fuellFarbe.konvertiereZuColor());

		Rechteck erstesrechteck = new Rechteck(x, y, kantenlaenge);

		erstesrechteck.zeichnen(graphics);

		graphics.setColor(schwarz.konvertiereZuColor());
		graphics.drawRect(x, y, kantenlaenge, kantenlaenge);
	}

	public void bewegeNachUnten() {
		List<TetrominoSpielstein> viertelBloecke = getViertelBloecke();

		for (TetrominoSpielstein einviertelBlock : viertelBloecke) {

			int y = einviertelBlock.getY();

			einviertelBlock.setY(y + getKantenlaenge());
		}

	}

	public void bewegeNachRechts() {
		List<TetrominoSpielstein> viertelBloecke = getViertelBloecke();

		for (TetrominoSpielstein einviertelBlock : viertelBloecke) {

			int x = einviertelBlock.getX();

			einviertelBlock.setX(x + getKantenlaenge());
		}
	}

	public void bewegeNachLinks() {
		List<TetrominoSpielstein> viertelBloecke = getViertelBloecke();
		for (TetrominoSpielstein einviertelBlock : viertelBloecke) {

			int x = einviertelBlock.getX();

			einviertelBlock.setX(x - getKantenlaenge());
		}
	}

	public void rotierenachLinks() {

	}

	public void rotierenachRechts() {

	}

	public int getKanteLinksX() {
		int kantelinksX = TetrisKonstanten.SPIELFELD_BREITE;
		for (TetrominoSpielstein block : getViertelBloecke())
			if (block.getKanteLinksX() < kantelinksX)
				kantelinksX = block.getKanteLinksX();
		return kantelinksX;
	}

	public int getKanteRechtsX() {
		int KanteRechtsX = 0;
		for (TetrominoSpielstein block : getViertelBloecke())
			if (block.getKanteRechtsX() > KanteRechtsX)
				KanteRechtsX = block.getKanteRechtsX();
		return KanteRechtsX;

	}

	/*
	 * public int getX() { for (TetrominoSpielstein block : getViertelBloecke()) }
	 */
}
