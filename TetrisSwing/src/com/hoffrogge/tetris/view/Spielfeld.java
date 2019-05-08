package com.hoffrogge.tetris.view;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hoffrogge.tetris.logik.Spiel;
import com.hoffrogge.tetris.model.Farbe;
import com.hoffrogge.tetris.model.GeometrischeFigur;
import com.hoffrogge.tetris.model.TetrisKonstanten;
import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;

@SuppressWarnings("serial")
public class Spielfeld extends Canvas {

    private Spiel spiel;

    /* Konstruktor */
    public Spielfeld(TetrominoFactory tetrominoFactory) {

        setBackground(TetrisKonstanten.HINTERGRUND.konvertiereZuColor());
        setBounds(TetrisKonstanten.SPIELFELD_POS_X, TetrisKonstanten.SPIELFELD_POS_Y, TetrisKonstanten.SPIELFELD_BREITE,
                TetrisKonstanten.SPIELFELD_HOEHE);
    }

    public void setSpiel(Spiel spiel) {
        this.spiel = spiel;
    }

    public void aktualisieren() {

        loescheVolleReihen();

        TetrominoSpielstein fallenderSpielstein = spiel.getFallenderSpielstein();

        if (fallenderSpielstein != null) {

            fallenderSpielstein.bewegeNachUnten();

            if (spiel.hatFallenderSteinBodenErreicht() || faelltFallenderSteinAufAnderenStein()) {

                List<TetrominoSpielstein> viertelBloecke = fallenderSpielstein.getViertelBloecke();

                if (viertelBloecke != null)
                    spiel.getGefalleneSteine().addAll(viertelBloecke);

                spiel.bestimmeNaechstenFallendenSpielstein();

                spiel.erhoehePunkte();
            }
        }
    }

    public void zeichnen() {

        Graphics g = null;

        try {

            g = getBufferStrategy().getDrawGraphics();

            zeichneSpielfeld(g);

            if (!spiel.isPause()) {

                TetrominoSpielstein fallenderSpielstein = spiel.getFallenderSpielstein();

                if (fallenderSpielstein != null)
                    fallenderSpielstein.zeichnen(g);

                for (GeometrischeFigur gefallenerStein : spiel.getGefalleneSteine())
                    gefallenerStein.zeichnen(g);

            } else
                zeichnePauseSchriftzug(g);

        } finally {
            if (g != null)
                g.dispose();
        }

        getBufferStrategy().show();
    }

    public boolean istSpielfeldVoll() {

        for (TetrominoSpielstein gefallenerStein : spiel.getGefalleneSteine())
            if (gefallenerStein.getHoechstesY() <= 0)
                return true;

        return false;
    }

    private static void zeichneSpielfeld(Graphics g) {

        /* Hintergrund des Spielfeldes */
        g.setColor(TetrisKonstanten.VORDERGRUND.konvertiereZuColor());
        g.fillRect(TetrisKonstanten.SPIELFELD_X0, TetrisKonstanten.SPIELFELD_Y0, TetrisKonstanten.SPIELFELD_BREITE, TetrisKonstanten.SPIELFELD_HOEHE);
    }

    private void zeichnePauseSchriftzug(Graphics g) {

        Font font = new Font("Arial Black", Font.BOLD, TetrisKonstanten.BLOCK_BREITE);

        g.setColor(TetrisKonstanten.AKZENT.konvertiereZuColor());
        g.setFont(font);

        g.drawString("Pause", TetrisKonstanten.SPIELFELD_BREITE / 2 - TetrisKonstanten.BLOCK_BREITE * 2, TetrisKonstanten.SPIELFELD_HOEHE / 2);
    }

    private boolean faelltFallenderSteinAufAnderenStein() {

        if (spiel.getGefalleneSteine().isEmpty())
            return false;

        for (TetrominoSpielstein block : spiel.getGefalleneSteine())
            if (spiel.getFallenderSpielstein().faelltAuf(block))
                return true;

        return false;
    }

    private void loescheVolleReihen() {

        Collections.sort(spiel.getGefalleneSteine());

        Map<Integer, List<TetrominoSpielstein>> bloeckeProReihe = new HashMap<>();

        for (TetrominoSpielstein block : spiel.getGefalleneSteine()) {

            List<TetrominoSpielstein> blockListe = bloeckeProReihe.get(block.getY());

            if (blockListe == null)
                blockListe = new ArrayList<>();

            blockListe.add(block);

            bloeckeProReihe.put(block.getY(), blockListe);
        }

        for (Entry<Integer, List<TetrominoSpielstein>> reihe : bloeckeProReihe.entrySet()) {

            List<TetrominoSpielstein> blockListe = reihe.getValue();

            if (blockListe.size() == TetrisKonstanten.SPIELFELD_BREITE / TetrisKonstanten.BLOCK_BREITE)
                loescheReihe(blockListe);
        }
    }

    private void loescheReihe(List<TetrominoSpielstein> blockListe) {

        int hoehe = 0;

        for (TetrominoSpielstein block : blockListe) {

            block.setFuellFarbe(new Farbe(255, 60, 255));
            spiel.getGefalleneSteine().remove(block);
            hoehe = block.getY();
        }

        for (TetrominoSpielstein block : spiel.getGefalleneSteine())
            if (block.getY() < hoehe)
                block.bewegeNachUnten();

        spiel.erhoeheReihen();
    }
}