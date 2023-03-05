package Pages;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

import Components.CustomButton;
import Components.CustomSlider;
import Components.GradientPanel;
import Components.NumberTextField;

@SuppressWarnings("serial")
public class LoginPage extends JPanel {

	private JFrame frame;
	private String frameTitle = "İş Takip Sistemi";

	private JPanel leftPanel, rightPanel;
    private JLabel welcomeLabel;
    private NumberTextField idTextField;
    private CustomButton loginButton;
    private JLabel photoLabel;
    private JLabel titleLabel;
    private ImageIcon image;
    private ImageIcon bgImage;
    private ImageIcon tusasLogo;
    private JLabel tusasLogoLabel;
    
    private int imageWidth = 0;
    private int imageHeight = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LoginPage() {
		initialize();
	}
	 protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
	        int width = frame.getWidth();
	        int height = frame.getHeight();
	        GradientPaint gradient = new GradientPaint(width, 0, new Color(255, 255, 255, 0), 0, 0, new Color(255, 255, 255, 255));
	        g2d.setPaint(gradient);
	        g2d.fillRect(0, 0, width, height);
	    }

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon frameIcon = new ImageIcon("D:\\INTELLIJ\\src\\Assets\\tusas.png");
		frame.setIconImage(frameIcon.getImage());
		frame.setTitle(frameTitle);
		
		imageWidth = (int) (frame.getWidth() * 0.4);
		imageHeight = (int) (imageWidth * 1.40625);
		
		tusasLogo =  new ImageIcon("D:\\INTELLIJ\\src\\Assets\\tusas_logo.png");
		tusasLogoLabel = new JLabel(tusasLogo);
		tusasLogoLabel.setPreferredSize(new Dimension(100,50));
		
		leftPanel = new GradientPanel(false);
        leftPanel.setBackground(Color.decode("#6096B4"));
		leftPanel.setPreferredSize(new Dimension((int) (frame.getWidth() * 0.6), frame.getHeight()));
        leftPanel.setLayout(new GridBagLayout());
        
        rightPanel = new GradientPanel(true);
        rightPanel.setBackground(Color.decode("#6096B4"));
        
        rightPanel.setPreferredSize(new Dimension((int) (frame.getWidth() * 0.4), frame.getHeight()));
        rightPanel.setLayout(new GridBagLayout());
        
        image = new ImageIcon("D:\\INTELLIJ\\src\\Assets\\login_background.png");
        bgImage = new ImageIcon("D:\\INTELLIJ\\src\\Assets\\login_background.png");
		image.setImage(bgImage.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH));
        photoLabel = new JLabel(image);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
		gbc.weighty = 1;
        rightPanel.add(photoLabel, gbc);
        
        
        GridBagConstraints gbc0 = new GridBagConstraints();
        gbc0.gridx = 0;
        gbc0.gridy = 0;
        gbc0.insets = new Insets(0,0,50,0);
        gbc0.fill = GridBagConstraints.BOTH;
        gbc0.weightx = 0;
        gbc0.weighty = 0;
        
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 1;
        gbc1.insets = new Insets(0,0,0,0);
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.weightx = 0;
        gbc1.weighty = 0;
        
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        gbc2.insets = new Insets(2,0,10,0);
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.weightx = 0;
        gbc2.weighty = 0;
        
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 3;
        gbc3.insets = new Insets(0,0,0,0);
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.weightx = 0;
        gbc3.weighty = 0;
        
        welcomeLabel = new JLabel("İş Takip Sistemine Hoş Geldiniz");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.decode("#6096B4"));
        leftPanel.add(welcomeLabel, gbc0);
        
        titleLabel = new JLabel("Sicil No Girin");
        titleLabel.setFont(new Font("Arial", 0, 12));
        titleLabel.setForeground(Color.decode("#6096B4"));
        leftPanel.add(titleLabel, gbc1);

        idTextField = new NumberTextField();
        leftPanel.add(idTextField,gbc2);
        
        
        
        loginButton = new CustomButton(Color.decode("#6096B4"));
        loginButton.setText("Giriş Yap");
        loginButton.setRadius(25);
        loginButton.setBorder(null);
        loginButton.setForeground(Color.white);
        loginButton.setFocusPainted(false);
        
        loginButton.setPreferredSize(new Dimension(loginButton.getPreferredSize().width, 25));
        leftPanel.add(loginButton,gbc3);
        
        idTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	loginButton.doClick();
            }
        });
        
        loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String sicilNo = idTextField.getText();
				if(sicilNo.length() != 5){
					JOptionPane.showMessageDialog(null, "Please enter 5 digit number!");
				}else{
					//System.out.println(sicilNo);
					frame.dispose();
                    HomePage homePage = null;
                    try {
                        homePage = new HomePage(sicilNo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    homePage.frame.setVisible(true);
				}
			}
		});
        

		frame.add(leftPanel, BorderLayout.WEST);
		frame.add(rightPanel, BorderLayout.EAST);
		
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				leftPanel.setPreferredSize(new Dimension((int) (frame.getWidth() * 0.6), frame.getHeight()));
				leftPanel.revalidate();

				photoLabel.setPreferredSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));
				
				rightPanel.setPreferredSize(new Dimension((int) (frame.getWidth() * 0.4), frame.getHeight()));
				rightPanel.revalidate();
				
				imageWidth = (int) (frame.getWidth() * 0.4);
				imageHeight = (int) (imageWidth * 1.40625);
				image.setImage(bgImage.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH));

			}
		});

        frame.setVisible(true);
	}

}