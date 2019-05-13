import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WAVForm extends JPanel {
	private double[] samples;

	
	public WAVForm(double[] samples) {
		this.samples = samples;
		
	}
		
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		int width = this.getWidth();
		int height = this.getHeight();
		
		Graphics2D graphics2D = (Graphics2D) graphics;
		
		graphics2D.setColor(Color.green);
		double step = (double)(width-10)/(double)this.samples.length;
		for(int i=0;i<this.samples.length;i++) {
			Line2D sample = new Line2D.Double((i*step),height-(height/2),(i*step),height - samples[i] - (height/2));
			graphics2D.draw(sample);
		}
		
			
	}
}
