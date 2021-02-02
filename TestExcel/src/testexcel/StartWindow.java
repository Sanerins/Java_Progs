package testexcel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class StartWindow extends javax.swing.JFrame {

    private static Component rootPane;
    private JPanel panel1;

    private void jButtonChooseFolderActionPerformed(java.awt.event.ActionEvent evt){
        JOptionPane.showMessageDialog(rootPane, "Получено событие: " + evt.getActionCommand());
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Выберете папку с файлами попыток");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            File dir = fileChooser.getSelectedFile();
        }
        JOptionPane.showMessageDialog(rootPane, "Получено значение " + result);
    }

    public static void main(String args[]){

        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                JButton butt = new JButton("Погнали нахуй");
                butt.setVisible(true);
                butt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        JOptionPane.showMessageDialog(rootPane, "Получено событие: " + evt.getActionCommand());
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setDialogTitle("Выберете папку с файлами попыток");
                        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//                        int result = fileChooser.showOpenDialog(this);
//                        if(result == JFileChooser.APPROVE_OPTION){
//                            File dir = fileChooser.getSelectedFile();
//                        }
                        //JOptionPane.showMessageDialog(rootPane, "Получено значение " + result);
                }
            });
        }
    });
}}
