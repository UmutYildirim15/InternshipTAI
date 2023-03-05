package Pages;

import javax.swing.*;

import Components.TabbedPaneComponent;

import java.awt.*;
import java.io.IOException;

public class HomePage{

	private String sicilNo;
	public JFrame frame;
	private String frameTitle = "İş Takip Sistemi";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println(10);
					HomePage window = new HomePage(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomePage(String sicilNo) throws IOException {
		this.sicilNo = sicilNo;
		initialize();
	}

	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon frameIcon = new ImageIcon("D:\\INTELLIJ\\src\\Assets\\tusas.png");
		frame.setIconImage(frameIcon.getImage());
		frame.setTitle(frameTitle);
		frame.setLayout(new BorderLayout());

		TabbedPaneComponent tabbedPane = new TabbedPaneComponent(frame);
		tabbedPane.setSicilNo(Integer.parseInt(sicilNo));

		frame.add(tabbedPane);
	}

}