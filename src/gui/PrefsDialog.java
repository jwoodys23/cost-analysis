package gui;

import javafx.scene.control.PasswordField;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jourdanwoodrich on 6/22/16.
 */
public class PrefsDialog extends JDialog{

    private JButton okButton;
    private JButton cancelButton;
    private JSpinner portSpinner;
    private SpinnerNumberModel spinnerModel;
    private JTextField userField;
    private JPasswordField passField;
    private PrefsListener prefsListener;

    public PrefsDialog(JFrame parent) {
        super(parent, "Preferences", false);

        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");
        spinnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
        portSpinner = new JSpinner(spinnerModel);
        userField = new JTextField(10);
        passField = new JPasswordField(10);


        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;

        // First Row///

        gc.weighty = 1;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 0;

        add(new JLabel("Username: "), gc);

        gc.gridx++;

        add(userField, gc);


        //Next Row//
        gc.gridy++;
        gc.weighty = 1;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 0;

        add(new JLabel("Password: "), gc);

        gc.gridx++;

        add(passField, gc);


        //Next Row////

        gc.gridy++;
        gc.gridx = 0;
        gc.weighty = 1;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.NONE;

        add(new JLabel("Port: "), gc);

        gc.gridx++;

        add(portSpinner, gc);

        //Next row
        gc.gridy++;
        gc.gridx = 0;
        add(okButton, gc);
        gc.gridx++;
        add(cancelButton,gc);

        //Action Listener to get port value
        okButton.addActionListener(e ->{
            Integer port = (Integer) portSpinner.getValue();
            String user = userField.getText();
            char[] password = passField.getPassword();

            if (prefsListener!=null){
                prefsListener.preferencesSet(user,new String(password), port);
            }

            setVisible(false);
        });

        cancelButton.addActionListener(e ->{
            setVisible(false);
        });


        setSize(400, 300);
        setLocationRelativeTo(parent);

    }

    public void setDefault(String user, String password, int port){
        userField.setText(user);
        passField.setText(password);
        portSpinner.setValue(port);
    }

    public void setPrefsListener(PrefsListener listener){
        this.prefsListener = listener;
    }
}
