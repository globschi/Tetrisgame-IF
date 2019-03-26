package com.hoffrogge.tetris.start;

import com.hoffrogge.tetris.logik.Spiel;
import com.hoffrogge.tetris.model.tetromino.StandardTetrominoFactory;
import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.view.Spielfenster;

public class Main {

    public static void main(String[] args) {

	/* Diese Factory ist dafür zuständig, Spielsteine zu generieren. */
	TetrominoFactory tetrominoFactory = new StandardTetrominoFactory();

	/*
	 * Das Spielfenster ist dafür zuständig, das Spiel anzuzeigen, die
	 * Tetrisspielsteine, die Vorschau, Highscore. Das Spielfenster selbst kann
	 * Spielsteine nicht beeinflussen, es stellt sie nur dar.
	 */
	Spielfenster spielfenster = new Spielfenster(tetrominoFactory);

	/*
	 * Das Spiel enthält alles an Logik, die es braucht, z. B. das Drehen von
	 * Spielsteine oder die Berechnung von Punkten. Das Spiel kann nichts
	 * darstellen, das ist Aufgabe des Spielfensters. Das Spiel kann nur dem
	 * Spielfenster Informationen geben, die das Spielfenster dann darstellt.
	 */
	Spiel spiel = new Spiel(spielfenster, tetrominoFactory);

	spiel.starteSpiel();
    }
}