import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class mainGUI extends JFrame {

    private JLabel label;
    private JTextField textField;
    private JLabel susPercentage;
    private JButton button;
    private MediaPlayer mediaPlayer;
    public mainGUI(){
        setLayout(new FlowLayout());

        label = new JLabel("Who sus???? ");
        label.setFont(new Font("Serif", Font.PLAIN, 60));
        add(label);

        textField = new JTextField(" sus person name here ",15);
        textField.setFont(new Font("Serif", Font.PLAIN, 55));
        add(textField);

        String alarm = "src/alarm.mp3";
        Media hit = new Media(new File(alarm).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);


        button = new JButton("Check if sussy");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                int percentage = (int)(Math.random()*100);
                susPercentage.setText(percentage + "%");
                if(percentage > 50) {
                    label.setText(name + " is sussy");
                    mediaPlayer.play();
                } else {
                    label.setText(name + " is not sus");
                    mediaPlayer.stop();
                }
            }
            
        });
        add(button);

        susPercentage = new JLabel(" x% ");
        susPercentage.setFont(new Font("Serif", Font.PLAIN, 100));
        add(susPercentage);

    }

    public static void main(String[] args){
        final JFXPanel fxPanel = new JFXPanel();
        mainGUI gui = new mainGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1500, 700);
        gui.setVisible(true);
        gui.setTitle("Suspicious person verifier");
    }
}
