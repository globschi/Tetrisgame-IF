package com.hoffrogge.tetris.model.tetromino;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.hoffrogge.tetris.model.Farbe;
import com.hoffrogge.tetris.model.Punkt;

public class Blitz extends AllgemeinerTetromino {

	private Punkt mittelpunkt;
	int xBlitz;
	int yBlitz;
	private List<TetrominoSpielstein> viertelBloecke = new ArrayList<>(4);
	private Farbe fuellFarbe = new Farbe(0, 255, 0);

	public Blitz() {
		this(0, 0);
	}

	public Blitz(int x, int y) {
		xBlitz = x;
		yBlitz = y;

		viertelBloecke.add(new ViertelBlock(xBlitz, yBlitz, fuellFarbe));
		viertelBloecke.add(new ViertelBlock(xBlitz + getKantenlaenge(), yBlitz, fuellFarbe));
		viertelBloecke.add(new ViertelBlock(xBlitz + getKantenlaenge(), yBlitz + getKantenlaenge(), fuellFarbe));
		viertelBloecke.add(new ViertelBlock(xBlitz + getKantenlaenge() + getKantenlaenge(), yBlitz + getKantenlaenge(),
				fuellFarbe));
	}

	@Override
	public void zeichnen(Graphics graphics) {

		for (TetrominoSpielstein tetrominoSpielstein : viertelBloecke)
			tetrominoSpielstein.zeichnen(graphics);
	}

	@Override
	public void setMittelpunkt(Punkt mittelpunkt) {
		new Punkt(xBlitz + getKantenlaenge() + getKantenlaenge(), yBlitz + getKantenlaenge());
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
		if (viertelBloecke.isEmpty())
			return false;

		if (getX() == tetrominoSpielstein.getX() && getTiefstesY() == tetrominoSpielstein.getY())
			return true;

		return false;
	}

	@Override
	public List<TetrominoSpielstein> getViertelBloecke() {
		return viertelBloecke;
	}

	@Override
	public Farbe getFuellFarbe() {
		return fuellFarbe;
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
