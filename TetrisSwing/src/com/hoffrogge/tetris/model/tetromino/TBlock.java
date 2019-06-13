package com.hoffrogge.tetris.model.tetromino;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.hoffrogge.tetris.model.Farbe;
import com.hoffrogge.tetris.model.Punkt;

public class TBlock extends AllgemeinerTetromino {

	private Punkt mittelpunkt;
	int xTBlock;
	int yTBlock;
	private List<TetrominoSpielstein> viertelBloecke = new ArrayList<>(4);
	private Farbe fuellFarbe = new Farbe(70, 150, 80);

	public TBlock() {
		this(0, 0);
	}

	public TBlock(int x, int y) {
		xTBlock = x;
		yTBlock = y;

		viertelBloecke.add(new ViertelBlock(xTBlock, yTBlock, fuellFarbe));
		viertelBloecke.add(new ViertelBlock(xTBlock, yTBlock + getKantenlaenge(), fuellFarbe));
		viertelBloecke.add(new ViertelBlock(xTBlock, yTBlock + getKantenlaenge() + getKantenlaenge(), fuellFarbe));
		viertelBloecke.add(new ViertelBlock(xTBlock + getKantenlaenge(), yTBlock + getKantenlaenge(), fuellFarbe));

	}

	public void zeichnen(Graphics graphics) {

		for (TetrominoSpielstein tetrominoSpielstein : viertelBloecke)
			tetrominoSpielstein.zeichnen(graphics);
	}

	@Override
	public void setMittelpunkt(Punkt mittelpunkt) {
		new Punkt(xTBlock + getKantenlaenge(), yTBlock);
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
		return viertelBloecke.get(2).getTiefstesY();
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
	public void setFuellFarbe(Farbe farbe) {
		// TODO Auto-generated method stub

	}

	@Override
	public Farbe getFuellFarbe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLinienFarbe(Farbe farbe) {
		// TODO Auto-generated method stub

	}
}
