package com.ZavrsniProgram_OOP;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Klasa za prikaz toka naseg turnira nakon svakog kola.
 * @author Sime Roncevic
 * @since srpanj 2022
 */

public class Turnament extends JFrame {

    /**
     * JText Field koji sluzi za prikaz jednog kluba koji je u turniru.
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
     */
    private JTextField txt1;

    /**
     * JText Field koji sluzi za prikaz jednog kluba koji je u turniru.
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
     */
    private JTextField txt2;

    /**
     * JText Field koji sluzi za prikaz jednog kluba koji je u turniru.
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
     */
    private JTextField txt3;

    /**
     * JText Field koji sluzi za prikaz jednog kluba koji je u turniru.
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
     */
    private JTextField txt4;

    /**
     * JText Field koji sluzi za prikaz jednog kluba koji je u turniru.
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
     */
    private JTextField txt5;

    /**
     * JText Field koji sluzi za prikaz jednog kluba koji je u turniru.
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
     */
    private JTextField txt6;

    /**
     * JText Field koji sluzi za prikaz jednog kluba koji je u turniru.
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
     */
    private JTextField txt7;

    /**
     * JText Field koji sluzi za prikaz jednog kluba koji je u turniru.
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
     */
    private JTextField txt8;

    /**
     * JText Field koji sluzi za prikaz jednog kluba koji je u turniru.
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
     */
    private JTextField txt9;

    /**
     * JText Field koji sluzi za prikaz jednog kluba koji je u turniru.
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
     */
    private JTextField txt10;

    /**
     * JText Field koji sluzi za prikaz jednog kluba koji je u turniru.
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
     */
    private JTextField txt11;

    /**
     * JText Field koji sluzi za prikaz jednog kluba koji je u turniru.
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
     */
    private JTextField txt12;


    /**
     * JText Field koji sluzi za prikaz jednog kluba koji je u turniru.
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
     */
    private JTextField txt13;

    /**
     * JText Field koji sluzi za prikaz jednog kluba koji je u turniru.
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
     */
    private JTextField txt14;

    /**
     * JText Field koji sluzi za prikaz jednog kluba koji je u turniru.
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
     */
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

        lista1 = GlavnaIgra.Glistener.getKolo1();
        lista2 = GlavnaIgra.Glistener.getKolo2();
        lista3 = GlavnaIgra.Glistener.getKolo3();
        pobjednik = GlavnaIgra.Glistener.getPobjednik();



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
     * Klubovi mogu pobjediti utakmicu pa se jedan klub moze nalaziti u vise TextFieldova.
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
