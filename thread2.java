class Thread1 implements Runnable{
    public void run(){
        try{
            Thread.sleep(500);
        for(int i=0;i<10;i++){
            System.out.println("psg vs bayern");
        }}
        catch(InterruptedException e){
            System.out.println(e);
        }

    }
}
class Thread2 implements Runnable{
    public void run(){
        try{
            Thread.sleep(800);
        for(int i=0;i<10;i++){
            System.out.println("man united vs barcelona");
        }}
        catch(InterruptedException e){
            System.out.println(e);
        }

    }
}
class Demo{
    public static void main(String args[]){
    Thread1 t1=new Thread1();
    Thread th1=new Thread(t1);
    Thread2 t2=new Thread2();
    Thread th2=new Thread(t2);

    th1.start();
    th2.start();
    System.out.println("in main thread");
    System.out.println(th1.isAlive());
    System.out.println(th2.isAlive());

    }
}
