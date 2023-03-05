package Components;

import Pages.LoginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class IconButton extends JLabel {
    
    private String url;
    private ActionListener onTap;

    public int getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(int sicilNo) {
        this.sicilNo = sicilNo;
    }

    private int sicilNo;
    
    public IconButton(String url, ActionListener onTap, String buttonType, int sicilNo) {
        this.url = url;
        this.onTap = onTap;
        this.sicilNo = sicilNo;
        Image scaledIcon = new ImageIcon(url).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(scaledIcon));
        setPreferredSize(new Dimension(25, 25));
        setSize(new Dimension(25, 25));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                onTap.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
                if(buttonType.equals("addButton"))
                {
                    AddPanel addPanel = new AddPanel();
                }
                else if(buttonType.equals("deleteButton"))
                {

                }
                else if(buttonType.equals("editButton"))
                {

                }
                else if(buttonType.equals("logoutButton"))
                {
                    setSicilNo(0);  // for null  --> int sicilNo yerine string veya object koyup null yapılabilir.
                }
            }
        });
    }
    private void AddButton()
    {

    }
}