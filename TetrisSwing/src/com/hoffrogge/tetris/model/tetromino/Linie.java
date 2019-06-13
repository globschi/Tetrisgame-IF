package com.hoffrogge.tetris.model.tetromino;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.hoffrogge.tetris.model.Farbe;
import com.hoffrogge.tetris.model.Punkt;

public class Linie extends AllgemeinerTetromino {
	private Punkt mittelpunkt;
	int xLinie;
	int yLinie;
	private List<TetrominoSpielstein> viertelBloecke = new ArrayList<>(4);
	private Farbe fuellFarbe = new Farbe(0, 0, 255);

	public Linie() {
		this(0, 0);
	}

	public Linie(int x, int y) {

		xLinie = x;
		yLinie = y;

		viertelBloecke.add(new ViertelBlock(xLinie, yLinie, fuellFarbe));
		viertelBloecke.add(new ViertelBlock(xLinie, yLinie + getKantenlaenge(), fuellFarbe));
		viertelBloecke.add(new ViertelBlock(xLinie, yLinie + getKantenlaenge() + getKantenlaenge(), fuellFarbe));
		viertelBloecke.add(new ViertelBlock(xLinie, yLinie + getKantenlaenge() + getKantenlaenge() + getKantenlaenge(),
				fuellFarbe));
	}

	public void zeichnen(Graphics graphics) {
		for (TetrominoSpielstein tetrominoSpielstein : viertelBloecke) {
			tetrominoSpielstein.zeichnen(graphics);
		}
	}

	@Override
	public void setMittelpunkt(Punkt mittelpunkt) {
		new Punkt(xLinie + getKantenlaenge(), yLinie + getKantenlaenge() + getKantenlaenge());
		this.mittelpunkt = mittelpunkt;

	}

	@Override
	public Punkt getMittelPunkt() {
		return mittelpunkt;
	}

	@Override
	public void setDurchmesser(int d) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(TetrominoSpielstein o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHoechstesY() {
		return viertelBloecke.get(0).getHoechstesY();
	}

	@Override
	public int getTiefstesY() {
		return viertelBloecke.get(3).getTiefstesY();
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotiereNachLinks() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotiereNachRechts() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean faelltAuf(TetrominoSpielstein tetrominoSpielstein) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TetrominoSpielstein> getViertelBloecke() {
		return viertelBloecke;
	}

	@Override
	public Farbe getFuellFarbe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFuellFarbe(Farbe farbe) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLinienFarbe(Farbe farbe) {
		// TODO Auto-generated method stub

	}
}
