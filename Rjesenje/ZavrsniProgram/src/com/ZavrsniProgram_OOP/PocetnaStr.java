package com.ZavrsniProgram_OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;


/**
 * Pocetna strana omogucuje registraciju korisnika i prikaz zadnjih igara
 * @author Sime Roncevic
 * @since srpanj 2022
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
     * Uvodna strana je prozor koji se otvara pritiskom na botun Log in.
     */
    public static UvodnaStrana ustr;

    /**
     * JBUtton je botun koji nam sluzi da vidimo sve registrirane korisnike koji su u proslosti igrali igru i koji su rezultat ostvarili.
     */
    private static JButton register;

    /**
     * JButton koji nam sluzi za otvaranj uvodnog prozora preko kojega biramo koju igru zelimo igrati
     * Pritiskom na njega stvaramo korisnika.
     */
    public static JButton logIn;

    /**
     * JTextField je polje u koje korisnik upisuje svoje ime.
     */
    public static JTextField mojeIme;

    /**
     * JTextField u kojem korisnik zapisuje svoje prezime
     */
    public static JTextField mojID;

    public PocetnaStr() {
        super("Registracija");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        korisniciIZF = CitanjeFilea.loadKorisnici();

        initComponents();
        layoutComponents();
        activatePocetnaStr();


    }

    public static void initComponents() {
        register = new JButton("Rekordi");
        logIn = new JButton("LOG IN");

        mojeIme = new JTextField(10);
        mojID = new JTextField(10);

    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        add(new JLabel("Ime:"), gbc);
        gbc.gridx++;

        add(mojeIme, gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //----------------------------------------

        add(new JLabel("     "), gbc);
        gbc.gridy++;

        //----------------------------------------

        add(new JLabel("ID:"), gbc);
        gbc.gridx++;

        add(mojID, gbc);
        gbc.gridx = 0;

        gbc.gridy++;
        //----------------------------------------

        add(new JLabel("     "), gbc);
        gbc.gridy++;

        //----------------------------------------

        add(register, gbc);
        gbc.gridx++;
        add(logIn, gbc);
    }

    private void activatePocetnaStr() {
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == register) {
                    rekordi = new Rekordi();
                }
            }
        });

        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == logIn) {
                    if (!Objects.equals(mojeIme.getText(), "") & !Objects.equals(mojID.getText(), "")) {
                        noviKorisnik = new Korisnik(mojeIme.getText(), mojID.getText());
                        ustr = new UvodnaStrana();
                    }
                }
            }
        });
    }





    /**
     * Klasicni geter
     * @return
     *      vraca Korisnika
     */
    public static Korisnik getNoviKorisnik() {
        return noviKorisnik;
    }

    /**
     * Klasicni geter
     * @return
     *      Vraca korisnikeIzListe
     */
    public static ArrayList<Korisnik> getKorisniciIZF() {
        return korisniciIZF;
    }
}
