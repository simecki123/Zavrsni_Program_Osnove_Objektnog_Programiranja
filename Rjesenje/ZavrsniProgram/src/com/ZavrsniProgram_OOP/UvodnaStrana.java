package com.ZavrsniProgram_OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ova klasa je nas uvodni prozor koji ce nam omoguciti da odaberemo jednu od dvije igre.
 * @author Sime Roncevic
 * @since srpanj 2022
 */

public class UvodnaStrana extends JFrame {
    /**
     * Botun koji nam omogucuje da pritiskom na njega pokrecemo Igru "Liga".
     */
    public static JButton liga;

    /**
     * Botun koji nam omogucuje da pritiskom na njega pokrecemo igru "Turnir.
     */
    public static JButton turnir;

    /**
     * Nasa glavna igra odnosno turnir.
     */
    public static GlavnaIgra GI;

    /**
     * Nasa igra "Liga".
     */
    public static Liga ligaPr;


    public UvodnaStrana(){
        super("PŠK-Prva Šimina Kladionica");
        setSize(700,550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        initComponents();
        layoutAll();

        activateGames();
    }

    private void initComponents(){
        liga = new JButton("LIGA");
        turnir = new JButton("TURNIR");
    }

    private void layoutAll(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        add(liga,gbc);
        gbc.gridx++;

        add(new JLabel("            "), gbc);
        gbc.gridx++;

        add(turnir,gbc);

    }

    private void activateGames(){
        liga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ligaPr = new Liga();
            }
        });

        turnir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GI = new GlavnaIgra();
            }
        });
    }

    /**
     * Klasicni geter.
     * @return
     *      vraca "Glavnu igru"
     */
    public static GlavnaIgra getGI() {
        return GI;
    }

    /**
     * Klasicni geter.
     * @return
     *      vraca "Ligu"
     */
    public static Liga getLigaPr() {
        return ligaPr;
    }
}

