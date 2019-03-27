package com.hoffrogge.tetris.start;

import com.hoffrogge.tetris.logik.Spiel;
import com.hoffrogge.tetris.model.TetrisKonstanten;
import com.hoffrogge.tetris.model.tetromino.StandardTetrominoFactory;
import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.view.Spielfeld;
import com.hoffrogge.tetris.view.Spielfenster;
import com.hoffrogge.tetris.view.TetrisKeyListener;

public class Main {

    public static void main(String[] args) {

        /*
         * Diese Factory ist dafür zuständig, Spielsteine zu generieren. Mit
         * deiner eigenen Factory kannst du hier deine eigenen Spielsteine
         * einbauen.
         */
        TetrominoFactory tetrominoFactory = new StandardTetrominoFactory();

        /*
         * Dies ist das Spielfeld. Es zeichnet das Spielfeld und weiss, wo
         * welche Spielsteine sind. Das Spielfeld kann Tetrisspielsteine nicht
         * beeinflussen, es weiss nur, wo sie sind.
         */
        Spielfeld spielfeld = new Spielfeld(tetrominoFactory);
        spielfeld.setBackground(TetrisKonstanten.HINTERGRUND.konvertiereZuColor());
        spielfeld.setBounds(TetrisKonstanten.SPIELFELD_POS_X, TetrisKonstanten.SPIELFELD_POS_Y, TetrisKonstanten.SPIELFELD_BREITE,
                TetrisKonstanten.SPIELFELD_HOEHE);

        /*
         * Dieser Listener wird fuer die Steuerung des Spiels benoetigt (links,
         * rechts, runter, drehen, Pause)
         */
        TetrisKeyListener tetrisKeyListener = new TetrisKeyListener(spielfeld);

        /*
         * Das Spielfenster ist dafür zuständig, das Spiel anzuzeigen, die
         * Tetrisspielsteine, die Vorschau, Highscore. Das Spielfenster selbst
         * kann Spielsteine nicht beeinflussen, es stellt sie nur dar.
         */
        Spielfenster spielfenster = new Spielfenster(spielfeld, tetrominoFactory, tetrisKeyListener);

        /*
         * Das Spiel enthält alles an Logik, die es braucht, z. B. das Drehen
         * von Spielsteinen oder die Berechnung von Punkten. Das Spiel kann
         * nichts darstellen, das ist Aufgabe des Spielfensters. Das Spiel kann
         * nur dem Spielfenster Informationen geben, die das Spielfenster dann
         * darstellt.
         */
        Spiel spiel = new Spiel(spielfenster, tetrominoFactory, tetrisKeyListener);

        spiel.starteSpiel();
    }
}