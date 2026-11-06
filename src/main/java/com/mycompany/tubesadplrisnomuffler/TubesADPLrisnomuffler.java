package com.mycompany.tubesadplrisnomuffler;

import com.mycompany.tubesadplrisnomuffler.view.MainMenuFrame;

public class TubesADPLrisnomuffler {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            MainMenuFrame menu = new MainMenuFrame();
            menu.setVisible(true);
        });
    }
}
