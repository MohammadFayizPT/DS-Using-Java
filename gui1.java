import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
class One extends JFrame implements ActionListener
  {
    JLabel l1,l2,l3,l4;
    JTextField t1,t2;
    JComboBox c4;
    JRadioButton rm,rf;
    JButton b;
    One(){
        super("GUI");
        setSize(300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);

        l1=new JLabel("name:");
        add(l1);
        l1.setBounds(100,40,60,30);
        t1=new JTextField(20);
        add(t1);
        t1.setBounds(165,40,100,30);

        l2=new JLabel("age:");
        add(l2);
        l2.setBounds(100,80,60,30);
        t2=new JTextField(6);
        add(t2);
        t2.setBounds(165,80,60,30);

        l3=new JLabel("gender:");
        add(l3);
        l3.setBounds(100,120,60,30);
        rm=new JRadioButton("male");
        add(rm);
        rm.setBounds(170,120,40,20);
        rf=new JRadioButton("female");
        add(rf);
        rf.setBounds(210,120,40,20);
        ButtonGroup bg=new ButtonGroup();
        bg.add(rm);
        bg.add(rf);
         
        l4=new JLabel("branch");
        add(l4);
        l4.setBounds(100,150,60,30);
        String bra[]={"cse","eee","ece","mech"};
        c4=new JComboBox<>(bra);
        add(c4);
        c4.setBounds(170,150,50,20);

        b=new JButton("submit");
        add(b);
        b.addActionListener((ActionListener) this);
        b.setBounds(200,180,60,30);
       
    }

    public void actionPerformed(ActionEvent e){
         if(e.getSource()==b){
            try{
                PrintWriter pw=new PrintWriter("reg.txt");
                pw.println(t1.getText());
                pw.println(t2.getText());
                if(rm.isSelected()){
                    pw.println("male");
                }
                if(rf.isSelected()){
                    pw.println("female");
                }
                pw.println(c4.getSelectedItem());
                pw.flush();
                pw.close();
            }
            catch(IOException io){
                System.out.println(io);
            }
         }
    }
}

class Demo{
    public static void main(String args[]){
        new One();
    }
}