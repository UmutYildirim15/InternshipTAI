package Components;
import Pages.HomePage;
import Pages.LoginPage;
import Services.DBConnection;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

@SuppressWarnings("serial")
public class TabbedPaneComponent extends JPanel {
    public int getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(int sicilNo) {
        this.sicilNo = sicilNo;
    }

    protected int sicilNo;
    public TabbedPaneComponent(JFrame frame) throws IOException {

        super(new GridLayout(1, 1));
        DBConnection db = new DBConnection("C:\\Users\\Hp\\Desktop\\db.xlsx");
        JTabbedPane tabbedPane = new JTabbedPane();
        
        
        JPanel panel1 = new JPanel(new BorderLayout());
        
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        panel1.add(toolbar, BorderLayout.NORTH);
        
        IconButton addButton = new IconButton("D:\\INTELLIJ\\src\\Assets\\add_icon.png", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Icon clicked!");
            }
        },"addButton",sicilNo);
        
        IconButton deleteButton = new IconButton("D:\\INTELLIJ\\src\\Assets\\delete_icon.png", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Icon clicked!");
            }
        },"deleteButton",sicilNo);
        IconButton editButton = new IconButton("D:\\INTELLIJ\\src\\Assets\\edit_icon.png", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Icon clicked!");
            }
        },"editButton",sicilNo);
        IconButton logoutButton = new IconButton("D:\\INTELLIJ\\src\\Assets\\log_out_icon.png", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSicilNo(0);
                frame.dispose();
                LoginPage loginPage = new LoginPage();
            }
        },"logoutButton",sicilNo);
        
        toolbar.add(addButton);
        toolbar.add(deleteButton);
        toolbar.add(editButton);
        toolbar.add(logoutButton);
        JTable table = new JTable(5, 3);
        JScrollPane scrollPane = new JScrollPane(table);
        panel1.add(scrollPane, BorderLayout.CENTER);
        
        
        tabbedPane.addTab("Genel İş Yönetimi", null, panel1, "Genel İş Yönetimi");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        ////////////////////////////////////////////////  Burası Düzenlenmeli!!!

        JComponent panel2 = new JPanel(new BorderLayout());
        JToolBar toolbar2 = new JToolBar();
        IconButton addButton2 = new IconButton("D:\\INTELLIJ\\src\\Assets\\add_icon.png", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Icon clicked!");
            }
        },"addButton",sicilNo);

        IconButton deleteButton2 = new IconButton("D:\\INTELLIJ\\src\\Assets\\delete_icon.png", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Icon clicked!");
            }
        },"deleteButton",sicilNo);
        IconButton editButton2 = new IconButton("D:\\INTELLIJ\\src\\Assets\\edit_icon.png", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Icon clicked!");
            }
        },"editButton",sicilNo);
        IconButton logoutButton2 = new IconButton("D:\\INTELLIJ\\src\\Assets\\log_out_icon.png", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSicilNo(0);
                frame.dispose();
                LoginPage loginPage = new LoginPage();
            }
        },"logoutButton",sicilNo);

        toolbar2.setFloatable(false);
        toolbar2.add(addButton2);
        toolbar2.add(deleteButton2);
        toolbar2.add(editButton2);
        toolbar2.add(logoutButton2);
        panel2.add(toolbar2, BorderLayout.NORTH);
        JTable table2 = new JTable(5, 3);
        JScrollPane scrollPane2 = new JScrollPane(table2);
        panel2.add(scrollPane2, BorderLayout.CENTER);
        tabbedPane.addTab("Yazılım İş Yönetimi", null, panel2, "Yazılım İş Yönetimi");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        add(tabbedPane);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
    
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
    
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = TabbedPaneComponent.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    private static void createAndShowGUI() throws IOException {
        JFrame frame = new JFrame("TabbedPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new TabbedPaneComponent(frame), BorderLayout.CENTER);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		UIManager.put("swing.boldMetal", Boolean.FALSE);
                try {
                    createAndShowGUI();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}