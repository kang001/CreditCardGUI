package com.Kara;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stiri on 10/25/2016.
 */
public class CreditCardValidator extends JFrame{
    private JTextField txtCCNumber;
    private JPanel rootPanel;
    private JLabel lblCCNumber;
    private JButton btnValidate;
    private JLabel lblResults;
    private JButton btnExit;



    public CreditCardValidator() {
        super("Credit Card Validator");
        setContentPane(rootPanel);
        pack();
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        btnValidate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ccNumber = txtCCNumber.getText();

                boolean valid = isVisaCreditCardNumberValid(ccNumber);

                if (valid) {
                    lblResults.setText("Credit Card number is valid");
                } else {
                    lblResults.setText("Credit Card number is NOT valid");
                }
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             System.exit(0);
            }
        });
    }

        private static boolean isVisaCreditCardNumberValid(String ccNumber) {
            if (!ccNumber.startsWith("4")) {
                System.out.println("Doesn't start with 4, invalid");
                return false;
            }

            if (ccNumber.length() != 16) {
                System.out.println("Credit card must be 16 numbers, invalid");
                return false;
            }


            int sum = 0;

            for (int i = 0; i < 16; i++) {
                int thisDigit = Integer.parseInt((ccNumber.substring(i, i + 1)));
                if (i % 2 == 1) {
                    sum = sum + thisDigit;
                } else {
                    int doubled = thisDigit * 2;
                    if (doubled > 9) {
                        int toAdd = 1 + (doubled % 10);
                        sum = sum + toAdd;
                    } else {
                        sum = sum + (thisDigit * 2);
                    }
                }
            }

            if (sum % 10 == 0) {
                return true;
            }

            System.out.println("Check digit is wrong, card number is invalid");
            return false;



        }
}

