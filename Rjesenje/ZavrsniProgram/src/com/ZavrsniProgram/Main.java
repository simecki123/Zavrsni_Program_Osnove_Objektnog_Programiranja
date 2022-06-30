package com.ZavrsniProgram;

import javax.swing.*;

/**
 * Nasa klasa koja pokrece GUI
 * @author Sime Roncevic
 */


public class Main {


    public static PocetnaStr pocetnaStr;



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pocetnaStr = new PocetnaStr();


            }
        });
    }

    public static PocetnaStr getPocetnaStr() {
        return pocetnaStr;
    }
}
