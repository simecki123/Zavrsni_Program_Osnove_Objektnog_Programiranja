package com.ZavrsniProgram_OOP;

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
 * @since srpanj 2022
 */



public class GlavnaIgraDown extends JPanel implements ActionListener {
    /**
     * sluzi za otvaranje bonus igre.
     */
    public static BonusIgra BI;

    /**
     * Listener za sve nase akcije
     * Posjeduje odredene metode koje koristoimo
     */
    private static GlavnaIgraListener GListener;

    /**
     * Botun koji nam omogucujemo da igramo nasu igru.
     * Svakim pritiskom na ovaj botun nasa igra se pokrece i postavlja nam nove klubove na koje se mozemo kladiti.
     */
    public static JButton igraj;

    /**
     * Botun koji nam omogucuje da odustanemo od igre.
     */
    private JButton odustani;

    /**
     * JComboBox koji nam omogucuje da biramo nas ulog.
     */
    public static JComboBox<String> ulog;

    /**
     * JTextField kojji nam omogucuje da vidimo nas potencijalni dobitak, ako odigramo igru na odredeni nacin.
     */
    public static JTextField potencijalniDobitak;

    /**
     * JTextField koji nam pokazuje koliko novaca imamo na racaunu.
     */
    public static JTextField trenutnoUNovcaniku;

    /**
     * JTextField koji nam pokazuje bonus dobitak iz bonus igre.
     * Taj dobitak dobivamo, ako se na kraju igre ostvari nase predvidanje iz bonus igre.
     */
    public static JTextField bonus;

    /**
     * Pritiskom na ovaj botun otvara se prikaz naseg turnira.
     */
    private JButton turnir;

    /**
     * Pritiskom na ovaj botun otvara se nasa bonus igra.
     */
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

        ulog = new JComboBox<String>(GlavnaIgra.UGLI.myBet);
        potencijalniDobitak = new JTextField(5);
        trenutnoUNovcaniku = new JTextField(5);
        bonus = new JTextField(5);

        trenutnoUNovcaniku.setText(String.valueOf(PocetnaStr.getNoviKorisnik().getNovacNaRacunuGlavnaIgra()));


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

    /**
     * Postavljamo nas listener.
     * @param GListener
     *      Postavljamo listener iz Glavne Igre.
     */
    public void setGListener(GlavnaIgraListener GListener) {
        GlavnaIgraDown.GListener = GListener;
    }

    /**
     * Dodavamo action listener za nase botune.
     */
    private void activateGlIgraDown(){
        bonusIgra.addActionListener(this);
        ulog.addActionListener(this);
        igraj.addActionListener(this);
        odustani.addActionListener(this);
        turnir.addActionListener(this);
    }

    /**
     * Daje Bonus igru.
     * Potrebno za pristup odredenim vrijednostima
     * @return
     */
    public static BonusIgra getBI() {
        return BI;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bonusIgra){
            BI = new BonusIgra();
        }

        if(e.getSource() == ulog){
            GListener.izracunajDobitak();
        }


        if(e.getSource() == igraj){
            int stanje = GlavnaIgra.UGLI.trenutnoStanjeNaRacunu-GlavnaIgra.UGLI.manje;
            GListener.setTrenutnoStanjeNaRacunu(stanje);
            trenutnoUNovcaniku.setText(String.valueOf(GlavnaIgra.UGLI.trenutnoStanjeNaRacunu));

            GListener.novaUtak();
            GlavnaIgra_UP.ispisKvote.setText("");
            GlavnaIgraDown.igraj.setEnabled(false);
            bonusIgra.setEnabled(false);
            ulog.setEnabled(false);
            odustani.setEnabled(true);
        }

        if(e.getSource() == odustani){
            ArrayList<Korisnik> korisnici = PocetnaStr.getKorisniciIZF();
            Korisnik korisnik = PocetnaStr.getNoviKorisnik();
            korisnik.setNovacNaRacunuGlavnaIgra(GlavnaIgra.UGLI.trenutnoStanjeNaRacunu);
            if(korisnici.contains(korisnik)){
                for(int k = 0; k < korisnici.size(); k++){
                    if(korisnici.get(k) == korisnik){
                        korisnici.get(k).setNovacNaRacunuGlavnaIgra(korisnik.getNovacNaRacunuGlavnaIgra());
                    }
                }
            } else {
                korisnici.add(korisnik);
            }
            CitanjeFilea.saveKorisnici(korisnici);
            PocetnaStr.logIn.setEnabled(false);

            UvodnaStrana.turnir.setEnabled(false);
            CitanjeFilea.saveKorisnici(korisnici);
            JFrame osvojeno = new JFrame();
            JOptionPane.showMessageDialog(osvojeno, "Prekinuli steIgru Pokupite Nagradu: "+GlavnaIgra.UGLI.trenutnoStanjeNaRacunu);
            GlavnaIgra GI = UvodnaStrana.getGI();
            GI.dispose();

        }

        if(e.getSource() == turnir){
            Turnament turnament = new Turnament();
        }


    }
}
