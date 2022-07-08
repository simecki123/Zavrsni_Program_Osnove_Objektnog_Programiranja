package com.ZavrsniProgram_OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Nasa klasa koja pokrece bonus igru
 * @author Sime Roncevic
 * @since srpanj 2022
 */

public class BonusIgra extends JFrame {
    /**
     * Sprema nase klubove kao kljuceve i njihove kvote kao vrijednosti.
     */
    private HashMap<String, Integer> kluboviIKvote = new HashMap<>();

    /**
     * Sprema nas ulog.
     */
    private int nvrijednostUloga;

    /**
     * JComboBox koji nam omogucuje da odaberemo naseg favorita.
     */
    public static JComboBox<String> birajPob;

    /**
     * JComboBox koji nam omogucuje da odaberemo nas ulog.
     */
    private JComboBox<String> mojUlog;

    /**
     * TextField koji sadrzi trenutno aktivnu kvotu.
     */
    private JTextField kvota;

    /**
     * TextField koji sadrzi trenutno aktivni potencijalni dobitak.
     */
    private JTextField potDob;

    /**
     * Botun koji predstavlja pristanak na odredenu odluku.
     * U ovom slucaju pristanak na zeljeni odabir pobjednika.
     */
    private JButton submit;

    /**
     * Odustajemo od igre.
     */
    private JButton cancle;

    public BonusIgra(){

        super("Bonus igra");
        setSize(700,550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        initComponents();
        layoutComponents();
        activateBonusGame();

    }

    private void initComponents(){

        generirajKvote();
        birajPob = new JComboBox<String>(GlavnaIgra.UGLI.listaKlubova);
        mojUlog = new JComboBox<String>(GlavnaIgra.UGLI.myBet);
        kvota = new JTextField(10);
        potDob = new JTextField(10);
        submit = new JButton("SUBMIT");
        cancle = new JButton("CANCLE");

        kvota.setEditable(false);
        potDob.setEditable(false);
        submit.setEnabled(false);


    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        add(new JLabel("      "),gbc);
        gbc.gridx++;

        add(new JLabel("      "),gbc);
        gbc.gridx++;

        add(new JLabel("Predvidite pobjednika:"),gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //--------------------------------------

        gbc.gridx++;
        gbc.gridx++;

        add(birajPob,gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //-------------------------------------
        add(new JLabel("    "),gbc);
        gbc.gridy++;
        //-------------------------------------

        add(new JLabel("Kvota:"),gbc);
        gbc.gridx++;

        add(kvota,gbc);
        gbc.gridx++;
        gbc.gridx++;

        add(potDob,gbc);
        gbc.gridx++;

        add(new JLabel("Potencijalni Dobitak"),gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        //------------------------------------
        add(new JLabel("     "),gbc);
        gbc.gridy++;
        //------------------------------------

        gbc.gridx++;
        gbc.gridx++;
        add(new JLabel("Ulog:"),gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        //-----------------------------------

        gbc.gridx++;
        gbc.gridx++;
        add(mojUlog,gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        //-----------------------------------
        add(new JLabel("     "),gbc);
        gbc.gridy++;
        //------------------------------------

        gbc.gridx++;
        add(submit,gbc);
        gbc.gridx++;
        gbc.gridx++;

        add(cancle,gbc);
    }

    /**
     * Metoda koja generira Mapu koja ce spremati naše klubove i njihove kvote.
     * Random poredani klubovi i njima pripadne random dane kvote.
     */
    private void generirajKvote(){
        String[] listaKlubova = GlavnaIgra.UGLI.listaKlubova;
        int vrijednostKvote;
        Random rand = new Random();

        for (int k = 0; k < listaKlubova.length; k++){
            vrijednostKvote = rand.nextInt(8,20);
            kluboviIKvote.put(listaKlubova[k], vrijednostKvote);
        }


    }

    /**
     * Metoda koja izracunava nas potencijalni dobitak.
     * Mnozi kvotu i ulozene novce.
     * Sluzi da mozemo vidjeti kolika bi igracu bila nagrada ako bi odigrao igru na taj nacin.
     */
    private void izrDobitak(){
        int brojPob = birajPob.getSelectedIndex();
        String pobjednik = GlavnaIgra.UGLI.listaKlubova[brojPob];
        int brojUloga = mojUlog.getSelectedIndex();
        int vr = Integer.parseInt(GlavnaIgra.UGLI.myBet[brojUloga]);

        if(vr >= (GlavnaIgra.UGLI.trenutnoStanjeNaRacunu)){
            submit.setEnabled(false);
            kvota.setText("");
            potDob.setText("");

        } else {
            submit.setEnabled(true);
            nvrijednostUloga = vr;

            for (Map.Entry<String, Integer> set : kluboviIKvote.entrySet()) {
                if (set.getKey().equals(pobjednik)) {
                    int dobitak = set.getValue() * nvrijednostUloga;
                    kvota.setText(String.valueOf(set.getValue()));
                    potDob.setText(String.valueOf(dobitak));




                }

            }
        }

    }

    /**
     * Aktiviramo action listener za pojedini botun ili JComboBox.
     */
    private void activateBonusGame(){
        cancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== cancle){
                    BonusIgra BI = GlavnaIgraDown.getBI();
                    BI.dispose();
                }
            }
        });

        birajPob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == birajPob){
                    int indx = birajPob.getSelectedIndex();
                    GlavnaIgra.UGLI.bonusOdabir = GlavnaIgra.UGLI.listaKlubova[indx];
                    izrDobitak();
                }
            }
        });

        mojUlog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submit.setEnabled(true);
                if(e.getSource() == mojUlog){
                    izrDobitak();
                }
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == submit){
                    GlavnaIgraDown.bonusIgra.setEnabled(false);

                    GlavnaIgra.UGLI.setTrenutnoStanjeNaRacunu(GlavnaIgra.UGLI.trenutnoStanjeNaRacunu-nvrijednostUloga);
                    String dobiveno = potDob.getText();

                    GlavnaIgraDown.bonus.setText(dobiveno);


                    GlavnaIgraDown.trenutnoUNovcaniku.setText(String.valueOf(GlavnaIgra.UGLI.trenutnoStanjeNaRacunu));

                    BonusIgra BI = GlavnaIgraDown.getBI();
                    BI.dispose();
                }
            }
        });


    }
}
