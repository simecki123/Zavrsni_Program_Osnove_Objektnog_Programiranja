package com.ZavrsniProgram;

import java.io.Serializable;

/**
 * Korisnik predstavlja igraca
 * @author Sime Roncevic
 */

public class Korisnik implements Serializable {
    private String ime;
    private String id;
    private int novacNaRacunu = 10;

    public Korisnik(String ime, String id){
        this.ime = ime;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "ime='" + ime + '\'' +
                ", id='" + id + '\'' +
                ", novacNaRacunu=" + novacNaRacunu +
                '}';
    }


    /**
     * Postavlja novac na racun korisnika
     * @param novacNaRacunu
     */
    public void setNovacNaRacunu(int novacNaRacunu) {
        this.novacNaRacunu = novacNaRacunu;
    }
}
