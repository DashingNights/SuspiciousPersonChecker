import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainGUI extends JFrame {

    private JLabel label;
    private JTextField textField;
    private JLabel susPercentage;
    private JButton button;

    public mainGUI(){

        setLayout(new FlowLayout());


        label = new JLabel("Who sus???? ");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
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
                susPercentage.setText(percentage + "%");
                if(percentage > 50 || percentage == 50) {
                    label.setText(name + " is sussy");
                } else {
                    label.setText(name + " is not sus");

                }
            }
        });
        add(button);
        susPercentage = new JLabel(" x% ");
        susPercentage.setFont(new Font("Serif", Font.PLAIN, 40));
        add(susPercentage);
    }
    public static void main(String[] args){
        mainGUI gui = new mainGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(255, 300);
        gui.setVisible(true);
        gui.setTitle("Suspicious person verifier");
        gui.setResizable(false);
    }
}

