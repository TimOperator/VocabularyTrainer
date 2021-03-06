/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hamp_it.vocabularytrainer;

import de.hamp_it.EasyuseServerConnector.MainServerConnector;
import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tim
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public MainWindow(String dictionaryFile) {
        initComponents();
        fullDictionaryFile = dictionaryFile;
        myDictionaryMap = new HashMap<>();
        myDictionaryKeys = new LinkedList<>();
        publicDictionary = new TreeMap<>();
        publicDictionaryKeys = new LinkedList<>();
        index = 0;
        myDictionaryTableModel = (DefaultTableModel) myDictionaryTable.getModel();
        loadFullDictionary(fullDictionaryFile);
        loadPrivateDictionary(myDictionaryFile);
        origLabel.setText(myDictionaryKeys.get(index));
        defaultButtonBackgroundColor = checkButton.getBackground();
        defaultFieldBackgroundColor = transTextField.getBackground();
        rd = new Random();
        rd.setSeed(System.currentTimeMillis());
        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent ce) {
                // TODO rescale
                mainSplitPane.setDividerLocation(0.55);
            }

            @Override
            public void componentMoved(ComponentEvent ce) {
                // Do nothing
            }

            @Override
            public void componentShown(ComponentEvent ce) {
                // Do nothing
            }

            @Override
            public void componentHidden(ComponentEvent ce) {
                // Do nothing
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        languageButtonGroup = new javax.swing.ButtonGroup();
        mainSplitPane = new javax.swing.JSplitPane();
        dictionaryPanel = new javax.swing.JPanel();
        enRadioButton = new javax.swing.JRadioButton();
        deRadioButton = new javax.swing.JRadioButton();
        inputTextField = new javax.swing.JTextField();
        translateButton = new javax.swing.JButton();
        translationLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        randomButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        bothRadioButton = new javax.swing.JRadioButton();
        updateCheckButton = new javax.swing.JButton();
        sideSplitPane2 = new javax.swing.JSplitPane();
        trainerPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        origLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        transTextField = new javax.swing.JTextField();
        transTextLabel = new javax.swing.JLabel();
        checkButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        myDictionaryPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myDictionaryTable = new javax.swing.JTable();
        deleteVocButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vokabeltrainer v1.4");
        setMinimumSize(new java.awt.Dimension(512, 330));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("interfaces"); // NOI18N
        dictionaryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("title_translator"))); // NOI18N

        languageButtonGroup.add(enRadioButton);
        enRadioButton.setText(bundle.getString("checkbox_english")); // NOI18N

        languageButtonGroup.add(deRadioButton);
        deRadioButton.setText(bundle.getString("checkbox_german")); // NOI18N

        inputTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputTextFieldKeyReleased(evt);
            }
        });

        translateButton.setText(bundle.getString("button_translate")); // NOI18N
        translateButton.setEnabled(false);
        translateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateButtonActionPerformed(evt);
            }
        });

        translationLabel.setText(bundle.getString("label_translation_colon")); // NOI18N

        saveButton.setText(bundle.getString("button_save_to_trainer")); // NOI18N
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        randomButton.setText(bundle.getString("button_random")); // NOI18N
        randomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomButtonActionPerformed(evt);
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "English", "German"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(resultTable);

        languageButtonGroup.add(bothRadioButton);
        bothRadioButton.setSelected(true);
        bothRadioButton.setText(bundle.getString("checkbox_both")); // NOI18N

        updateCheckButton.setText(bundle.getString("button_check_updates")); // NOI18N
        updateCheckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCheckButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dictionaryPanelLayout = new javax.swing.GroupLayout(dictionaryPanel);
        dictionaryPanel.setLayout(dictionaryPanelLayout);
        dictionaryPanelLayout.setHorizontalGroup(
            dictionaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dictionaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dictionaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dictionaryPanelLayout.createSequentialGroup()
                        .addComponent(enRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(deRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bothRadioButton))
                    .addComponent(inputTextField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dictionaryPanelLayout.createSequentialGroup()
                        .addComponent(updateCheckButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton))
                    .addGroup(dictionaryPanelLayout.createSequentialGroup()
                        .addComponent(randomButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(translateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(dictionaryPanelLayout.createSequentialGroup()
                        .addComponent(translationLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dictionaryPanelLayout.setVerticalGroup(
            dictionaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dictionaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dictionaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enRadioButton)
                    .addComponent(deRadioButton)
                    .addComponent(bothRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dictionaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(translateButton)
                    .addComponent(randomButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(translationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dictionaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(updateCheckButton))
                .addContainerGap())
        );

        mainSplitPane.setLeftComponent(dictionaryPanel);

        sideSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        trainerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("title_trainer"))); // NOI18N

        jLabel3.setText(bundle.getString("label_original_colon")); // NOI18N

        origLabel.setText("Word");

        jLabel4.setText(bundle.getString("label_translate_colon")); // NOI18N

        transTextLabel.setText(bundle.getString("label_translation")); // NOI18N

        checkButton.setText(bundle.getString("button_check")); // NOI18N
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });

        nextButton.setText(bundle.getString("button_next")); // NOI18N
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout trainerPanelLayout = new javax.swing.GroupLayout(trainerPanel);
        trainerPanel.setLayout(trainerPanelLayout);
        trainerPanelLayout.setHorizontalGroup(
            trainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trainerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(trainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(trainerPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(origLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(trainerPanelLayout.createSequentialGroup()
                        .addGroup(trainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(trainerPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(trainerPanelLayout.createSequentialGroup()
                                .addComponent(checkButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nextButton))
                            .addComponent(transTextField))
                        .addContainerGap())
                    .addGroup(trainerPanelLayout.createSequentialGroup()
                        .addComponent(transTextLabel)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        trainerPanelLayout.setVerticalGroup(
            trainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trainerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(origLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transTextLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(trainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkButton)
                    .addComponent(nextButton))
                .addContainerGap())
        );

        sideSplitPane2.setTopComponent(trainerPanel);

        myDictionaryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("title_my_dictionary"))); // NOI18N

        myDictionaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "English", "German"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        myDictionaryTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(myDictionaryTable);

        deleteVocButton.setText(bundle.getString("button_delete")); // NOI18N
        deleteVocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVocButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myDictionaryPanelLayout = new javax.swing.GroupLayout(myDictionaryPanel);
        myDictionaryPanel.setLayout(myDictionaryPanelLayout);
        myDictionaryPanelLayout.setHorizontalGroup(
            myDictionaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myDictionaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myDictionaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myDictionaryPanelLayout.createSequentialGroup()
                        .addGap(0, 126, Short.MAX_VALUE)
                        .addComponent(deleteVocButton)))
                .addContainerGap())
        );
        myDictionaryPanelLayout.setVerticalGroup(
            myDictionaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myDictionaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteVocButton)
                .addContainerGap())
        );

        sideSplitPane2.setRightComponent(myDictionaryPanel);

        mainSplitPane.setRightComponent(sideSplitPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainSplitPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainSplitPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        String input = transTextField.getText().trim();
        String trans = myDictionaryMap.get(myDictionaryKeys.get(index));
        if (input.equalsIgnoreCase(trans)) {
            checkButton.setBackground(Color.GREEN);
            transTextField.setBackground(Color.GREEN);
        } else {
            checkButton.setBackground(Color.RED);
            transTextField.setBackground(Color.RED);
        }
        transTextLabel.setText(trans);
    }//GEN-LAST:event_checkButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        checkButton.setBackground(defaultButtonBackgroundColor);
        transTextField.setBackground(defaultFieldBackgroundColor);
        transTextField.setText("");
        transTextLabel.setText(INTERFACE_STRINGS.getString("label_translation"));
        if (myDictionaryKeys.get(0).length() != 0 && myDictionaryKeys.size() > 1) {
            int oldIndex = index;
            do {
                index = rd.nextInt() % myDictionaryKeys.size();
            } while (index < 0 || index == oldIndex);
            origLabel.setText(myDictionaryKeys.get(index));
        } else if (myDictionaryKeys.get(0).length() != 0) {
            index = 0;
            origLabel.setText(myDictionaryKeys.get(index));
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (resultKeys.size() == 1) {
            resultTable.setRowSelectionInterval(0, 0);
        }
        int rowPos = resultTable.getSelectedRow();
        int colPos = resultTable.getSelectedColumn();
        if (rowPos == -1) {
            JOptionPane.showMessageDialog(null, MESSAGE_STRINGS.getString("select_element_first"));
            return;
        }
        // Read actual cell, can be edited
        String de = (String) resultTable.getValueAt(rowPos, 1);
        String en = (String) resultTable.getValueAt(rowPos, 0);

        int pos;

        // Cut german word
        pos = de.indexOf("{");
        if (pos != -1) {
            de = de.substring(0, pos);
        }

        // Cut english word
        pos = en.indexOf("|");
        if (pos != -1) {
            en = en.substring(0, pos-1);
        }
        pos = en.indexOf(";");
        if (pos != -1) {
            en = en.substring(0, pos-1);
        }

        // Cut pre- & post-spaces
        en = en.toLowerCase().trim();
        de = de.toLowerCase().trim();

        // Replace ';' for csv file
        en = en.replaceAll(";", ",");
        de = de.replaceAll(";", ",");
        // Add to private learning dictionary
        myDictionaryKeys.add(de);
        myDictionaryMap.put(de, en);
        myDictionaryTableModel.addRow(new Object[]{en, de});
        savePrivateDictionary(myDictionaryFile);
        saveButton.setEnabled(false);
        
        // TODO implement Yes/No-Button
        JOptionPane.showMessageDialog(null, de + " (en: " + en + ") " + MESSAGE_STRINGS.getString("added_to_trainer"));
    }//GEN-LAST:event_saveButtonActionPerformed

    private void translateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_translateButtonActionPerformed
        resultTable.removeAll();
        if (enRadioButton.isSelected()) {
            srcLang = sourceLanguage.EN;
        } else if (deRadioButton.isSelected()) {
            srcLang = sourceLanguage.DE;
        } else if (bothRadioButton.isSelected()) {
            srcLang = sourceLanguage.BOTH;
        }
        translateFromFile(fullDictionaryFile, inputTextField.getText());
    }//GEN-LAST:event_translateButtonActionPerformed

    private void inputTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTextFieldKeyPressed
        saveButton.setEnabled(false);
    }//GEN-LAST:event_inputTextFieldKeyPressed

    private void randomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomButtonActionPerformed
        int pos;
        do {
            pos = rd.nextInt() % publicDictionaryKeys.size();
        } while (pos < 0 || pos >= publicDictionaryKeys.size());
        inputTextField.setText(publicDictionaryKeys.get(pos));
        srcLang = sourceLanguage.DE;
        deRadioButton.setSelected(true);
        translateFromFile(fullDictionaryFile, publicDictionaryKeys.get(pos));
    }//GEN-LAST:event_randomButtonActionPerformed

    private void inputTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTextFieldKeyReleased
        if (inputTextField.getText().trim().length() <= 0) {
            translateButton.setEnabled(false);
        } else {
            translateButton.setEnabled(true);
        }
    }//GEN-LAST:event_inputTextFieldKeyReleased

    private void updateCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCheckButtonActionPerformed
        updateCheckButton.setEnabled(false);
        String message;
        int currentVersionNo = MainServerConnector.getVersionNumber(this.getTitle());
        String name = MainServerConnector.getProgramName(this.getTitle());
        try {
            int latestVersionNo = MainServerConnector.getLatestVersionNo(name, currentVersionNo);
            if (currentVersionNo > latestVersionNo) {
                message = MESSAGE_STRINGS.getString("version_forward");
            } else if (currentVersionNo == latestVersionNo) {
                message = MESSAGE_STRINGS.getString("version_up_to_date");
            } else {
                message = MESSAGE_STRINGS.getString("version_outdated");
            }
        } catch (IOException ex) {
            message = MESSAGE_STRINGS.getString("out_of_service");
            System.out.println(message);
            System.out.println(ex.toString());
        }
        JOptionPane.showMessageDialog(null, message);
        updateCheckButton.setEnabled(true);
    }//GEN-LAST:event_updateCheckButtonActionPerformed

    private void deleteVocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVocButtonActionPerformed
        int rowPos = myDictionaryTable.getSelectedRow();
        int colPos = myDictionaryTable.getSelectedColumn();
        if (rowPos == -1) {
            JOptionPane.showMessageDialog(null, MESSAGE_STRINGS.getString("select_element_first"));
            return;
        }
        // Read actual cell, can be edited
        String de = (String) myDictionaryTable.getValueAt(rowPos, 1);
        String en = (String) myDictionaryTable.getValueAt(rowPos, 0);
        myDictionaryTableModel.removeRow(rowPos);
        myDictionaryKeys.remove(de);
        myDictionaryMap.remove(de);
        savePrivateDictionary(myDictionaryFile);
        JOptionPane.showMessageDialog(null, de + " (en: " + en + ") " + MESSAGE_STRINGS.getString("deleted_from_trainer"));
        
    }//GEN-LAST:event_deleteVocButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bothRadioButton;
    private javax.swing.JButton checkButton;
    private javax.swing.JRadioButton deRadioButton;
    private javax.swing.JButton deleteVocButton;
    private javax.swing.JPanel dictionaryPanel;
    private javax.swing.JRadioButton enRadioButton;
    private javax.swing.JTextField inputTextField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.ButtonGroup languageButtonGroup;
    private javax.swing.JSplitPane mainSplitPane;
    private javax.swing.JPanel myDictionaryPanel;
    private javax.swing.JTable myDictionaryTable;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel origLabel;
    private javax.swing.JButton randomButton;
    private javax.swing.JTable resultTable;
    private javax.swing.JButton saveButton;
    private javax.swing.JSplitPane sideSplitPane2;
    private javax.swing.JPanel trainerPanel;
    private javax.swing.JTextField transTextField;
    private javax.swing.JLabel transTextLabel;
    private javax.swing.JButton translateButton;
    private javax.swing.JLabel translationLabel;
    private javax.swing.JButton updateCheckButton;
    // End of variables declaration//GEN-END:variables
    //Keys in german
    List<String> myDictionaryKeys;
    HashMap<String, String> myDictionaryMap;
    // Keys in german
    List<String> publicDictionaryKeys;
    TreeMap<String, String> publicDictionary;
    //Keys in german
    List<String> resultKeys = new LinkedList<>();
    HashMap<String, String> resultMap = new HashMap<>();
    private int index;
    private final Color defaultButtonBackgroundColor;
    private final Color defaultFieldBackgroundColor;
    private final Random rd;
    private String fullDictionaryFile = "de-en.txt";
    private final String myDictionaryFile = "dictionary.csv";
    private final String ENGLISH = "en";
    private final String GERMAN = "de";
    private sourceLanguage srcLang;
    private final DefaultTableModel myDictionaryTableModel;
    private final ResourceBundle MESSAGE_STRINGS = ResourceBundle.getBundle("messages");
    private final ResourceBundle INTERFACE_STRINGS = ResourceBundle.getBundle("interfaces");

    private void loadPrivateDictionary(String filename) {
        myDictionaryMap.clear();
        
        for (int i = myDictionaryTableModel.getRowCount() - 1; i >= 0; i--) {
            myDictionaryTableModel.removeRow(i);
        }
        
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
            int counter = 0;
            String line;
            while ((line = br.readLine()) != null) {

                if (line.contains(";")) {
                    String[] buffer = line.split(";");
                    String key = buffer[0];
                    String value = buffer[1];
                    myDictionaryKeys.add(key);
                    myDictionaryMap.put(key, value);
                    counter++;
                }
            }
            
            for (int i = 0; i < myDictionaryKeys.size(); i++) {
                    String de = myDictionaryKeys.get(i);
                    String en = myDictionaryMap.get(de);
                    myDictionaryTableModel.addRow(new Object[]{en, de});
                }
            
        } catch (IOException ex) {
            nextButton.setEnabled(false);
            checkButton.setEnabled(false);
            //JOptionPane.showMessageDialog(null, "Unable to load dictionary! (" + filename + ")");
            myDictionaryKeys.add("");
            myDictionaryMap.put("", "");
        }
    }

    private void savePrivateDictionary(String filename) {
        // Save myDictionaryMap
        if (myDictionaryKeys.get(0).length() == 0) {
            myDictionaryKeys.remove("");
            myDictionaryMap.remove("");
            nextButton.setEnabled(true);
            checkButton.setEnabled(true);
        }
        String key;
        String value;
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"))) {
            for (int i = 0; i < myDictionaryKeys.size(); i++) {
                key = myDictionaryKeys.get(i);
                value = myDictionaryMap.get(key);
                writer.write(key + ";" + value + "\r\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, MESSAGE_STRINGS.getString("unable_save_dictionary") + ": " + e.toString());
        }
    }

    private void translateFromFile(String filename, String word) {
        boolean foundWord = false;
        // Clear table
        resultKeys.clear();
        resultMap.clear();
        DefaultTableModel tableModel = (DefaultTableModel) resultTable.getModel();
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
            int counter = 0;
            int pos;
            String key;
            String value;
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.contains(word)) {
                    // Skip if word not found
                    continue;
                }
                if (line.contains("::")) {
                    // Split between german and english side
                    String[] buffer = line.split("::");

                    // Cut german side
                    pos = buffer[0].indexOf("{");
                    if (pos == -1) {
                        continue;
                    } else {
                        key = buffer[0].substring(0, pos).trim();
                    }

                    // Cut english side
                    pos = buffer[1].indexOf("|") - 1;
                    if (pos <= -1) {
                        value = buffer[1].trim();
                    } else {
                        value = buffer[1].substring(0, pos).trim();
                    }

                    // Remove empty entries
                    if (key.length() == 0 || value.length() == 0) {
                        continue;
                    }

                    if (srcLang == sourceLanguage.BOTH && !value.contains(word) && !key.contains(word)) {
                        // Word not in english key or german key found
                        continue;
                    } else if (srcLang == sourceLanguage.DE && !key.contains(word)) {
                        // Word not in german key found
                        continue;
                    } else if (srcLang == sourceLanguage.EN && !value.contains(word)) {
                        // Word not in english key found
                        continue;
                    }

                    // Add word and translation to result
                    foundWord = true;
                    resultKeys.add(buffer[0].trim());
                    resultMap.put(buffer[0].trim(), buffer[1].trim());
                    counter++;
                }
            }
            if (foundWord) {
                // Adding elements to board
                for (int i = 0; i < resultKeys.size(); i++) {
                    String de = resultKeys.get(i);
                    String en = resultMap.get(de);
                    tableModel.addRow(new Object[]{en, de});
                }
                saveButton.setEnabled(true);
            } else {
                String lang = "DE/EN";
                if (srcLang == sourceLanguage.DE) {
                    lang = "DE";
                } else if (srcLang == sourceLanguage.EN) {
                    lang = "EN";
                }
                saveButton.setEnabled(false);
                JOptionPane.showMessageDialog(null, MESSAGE_STRINGS.getString("word") + " " + word + " (" + lang + ") " + MESSAGE_STRINGS.getString("not_found_in")+ " " + filename);
            }
        } catch (IOException ex) {
            nextButton.setEnabled(false);
            checkButton.setEnabled(false);
            JOptionPane.showMessageDialog(null, MESSAGE_STRINGS.getString("unable_load_dictionary") + "! (" + filename + "): " + ex.toString());
            publicDictionaryKeys.add("");
            publicDictionary.put("", "");
        }
    }

    private void translate(String srcLanguage, String word) {
        resultTable.setEnabled(false);
        boolean foundWord = false;
        String tmp;
        String result = "";
        resultKeys.clear();
        resultMap.clear();
        String lastResult;
        DefaultTableModel tableModel = (DefaultTableModel) resultTable.getModel();
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        resultTable.removeAll();
        if (srcLanguage.equals(GERMAN)) {
            // DE -> EN
            for (int i = 0; i < publicDictionaryKeys.size(); i++) {

                // German tmp
                tmp = publicDictionaryKeys.get(i);

                if (tmp.contains(word)) {
                    lastResult = result;

                    // English result
                    result = publicDictionary.get(tmp);
                    if (result.equalsIgnoreCase(lastResult)) {
                        continue;
                    }
                    resultKeys.add(tmp);
                    resultMap.put(tmp, result);
                    foundWord = true;
                    // break here to only find one element
                    //break;
                }
            }
            if (foundWord) {
                // Adding elements to board
                for (int i = 0; i < resultKeys.size(); i++) {
                    String de = resultKeys.get(i);
                    String en = resultMap.get(de);
                    tableModel.addRow(new Object[]{en, de});
                }
            }
        } else if (srcLanguage.equals(ENGLISH)) {
            // EN -> DE
            for (int i = 0; i < publicDictionaryKeys.size(); i++) {

                // English tmp
                tmp = publicDictionary.get(publicDictionaryKeys.get(i));

                if (tmp.contains(word)) {
                    lastResult = result;

                    // German result
                    result = publicDictionaryKeys.get(i);
                    if (result.equalsIgnoreCase(lastResult)) {
                        continue;
                    }
                    resultKeys.add(result);
                    resultMap.put(result, tmp);
                    foundWord = true;
                    // break here to only find one element
                    //break;
                }
            }
            if (foundWord) {
                // Adding elements to board
                for (int i = 0; i < resultKeys.size(); i++) {
                    String de = resultKeys.get(i);
                    String en = resultMap.get(de);
                    tableModel.addRow(new Object[]{en, de});
                }
            }
        }
        if (!foundWord) {
            saveButton.setEnabled(false);
            JOptionPane.showMessageDialog(null, MESSAGE_STRINGS.getString("unable_find_word") + " " + word + " (" + srcLanguage.toUpperCase() + ")");
        } else {

            saveButton.setEnabled(true);
        }
        resultTable.setEnabled(true);
        if (tableModel.getRowCount() == 1) {
            // TODO Select first row
        }
    }

    private void loadFullDictionary(String filename) {
        publicDictionaryKeys.clear();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
            //scanner = new Scanner(dictionaryFile);
            int counter = 0;
            int pos;
            String key;
            String value;
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("::")) {
                    String[] buffer = line.split("::");
                    pos = buffer[0].indexOf("{");

                    if (pos == -1) {
                        continue;
                    } else {
                        key = buffer[0].substring(0, pos).trim();
                    }
                    //System.out.println("" + counter + ":" + key);
                    pos = buffer[1].indexOf("|") - 1;
                    if (pos <= -1) {
                        value = buffer[1];
                    } else {
                        value = buffer[1].substring(0, pos).trim();
                    }
                    if (key.length() == 0 || value.length() == 0) {
                        continue;
                    }
                    publicDictionaryKeys.add(key.trim());
                    publicDictionary.put(key.trim(), value.trim());
                    counter++;
                }
            }
            //scanner.close();
        } catch (IOException ex) {
            nextButton.setEnabled(false);
            checkButton.setEnabled(false);
            JOptionPane.showMessageDialog(null, MESSAGE_STRINGS.getString("unable_load_dictionary") + "! (" + filename + "): " + ex.toString());
            publicDictionaryKeys.add("");
            publicDictionary.put("", "");
        }
    }

    enum sourceLanguage {
        EN,
        DE,
        BOTH
    }
}
