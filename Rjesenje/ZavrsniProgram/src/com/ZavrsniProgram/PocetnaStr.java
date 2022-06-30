package com.ZavrsniProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;


/**
 * Pocetna strana omogucuje registraciju korisnika i prikaz zadnjih igara
 * @author Sime Roncevic
 */
public class PocetnaStr extends JFrame {

    /**
     * Nasi korisnici koje dobijemo iz bin file-a
     */
    public static ArrayList<Korisnik> korisniciIZF;

    /**
     * Klasa Rekordi
     */
    public static Rekordi rekordi;

    /**
     * Nas korisnik
     */
    public static Korisnik noviKorisnik;

    /**
     * Klasa GlavnaIgra
     */
    public static GlavnaIgra GI;

    private static JButton register;
    public static JButton logIn;

    public static JTextField mojeIme;
    public static JTextField mojID;

    public PocetnaStr(){
        super("Registracija");
        setSize(700,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        korisniciIZF = CitanjeFilea.loadKorisnici();

        initComponents();
        layoutComponents();
        activatePocetnaStr();


    }

    public static void initComponents(){
        register = new JButton("Rekordi");
        logIn = new JButton("LOG IN");

        mojeIme = new JTextField(10);
        mojID = new JTextField(10);

    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        add(new JLabel("Ime:"),gbc);
        gbc.gridx++;

        add(mojeIme,gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //----------------------------------------

        add(new JLabel("     "),gbc);
        gbc.gridy++;

        //----------------------------------------

        add(new JLabel("ID:"),gbc);
        gbc.gridx++;

        add(mojID,gbc);
        gbc.gridx = 0;

        gbc.gridy++;
        //----------------------------------------

        add(new JLabel("     "),gbc);
        gbc.gridy++;

        //----------------------------------------

        add(register,gbc);
        gbc.gridx++;
        add(logIn,gbc);
    }

    private void activatePocetnaStr(){
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==register){
                    rekordi = new Rekordi();
                }
            }
        });

        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==logIn){
                    if(!Objects.equals(mojeIme.getText(), "") & !Objects.equals(mojID.getText(), "")) {
                        noviKorisnik = new Korisnik(mojeIme.getText(), mojID.getText());
                        GI = new GlavnaIgra();
                    }
                }
            }
        });
    }


    /**
     * Vraca GlavnuIgru
     * @return
     */
    public static GlavnaIgra getGI() {
        return GI;
    }

    /**
     * vraca Korisnika
     * @return
     */
    public static Korisnik getNoviKorisnik() {
        return noviKorisnik;
    }

    /**
     * Vraca korisnikeIzListe
     * @return
     */
    public static ArrayList<Korisnik> getKorisniciIZF() {
        return korisniciIZF;
    }
}
