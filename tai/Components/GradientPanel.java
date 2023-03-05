package Components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GradientPanel extends JPanel {

	protected boolean fadeRight;
	public GradientPanel(boolean fadeRight)
	{
		this.fadeRight = fadeRight;
	}
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        GradientPaint gradient = null;
      
        if(this.fadeRight)
        	gradient = new GradientPaint((float) (width*(2)), 0, new Color(255, 255, 255, 127), 0, 0, new Color(255, 255, 255, 255));
        else
        	gradient = new GradientPaint((float) (width/1.25), 0, new Color(255, 255, 255, 255), 0, 0, new Color(255, 255, 255, 127));
        
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
    }
    public void setFadeRight(boolean fadeRight)
    {
    	this.fadeRight = fadeRight;
    }
    public boolean getFadeRight()
    {
    	return this.fadeRight;
    }
}