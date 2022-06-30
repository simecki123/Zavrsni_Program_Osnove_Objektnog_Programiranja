package com.ZavrsniProgram;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Random;

/**
 * Glavna klasa za realizaciju nase igre.
 * Predstavlja pocetni ekran nase igre.
 * @author Sime Roncevic
 *
 */

public class GlavnaIgra extends JFrame {
    public static final String[] listaKlubova = {"Real Madrid","Bayern Muinchen","Hajduk","Manchester United","Liverpool","Juventus","Chelsea","Barcelona"};

    /**
     * Klubovi kvote cuva nase klubove kao kljuceve i njihove kvote kao vrijednosti
     */
    public static HashMap<String, Integer> kluboviIKvote;

    public static ArrayList<String> pomisaniKlubovi = new ArrayList<>();

    /**
     * Sprema odredeno kolo za prikaz turnira u drugoj klasi
     */
    public static ArrayList<String> kolo1 = new ArrayList<>();

    /**
     * Sprema odredeno kolo za prikaz turnira u drugoj klasi
     */
    public static ArrayList<String> kolo2 = new ArrayList<>();

    /**
     * Sprema odredeno kolo za prikaz turnira u drugoj klasi
     */
    public static ArrayList<String> kolo3 = new ArrayList<>();

    /**
     * Sprema pobjednika za prikaz turnira u drugoj klasi
     */
    public static String pobjednik;

    public static final String[] myBet = {"1","5","10","50","100"};

    /**
     * novaListaNK nam sluzi za generiranje novog kola
     */
    private static ArrayList<String> novaListaNK = new ArrayList<>();

    /**
     * k predstavlja index koji nam omogucava inicijaliziranje odredene vrijednosti iz liste.
     * Nakon sto stekne odredenu duljinu resetira se
     */
    public int k = 0;

    /**
     * Nas odabir pobjednika iz bonus igre
     */
    public static String bonusOdabir;

    /**
     * manje sprema nas gubitak odnosno ulozeno
     */
    public static int manje = 0;

    /**
     * pogodak odreduje jesmo li pogodili pobjednika jedne igre u smislu:
     *      true = klub1
     *      false = klub2
     */



    public static int trenutnoStanjeNaRacunu = 10;
    private static GlavnaIgra_UP GU;
    private static GlavnaIgraDown GD;




    public GlavnaIgra(){
        super("PŠK-Prva Šimina Kladionica");
        setSize(700,550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        initComponents();
        layoutAll();
        pokreniIgruUPozadini();


    }



    private void initComponents(){

        GU = new GlavnaIgra_UP();
        GD = new GlavnaIgraDown();

    }

    private void layoutAll(){
        setLayout(new BorderLayout());
        add(GU, BorderLayout.NORTH);
        add(GD, BorderLayout.CENTER);

    }


    /**
     * Metoda koja ce nam pokrenuti prvi korak u nasoj igri. Ona ce pokrenuti prvi korak
     * Sastoji se od 2 dodatne metode koje postavljaju pocetne uvjete za pokretanje
     */
    private void pokreniIgruUPozadini(){
        pomjesajKlubove();
        if(pomisaniKlubovi.size() == 8){
            kolo1 = pomisaniKlubovi;
        }
        getSveKvote();


        GU.getIme1Kluba().setText(pomisaniKlubovi.get(k));
        GU.getIme2Kluba().setText(pomisaniKlubovi.get(k+1));

    }

    /**
     * Metoda koja sprema nase klubove kao kljuceve i njihove kvote
     */
    private void getSveKvote(){
        kluboviIKvote = new HashMap<>();
        Random random = new Random();
        int k = 0;

        while(k < pomisaniKlubovi.size()){
            int vrijednost = random.nextInt(1,9);
            if (! (kluboviIKvote.containsValue(vrijednost))) {
                kluboviIKvote.put(pomisaniKlubovi.get(k), vrijednost);
                k++;
            }
        }
    }


    /**
     * Metoda koja ce nam dati random parove
     */
    private void pomjesajKlubove(){
        Random random = new Random();

        while(true){
            int randKlub = random.nextInt(0,listaKlubova.length);
            String noviKlub = listaKlubova[randKlub];

            if(! (pomisaniKlubovi.contains(noviKlub))){
                pomisaniKlubovi.add(noviKlub);
            }
            if(pomisaniKlubovi.size() == listaKlubova.length){
                break;
            }
        }

    }
    //---------------------------------------------------------------

    /**
     * Metoda koja se vrti svakim pritiskom na odredeni botun. Srce nase igrice
     */
    public void novaUtak(){
        provjeriZaGasiti();

        if(pomisaniKlubovi.size() == 4){
            kolo2 = pomisaniKlubovi;

        }
        if (pomisaniKlubovi.size() == 2){
            kolo3 = pomisaniKlubovi;

        }

        jesamLiPogodio();

        prijelazIgre();




    }

    /**
     * Metoda koja provjerava da li je naš klub u jednoj igri pobjedio
     */
    private void jesamLiPogodio(){
        Random random = new Random();

        int vrijednost = random.nextInt(1,3);
        if(vrijednost == 1){
            if (GlavnaIgra_UP.pogodiKL1){
                int dobitak = Integer.parseInt(GlavnaIgraDown.potencijalniDobitak.getText());
                trenutnoStanjeNaRacunu = trenutnoStanjeNaRacunu +dobitak;
                GlavnaIgraDown.trenutnoUNovcaniku.setText(String.valueOf(trenutnoStanjeNaRacunu));

            }
            novaListaNK.add(GU.getIme1Kluba().getText());

        } else{
            if (GlavnaIgra_UP.isPogodiKL2){
                int dobitak = Integer.parseInt(GlavnaIgraDown.potencijalniDobitak.getText());
                trenutnoStanjeNaRacunu = trenutnoStanjeNaRacunu + dobitak;
                GlavnaIgraDown.trenutnoUNovcaniku.setText(String.valueOf(trenutnoStanjeNaRacunu));
            }
            novaListaNK.add(GU.getIme2Kluba().getText());
        }
    }


    /**
     * Metoda koja provjerava da li je igra zavrsila
     */
    private void prijelazIgre(){

        if (k == pomisaniKlubovi.size()-2){
            pomisaniKlubovi = novaListaNK;
            novaListaNK = new ArrayList<>();
            k = 0;

            if(pomisaniKlubovi.size()==1){
                pobjednik = pomisaniKlubovi.get(0);

                jesmoLIdobiliBonus(pobjednik);
                GU.klub1.setEnabled(false);
                GU.klub2.setEnabled(false);
                GD.ulog.setEnabled(false);

                ArrayList<Korisnik> korisnici = PocetnaStr.getKorisniciIZF();
                Korisnik korisnik = PocetnaStr.getNoviKorisnik();
                korisnik.setNovacNaRacunu(trenutnoStanjeNaRacunu);
                korisnici.add(korisnik);
                CitanjeFilea.saveKorisnici(korisnici);

                JFrame prekid = new JFrame();
                JOptionPane.showMessageDialog(prekid, "Igra je zavrsena vasa zarada je "+ trenutnoStanjeNaRacunu+"\n Pobjednik turnira je " + pobjednik);

            }else {
                GU.getIme1Kluba().setText(pomisaniKlubovi.get(k));
                GU.getIme2Kluba().setText(pomisaniKlubovi.get(k + 1));
            }




        } else{
            k = k+2;
            GU.getIme1Kluba().setText(pomisaniKlubovi.get(k));
            GU.getIme2Kluba().setText(pomisaniKlubovi.get(k+1));

        }
    }


    /**
     * Metoda koja provjerava da li je korisnikovo pogađanje iz bonus igre tocno
     * @param pobjednik
     */
    private void jesmoLIdobiliBonus(String pobjednik){

        if (pobjednik.equals(bonusOdabir)){
            int bon = Integer.parseInt(GD.bonus.getText());
            trenutnoStanjeNaRacunu = trenutnoStanjeNaRacunu + bon;
        }
    }

    /**
     * Metoda koja provjerava da li je korisnik potrosio sve novce na racunu
     */
    public static void provjeriZaGasiti(){
        if(trenutnoStanjeNaRacunu <= 0){
            JFrame kraj = new JFrame();
            JOptionPane.showMessageDialog(kraj, "Potrošili ste sve novce- GameOver");
            GlavnaIgra GI = PocetnaStr.getGI();
            GI.dispose();

        }
    }

    /**
     * Metoda koja ce iracunati nas dobitak, te blokirati daljnju igru ukoliko je moj ulog veci od dopustenog
     */
    public static void izracunajDobitak(){
        int brojUloga = GD.ulog.getSelectedIndex();


        int vr = Integer.parseInt(GlavnaIgra.myBet[brojUloga]);

        GD.igraj.setEnabled(true);
        if(vr >= GlavnaIgra.trenutnoStanjeNaRacunu) {
            GD.igraj.setEnabled(false);



        } else{
            GD.igraj.setEnabled(true);
            int novaVrUloga = Integer.parseInt(myBet[brojUloga]);
            int dobitak = Integer.parseInt(GU.getIspisKvote().getText());
            dobitak = dobitak * novaVrUloga;
            GD.potencijalniDobitak.setText(String.valueOf(dobitak));
            manje = vr;
        }



    }

    /**
     * Getter za kolo1. Sluzi nam za klasu Turnament
     * @return
     */
    public static ArrayList<String> getKolo1() {
        return kolo1;
    }

    /**
     * Getter za kolo2. Sluzi nam za klasu Turnament
     * @return
     */
    public static ArrayList<String> getKolo2() {
        return kolo2;
    }

    /**
     * Getter za kolo3. Sluzi nam za klasu Turnament
     * @return
     */
    public static ArrayList<String> getKolo3() {
        return kolo3;
    }

    /**
     * Daje pobjednika klasi Turnament
     * @return
     */
    public static String getPobjednik() {
        return pobjednik;
    }

    /**
     * Postavlja novac na nas racun
     * @param trenutnoStanjeNaRacunu
     */
    public static void setTrenutnoStanjeNaRacunu(int trenutnoStanjeNaRacunu) {
        GlavnaIgra.trenutnoStanjeNaRacunu = trenutnoStanjeNaRacunu;
    }
}
