package com.ZavrsniProgram_OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Rekordi prikazuju nase korisnike i njihove dobitke
 * @author Sime Roncevic
 * @since srpanj 2022
 */

public class Rekordi extends JFrame {

    /**
     * Ovo su nasi korisnici koje dobijemo iz filea.
     */
    public ArrayList<Korisnik> korisniciIZF;

    /**
     * JTextarea je prostor u kojeg zapisujemo sve korisnike koji su registrirani i koji su igrali igru.
     */
    private JTextArea TA;

    private JScrollPane SB;

    /**
     * Klikom na ovaj botun izlazimo iz prozora.
     */
    private JButton cancle;

    public Rekordi(){
        super("Rekordi");

        setSize(700,550);
        dispose();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        korisniciIZF = PocetnaStr.getKorisniciIZF();

        initComponents();
        layoutAll();
        butnCancle();


    }

    private void initComponents() {
        TA = new JTextArea(400,600);
        unesiTekst();
        SB = new JScrollPane(TA);
        cancle = new JButton("Cancle");
    }

    private void layoutAll(){
        setLayout(new BorderLayout());
        add(SB, BorderLayout.CENTER);
        add(cancle, BorderLayout.SOUTH);
    }

    private void butnCancle() {
        cancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == cancle){
                    dispose();

                }
            }
        });
    }

    /**
     * Unose tekst u nas TextArea.
     * U Konstruktoru Pocetne strane korisnici se izvlace iz Filea.
     * Rekordi dobivaju korisnike pomocu getera.
     * U Ovoj metodi te korisnike zapisujemo u vizualni prikaz za korisnika.
     */
    private void unesiTekst(){
        TA.setText(null);
        for(Korisnik korisnik : korisniciIZF){
            TA.append(korisnik.toString() + "\n");
            System.out.println(korisnik);
        }

    }



}
