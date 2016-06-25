package gui;

import javax.swing.*;

//TODO Add dynamic reports to application

public class App {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new MainFrame();

        });
    }
}
