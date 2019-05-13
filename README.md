# WAVFile-Reader
A simple wave file reader that reads <b>pcb encoded mono</b> audio files of <b>WAV</b> format and renders the wave form on the screen.

<h2>Details:</h2>
<ol>
<li>Source code can be found in WAVFileReader > src</li>
<li>This program was developed using Java programming language and compiled with Eclipse IDE</li>
<li>Java UI Library: Using <b>Swing</b> and <b>JFrame</b> to create window panels/frames/drawing graphics elements</li>
</ol>

<h2>Program Structure:</h2>
<ol>
<li><b>WAVFile.java:</b> reads, organizes and interprets wav file bytes</li>
<li><b>WAVForm.java:</b> this class extends JFrame class, overrides the paintComponent(Graphics graphics) method of the JFrame class. The importance of this class is that it draws each sample into a wave form and creates a <b>JFrame component</b> which can be added to a new frame and displayed to the user.</li>
<li><b>Main.java:</b> stitches together all program components/classes including showing the welcome UI to help users navigate the program.</li>
</ol>

<h2>Testing</h2>
<ol>
 <li>An executable .jar file can be found in the root folder of this project <b>WAVFileReader > WAVFileReader.jar</b></li>
 <li>Some test audio files can be found in <b>WAVFileReader > SampleAudio</b></li>
</ol>
 
