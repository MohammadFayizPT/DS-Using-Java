 import javax.swing.*;
 import java.awt.*;
 import java.io.*;
 import java.awt.event.*;
 
 class Employee {
    String emp_name;
    long emp_id,mob_no;
    String address;

    Employee(String emp_name,long emp_id,long mob_no,String address){
        this.emp_name=emp_name;
        this.emp_id=emp_id;
        this.mob_no=mob_no;
        this.address=address;
    }
}

class Associate_Professor extends Employee{
    int basic_pay;
    double DA,HRA,PF,staff_fund;

    Associate_Professor(String name,long id,long no,String add,int basic_pay) {
        super(name,id,no,add);
        this.basic_pay=basic_pay;
        DA=0.97*basic_pay;
        HRA=0.1*basic_pay;
        PF=0.12*basic_pay;
        staff_fund=0.001*basic_pay;
      
    }
  
    public void check()throws Negative_Value_Exception{
    if(basic_pay<0){
        throw new Negative_Value_Exception("invalid basic_pay");
    }

}
}

class Professor extends Employee{
   int basic_pay;
   double DA,HRA,PF,staff_fund;

    Professor(String name,long id,long no,String add,int basic_pay){
        super(name,id,no,add);
        this.basic_pay=basic_pay;
        DA=0.95*basic_pay;
        HRA=0.08*basic_pay;
        PF=0.1*basic_pay;
        staff_fund=0.0005*basic_pay;

    }

    public void check() throws Negative_Value_Exception{
    if(basic_pay<0){
        throw new Negative_Value_Exception("invalid basic_pay");
    }
} 
}

class Gui extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton sb;

    Gui(){
        super("Gui");
        setSize(500,500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        l1=new JLabel("name:");
        add(l1);
        t1=new JTextField(20);
        add(t1);

        l6=new JLabel("designaion:");
        add(l6);
        t6=new JTextField(20);
        add(t6);

        l2=new JLabel("id:");
        add(l2);
        t2=new JTextField(20);
        add(t2);

        l3=new JLabel("mob_no:");
        add(l3);
        t3=new JTextField(20);
        add(t3);

        l4=new JLabel("address:");
        add(l4);
        t4=new JTextField(20);
        add(t4);

        l5=new JLabel("basic_pay:");
        add(l5);
        t5=new JTextField(20);
        add(t5);

        sb=new JButton("submit");
        add(sb);

        sb.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sb){
            if(t6.getText().equalsIgnoreCase("associate professor")){

           Associate_Professor ap= new Associate_Professor(t1.getText(),Long.parseLong(t2.getText()),Long.parseLong(t3.getText()),t4.getText(),Integer.parseInt(t5.getText()));
            try{ ap.check();}catch(Negative_Value_Exception nv){}

            try{
              FileWriter fw=new FileWriter("file1.txt",true);
              fw.write(ap.emp_name);
              fw.write("\n");
              fw.write(String.valueOf(ap.emp_id));
              fw.write("\n");
              fw.write(String.valueOf(ap.mob_no));
              fw.write("\n");
              fw.write(t6.getText());
              fw.write("\n");
              fw.write(ap.address);
              fw.write("\n");
              fw.write(String.valueOf(ap.DA+ap.HRA+ap.PF+ap.basic_pay+ap.staff_fund));
              fw.write("\n");

              fw.flush();
              fw.close();

              BufferedReader br=new BufferedReader(new FileReader("file1.txt"));
              String str=br.readLine();
              PrintWriter pw1=new PrintWriter("file2.txt");

              while(str!=null){  
               pw1.println(str);
                str=br.readLine();
              }
              br.close();
              pw1.flush();
              pw1.close();

            }
            catch(IOException ie){}

        }

        if(t6.getText().equalsIgnoreCase("professor")){

            Professor p=new Professor(t1.getText(),Long.parseLong(t2.getText()),Long.parseLong(t3.getText()),t4.getText(),Integer.parseInt(t5.getText()));
            try{ p.check();}catch(Negative_Value_Exception nv){}

            try{
                FileWriter fw=new FileWriter("file1.txt",true);
                fw.write(p.emp_name);
                fw.write("\n");
                fw.write(String.valueOf(p.emp_id));
                fw.write("\n");
                fw.write(String.valueOf(p.mob_no));
                fw.write("\n");
                fw.write(t6.getText());
                fw.write("\n");
                fw.write(p.address);
                fw.write("\n");
                fw.write(String.valueOf(p.DA+p.HRA+p.PF+p.basic_pay+p.staff_fund));
                fw.write("\n");
  
                fw.flush();
                fw.close();

                BufferedReader br=new BufferedReader(new FileReader("file1.txt"));
                String str=br.readLine();
                PrintWriter pw1=new PrintWriter("file2.txt");
  
                while(str!=null){  
                 pw1.println(str);
                  str=br.readLine();
                }
                br.close();
                pw1.flush();
                pw1.close();
              }
              catch(IOException ie){}
        }
     }
    }
}

class Demo{
    public static void main(String args[]){
        new Gui();
    }

}

class Negative_Value_Exception extends Exception{
     Negative_Value_Exception(String msg){
        super(msg);
     }
}