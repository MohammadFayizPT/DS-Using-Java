 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.util.*;
 import java.io.*;
 
 interface Stack {
    void push() throws CustomException;
    void pop() throws CustomException;
}

class IntegerStack implements Stack{

    int arr[]=new int[30];
    int stack[]=new int[30];
    int top=-1,n;
    Scanner sc=new Scanner(System.in);
     
    IntegerStack(int x){
        System.out.println("input size");
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            arr[i]=x;
        }
    }

   public void push() throws CustomException{
    if(top==n-1){
    System.out.println("Stack overflow");
    throw new CustomException("invalid");
       }
    else{
        for(int i=0;i<n;i++){
        top++;
        stack[top]=arr[i];
    }
}
   }

   public void pop() throws CustomException{
    if(top==-1){
        System.out.println("stack underflow");
        throw new CustomException("invalid");}
        else{
            top--;
            System.out.println("popped element:"+stack[top+1]);
        }
   }
}

class CharacterStack implements Stack{
    char ch[]= new char[30];
    char stack[]=new char[30];
    int top=-1,n;
    Scanner sc=new Scanner(System.in);
  
    CharacterStack(String c){
        System.out.println("input size");
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            ch[i]=c;
        }
    }

    public void push() throws CustomException{
        if(top==n-1){       
        System.out.println("Stack overflow");
        throw new CustomException("invalid");
    }
        else{
            for(int i=0;i<n;i++){
            top++;
            stack[top]=ch[i];
        }
    }

}
     public void pop() throws CustomException{
        if(top==-1){
        System.out.println("stack underflow");
        throw new CustomException("invalid");
            }
        else{
            top--;
            System.out.println("popped element:"+stack[top+1]);
        }
     }
}

class CustomException extends Exception{
    CustomException(String msg){
        super(msg);
    }
}

class Gui extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField t1,t2;
    JButton ps;
   
     Gui(){
        super("gui");
        setSize(200,200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);
        setVisible(true);

        l1=new JLabel("integer:");
        add(l1);
        t1=new JTextField(10);
        add(t1);

        l2=new JLabel("character");
        add(l2);
        t2=new JTextField(10);
        add(t2);

        ps=new JButton("pass");
        add(ps);

        ps.addActionListener(this);
     }

     public void actionPerformed(ActionEvent e){
        if(e.getSource()==ps){
        
         IntegerStack is= new IntegerStack(Integer.parseInt(t1.getText()));
         CharacterStack cs=new CharacterStack(Character.parseChar(t2.getText()));
        }
     }
}