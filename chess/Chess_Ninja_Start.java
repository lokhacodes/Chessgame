package com.chess;

import com.chess.gui.Main;
import com.chess.gui.Table;
import net.miginfocom.swing.MigLayout;

public class Chess_Ninja_Start {

    public static void main(final String[] args) throws Exception {
        Table.get().show();
        
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
                
            }
        });
    }
}
