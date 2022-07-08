package com.ZavrsniProgram_OOP;

import java.io.Serializable;

/**
 * Korisnik predstavlja igraca.
 * @author Sime Roncevic
 * @since srpanj 2022
 */

public class Korisnik implements Serializable {
    /**
     * Ime naseg korisnika.
     */
    private String ime;

    /**
     * Prezime naseg korisnika.
     */
    private String prezime;

    /**
     * Novac na racunu koji ima za glavnu igru odnosno turnir.
     */
    private int novacNaRacunuGlavnaIgra = 10;

    /**
     * Novac koji ima za ligu.
     */
    private int novacNaRacunuLiga = 10;

    public Korisnik(String ime, String prezime){
        this.ime = ime;
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "ime='" + ime + '\'' +
                ", id='" + prezime + '\'' +
                ", novacNaRacunuGlavnaIgra=" + novacNaRacunuGlavnaIgra +
                ", novacNaRacunuLiga=" + novacNaRacunuLiga +
                '}';
    }

    /**
     * Postavlja novac na racun korisnika
     * @param novacNaRacunuGlavnaIgra
     *      postavlja novac na korisnikov racun
     */
    public void setNovacNaRacunuGlavnaIgra(int novacNaRacunuGlavnaIgra) {
        this.novacNaRacunuGlavnaIgra = novacNaRacunuGlavnaIgra;
    }

    /**
     * Klasicin getter
     * @return
     *      vraca novac korisnika
     */
    public int getNovacNaRacunuGlavnaIgra() {
        return novacNaRacunuGlavnaIgra;
    }

    /**
     * Postavlja novac na racun korisnika
     * @param novacNaRacunuLiga
     *      postavlja novac na korisnikov racun
     */
    public void setNovacNaRacunuLiga(int novacNaRacunuLiga) {
        this.novacNaRacunuLiga = novacNaRacunuLiga;
    }

    /**
     * Klasicin getter
     * @return
     *      vraca novac korisnika
     */
    public int getNovacNaRacunuLiga() {
        return novacNaRacunuLiga;
    }
}
