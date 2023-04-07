package org.example;//package org.example;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.concurrent.TimeUnit;
////tao 2 button tren cung 1 frame
//
//public class Main  {
//    private JFrame frame;
//    private JButton button1 = new JButton("click me");
//    private JButton button2 = new JButton("click me");
//    private JCheckBox checkBox = new JCheckBox("click to start");
//    private JPanel panel = new JPanel();
//    private boolean moved = false;
//    private int xPos =70;
//    private int yPos = 70;
//    private MyDraw draw = new MyDraw();
////    class frame1 implements ActionListener{
////        @Override
////        public void actionPerformed(ActionEvent e) {
////            button1.setText("I've been clicked");
////        }
////    }
////    class frame2 implements ActionListener{
////        public void actionPerformed(ActionEvent e) {
////            moved = true;
////        }
////    }
//    public void go()
//    {
//        frame = new JFrame();
//        panel.setBackground(Color.RED);
//        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        button1.addActionListener(e -> button1.setText("I've been clicked"));
//        button2.addActionListener(e -> button2.setText("I've been clicked"));
//        panel.add(button2);
//        panel.add(button1);
//        panel.add(checkBox);
//
//        frame.getContentPane().add(draw);
//        //move();
//        frame.getContentPane().add(BorderLayout.EAST,panel);
////        frame.getContentPane().add(BorderLayout.NORTH,button1);
////        frame.getContentPane().add(BorderLayout.SOUTH,button2);
//        frame.setSize(300,300);
//        frame.setVisible(true);
//    }
//    public void move()
//    {
//        for(int i=0;i<130;i++)
//        {
////            if(moved)
////            {
////                checkBox.addActionListener(e ->
////                        {
////                            checkBox.setText("click to start");
////                            moved = false;
////                        }
////                );
////            }
////            else
////            {
////                checkBox.addActionListener(e ->
////                        {
////                            checkBox.setText("click to stop");
////                            moved = true;
////                        }
////                );
////            }
//            //if(!moved) break;
//            xPos++;
//            yPos++;
//            //draw.repaint();
//            try{
//                TimeUnit.MICROSECONDS.sleep(50);
//            }catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }
//    public static void main(String[] args) {
//        Main gui = new Main();
//        gui.go();
//    }
//    class MyDraw extends JPanel{
//        public void paintComponent(Graphics g)
//        {
//            g.setColor(Color.BLUE);
//            g.fillOval(xPos,yPos,20,20);
//        }
//    }
//
//}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.concurrent.TimeUnit;
public class Main {
    private JCheckBox checkBox = new JCheckBox("click to start",false);
    private JPanel panel = new JPanel();
    private int xPos = 50;
    private int yPos = 100;
    private boolean moved = false;
    public static void main(String[] args) {
        Main gui = new Main();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawPanel drawPanel = new MyDrawPanel();
        panel.setBackground(Color.RED);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(checkBox);

        frame.getContentPane().add(BorderLayout.EAST,panel);
        frame.getContentPane().add(drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
        int a = 1;
        int b = 1;
        while (true){
            checkBox.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == 1) {
                        checkBox.setText("click to stop       ");
                        moved = true;
                    } else {
                        checkBox.setText("click to continue");
                        moved = false;
                    }
                }
            });
            if(moved)
            {
                xPos += a;
                yPos += b;
                if(xPos >= 300 - 20)
                {
                    a = -1;
                }
                if(xPos <= 50)
                {
                    a = 1;
                }
                if(yPos >= 300 - 20)
                {
                    b = -1;
                }
                if(yPos <= 50) {
                    b = 1;
                }
                drawPanel.repaint();
                try {
                    TimeUnit.MILLISECONDS.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.green);
            g.drawLine(50,50,300,50);
            g.drawLine(300,50,300,300);
            g.drawLine(300,300,50,300);
            g.drawLine(50,300,50,50);
            g.fillOval(xPos, yPos,   20, 20);
        }
    }
}