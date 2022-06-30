package com.ZavrsniProgram;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Klasa za prikaz toka naseg turnira nakon svakog kola.
 * @author Sime Roncevic
 */

public class Turnament extends JFrame {
    private JTextField txt1;
    private JTextField txt2;
    private JTextField txt3;
    private JTextField txt4;
    private JTextField txt5;
    private JTextField txt6;
    private JTextField txt7;
    private JTextField txt8;

    private JTextField txt9;
    private JTextField txt10;
    private JTextField txt11;
    private JTextField txt12;

    private JTextField txt13;
    private JTextField txt14;

    private JTextField txt15;

    /**
     * Lista koja sprema podatke o odredenom kolu iz nase glavne igre
     */
    private ArrayList<String> lista1;

    /**
     * Lista koja sprema podatke o odredenom kolu iz nase glavne igre
     */
    private ArrayList<String> lista2;

    /**
     * Lista koja sprema podatke o odredenom kolu iz nase glavne igre
     */
    private ArrayList<String> lista3;

    /**
     * sprema pobjednika turnira iz glavne liste
     */
    private String pobjednik;





    public Turnament(){
        super("Prikaz turnira");
        setSize(700,550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        lista1 = GlavnaIgra.getKolo1();
        lista2 = GlavnaIgra.getKolo2();
        lista3 = GlavnaIgra.getKolo3();
        pobjednik = GlavnaIgra.getPobjednik();



        initComponents();
        layoutComponents();


    }

    private void initComponents(){
        txt1 = new JTextField(10);
        txt2 = new JTextField(10);
        txt3 = new JTextField(10);
        txt4 = new JTextField(10);
        txt5 = new JTextField(10);
        txt6 = new JTextField(10);
        txt7 = new JTextField(10);
        txt8 = new JTextField(10);

        txt9 = new JTextField(10);
        txt10 = new JTextField(10);
        txt11 = new JTextField(10);
        txt12 = new JTextField(10);

        txt13 = new JTextField(10);
        txt14 = new JTextField(10);

        txt15 = new JTextField(10);

        ispisiTurnir();


    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        add(txt1,gbc);
        gbc.gridx++;

        add(new JLabel("         "),gbc);
        gbc.gridx++;

        add(new JLabel("         "),gbc);
        gbc.gridx++;

        add(new JLabel("         "),gbc);
        gbc.gridx++;

        add(new JLabel("         "),gbc);
        gbc.gridx++;

        add(new JLabel("         "),gbc);
        gbc.gridx++;

        add(new JLabel("         "),gbc);
        gbc.gridx++;

        gbc.gridx = 0;
        gbc.gridy++;
        //-----------------------------------

        gbc.gridx++;
        gbc.gridx++;

        add(txt9,gbc);
        gbc.gridy++;
        gbc.gridx = 0;

        //--------------------------------------

        add(txt2,gbc);
        gbc.gridy++;

        //--------------------------------------

        gbc.gridx++;
        gbc.gridx++;
        gbc.gridx++;
        gbc.gridx++;

        add(txt13,gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //-------------------------------------

        add(txt3,gbc);
        gbc.gridy++;

        //------------------------------------

        gbc.gridx++;
        gbc.gridx++;

        add(txt10,gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //-------------------------------------
        add(txt4,gbc);
        gbc.gridy++;

        //------------------------------------

        gbc.gridx++;
        gbc.gridx++;
        gbc.gridx++;
        gbc.gridx++;
        gbc.gridx++;

        add(txt15,gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //--------------------------------------

        add(txt5,gbc);
        gbc.gridy++;

        //------------------------------------

        gbc.gridx++;
        gbc.gridx++;

        add(txt11,gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //-----------------------------------

        add(txt6,gbc);
        gbc.gridy++;

        //-----------------------------------

        gbc.gridx++;
        gbc.gridx++;
        gbc.gridx++;
        gbc.gridx++;

        add(txt14,gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //-----------------------------------

        add(txt7,gbc);
        gbc.gridy++;

        //------------------------------------

        gbc.gridx++;
        gbc.gridx++;

        add(txt12,gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //----------------------------------

        add(txt8,gbc);


    }

    /**
     * Metoda koja ispisuje sva Text podrucja u kojima se trebaju nalaziti imena nasih klubova
     */
    private void ispisiTurnir(){
        int brojac = 0;
        if(! lista1.isEmpty()) {
            txt1.setText(lista1.get(brojac));
            brojac++;
            txt2.setText(lista1.get(brojac));
            brojac++;
            txt3.setText(lista1.get(brojac));
            brojac++;
            txt4.setText(lista1.get(brojac));
            brojac++;
            txt5.setText(lista1.get(brojac));
            brojac++;
            txt6.setText(lista1.get(brojac));
            brojac++;
            txt7.setText(lista1.get(brojac));
            brojac++;
            txt8.setText(lista1.get(brojac));
            brojac = 0;
        }

        if (! lista2.isEmpty()){
            txt9.setText(lista2.get(brojac));
            brojac++;
            txt10.setText(lista2.get(brojac));
            brojac++;
            txt11.setText(lista2.get(brojac));
            brojac++;
            txt12.setText(lista2.get(brojac));
            brojac = 0;
        }

        if(! lista3.isEmpty()){
            txt13.setText(lista3.get(brojac));
            brojac++;
            txt14.setText(lista3.get(brojac));
            brojac = 0;
        }

        if(pobjednik != null){
            txt15.setText(pobjednik);
        }




    }


}
