import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class Sample{
    String name,country,ssn;
    Sample(String name,String country,String ssn){
        this.name=name;
        this.country=country;
        this.ssn=ssn;
    }

    public boolean isValid(){
      if(ssn.length()==11 && ssn.charAt(3)=='-' && ssn.charAt(6)=='-'){
        return true;
      }
      else{
        return false;
      }
    }
}

class gui extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JButton sb;

    gui(){
        setTitle("gui");
        setSize(300,300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);
        setVisible(true);

        l1=new JLabel("name:");
        add(l1);
        t1=new JTextField(15);
        add(t1);

       
        l2=new JLabel("country:");
        add(l2);
        t2=new JTextField(15);
        add(t2);

        
        l3=new JLabel("ssn:");
        add(l3);
        t3=new JTextField(15);
        add(t3);

        sb=new JButton("submit");
        add(sb);

        sb.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==sb){
            Sample sam=new Sample(t1.getText(),t2.getText(),t3.getText());

            if(sam.isValid()==true){
                try{
                  FileWriter fw=new FileWriter("ssn.txt",true);
                  fw.write(sam.name);
                  fw.write("\n");
                  fw.write(sam.country);
                  fw.write("\n");
                  fw.write(sam.ssn);
                  fw.write("\n");
                  fw.flush();
                  fw.close();
                }
                catch(IOException io){}
            }
            else{
                try {
                    throw new SocSeException("invalid ssn");
                } catch (SocSeException e1) {
                  e1.printStackTrace();
                }
            }
        }
    }
}
class SocSeException extends Exception{
    SocSeException(String mg){
        super(mg);
    }
}
class Demo{
    public static void main(String ar[]){
      new gui();
    }
}