# WAVFile-Reader
A simple wave file reader that reads <b><em>PCB</em> encoded <em>mono</em></b> audio files of <b><em>WAV</em></b> format and renders the wave form on the screen.

<h2>Details:</h2>
<ul>
<li>Source code can be found in WAVFileReader > src</li>
<li>This program was developed using Java programming language and compiled with Eclipse IDE</li>
<li>Java UI Library: Using <b>Swing</b> and <b>JFrame</b> to create window panels/frames/drawing graphics elements</li>
<li>Note: the audio track is assumed to have less than <em><strong>65536 samples</strong></em></li>
</ul>
<hr/>
<h2>Program Structure:</h2>
<ul>
<li><b>WAVFile.java:</b> reads, organizes and interprets wav file bytes</li>
<li><b>WAVForm.java:</b> this class extends JFrame class, overrides the paintComponent(Graphics graphics) method of the JFrame class. The importance of this class is that it draws each sample into a wave form and creates a <b>JFrame component</b> which can be added to a new frame and displayed to the user.</li>
<li><b>Main.java:</b> stitches together all program components/classes including showing the welcome UI to help users navigate the program.</li>
</ul>
<hr/>
<h2>Testing</h2>
<ul>
<li>
An executable .jar file can be found in the root folder of this project <cite><a href="https://github.com/Karan886/WAVFile-Reader/blob/master/WAVFileReader.jar"><b>WAVFileReader > WAVFileReader.jar</b></a></cite>
</li>
<li>
Some test audio files can be found in <cite><a href="https://github.com/Karan886/WAVFile-Reader/tree/master/SampleAudio"><b>WAVFileReader > SampleAudio</b></a></cite>
</li>
</ul>
 
