package com.ZavrsniProgram_OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Ova klasa predstavlja nasu ligu. Odnosno ovaj dio igre je predstavljen kao jedno kolo lige.
 * Dodatni zadatak
 * @author Sime Roncevic
 * @since srpanj 2022
 */

public class Liga extends JFrame {

    /**
     * Panel koji predstavlja jedan dio naseg prozora za igru s ligom
     */
    public static Liga_UP LU;

    /**
     * Panel koji predstavlja jedan dio naseg prozora za igru s ligom
     */
    public static Liga_Down LD;

    /**
     * Interface koji je ujedno i nas listener te sadrzi odredene metode.
     */
    private static LigaListener LListener;

    /**
     * Klasa koja sadrzi neke metode vezane za promjenu vrijednosti svojih varijabli.
     * Cuva nase vrijednosti za Ligu.
     */
    public static UtakmiceLige UL;

    public Liga(){
        super("PŠK-Prva Šimina Kladionica");
        setSize(700,550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        initComponents();
        layoutAll();
        activateComponents();
        LListener.pokreniIgruUPozadini();
    }

    private void initComponents(){
        LU = new Liga_UP();
        LD = new Liga_Down();
        UL = new UtakmiceLige();
    }

    private void layoutAll(){
        setLayout(new BorderLayout());
        add(LU, BorderLayout.NORTH);
        add(LD, BorderLayout.CENTER);
    }

    /**
     * Aktiviramo nase komponente te postavljamo nas listener.
     */
    private void activateComponents(){
        LListener = new LigaListener() {
            @Override
            public void pokreniIgruUPozadini() {
                UL.pokreniIgruUPozadini();
            }

            @Override
            public void novaUtak() {
                UL.novaUtak();
            }

            @Override
            public void izracunajDobitak() {
                UL.izracunajDobitak();
            }

            @Override
            public HashMap<String, Integer> getKluboviIKovte() {
                return UL.getKluboviIKvote();
            }
        };

        LU.setLListener(LListener);
        LD.setLListener(LListener);
    }

    /**
     * Klasicni geter
     * @return
     *      Vraca jedan panel nase lige.
     */
    public static Liga_UP getLU() {
        return LU;
    }


    /**
     * Klasicni geter
     * @return
     *      Vraca jedan panel nase lige.
     */
    public static Liga_Down getLD() {
        return LD;
    }


}
