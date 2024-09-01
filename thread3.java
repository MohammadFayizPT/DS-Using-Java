import java.util.*;
class One extends Thread {
    int x;
    public void run(){
        for(int i=0;i<10;i++){
            try{
                Thread.sleep(500);}
                catch(InterruptedException e){}
            Random r=new Random();
            int x=r.nextInt(15);

            if(x%2==0){
                Two tw=new Two(x);
                tw.start();
            }
            else{
                Three th=new Three(x);
                th.start();
            }
        }
      
    }

}
class  Two extends Thread{
    int x;
    Two(int x){
        this.x=x;
    }
    public void run(){
    System.out.println("square of" +x+"="+x*x);
}}
class Three extends Thread{
    int x;
    Three(int x){
        this.x=x;
    }
    public void run(){
        System.out.println("cube of "+x+"="+x*x*x);
    }
}
class Demo{
    public static void main(String args[]){
        One o=new One();
        o.start();
    }
}