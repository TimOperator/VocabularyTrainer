/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hamp_it.vocabularytrainer;

import java.util.ResourceBundle;
import javax.swing.UIManager;

/**
 *
 * @author Tim
 */
public class VocabularyTrainer {

    private static final ResourceBundle MESSAGE_STRINGS = ResourceBundle.getBundle("messages");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(MESSAGE_STRINGS.getString("no_system_layout"));
        }
        String dictionaryFile = "de-en.txt";
        if (args.length >= 1) {
            System.out.println(MESSAGE_STRINGS.getString("use_default_dictionary"));
            dictionaryFile = args[0];
        }
        MainWindow mw = new MainWindow(dictionaryFile);
        mw.setLocationRelativeTo(null);
        mw.setVisible(true);
    }
    
}
