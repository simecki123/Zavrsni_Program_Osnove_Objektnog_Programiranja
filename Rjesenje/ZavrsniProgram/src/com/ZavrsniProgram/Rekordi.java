package com.ZavrsniProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Rekordi prikazuju nase korisnike i njihove dobitke
 * @author Sime Roncevic
 */

public class Rekordi extends JFrame {


    public ArrayList<Korisnik> korisniciIZF;
    private JTextArea TA;
    private JScrollPane SB;
    private JButton cancle;

    public Rekordi(){
        super("Rekordi");

        setSize(700,550);
        dispose();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        korisniciIZF = PocetnaStr.getKorisniciIZF();

        initComponents();
        layoutAll();
        butnCancle();


    }

    private void initComponents() {
        TA = new JTextArea(400,600);
        unesiTekst();
        SB = new JScrollPane(TA);
        cancle = new JButton("Cancle");
    }

    private void layoutAll(){
        setLayout(new BorderLayout());
        add(SB, BorderLayout.CENTER);
        add(cancle, BorderLayout.SOUTH);
    }

    private void butnCancle() {
        cancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == cancle){
                    dispose();

                }
            }
        });
    }

    /**
     * Unose tekst u nas TextArea
     */
    private void unesiTekst(){

        for(Korisnik korisnik : korisniciIZF){
            TA.append(korisnik.toString() + "\n");
            System.out.println(korisnik);
        }

    }



}
