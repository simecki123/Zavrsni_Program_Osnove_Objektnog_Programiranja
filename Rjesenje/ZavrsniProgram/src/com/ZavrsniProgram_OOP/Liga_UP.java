package com.ZavrsniProgram_OOP;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Nas panel koji cini jedan dio igre "Liga".
 * @author Sime Roncevic
 * @since srpanj 2022
 */

public class Liga_UP extends JPanel implements ActionListener {
    /**
     * JButton koji nam omogucujemo da se pritiskom na njega kladimo na odredeni klub.
     */
    public static JButton kl1;

    /**
     * Pritiskom na ovaj botun korisnik misli da ce rezultat utakmice biti nerijesen.
     */
    public static JButton izjednaceno;

    /**
     * JButton koji nam omogucuje da se pritiskom na njega kladimo na odredeni klub.
     */
    public static JButton kl2;

    /**
     * JTextField koji nam prikazuje kvotu na odredeno kladenje.
     */
    public static JTextField kvota;

    /**
     * JTextField koji nam prikazuje ime jednog od ponudenih klubova.
     */
    public static JTextField imeKL1;

    /**
     * JTextField koji nam prikazuje ime jednog od ponudenih klubova.
     */
    public static JTextField imeKL2;

    /**
     * Listener za sve nase akcije
     * Posjeduje odredene metode koje koristoimo
     */
    public LigaListener LListener;

    public Liga_UP(){
        Dimension dim = getPreferredSize();
        dim.height = 150;
        setPreferredSize(dim);

        initComponents();
        setBorders();
        layoutComponents();
        activateLigaUp();
    }

    private void initComponents(){
        kl1 = new JButton("1");
        kl2 = new JButton("2");
        izjednaceno = new JButton("X");

        kvota = new JTextField(4);
        imeKL1 = new JTextField(10);
        imeKL2 = new JTextField(10);

        kvota.setEditable(false);
        imeKL1.setEditable(false);
        imeKL2.setEditable(false);
    }

    private void setBorders() {
        Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border inner = BorderFactory.createTitledBorder("Main Game");

        Border border = BorderFactory.createCompoundBorder(outer, inner);
        setBorder(border);
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        add(imeKL1,gbc);
        gbc.gridx++;

        add(new JLabel("      "), gbc);
        gbc.gridx++;

        add(imeKL2,gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //----------------------------------------------------------------

        add(kl1,gbc);
        gbc.gridx++;

        add(izjednaceno,gbc);
        gbc.gridx++;

        add(kl2,gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //----------------------------------------------------------------

        add(new JLabel("   "),gbc);
        gbc.gridy++;

        //----------------------------------------------------------------

        gbc.gridx++;
        add(kvota,gbc);

    }

    /**
     * Postavljamo nas listener.
     * @param LListener
     *      Postavljamo listener iz igre "Liga".
     */
    public void setLListener(LigaListener LListener) {
        this.LListener = LListener;
    }

    /**
     * Dodavamo action listener za nase botune.
     */
    private void activateLigaUp(){
        kl1.addActionListener(this);
        kl2.addActionListener(this);
        izjednaceno.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == kl1){
            Liga.LD.ulog.setEnabled(true);
            Liga.LD.igraj.setEnabled(true);
            Liga.UL.pogadanje = 1;
            HashMap<String, Integer> kluboviIKvote = LListener.getKluboviIKovte();

            for(Map.Entry<String, Integer> set : kluboviIKvote.entrySet()){
                int vr = set.getValue();
                String klub = set.getKey();
                if(imeKL1.getText().equals(klub)){
                    kvota.setText(String.valueOf(vr));
                }

            }
            LListener.izracunajDobitak();
        }

        if(e.getSource() == izjednaceno) {
            Liga.LD.ulog.setEnabled(true);
            Liga.LD.igraj.setEnabled(true);
            Liga.UL.pogadanje = 2;
            int odabranaKvota = Liga.UL.brojiIZjKvote.get(Liga.UL.brojiKvoteX);
            kvota.setText(String.valueOf(odabranaKvota));

            LListener.izracunajDobitak();


        }

        if(e.getSource() == kl2){
            Liga.LD.ulog.setEnabled(true);
            Liga.LD.racun.setText(String.valueOf(Liga.UL.trenutnoStanjeNaRacunu));
            Liga.LD.igraj.setEnabled(true);
            Liga.UL.pogadanje = 3;

            HashMap<String, Integer> kluboviIKvote = LListener.getKluboviIKovte();

            for(Map.Entry<String, Integer> set : kluboviIKvote.entrySet()){
                int vr = set.getValue();
                String klub = set.getKey();
                if(imeKL2.getText().equals(klub)){
                    kvota.setText(String.valueOf(vr));
                }

            }
            LListener.izracunajDobitak();
        }
    }
}
