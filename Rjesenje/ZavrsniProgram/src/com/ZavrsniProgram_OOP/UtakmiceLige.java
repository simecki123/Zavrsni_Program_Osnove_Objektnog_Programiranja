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

public class UtakmiceLige {

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
     * Prikazuje sve uloge koje mozemo imati.
     */
    public static final String[] myBet = {"1","5","10","50","100"};

    /**
     * k predstavlja index koji nam omogucava inicijaliziranje odredene vrijednosti iz liste.
     * Nakon sto stekne odredenu duljinu resetira se.
     */
    public static int k = 0;

    /**
     * manje sprema nas gubitak odnosno ulozeno.
     */
    public static int manje = 0;

    /**
     * Prikazuje stanje naseg racuna.
     */
    public static int trenutnoStanjeNaRacunu = PocetnaStr.getNoviKorisnik().getNovacNaRacunuLiga();

    /**
     * pogadanje predstavlja spremanje nase odluke (na koga smo se odlucili kladiti).
     * 1 = klub1
     * 2 = izjednaceno
     * 3 = klub2
     */
    public static int pogadanje;

    /**
     * lista koja predstavlja nase kvote za slucaj kada korisnik odigra "X".
     */
    public static ArrayList<Integer> brojiIZjKvote = new ArrayList<>();

    /**
     * Broji clanove kvota za "brojiIZjKvote".
     */
    public static int brojiKvoteX = 0;

    /**
     * Jedan od Panela nase igre
     */
    private static Liga_UP LU;

    /**
     * Jedan od Panela nase igre
     */
    private static Liga_Down LD;

    /**
     * realiziramo zeljene panele koje zelimo iskoristiti
     * To su isti oni paneli iz nase igre
     */
    public UtakmiceLige(){
        LU = Liga.getLU();
        LD = Liga.getLD();
    }

    /**
     * Metoda koja ce nam pokrenuti prvi korak u nasoj igri. Ona ce pokrenuti prvi korak.
     * Sastoji se od 2 dodatne metode koje postavljaju pocetne uvjete za pokretanje.
     * Postavit ce pocetne klubove na koje se mozemo kladiti.
     */
    public void pokreniIgruUPozadini(){
        pomjesajKlubove();

        getSveKvote();

        LD.racun.setText(String.valueOf(trenutnoStanjeNaRacunu));
        LU.imeKL1.setText(pomisaniKlubovi.get(k));
        LU.imeKL2.setText(pomisaniKlubovi.get(k+1));

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

        while(brojiIZjKvote.size() < listaKlubova.length / 2){
            int randomKvota = random.nextInt(1,6);
            brojiIZjKvote.add(randomKvota);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * Metoda koja se pokrece kada se klikne "IGRAJ".
     * Svaki put kad se taj botun pokrene ova metoda ce realizirati novi stupanj igre i tako sve do kraja(odredenog uvjeta)
     */
    public void novaUtak(){
        LD.racun.setText(String.valueOf(trenutnoStanjeNaRacunu));
        provjeriZaGasiti();


        jesamLiPogodio();

        prijelazIgre();

    }

    /**
     * Metoda koja provjerava da li je korisnik potrosio sve novce na racunu
     */
    public static void provjeriZaGasiti(){
        if(trenutnoStanjeNaRacunu <= 0){
            JFrame kraj = new JFrame();
            JOptionPane.showMessageDialog(kraj, "Potrošili ste sve novce- GameOver");
            Liga li = UvodnaStrana.getLigaPr();
            li.dispose();

        }
    }

    /**
     * Metoda koja provjerava da li smo pogodili da ce odredeni klub pobijediti u utakmici, te ce nam ovisno o tome dati nagradu.
     */
    private static void jesamLiPogodio(){
        Random random = new Random();

        int vrijednost = random.nextInt(1,4);
        if(vrijednost == 1){
            if (pogadanje == 1){
                int dobitak = Integer.parseInt(LD.potencijalniDobitak.getText());
                trenutnoStanjeNaRacunu = trenutnoStanjeNaRacunu +dobitak;
                LD.racun.setText(String.valueOf(trenutnoStanjeNaRacunu));

            }

        } else if(vrijednost == 2){
            if (pogadanje == 2){
                int dobitak = Integer.parseInt(LD.potencijalniDobitak.getText());
                trenutnoStanjeNaRacunu = trenutnoStanjeNaRacunu + dobitak;
                LD.racun.setText(String.valueOf(trenutnoStanjeNaRacunu));
            }

        } else{
            if(pogadanje == 3) {
                int dobitak = Integer.parseInt(LD.potencijalniDobitak.getText());
                trenutnoStanjeNaRacunu = trenutnoStanjeNaRacunu + dobitak;
                LD.racun.setText(String.valueOf(trenutnoStanjeNaRacunu));
            }
        }
    }

    /**
     * Metoda koja provjerava da li je igra zavrsila
     * Provjerava do kojeg smo stupnja dosli, biljezi u kojem smo kolu i pomocu ove metode spremamo pobjednike svakog kola.
     * Pripremamo listu pobjednika kola za novo kolo i tako sve do kraja igre.
     */
    private static void prijelazIgre(){

        if (k == pomisaniKlubovi.size()-2){

            ArrayList<Korisnik> korisnici = PocetnaStr.getKorisniciIZF();
            Korisnik korisnik = PocetnaStr.getNoviKorisnik();
            korisnik.setNovacNaRacunuLiga(trenutnoStanjeNaRacunu);

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

            LD.igraj.setEnabled(false);
            LU.kl1.setEnabled(false);
            LU.kl2.setEnabled(false);
            LU.izjednaceno.setEnabled(false);

            JFrame prekid = new JFrame();
            JOptionPane.showMessageDialog(prekid, "Igra je zavrsena vasa zarada je "+ trenutnoStanjeNaRacunu);

        } else{
            k = k+2;
            LU.imeKL1.setText(pomisaniKlubovi.get(k));
            LU.imeKL2.setText(pomisaniKlubovi.get(k+1));

        }
    }

    /**
     * Metoda koja ce iracunati nas potencijalni dobitak.
     * Zabiljezi nas ulog te blokira igru ako je veci od dopustenog.
     */
    public void izracunajDobitak(){
        int brojUloga = LD.ulog.getSelectedIndex();


        int vr = Integer.parseInt(myBet[brojUloga]);

        LD.igraj.setEnabled(true);
        if(vr >= trenutnoStanjeNaRacunu) {
            LD.igraj.setEnabled(false);



        } else{
            LD.igraj.setEnabled(true);
            int novaVrUloga = Integer.parseInt(myBet[brojUloga]);
            int dobitak = Integer.parseInt(LU.kvota.getText());
            dobitak = dobitak * novaVrUloga;
            LD.potencijalniDobitak.setText(String.valueOf(dobitak));
            manje = vr;
        }



    }

    /**
     * Klasicni geter
     * @return
     *      Vraca HashMapu  u kojoj s enalaze nasi klubovi kao kljucevi i nase kvote kao vrijednosti.
     */
    public static HashMap<String, Integer> getKluboviIKvote() {
        return kluboviIKvote;
    }


}
