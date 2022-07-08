package com.ZavrsniProgram_OOP;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Random;

/**
 * Glavna klasa za realizaciju nase igre.
 * Predstavlja pocetni ekran nase igre.
 * @author Sime Roncevic
 * @since srpanj 2022
 *
 */

public class GlavnaIgra extends JFrame {

    /**
     * Nas panel koji predstavlja jedan dio Glavne Igre.
     */
    private static GlavnaIgra_UP GU;

    /**
     * Nas panel koji predstavlja jedan dio Glavne Igre.
     */
    private static GlavnaIgraDown GD;

    /**
     * Interface koji je ujedno i nas listener te sadrzi odredene metode.
     */
    public static GlavnaIgraListener Glistener;

    /**
     * Klasa koja sadrzi neke metode vezane za promjenu vrijednosti svojih varijabli.
     * Cuva nase vrijednosti za Glavnu Igru.
     */
    public static UtakmiceGlavneIgre UGLI;




    public GlavnaIgra(){
        super("PŠK-Prva Šimina Kladionica");
        setSize(700,550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        initComponents();
        layoutAll();
        activateComponents();
        Glistener.pokreniIgruUPozadini();



    }



    private void initComponents(){

        GU = new GlavnaIgra_UP();
        GD = new GlavnaIgraDown();
        UGLI = new UtakmiceGlavneIgre();

    }

    private void layoutAll(){
        setLayout(new BorderLayout());
        add(GU, BorderLayout.NORTH);
        add(GD, BorderLayout.CENTER);

    }

    /**
     * Aktiviramo nase komponente te postavljamo nas listener.
     */
    private void activateComponents(){
        Glistener = new GlavnaIgraListener() {
            @Override
            public void pokreniIgruUPozadini() {
                UGLI.pokreniIgruUPozadini();
            }

            @Override
            public void novaUtak() {
                UGLI.novaUtak();
            }

            @Override
            public void izracunajDobitak() {
                UGLI.izracunajDobitak();
            }

            @Override
            public ArrayList<String> getKolo1() {
                return UtakmiceGlavneIgre.getKolo1();
            }

            @Override
            public ArrayList<String> getKolo2() {
                return UtakmiceGlavneIgre.getKolo2();
            }

            @Override
            public ArrayList<String> getKolo3() {
                return UtakmiceGlavneIgre.getKolo3();
            }

            @Override
            public String getPobjednik() {
                return UtakmiceGlavneIgre.getPobjednik();
            }

            @Override
            public void setTrenutnoStanjeNaRacunu(int trenutnoStanjeNaRacunu) {
                UGLI.setTrenutnoStanjeNaRacunu(trenutnoStanjeNaRacunu);
            }

        };

        GU.setGListener(Glistener);
        GD.setGListener(Glistener);
    }


    /**
     * Klasicni geter
     * @return
     *      Vraca "GlavnuIgru_UP"
     */
    public static GlavnaIgra_UP getGU() {
        return GU;
    }

    /**
     * klasicni geter
     * @return
     *      Vraca "GlavnuIgruDown"
     */
    public static GlavnaIgraDown getGD() {
        return GD;
    }
}
