package com.hoffrogge.tetris.model.tetromino;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.hoffrogge.tetris.model.Farbe;
import com.hoffrogge.tetris.model.Punkt;

public class LBlock extends AllgemeinerTetromino {
	private Punkt mittelpunkt;
	int xLBlock;
	int yLBlock;
	private List<TetrominoSpielstein> viertelBloecke = new ArrayList<>(4);
	private Farbe fuellFarbe = new Farbe(255, 200, 0);

	public LBlock() {
		this(0, 0);
	}

	public LBlock(int x, int y) {
		xLBlock = x;
		yLBlock = y;

		viertelBloecke.add(new ViertelBlock(xLBlock, yLBlock + getKantenlaenge(), fuellFarbe));
		viertelBloecke.add(new ViertelBlock(xLBlock + getKantenlaenge(), yLBlock + getKantenlaenge(), fuellFarbe));
		viertelBloecke.add(new ViertelBlock(xLBlock + getKantenlaenge() + getKantenlaenge(),
				yLBlock + getKantenlaenge(), fuellFarbe));
		viertelBloecke.add(new ViertelBlock(xLBlock + getKantenlaenge() + getKantenlaenge(), yLBlock, fuellFarbe));

	}

	public void zeichnen(Graphics graphics) {

		for (TetrominoSpielstein tetrominoSpielstein : viertelBloecke)
			tetrominoSpielstein.zeichnen(graphics);
	}

	@Override
	public void setMittelpunkt(Punkt mittelpunkt) {
		new Punkt(xLBlock + getKantenlaenge() + getKantenlaenge(), yLBlock + getKantenlaenge());
		this.mittelpunkt = mittelpunkt;

	}

	@Override
	public Punkt getMittelPunkt() {
		// TODO Auto-generated method stub
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
		return viertelBloecke.get(3).getHoechstesY();
	}

	@Override
	public int getTiefstesY() {
		return viertelBloecke.get(0).getTiefstesY();
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
