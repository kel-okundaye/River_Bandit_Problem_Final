import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame {
    private JFrame frame;
    private JPanel panel;
    private Box box;
    private ImageIcon backgroundImage = new ImageIcon("Ports.png"); // Ensure the image path is correct

    public MyFrame() {
        frame = new JFrame("The River Bandit Problem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(new Dimension(890, 690));
        frame.setLayout(new BorderLayout()); // Set BorderLayout for JFrame

        // Set the background label
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BoxLayout(backgroundLabel, BoxLayout.Y_AXIS));
        backgroundLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        // Initialize and setup the panel with a transparent background
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 400));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        // Set the panel's border
        Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border blackLine = BorderFactory.createTitledBorder(loweredetched, "The River Bandit Problem");
        panel.setBorder(blackLine);
        ((javax.swing.border.TitledBorder) panel.getBorder()).setTitleFont(new Font("Arial", Font.ITALIC, 30));

        // Add the panel to the background label
        backgroundLabel.add(Box.createVerticalGlue());
        backgroundLabel.add(panel);
        backgroundLabel.add(Box.createVerticalGlue());

        // Add the background label to the frame
        frame.add(backgroundLabel, BorderLayout.CENTER);

        // Add input fields and labels for the start state
        JTextField field1 = addInputLabel("How many bandits are on the left?", "3");
        JTextField field2 = addInputLabel("How many bandits are on the right?", "0");
        JTextField field3 = addInputLabel("How many merchants are on the left?", "0");
        JTextField field4 = addInputLabel("How many merchants are on the right?", "3");

        // Add space
        panel.add(new JLabel(" "));

        // Add input fields and labels for the goal state
        JTextField goalField1 = addInputLabel("How many bandits should be on the left?", "0");
        JTextField goalField2 = addInputLabel("How many bandits should be on the right?", "3");
        JTextField goalField3 = addInputLabel("How many merchants should be on the left?", "3");
        JTextField goalField4 = addInputLabel("How many merchants should be on the right?", "0");

        JButton aButton = new JButton("SOLUTION");
        aButton.setPreferredSize(new Dimension(50, 50));
        panel.add(aButton);

        aButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("SOLUTION button clicked. Calculating solution...");
                try {

                    int inputBanditLeft = Integer.parseInt(field1.getText());
                    int inputBanditRight = Integer.parseInt(field2.getText());
                    int inputMerchantsLeft = Integer.parseInt(field3.getText());
                    int inputMerchantsRight = Integer.parseInt(field4.getText());

                    int goalBanditLeft = Integer.parseInt(goalField1.getText());
                    int goalBanditRight = Integer.parseInt(goalField2.getText());
                    int goalMerchantsLeft = Integer.parseInt(goalField3.getText());
                    int goalMerchantsRight = Integer.parseInt(goalField4.getText());

                    Node startNode = new Node(inputBanditLeft, inputBanditRight, inputMerchantsLeft, inputMerchantsRight, true); // Assume boat starts on the left
                    Node goalNode = new Node(goalBanditLeft, goalBanditRight, goalMerchantsLeft, goalMerchantsRight, true); // Goal state boat position doesn't affect logic

                    StringBuilder solution = Main.constructTree_(startNode, goalNode);
                    JOptionPane.showMessageDialog(null, solution.toString(), "Solution", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Make sure you've entered valid numerical values", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private JTextField addInputLabel(String labelText, String defaultValue) {
        JLabel label = new JLabel(labelText);
        label.setBackground(new Color(255, 155, 155, 178));
        label.setOpaque(true);
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(label);

        JTextField textField = new JTextField(defaultValue);
        textField.setPreferredSize(new Dimension(20, 20));
        panel.add(textField);

        return textField;
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}