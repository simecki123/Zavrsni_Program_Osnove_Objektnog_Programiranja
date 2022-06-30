package com.ZavrsniProgram;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Klasa koja cini donji dio nase Glavne igre.
 * Ova klasa je zaslužna za kontantno pokretanje novih utakmica
 *
 * @author Sime Roncevic
 */



public class GlavnaIgraDown extends JPanel {
    /**
     * sluzi za otvaranje bonus igre
     */
    public static BonusIgra BI;

    public static JButton igraj;
    private JButton odustani;

    public static JComboBox<String> ulog;
    public static JTextField potencijalniDobitak;
    public static JTextField trenutnoUNovcaniku;
    public static JTextField bonus;

    private JButton turnir;
    public static JButton bonusIgra;



    public GlavnaIgraDown(){
        Dimension dim = getPreferredSize();
        setPreferredSize(dim);

        innitComponents();
        layoutComponents();
        setBorders();
        activateGlIgraDown();
    }

    private void innitComponents(){
        igraj = new JButton("PLAY");
        odustani = new JButton("GIVE UP");

        ulog = new JComboBox<String>(GlavnaIgra.myBet);
        potencijalniDobitak = new JTextField(5);
        trenutnoUNovcaniku = new JTextField(5);
        bonus = new JTextField(5);

        trenutnoUNovcaniku.setText("10");


        potencijalniDobitak.setEditable(false);
        trenutnoUNovcaniku.setEditable(false);
        bonus.setEditable(false);

        turnir = new JButton("TURNAMENT");
        bonusIgra = new JButton("BONUS GAME");
        bonus.setText("0");

        igraj.setEnabled(false);
        odustani.setEnabled(false);
        ulog.setEnabled(false);


    }

    private void setBorders() {
        Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border inner = BorderFactory.createTitledBorder("Settings");

        Border border = BorderFactory.createCompoundBorder(outer, inner);
        setBorder(border);
    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        add(new JLabel("        "),gbc);
        gbc.gridx++;

        add(new JLabel("        "),gbc);
        gbc.gridx++;

        add(igraj,gbc);
        gbc.gridx++;

        add(new JLabel("        "),gbc);
        gbc.gridx++;

        add(odustani,gbc);
        gbc.gridx++;

        add(new JLabel("        "),gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        //-------------------------------------------

        add(new JLabel("      "),gbc);
        gbc.gridy++;
        //-------------------------------------------

        gbc.gridx++;
        gbc.gridx++;

        add(new JLabel("Ulog:"),gbc);
        gbc.gridx++;
        gbc.gridx++;

        add(new JLabel("Dobitak:"),gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        //-------------------------------------------

        add(new JLabel("   "),gbc);
        gbc.gridy++;
        //-------------------------------------------

        gbc.gridx++;
        gbc.gridx++;

        add(ulog,gbc);
        gbc.gridx++;
        gbc.gridx++;

        add(potencijalniDobitak,gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        //-------------------------------------------
        add(new JLabel("   "),gbc);
        gbc.gridy++;
        //-------------------------------------------

        gbc.gridx++;
        gbc.gridx++;

        add(new JLabel("Budžet:"),gbc);
        gbc.gridx++;
        gbc.gridx++;

        add(new JLabel("Bonus:"),gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        //-------------------------------------------

        add(new JLabel(""),gbc);
        gbc.gridy++;
        //-------------------------------------------

        add(turnir,gbc);
        gbc.gridx++;
        gbc.gridx++;

        add(trenutnoUNovcaniku,gbc);
        gbc.gridx++;
        gbc.gridx++;

        add(bonus,gbc);
        gbc.gridx++;
        gbc.gridx++;

        add(bonusIgra,gbc);



    }




    private void activateGlIgraDown(){
        bonusIgra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == bonusIgra){
                     BI = new BonusIgra();
                }
            }
        });

        ulog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == ulog){
                    GlavnaIgra.izracunajDobitak();
                }
            }
        });

        igraj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == igraj){
                    GlavnaIgra.trenutnoStanjeNaRacunu = GlavnaIgra.trenutnoStanjeNaRacunu-GlavnaIgra.manje;
                    trenutnoUNovcaniku.setText(String.valueOf(GlavnaIgra.trenutnoStanjeNaRacunu));

                    PocetnaStr.GI.novaUtak();
                    GlavnaIgra_UP.ispisKvote.setText("");
                    GlavnaIgraDown.igraj.setEnabled(false);
                    bonusIgra.setEnabled(false);
                    ulog.setEnabled(false);
                    odustani.setEnabled(true);
                }
            }
        });
        odustani.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == odustani){
                    ArrayList<Korisnik> korisnici = PocetnaStr.getKorisniciIZF();
                    Korisnik korisnik = PocetnaStr.getNoviKorisnik();
                    korisnik.setNovacNaRacunu(GlavnaIgra.trenutnoStanjeNaRacunu);
                    if(! korisnici.contains(korisnik)) {
                        korisnici.add(korisnik);
                    }

                    CitanjeFilea.saveKorisnici(korisnici);
                    JFrame osvojeno = new JFrame();
                    JOptionPane.showMessageDialog(osvojeno, "Prekinuli steIgru Pokupite Nagradu: "+GlavnaIgra.trenutnoStanjeNaRacunu);

                    GlavnaIgra GI = PocetnaStr.getGI();
                    GI.dispose();

                }
            }
        });

        turnir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == turnir){
                    Turnament turnament = new Turnament();
                }
            }
        });


    }

    /**
     * Daje Bonus igru.
     * Potrebno za pristup odredenim vrijednostima
     * @return
     */
    public static BonusIgra getBI() {
        return BI;
    }


}

