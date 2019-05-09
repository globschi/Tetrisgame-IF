package com.hoffrogge.tetris.start;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.hoffrogge.tetris.logik.Spiel;
import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.view.Spielfeld;
import com.hoffrogge.tetris.view.Spielfenster;
import com.hoffrogge.tetris.view.Vorschau;

public class Main {

	public static void main(String[] args) {

		/*
		 * ==================================================================== Diese
		 * Factory ist dafür zuständig, Spielsteine zu generieren. Mit deiner eigenen
		 * Factory kannst du hier deine eigenen Spielsteine einbauen.
		 * ====================================================================
		 */
		TetrominoFactory tetrominoFactory = new MyTetrominoFactory();

		/*
		 * Dies ist das Spielfeld. Es zeichnet das Spielfeld und weiss, wo welche
		 * Spielsteine sind. Das Spielfeld kann Tetrisspielsteine nicht beeinflussen, es
		 * weiss nur, wo sie sind.
		 */
		Spielfeld spielfeld = new Spielfeld(tetrominoFactory);

		/*
		 * Die Vorschau zeigt den jeweils nächsten Spielstein an. Mehr kann sie nicht
		 * tun.
		 */
		Vorschau vorschau = new Vorschau(tetrominoFactory);

		/*
		 * Das Spielfenster ist dafür zuständig, das Spiel anzuzeigen, die
		 * Tetrisspielsteine, die Vorschau, Highscore. Das Spielfenster selbst kann
		 * Spielsteine nicht beeinflussen, es stellt sie nur dar.
		 */
		Spielfenster spielfenster = new Spielfenster(spielfeld, vorschau);

		/*
		 * Das Spiel enthält alles an Logik, die es braucht, z. B. das Drehen von
		 * Spielsteinen oder die Berechnung von Punkten. Das Spiel kann nichts
		 * darstellen, das ist Aufgabe des Spielfensters. Das Spiel kann nur dem
		 * Spielfenster Informationen geben, die das Spielfenster dann darstellt.
		 */
		Spiel spiel = new Spiel(tetrominoFactory, spielfeld, spielfenster, vorschau);

<<<<<<< HEAD
		/*
		 * ==================================================================== Dieser
		 * Listener wird fuer die Steuerung des Spiels benoetigt (links, rechts, runter,
		 * drehen, Pause). Er erkennt Tastatureingaben und reicht diese an das Spiel
		 * weiter. Ohne den KeyListener läuft das Spiel, ohne das der Spieler etwas
		 * machen kann. Hier musst du deinen KeyListener einbauen.
		 * ====================================================================
		 */
		KeyListener tetrisKeyListener = new KeyListener() {
=======
        /*
         * Dies ist das Spielfeld. Es zeichnet das Spielfeld und die
         * Spielsteine. Das Spielfeld kann Tetrisspielsteine nicht beeinflussen.
         */
        Spielfeld spielfeld = new Spielfeld(tetrominoFactory);
>>>>>>> branch 'master' of https://github.com/HInformatikAG/TetrisSwing.git

			/*
			 * Dies ist eine anonyme Implementierung, die nur dafür da ist, damit der Code
			 * compiliert und keine Fehler wirft. Du kannst sie entfernen und gegen deinen
			 * eigenen KeyListener austauschen.
			 */

<<<<<<< HEAD
			@Override
			public void keyTyped(KeyEvent e) {
			}
=======
        /*
         * Das Spielfenster zeichnet das Spielfeld, die Vorschau, Highscore,
         * Level, Punkte und Reihen. Das Spielfenster kann Spielsteine nicht
         * beeinflussen.
         */
        Spielfenster spielfenster = new Spielfenster(spielfeld, vorschau);
>>>>>>> branch 'master' of https://github.com/HInformatikAG/TetrisSwing.git

<<<<<<< HEAD
			@Override
			public void keyReleased(KeyEvent e) {
			}
=======
        /*
         * Das Spiel enthält alles an Logik, die es braucht, z. B. das Drehen
         * von Spielsteinen oder die Berechnung von Punkten. Das Spiel kann
         * nichts darstellen, das ist Aufgabe des Spielfelds. Das Spiel kann nur
         * dem Spielfeld Informationen geben, die das Spielfeld dann darstellt.
         */
        Spiel spiel = new Spiel(tetrominoFactory, spielfeld, spielfenster, vorschau);
>>>>>>> branch 'master' of https://github.com/HInformatikAG/TetrisSwing.git

			@Override
			public void keyPressed(KeyEvent e) {
			}
		};

		/*
		 * Der KeyListener muss an einer Komponente hängen, die angezeigt wird, in
		 * diesem Fall eignet sich das Spielfenster dafür.
		 */
		spielfenster.addKeyListener(tetrisKeyListener);

		spiel.starteSpiel();
	}
}