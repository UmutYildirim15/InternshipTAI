package Components;


import Services.DBConnection;

import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddPanel {
    private JFrame frame;
    private JLabel titleLabel1;
    private JLabel titleLabel2;
    private JLabel titleLabel3;
    private JLabel titleLabel4;
    private JLabel titleLabel5;
    private JLabel titleLabel6;
    private JLabel titleLabel7;
    private JLabel titleLabel8;
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField aciklama;
    private JTextField field5;
    private CustomCheckBox check1;
    private CustomCheckBox check2;
    private CustomComboBox combo1;
    private JButton addButton;

    public AddPanel()
    {
        // Create the main frame
        frame = new JFrame("İş Giriş Sayfası");
        ImageIcon frameIcon = new ImageIcon("D:\\INTELLIJ\\src\\Assets\\tusas.png");
        frame.setIconImage(frameIcon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 420);
        frame.setLocationRelativeTo(null);

        LinkedList<String> values = new LinkedList<String>();

        // Create the panel with the text fields and check boxes
        JPanel inputPanel = new JPanel(new GridLayout(8, 2));

        titleLabel1 = new JLabel("  Field 1:");
        titleLabel1.setFont(new Font("Arial", 0, 12));
        titleLabel1.setForeground(Color.decode("#6096B4"));
        inputPanel.add(titleLabel1);
        field1 = new JTextField();
        inputPanel.add(field1);

        titleLabel2 = new JLabel("  Field 2:");
        titleLabel2.setFont(new Font("Arial", 0, 12));
        titleLabel2.setForeground(Color.decode("#6096B4"));
        inputPanel.add(titleLabel2);
        field2 = new JTextField();
        inputPanel.add(field2);

        titleLabel3 = new JLabel("  Field 3:");
        titleLabel3.setFont(new Font("Arial", 0, 12));
        titleLabel3.setForeground(Color.decode("#6096B4"));
        inputPanel.add(titleLabel3);
        field3 = new JTextField();
        inputPanel.add(field3);

        titleLabel4 = new JLabel("  Açıklama:");
        titleLabel4.setFont(new Font("Arial", 0, 12));
        titleLabel4.setForeground(Color.decode("#6096B4"));
        inputPanel.add(titleLabel4);
        aciklama = new JTextField();
        inputPanel.add(aciklama);

        titleLabel5 = new JLabel("  Field 5:");
        titleLabel5.setFont(new Font("Arial", 0, 12));
        titleLabel5.setForeground(Color.decode("#6096B4"));
        inputPanel.add(titleLabel5);
        field5 = new JTextField();
        inputPanel.add(field5);

        titleLabel6 = new JLabel("  Check 1:");
        titleLabel6.setFont(new Font("Arial", 0, 12));
        titleLabel6.setForeground(Color.decode("#6096B4"));
        inputPanel.add(titleLabel6);
        check1 = new CustomCheckBox();
        inputPanel.add(check1);

        titleLabel7 = new JLabel("  Check 2:");
        titleLabel7.setFont(new Font("Arial", 0, 12));
        titleLabel7.setForeground(Color.decode("#6096B4"));
        inputPanel.add(titleLabel7);
        check2 = new CustomCheckBox();
        inputPanel.add(check2);

        titleLabel8 = new JLabel("  Seçiniz:");
        titleLabel8.setFont(new Font("Arial", 0, 12));
        titleLabel8.setForeground(Color.decode("#6096B4"));
        inputPanel.add(titleLabel8);
        combo1 = new CustomComboBox();
        combo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item1", "Item2", "Item3", "-" }));
        combo1.setSelectedIndex(-1);
        combo1.setLabeText("");  // bu çalışmıyor çünkü animasyon yok!
        inputPanel.add(combo1);


        // Create the panel with the add button
        JPanel buttonPanel = new JPanel();
        addButton = new CustomButton(Color.decode("#6096B4"));
        addButton.setText("Kaydet");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Burası edit için gerekli olabilir!
                    if (aciklama.getText().isEmpty()) {
                        javax.swing.JOptionPane.showMessageDialog(frame, "Kaydetmek için açıklama giriniz!");
                        return;
                    }


                    DBConnection db = new DBConnection("C:\\Users\\Hp\\Desktop\\db.xlsx");
                    values.add(field1.getText());
                    values.add(field2.getText());
                    values.add(field3.getText());
                    values.add(aciklama.getText());
                    values.add(field5.getText());
                    if(!check1.isSelected())
                        values.add("-");
                    if(!check2.isSelected())
                        values.add("-");
                    values.add(combo1.getSelectedItem().toString());
                    db.Add(values);

                    // Clear the text fields and check boxes
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");
                    aciklama.setText("");
                    field5.setText("");
                    check1.setSelected(false);
                    check2.setSelected(false);
                    combo1.setSelectedItem(null);

                    // Show a confirmation message
                    javax.swing.JOptionPane.showMessageDialog(frame, "Değerler veritabanına kaydedildi!.");
                    //frame.dispose();    // Ekledikten sonra pop-up kapansın mı??

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        buttonPanel.add(addButton);

        // Add the panels to the frame
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Show the frame
        frame.setVisible(true);
    }

}