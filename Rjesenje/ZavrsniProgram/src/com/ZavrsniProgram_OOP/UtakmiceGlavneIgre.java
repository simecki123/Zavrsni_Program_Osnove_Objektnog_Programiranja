package com.ZavrsniProgram_OOP;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Klasa koja cuva podatke o pojedinoj igri odnosno natjecanju.
 * Updatea podatke ovisno o rezultatima korisnikovog kladanja.
 * @author Sime Roncevic
 * @since srpanj 2022
 */

public class UtakmiceGlavneIgre {
    /**
     * Sadrzi sve klubove koji ce se koristiti u igri.
     */
    public static final String[] listaKlubova = {"Real Madrid","Bayern Muinchen","Hajduk","Manchester United","Liverpool","Juventus","Chelsea","Barcelona"};

    /**
     * Klubovi kvote cuva nase klubove kao kljuceve i njihove kvote kao vrijednosti.
     */
    public static HashMap<String, Integer> kluboviIKvote;

    /**
     * U ovu listu ce mo spremiti nase klubove u pomjesanom nizu tako da svaki put kada pokrenemo igru imamo drugaciju situaciju turnira.
     */
    public static ArrayList<String> pomisaniKlubovi = new ArrayList<>();

    /**
     * Sprema odredeno kolo za prikaz turnira u klasi "Turnir".
     */
    public static ArrayList<String> kolo1 = new ArrayList<>();

    /**
     * Sprema odredeno kolo za prikaz turnira u klasi "Turnir".
     */
    public static ArrayList<String> kolo2 = new ArrayList<>();

    /**
     * Sprema odredeno kolo za prikaz turnira u klasi "Turnir".
     */
    public static ArrayList<String> kolo3 = new ArrayList<>();

    /**
     * Sprema pobjednika za prikaz turnira u klasi "Turnir", te za opcenito prikaz pobjednika
     */
    public static String pobjednik;

    /**
     * Prikazuje sve uloge koje mozemo imati.
     */
    public static final String[] myBet = {"1","5","10","50","100"};

    /**
     * novaListaNK nam sluzi za generiranje novog kola.
     * Svako kolo duljina liste se smanji, a ova lista ce nam omoguciti spremanje pobjednika svake utakmice, te će se ti podaci koristiti za drugo kolo.
     */
    private static ArrayList<String> novaListaNK = new ArrayList<>();

    /**
     * k predstavlja index koji nam omogucava inicijaliziranje odredene vrijednosti iz liste.
     * Nakon sto stekne odredenu duljinu resetira se.
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
     * Prikazuje stanje naseg racuna.
     */
    public static int trenutnoStanjeNaRacunu = PocetnaStr.getNoviKorisnik().getNovacNaRacunuGlavnaIgra();

    /**
     * Jedan od Panela nase igre
     */
    private static GlavnaIgra_UP GU;

    /**
     * Jedan od Panela nase igre
     */
    private static GlavnaIgraDown GD;

    /**
     * realiziramo zeljene panele koje zelimo iskoristiti
     * To su isti oni paneli iz nase igre
     */
    public UtakmiceGlavneIgre(){
        GU = GlavnaIgra.getGU();
        GD = GlavnaIgra.getGD();
    }

    /**
     * Metoda koja ce nam pokrenuti prvi korak u nasoj igri. Ona ce pokrenuti prvi korak.
     * Sastoji se od 2 dodatne metode koje postavljaju pocetne uvjete za pokretanje.
     * Postavit ce pocetne klubove na koje se mozemo kladiti.
     * Mijesa dane klubove, i postavlja kvote.
     * Takoder postavlja prva dva kluba tako da mozemo zapoceti igru.
     */
    public void pokreniIgruUPozadini(){
        pomjesajKlubove();
        if(pomisaniKlubovi.size() == 8){
            kolo1 = pomisaniKlubovi;
        }
        getSveKvote();


        GU.getIme1Kluba().setText(pomisaniKlubovi.get(k));
        GU.getIme2Kluba().setText(pomisaniKlubovi.get(k+1));

    }

    /**
     * Metoda koja sprema nase klubove kao kljuceve i njima pripadne kvote.
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
     * Metoda koja ce pomijesati nase klubove tako da svaki put kad odigramo igru imamo razlicite utakmice.
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
     * Metoda koja se pokrece kada se klikne "IGRAJ".
     * Svaki put kad se taj botun pokrene ova metoda ce realizirati novi stupanj igre i tako sve do kraja(odredenog uvjeta).
     * Prvi svakom pokretanju pokrece metodu koja provjerava da li mora doci do prekida igre.
     * Provjerava jesmo li pogodili u kladenju.
     * Igra prelazi u novu fazu.
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
     * Metoda koja provjerava da li smo pogodili da ce odredeni klub pobijediti u utakmici, te ce nam ovisno o tome dati nagradu.
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
     * Provjerava do kojeg smo stupnja dosli, biljezi u kojem smo kolu i pomocu ove metode spremamo pobjednike svakog kola.
     * Pripremamo listu pobjednika kola za novo kolo i tako sve do kraja igre.
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
                korisnik.setNovacNaRacunuGlavnaIgra(trenutnoStanjeNaRacunu);

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
            GlavnaIgra GI = UvodnaStrana.getGI();
            GI.dispose();

        }
    }

    /**
     * Metoda koja ce iracunati nas potencijalni dobitak.
     * Zabiljezi nas ulog te blokira igru ako je veci od dopustenog.
     */
    public void izracunajDobitak(){
        int brojUloga = GD.ulog.getSelectedIndex();


        int vr = Integer.parseInt(myBet[brojUloga]);

        GD.igraj.setEnabled(true);
        if(vr >= trenutnoStanjeNaRacunu) {
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
     *      vraca listu za kolo1
     */
    public static ArrayList<String> getKolo1() {
        return kolo1;
    }

    /**
     * Getter za kolo2. Sluzi nam za klasu Turnament
     * @return
     *      vraca listu za kolo1
     */
    public static ArrayList<String> getKolo2() {
        return kolo2;
    }

    /**
     * Getter za kolo3. Sluzi nam za klasu Turnament
     * @return
     *      vraca listu za kolo3
     */
    public static ArrayList<String> getKolo3() {
        return kolo3;
    }

    /**
     * Daje pobjednika klasi Turnament
     * @return
     *      vraca pobjednika turnira.
     */
    public static String getPobjednik() {
        return pobjednik;
    }

    /**
     * Postavlja novac na nas racun
     * @param trenutnoStanjeNaRacunu
     *      postavlja novo stanje na racunu iz druge klase.
     */
    public void setTrenutnoStanjeNaRacunu(int trenutnoStanjeNaRacunu) {
        trenutnoStanjeNaRacunu = trenutnoStanjeNaRacunu;
    }
}
