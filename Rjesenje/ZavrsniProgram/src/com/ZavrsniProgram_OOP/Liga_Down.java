package com.ZavrsniProgram_OOP;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Nas panel koji cini jedan dio igre "Liga".
 * @author Sime Roncevic
 * @since srpanj 2022
 */

public class Liga_Down extends JPanel implements ActionListener {

    /**
     * JTextField kojin nam prikazuje potencijalni dobitak koji mozemo dobiti, ako odigramo igru na odredeni nacin.
     */
    public static JTextField potencijalniDobitak;

    /**
     * JTextField koji nam prikazuje koliko novaca trenutno imamo na racunu.
     */
    public static JTextField racun;

    /**
     * JComboBox koji nam omogucuje da odaberemo nas ulog.
     */
    public static JComboBox<String> ulog;

    /**
     * JButton koji nam omogucuje pokretanje igre kada se odlucimo za to.
     * Pritiskom na ovaj gumb prelazimo u iduci dio igre.
     */
    public static JButton igraj;

    /**
     * JButton koji nam omogucuje da u bilo kojem trenutku odustanemo od igre.
     */
    private static JButton odustani;

    /**
     * Listener za sve nase akcije
     * Posjeduje odredene metode koje koristoimo
     */
    public LigaListener LListener;

    public Liga_Down(){
        Dimension dim = getPreferredSize();
        setPreferredSize(dim);

        initComponents();
        setBorders();
        layoutComponents();
        activateLigaDown();
    }

    private void initComponents(){
        igraj = new JButton("IGRAJ");
        odustani = new JButton("ODUSTANI");

        ulog = new JComboBox<>(Liga.UL.myBet);

        potencijalniDobitak = new JTextField(10);
        racun = new JTextField(10);

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

        add(new JLabel("Ulog:"),gbc);
        gbc.gridx++;

        add(new JLabel("    "),gbc);
        gbc.gridx++;

        add(new JLabel("Potencijalni dobitak:"),gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //-----------------------------------------------------

        add(ulog,gbc);
        gbc.gridx++;
        gbc.gridx++;

        add(potencijalniDobitak,gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //-----------------------------------------------------

        add(new JLabel("   "),gbc);
        gbc.gridy++;

        //-----------------------------------------------------

        gbc.gridx++;
        add(new JLabel("Stanje na racunu:"),gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //----------------------------------------------------

        gbc.gridx++;
        add(racun,gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        //------------------------------------------------------

        add(new JLabel("   "),gbc);
        gbc.gridy++;

        //------------------------------------------------------

        add(igraj,gbc);
        gbc.gridx++;
        gbc.gridx++;

        add(odustani,gbc);

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
    private void activateLigaDown(){
        igraj.addActionListener(this);
        odustani.addActionListener(this);
        ulog.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ulog){
            int indx = ulog.getSelectedIndex();
            Liga.UL.manje = Integer.parseInt(Liga.UL.myBet[indx]);
            LListener.izracunajDobitak();
        }

        if(e.getSource() == igraj){
            odustani.setEnabled(true);
            ulog.setEnabled(false);
            Liga.UL.trenutnoStanjeNaRacunu = Liga.UL.trenutnoStanjeNaRacunu-Liga.UL.manje;
            racun.setText(String.valueOf(Liga.UL.trenutnoStanjeNaRacunu));
            Liga.UL.brojiKvoteX++;

            LListener.novaUtak();
            Liga.LU.kvota.setText("");
            igraj.setEnabled(false);



        }

        if(e.getSource() == odustani){

            racun.setText(String.valueOf(Liga.UL.trenutnoStanjeNaRacunu));
            ArrayList<Korisnik> korisnici = PocetnaStr.getKorisniciIZF();
            Korisnik korisnik = PocetnaStr.getNoviKorisnik();
            korisnik.setNovacNaRacunuLiga(Liga.UL.trenutnoStanjeNaRacunu);

            if(korisnici.contains(korisnik)){
                for(int k = 0; k < korisnici.size(); k++){
                    if(korisnici.get(k) == korisnik){
                        korisnici.get(k).setNovacNaRacunuLiga(korisnik.getNovacNaRacunuLiga());
                    }
                }
            } else {
                korisnici.add(korisnik);
            }
            CitanjeFilea.saveKorisnici(korisnici);
            PocetnaStr.logIn.setEnabled(false);

            UvodnaStrana.liga.setEnabled(false);
            CitanjeFilea.saveKorisnici(korisnici);
            JFrame osvojeno = new JFrame();
            JOptionPane.showMessageDialog(osvojeno, "Prekinuli steIgru Pokupite Nagradu: "+Liga.UL.trenutnoStanjeNaRacunu);
            Liga LI = UvodnaStrana.getLigaPr();
            LI.dispose();

        }

    }
}
