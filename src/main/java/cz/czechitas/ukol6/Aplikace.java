package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel husyLabel;
    private JLabel králíciLabel;
    private JTextField husyField;
    private JTextField králíciField;
    private JButton vypočítatButton;
    private JLabel početHlavLabel;
    private JLabel početNohouLabel;
    private JTextField početHlavField;
    private JTextField početNohouField;


    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //TODO implementovat formulář podle zadání

        pack();

        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        husyField.setHorizontalAlignment(JTextField.TRAILING);
        add(husyLabel);
        add(husyField);

        králíciField = new JTextField();
        králíciLabel = new JLabel("Králíci");
        králíciLabel.setDisplayedMnemonic('K');
        králíciLabel.setLabelFor(králíciField);
        králíciField.setHorizontalAlignment(JTextField.TRAILING);
        add(králíciLabel);
        add(králíciField);

        add(createButtonBar(),"center, span");

        početHlavField = new JTextField();
        početHlavLabel = new JLabel("Počet hlav");
        početHlavLabel.setLabelFor(početHlavField);
        početHlavField.setHorizontalAlignment(JTextField.TRAILING);
        add(početHlavLabel);
        add(početHlavField);
        početHlavField.setEnabled(false);

        početNohouField = new JTextField();
        početNohouLabel = new JLabel("Počet nohou");
        početNohouLabel.setLabelFor(početNohouField);
        početNohouField.setHorizontalAlignment(JTextField.TRAILING);
        add(početNohouLabel);
        add(početNohouField);
        početNohouField.setEnabled(false);



        getRootPane().setDefaultButton(vypočítatButton);
        vypočítatButton.addActionListener(this::handleVypočítat);

    }

        private JPanel createButtonBar() {
            vypočítatButton = new JButton("Vypočítat");
            vypočítatButton.setMnemonic('V');
            JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
            buttonBar.add(vypočítatButton);
            return buttonBar;
        }

        private void handleVypočítat (ActionEvent actionEvent) {

            int čísloHusy = Integer.parseInt(husyField.getText());
            int čísloKrálíci = Integer.parseInt(králíciField.getText());
            int výsledekHlavy = čísloHusy + čísloKrálíci;
            početHlavField.setText(String.valueOf((výsledekHlavy)));

            int výsledekNohy = čísloHusy * 2 + čísloKrálíci * 4;
            početNohouField.setText(String.valueOf(výsledekNohy));

        }
    }



