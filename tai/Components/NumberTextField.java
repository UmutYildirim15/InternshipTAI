package Components;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.text.*;

@SuppressWarnings("serial")
public class NumberTextField extends JTextField {

    public NumberTextField() {
        setDocument(new NumberDocument());
    }

    private class NumberDocument extends PlainDocument {

        @Override
        public void insertString(int offs, String str, AttributeSet a)
        		throws BadLocationException {
        	
            if (str == null) {
                return;
            }

            String currentText = getText(0, getLength());

            if (!str.matches("\\d+")) {
                return;
            }

            if ((currentText.length() + str.length()) > 5) {
                Toolkit.getDefaultToolkit().beep();
                return;
            }

            super.insertString(offs, str, a);

            if (getText(0,5).length() == 5 && !getText(0,5).matches("\\d+")) {
                //JOptionPane.showMessageDialog(null, "Please enter 5 digit number!");
                //setText("");
            }
        }
        

    }
}