package com.hoffrogge.tetris.start;

import com.hoffrogge.tetris.model.tetromino.Blitz;
import com.hoffrogge.tetris.model.tetromino.Blitz2;
import com.hoffrogge.tetris.model.tetromino.LBlock;
import com.hoffrogge.tetris.model.tetromino.LBlock2;
import com.hoffrogge.tetris.model.tetromino.Linie;
import com.hoffrogge.tetris.model.tetromino.Quadrat1;
import com.hoffrogge.tetris.model.tetromino.TBlock;
import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;
import com.hoffrogge.tetris.model.tetromino.TetrominoTyp;

//gib der Klasse mit der Tastenkombination Alt+Shift+R einen Namen (MyTetrominoFactory markieren, dann die Tastenkombination)
public class MyTetrominoFactory implements TetrominoFactory {

	@Override
	public TetrominoTyp erstelleZufaelligenTetrominoTyp() {
		double zufallszahl;
		zufallszahl = (int) (Math.random() * 7) + 1;

		if (zufallszahl == 1)
			return TetrominoTyp.BLOCK;
		if (zufallszahl == 2)
			return TetrominoTyp.UMGEDREHTES_Z;
		if (zufallszahl == 3)
			return TetrominoTyp.Z;
		if (zufallszahl == 4)
			return TetrominoTyp.L;
		if (zufallszahl == 5)
			return TetrominoTyp.UMGEDREHTES_L;
		if (zufallszahl == 6)
			return TetrominoTyp.T;
		if (zufallszahl == 7)
			return TetrominoTyp.LANGER;
		return null;
	}

	@Override
	public TetrominoSpielstein erstelleTetromino(TetrominoTyp tetrominoTyp) {

		// Hack damit nur der bestimmte Tetromino ausgewählt wird (kein Zufall Mehr)
		// if (true)
		// return new Blitz();
		// Aufgabe fürs nächste Mal
		// - höchstes und tieftes y
		// - links rechts Bewegung

		if (tetrominoTyp == TetrominoTyp.BLOCK)
			return new Quadrat1();
		if (tetrominoTyp == TetrominoTyp.L)
			return new LBlock();
		if (tetrominoTyp == TetrominoTyp.LANGER)
			return new Linie();
		if (tetrominoTyp == TetrominoTyp.T)
			return new TBlock();
		if (tetrominoTyp == TetrominoTyp.UMGEDREHTES_L)
			return new LBlock2();
		if (tetrominoTyp == TetrominoTyp.UMGEDREHTES_Z)
			return new Blitz2();
		if (tetrominoTyp == TetrominoTyp.Z)
			return new Blitz();

		return null;
	}

	@Override
	public TetrominoSpielstein erstelleTetromino(TetrominoTyp typ, int x, int y) {

		if (TetrominoTyp.BLOCK == typ)
			return new Quadrat1(x, y);
		if (TetrominoTyp.L == typ)
			return new LBlock(x, y);
		if (TetrominoTyp.LANGER == typ)
			return new Linie(x, y);
		if (TetrominoTyp.T == typ)
			return new TBlock(x, y);
		if (TetrominoTyp.UMGEDREHTES_L == typ)
			return new LBlock2(x, y);
		if (TetrominoTyp.UMGEDREHTES_Z == typ)
			return new Blitz2(x, y);
		if (TetrominoTyp.Z == typ)
			return new Blitz(x, y);

		return null;
	}

}