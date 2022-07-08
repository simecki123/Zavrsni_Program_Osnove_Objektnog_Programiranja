package com.ZavrsniProgram_OOP;

import java.io.*;
import java.util.ArrayList;

/**
 * Nasa klasa za citanje objekata iz bin filea i upisivanje objekata u bin file
 * @author Sime Roncevic
 * @since srpanj 2022
 */


public class CitanjeFilea implements Serializable{


    /**
     * Ova metoda izcitava objekte, u ovom slucaju korisnike iz bin filea
     * @return
     *          Vraca listu izcitanih korisnika
     */
    public static ArrayList<Korisnik> loadKorisnici(){
        String fileName = "C:\\Users\\simer\\Documents\\OsnoveObjektnogProgramiranja_ZavrsniRad\\ZavrsniProgram\\src\\com\\ZavrsniProgram_OOP\\Rekordi.bin";

        ArrayList<Korisnik> korisniciIzF = new ArrayList<>();
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            String line;
            Korisnik korisnikIZFIlea = null;


            while((line = br.readLine()) != null){
                korisnikIZFIlea = (Korisnik) in.readObject();

                korisniciIzF.add(korisnikIZFIlea);

            }
            in.close();
            file.close();


            return korisniciIzF;
        } catch (FileNotFoundException e) {
            // prozor
        } catch (IOException e) {
            // prozor
        } catch (ClassNotFoundException e) {
            // prozor
        }

        System.out.println("Your file is empty... ");
        return korisniciIzF;


    }


    /**
     * Ova metoda sprema objekte.
     * Spremamo korinike u bin file
     * @param korisnici
     *      Ulazna lista predstavlja listu objekata odnosno korisnika koje zelimo unijeti u bin file
     */
    public static void saveKorisnici(ArrayList<Korisnik> korisnici){
        String fileName = "C:\\Users\\simer\\Documents\\OsnoveObjektnogProgramiranja_ZavrsniRad\\ZavrsniProgram\\src\\com\\ZavrsniProgram_OOP\\Rekordi.bin";

        try{
            if(! fileExists(fileName)){
                File f = new File(fileName);
            }else{
                File f = new File(fileName);
            }

            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);


            for (Korisnik korisnik : korisnici){
                out.writeObject(korisnik);

            }

            out.close();
            file.close();
            System.out.println("korisnik spremljen");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * Provjerava postojanje nasih filova
     * @param fileName
     * @return
     * @throws IOException
     */
    public static boolean fileExists(String fileName) throws IOException {
        File f = new File(fileName);
        if (f.exists()){
            System.out.println("Your file  exists...");
            return true;
        } else{
            f.createNewFile();
            System.out.println("Your file didnt exist but now it is created");
            return false;
        }
    }



}
