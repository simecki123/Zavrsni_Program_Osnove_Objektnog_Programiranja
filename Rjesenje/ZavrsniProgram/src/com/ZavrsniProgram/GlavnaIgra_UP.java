package com.ZavrsniProgram;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Klasa koja cini gornji dio nase GUI-a Glavne igre
 * @author Sime Roncevic
 */

public class GlavnaIgra_UP extends JPanel{
    public static JButton klub1;

    public static JButton klub2;
    public static JTextField ispisKvote;
    public static JTextField ime1Kluba;
    public static JTextField ime2Kluba;

    /**
     * pogadamo klub1
     */
    public static boolean pogodiKL1 = false;
    /**
     * pogadamo klub2
     */
    public static boolean isPogodiKL2 = false;



    public GlavnaIgra_UP(){
        Dimension dim = getPreferredSize();
        dim.height = 150;
        setPreferredSize(dim);

        innitComponents();
        layoutComponents();
        setBorders();
        activateGlavnaIUPP();
    }



    private void innitComponents(){
        klub1 = new JButton("1");

        klub2 = new JButton("2");
        ispisKvote = new JTextField(4);

        ime1Kluba = new JTextField(10);
        ime2Kluba = new JTextField(10);

        ispisKvote.setEditable(false);
        ime1Kluba.setEditable(false);
        ime2Kluba.setEditable(false);




    }

    private void setBorders() {
        Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border inner = BorderFactory.createTitledBorder("Main Game");

        Border border = BorderFactory.createCompoundBorder(outer, inner);
        setBorder(border);
    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.WEST;

        add(ime1Kluba, gbc);
        gbc.gridx++;

        add(new JLabel(" "),gbc);
        gbc.gridx++;


        gbc.gridx++;

        add(new JLabel("                   "),gbc);
        gbc.gridx++;

        add(ime2Kluba,gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        add(klub1,gbc);
        gbc.gridx++;

        add(new JLabel("    "),gbc);
        gbc.gridx++;


        gbc.gridx++;

        add(new JLabel("         "),gbc);
        gbc.gridx++;

        add(klub2, gbc);
        gbc.gridx = 0;

        gbc.gridy++;
        add(new JLabel("  "),gbc);
        gbc.gridy++;

        add(new JLabel("  "),gbc);
        gbc.gridx++;

        add(new JLabel("    "),gbc);
        gbc.gridx++;

        add(ispisKvote,gbc);



    }

    private void activateGlavnaIUPP(){
        klub1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pogodiKL1 =true;
                isPogodiKL2 = false;
                if(e.getSource() == klub1){

                    GlavnaIgraDown.ulog.setEnabled(true);
                    HashMap<String, Integer> kluboviIKvote = GlavnaIgra.kluboviIKvote;

                    for(Map.Entry<String, Integer> set : kluboviIKvote.entrySet()){
                        int vr = set.getValue();
                        String klub = set.getKey();
                        if(ime1Kluba.getText().equals(klub)){
                            ispisKvote.setText(String.valueOf(vr));
                        }
                    }
                    GlavnaIgra.izracunajDobitak();


                }
            }

        });

        klub2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == klub2){
                    pogodiKL1 = false;
                    isPogodiKL2 = true;
                    GlavnaIgraDown.ulog.setEnabled(true);
                    HashMap<String, Integer> kluboviIKvote = GlavnaIgra.kluboviIKvote;

                    for(Map.Entry<String, Integer> set : kluboviIKvote.entrySet()){
                        int vr = set.getValue();
                        String klub = set.getKey();
                        if(ime2Kluba.getText().equals(klub)){
                            ispisKvote.setText(String.valueOf(vr));
                        }
                    }
                    GlavnaIgra.izracunajDobitak();

                }
            }

        });


    }

    /**
     * Dobivamo zeljenu kvotu
     * @return
     */
    public JTextField getIspisKvote() {
        return ispisKvote;
    }

    /**
     * Dobivamo ime zeljenog kluba
     * @return
     */
    public JTextField getIme1Kluba() {
        return ime1Kluba;
    }

    /**
     * Dobivamo ime zeljenog kluba
     * @return
     */
    public JTextField getIme2Kluba() {
        return ime2Kluba;
    }


}
