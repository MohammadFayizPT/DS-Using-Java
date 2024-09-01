import java.io.*;

class File1 {
    public static void main(String args[]){
    try{
     BufferedWriter bw=new BufferedWriter(new FileWriter("fayiz.txt"));
     bw.write(67);
     bw.write("\n");
     bw.write("i am very scn");
     bw.write("\n");
     bw.write('b');
     bw.write("\n");
     bw.flush();
     bw.close();  
  
    FileReader fr=new FileReader("fayiz.txt");
    char ch=(char) fr.read();
    System.out.print(ch);
    while(ch!='\0'){
        ch=(char)fr.read();
       System.out.print(ch);
    }
 }
   catch(IOException e){}
}
}