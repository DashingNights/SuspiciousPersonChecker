import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class mainGUI extends JFrame {

    private JLabel label;
    private JTextField textField;
    private JLabel susPercentage;
    private JButton button;


    public mainGUI() {
        setLayout(new FlowLayout());

        label = new JLabel("Who is sus? ");
        label.setFont(new Font("Serif", Font.PLAIN, 13));
        add(label);

        textField = new JTextField(" sus person name here ",15);
        textField.setFont(new Font("Serif", Font.PLAIN, 20));
        add(textField);

        button = new JButton("Check if sussy");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                int percentage = (int)(Math.random()*100);
                susPercentage.setText(percentage + "% sus");
                if(percentage > 50 || percentage == 50) {
                    label.setText(name + " is sussy");
                    String soundName = "sus_sound.wav";
                    AudioInputStream audioInputStream = null;
                    try {
                        audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    label.setText(name + " is not sus");
                }
            }
        });
        add(button);
        susPercentage = new JLabel(" x% ");
        susPercentage.setFont(new Font("Serif", Font.PLAIN, 40));
        add(susPercentage);

        ImageIcon icon = new ImageIcon(getClass().getResource("among-us-twerk.gif"));
        JLabel picLabel = new JLabel(icon);
        add(picLabel);


    }
    public static void main(String[] args) {
        mainGUI gui = new mainGUI();
        mainGUI player = new mainGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1000, 1000);
        gui.setVisible(true);
        gui.setTitle("S.P.I.");
        gui.setResizable(false);
    }
}

