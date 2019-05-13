

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;

public class Main {
	private static final String NAME = "WAV File Reader";
	private static String AUDIO_FILE_NAME = "AUDIO WAVE FORM";
	
	public static String openBrowseFilesWindow() {
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(new FileNameExtensionFilter(".wav files only","wav"));
		
		int res = fileChooser.showOpenDialog(null);
		
		if(res == fileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile().toString();
		}
		return null;
	}
	
	public static void drawWave(double[] samples, int maxSample) {
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screen.height;
		int width = screen.width;
		
		JFrame frame = new JFrame(AUDIO_FILE_NAME);
		frame.setSize(new Dimension(width - (width/4),height/2));
		frame.setResizable(false);
		
		WAVForm wavForm = new WAVForm(samples);
		frame.setContentPane(wavForm);
		
		JLabel numSamples_label = new JLabel("Number of Samples: " + samples.length);
		numSamples_label.setBounds((width/2),height-10,200,100);
		numSamples_label.setForeground(Color.WHITE);;
		frame.getContentPane().add(numSamples_label);
		
		JLabel maxSample_label = new JLabel("  Maximum Sample: " + maxSample);
		maxSample_label.setBounds((width/2),height-10,200,100);
		maxSample_label.setForeground(Color.WHITE);
		frame.getContentPane().add(maxSample_label);
		
		frame.getContentPane().setBackground(new Color(72,76,81));
		frame.setVisible(true);
	}
	
	public static void showGUIWindow() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screen.height;
		int width = screen.width;
				
		JFrame frame = new JFrame(NAME);
		JPanel panel = (JPanel)frame.getContentPane();
		panel.setLayout(null);
		
		JLabel instr_label = new JLabel("click on the icon below to browse for .wav files");
		panel.add(instr_label);
		instr_label.setBounds((width/2)-455,40,500,100);
		
		JButton browseFilesButton = new JButton(new ImageIcon(Main.class.getResource("/browseFiles.png")));
		browseFilesButton.setBorder(null);
		browseFilesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String filePath = openBrowseFilesWindow();
				if(filePath != null) {
					WAVFile wav = new WAVFile(filePath);
					double[] norm_samples = wav.normalizeSamples(wav.getSamples(),height/5);
					drawWave(norm_samples,wav.maxSample);
				}
			}
		});
		
		browseFilesButton.setBounds(250,100,150,150);
		panel.add(browseFilesButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(width/2,height/2));
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//create a thread to execute showGUIWindow() routine/ asynchronous execution of UI components of main frame
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				showGUIWindow();
			}
		});
	}

}
