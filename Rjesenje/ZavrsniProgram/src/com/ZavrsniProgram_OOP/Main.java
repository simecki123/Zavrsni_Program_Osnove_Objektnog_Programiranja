package com.ZavrsniProgram_OOP;

import javax.swing.*;

/**
 * Nasa klasa koja pokrece GUI
 * @author Sime Roncevic
 * @since srpanj 2022
 */


public class Main {

    /**
     * Pocetna strana je prvi prozor koji se otvara.
     */
    public static PocetnaStr pocetnaStr;



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pocetnaStr = new PocetnaStr();


            }
        });
    }



}
