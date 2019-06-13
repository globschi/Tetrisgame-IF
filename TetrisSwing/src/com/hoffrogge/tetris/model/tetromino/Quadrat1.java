package com.hoffrogge.tetris.model.tetromino;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.hoffrogge.tetris.model.Farbe;
import com.hoffrogge.tetris.model.Punkt;

public class Quadrat1 extends AllgemeinerTetromino implements TetrominoSpielstein {
	private Punkt mittelpunkt;
	int xQuadrat;
	int yQuadrat;
	private List<TetrominoSpielstein> viertelBloecke = new ArrayList<>(4);
	private Farbe fuellFarbe = new Farbe(10, 10, 150);

	public Quadrat1() {
		this(0, 0);
	}

	public Quadrat1(int x, int y) {
		xQuadrat = x;
		yQuadrat = y;

		viertelBloecke.add(new ViertelBlock(xQuadrat, yQuadrat, fuellFarbe));
		viertelBloecke.add(new ViertelBlock(xQuadrat + getKantenlaenge(), yQuadrat, fuellFarbe));
		viertelBloecke.add(new ViertelBlock(xQuadrat, yQuadrat + getKantenlaenge(), fuellFarbe));
		viertelBloecke.add(new ViertelBlock(xQuadrat + getKantenlaenge(), yQuadrat + getKantenlaenge(), fuellFarbe));

	}

	public void zeichnen(Graphics graphics) {

		for (TetrominoSpielstein tetrominoSpielstein : viertelBloecke)
			tetrominoSpielstein.zeichnen(graphics);
	}

	@Override
	public void setMittelpunkt(Punkt mittelpunkt) {
		new Punkt(xQuadrat + getKantenlaenge(), yQuadrat + getKantenlaenge());
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
