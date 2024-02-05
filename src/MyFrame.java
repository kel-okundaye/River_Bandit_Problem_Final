import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class MyFrame{
    JFrame frame;
    JPanel panel;
    Box box;
    ImageIcon backgroundImage = new ImageIcon("Ports.png");
    public MyFrame(){
        frame =  new JFrame();
        frame.pack();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

//        frame.getContentPane().setBackground(Color.blue);


        frame.setContentPane(new JLabel(backgroundImage));
        frame.pack();
        frame.setVisible(true);


        frame.setSize(new Dimension(890,690));


        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));





        panel = new JPanel();


        panel.setPreferredSize(new Dimension(600,400));
        panel.setMaximumSize(new Dimension(600,400));
        panel.setMinimumSize(new Dimension(600,400));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBackground(new Color(245, 138, 8, 100));
        panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        Border loweredetched;
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border blackLine = BorderFactory.createTitledBorder(loweredetched, "The River Bandit Problem");

        panel.setBorder(blackLine);

        ((javax.swing.border.TitledBorder) panel.getBorder()).
                setTitleFont(new Font("Arial", Font.ITALIC, 30));




        box = new Box(BoxLayout.X_AXIS);
        box.add(Box.createVerticalGlue());
        box.add(panel);
        box.add(Box.createVerticalGlue());
        frame.add(box);


        JLabel prompt1 = new JLabel("How many bandits are on the left?");
        prompt1.setBackground(new Color(255, 155, 155, 178));
        prompt1.setOpaque(true);
        prompt1.setFont(new Font("Arial", 0, 15));
        panel.add(prompt1);

        JTextField field1 = new JTextField();
        field1.setText("3");
        field1.setPreferredSize(new Dimension(20,20));
        panel.add(field1);



        JLabel prompt2 = new JLabel("How many bandits are on the right?");
        prompt2.setBackground(new Color(255, 155, 155, 178));
        prompt2.setOpaque(true);
        prompt2.setFont(new Font("Arial", 0, 15));
        panel.add(prompt2);

        JTextField field2 = new JTextField();
        field2.setText("0");
        panel.add(field2);




        JLabel prompt3 = new JLabel("How many merchants are on the left?");
        prompt3.setBackground(new Color(255, 155, 155, 178));
        prompt3.setOpaque(true);
        prompt3.setFont(new Font("Arial", 0, 15));
        panel.add(prompt3);

        JTextField field3 = new JTextField();
        field3.setText("0");
        panel.add(field3);

        JLabel prompt4 = new JLabel("How many merchants are on the right?");
        prompt4.setBackground(new Color(255, 155, 155, 178));
        prompt4.setOpaque(true);
        prompt4.setFont(new Font("Arial", 0, 15));
        panel.add(prompt4);

        JTextField field4 = new JTextField();
        field4.setText("3");
        panel.add(field4);

        JLabel Space = new JLabel("\n");
        panel.add(Space);


        JLabel goal1 = new JLabel("How many bandits should be on the left?");
        goal1.setBackground(new Color(149, 224, 138, 181));
        goal1.setOpaque(true);
        goal1.setFont(new Font("Arial", 0, 15));
        panel.add(goal1);

        JTextField goalField1 = new JTextField();
        goalField1.setText("0");
        panel.add(goalField1);



        JLabel goal2 = new JLabel("How many bandits should be on the right?");
        goal2.setBackground(new Color(149, 224, 138, 181));
        goal2.setOpaque(true);
        goal2.setFont(new Font("Arial", 0, 15));
        panel.add(goal2);

        JTextField goalField2 = new JTextField();
        goalField2.setText("3");
        panel.add(goalField2);




        JLabel goal3 = new JLabel("How many merchants should be on the left?");
        goal3.setBackground(new Color(149, 224, 138, 181));
        goal3.setOpaque(true);
        goal3.setFont(new Font("Arial", 0, 15));
        panel.add(goal3);

        JTextField goalField3 = new JTextField();
        goalField3.setText("3");
        panel.add(goalField3);



        JLabel goal4 = new JLabel("How many merchants should be on the right?");
        goal4.setBackground(new Color(149, 224, 138, 181));
        goal4.setOpaque(true);
        goal4.setFont(new Font("Arial", 0, 15));
        panel.add(goal4);

        JTextField goalField4 = new JTextField();
        goalField4.setText("0");
        panel.add(goalField4);


        JButton aButton = new JButton("SOLUTION");
//        aButton.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.blue));
        aButton.setPreferredSize(new Dimension(50,50));
        panel.add(aButton);

        aButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            try {
                Integer inputBanditLeft = Integer.parseInt(field1.getText());
                Integer inputBanditRight = Integer.parseInt(field2.getText());
                Integer inputMerchantsLeft = Integer.parseInt(field3.getText());
                Integer inputMerchantsRight = Integer.parseInt(field4.getText());

                Integer goalBanditLeft = Integer.parseInt(goalField1.getText());
                Integer goalBanditRight = Integer.parseInt(goalField2.getText());
                Integer goalMerchantsLeft = Integer.parseInt(goalField3.getText());
                Integer goalMerchantsRight = Integer.parseInt(goalField4.getText());

                ArrayList<Integer> tempList = new ArrayList<Integer>();
                tempList.add(inputBanditLeft);
                tempList.add(inputBanditRight);
                tempList.add(inputMerchantsLeft);
                tempList.add(inputMerchantsRight);

                tempList.add(goalBanditLeft);
                tempList.add(goalBanditRight);
                tempList.add(goalMerchantsLeft);
                tempList.add(goalMerchantsRight);

                Integer ifMoreThanOneTheFalse = 0;
                Integer inputTotal = inputBanditLeft+inputBanditRight+inputMerchantsLeft+inputMerchantsRight;
                Integer goalTotal = goalBanditLeft + goalBanditRight+goalMerchantsLeft+goalMerchantsRight;

                for(Integer i:tempList){
                    if((i>=0)&&(inputTotal==goalTotal)){

                    }
                    else if(!(i>=0)){
                        ifMoreThanOneTheFalse = ifMoreThanOneTheFalse+1;
                    }
                    else if((goalMerchantsLeft==goalBanditLeft)){
                        ifMoreThanOneTheFalse = ifMoreThanOneTheFalse+1;
                    }
                    else{
                        ifMoreThanOneTheFalse = ifMoreThanOneTheFalse+1;
                    }
                }

                if(ifMoreThanOneTheFalse == 0){
                    Node newNode = new Node(inputBanditLeft,inputBanditRight,inputMerchantsLeft,inputMerchantsRight,true);
                    Node goalNode = new Node(goalBanditLeft,goalBanditRight,goalMerchantsLeft,goalMerchantsRight,true);

                    StringBuilder theAnswer = Main.constructTree_(newNode,goalNode);
                    JOptionPane.showMessageDialog(null, theAnswer,"Solution", JOptionPane.INFORMATION_MESSAGE);
//                    System.out.println(Main.constructTree_(newNode,goalNode));
                }
                else{
                    JOptionPane.showMessageDialog(null, "There aren't an equal amount of people in your starting and expected group","Error", JOptionPane.ERROR_MESSAGE);
                }




            }
            catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Make sure you've entered valid numerical values","Error", JOptionPane.ERROR_MESSAGE);
            }






            }
        });





        frame.setVisible(true);

    }


    public static void main(String[] args) {

        new MyFrame();
    }

