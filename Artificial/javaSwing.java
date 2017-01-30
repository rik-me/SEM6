import java.awt.event.*;
import javax.swing.*;
public class javaSwing {
    int counter=0;
    JFrame f ;
    JButton inc ;
    JButton dec ;
    JButton showButton;
    JButton showHello;
    JLabel hello;
    public javaSwing () {
        f = new JFrame("Hello World");
        f.setSize(800,600);
        //f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        showHello = new JButton("Click");
        showHello.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                hello.setText("Hello World Printed "+String.valueOf(++counter)+" times");
            }
        });
        showHello.setBounds(500,100,100,50);

        hello = new JLabel("Hello World",JLabel.CENTER);
        //hello.setOpaque(true);

        showButton = new JButton(String.valueOf(counter));
        showButton.setBounds(100,200,100,50);

        inc = new JButton("inc");
        inc.setBounds(100,100,100,50);//x,y,width,height
        inc.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                showButton.setText(String.valueOf(++counter));
            } 
        });

        dec = new JButton("dec");
        dec.setBounds(250,100,100,50);//x,y,width,height
        dec.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                showButton.setText(String.valueOf(--counter));
            } 
        });


        //f.add(inc);
        //f.add(dec);
        //f.add(showButton);
        f.add(showHello);
        f.add(hello);
    }
    public static void main(String[] args){
        new javaSwing();
    }
}