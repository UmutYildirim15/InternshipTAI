package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CustomTextField extends javax.swing.JTextField{
    private int originallimit;
    int previousLength;
    int length;

    public CustomTextField(int limit){

        previousLength=10;
        originallimit = limit;

        this.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {

                JTextField textField = (JTextField) e.getSource();
                length = textField.getText().length();

                if(length >= originallimit){

                    if(length > previousLength){
                        textField.setSize(new Dimension(textField.getWidth()+10, textField.getHeight()));
                    }
                    else{
                        if(length < previousLength)
                            textField.setSize(new Dimension(textField.getWidth()-10, textField.getHeight()));
                    }
                    previousLength = length;

                }else{
                    textField.setSize(textField.getPreferredSize());
                }
            }
        });
    }

}

