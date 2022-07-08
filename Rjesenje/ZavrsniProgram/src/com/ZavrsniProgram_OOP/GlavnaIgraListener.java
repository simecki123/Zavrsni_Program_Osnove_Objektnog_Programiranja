package com.ZavrsniProgram_OOP;

import java.util.ArrayList;

/**
 * Ovo je interface koji predstavlja nas listener.
 * Posjeduje odredene metode koje se ostvaruju kada se dogodi neki dogadaj.
 * @author Sime Roncevic
 * @since srpanj 2022
 */

public interface GlavnaIgraListener {
    /**
     * Metoda koja ce nam pokrenuti prvi korak u nasoj igri. Ona ce pokrenuti prvi korak.
     * Sastoji se od 2 dodatne metode koje postavljaju pocetne uvjete za pokretanje.
     * Postavit ce pocetne klubove na koje se mozemo kladiti.
     * Mijesa dane klubove, i postavlja kvote.
     * Takoder postavlja prva dva kluba tako da mozemo zapoceti igru.
     */
    public void pokreniIgruUPozadini();

    /**
     * Metoda koja se pokrece kada se klikne "IGRAJ".
     * Svaki put kad se taj botun pokrene ova metoda ce realizirati novi stupanj igre i tako sve do kraja(odredenog uvjeta).
     * Prvi svakom pokretanju pokrece metodu koja provjerava da li mora doci do prekida igre.
     * Provjerava jesmo li pogodili u kladenju.
     * Igra prelazi u novu fazu.
     */
    public void novaUtak();

    /**
     * Metoda koja ce iracunati nas potencijalni dobitak.
     * Zabiljezi nas ulog te blokira igru ako je veci od dopustenog.
     */
    public void izracunajDobitak();

    /**
     * Klasicni geter.
     * @return
     *      Vraca Listu koja sadrzi 1. kolo nase igre.
     *      Sluzi za klasu turnir.
     */
    public ArrayList<String> getKolo1();

    /**
     * Klasicni geter.
     * @return
     *      Vraca Listu koja sadrzi 2. kolo nase igre.
     *      Sluzi za klasu turnir.
     */
    public ArrayList<String> getKolo2();

    /**
     * Klasicni geter.
     * @return
     *      Vraca Listu koja sadrzi 3. kolo nase igre.
     *      Sluzi za klasu turnir.
     */
    public ArrayList<String> getKolo3();

    /**
     * Klasicni geter.
     * @return
     *      Vraca pobjednika naseg turnira.
     *      Sluzi za klasu turnir.
     */
    public String getPobjednik();

    /**
     * Updatea nas racun s dobitcima.
     * @param trnutnoStanjeNaRacunu
     *      postavlja novi racun.
     */
    public void setTrenutnoStanjeNaRacunu(int trnutnoStanjeNaRacunu);

}
