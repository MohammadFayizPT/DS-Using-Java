import java.io.*;
import java.util.*;
class File2 {
    public static void main(String arg[]) throws Exception{
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the file name:");
    String name=sc.nextLine();
    System.out.println("Enter the line of contents:");
    int n=sc.nextInt();
    PrintWriter pw=new PrintWriter(name); 
    System.out.println("Enter the contents of file:");
    pw.println(sc.nextLine()); 
    int i=0;
    while(i<n){
    pw.println(sc.nextLine());
     i++;
       }
    pw.flush();
    pw.close();
  //  String word[]=new String[20];
     int c=0;
    BufferedReader br=new BufferedReader(new FileReader(name));
    String str=br.readLine();
    while(str!=null){
       String word[]=str.split(" ");
       for(i=0;i<word.length;i++){
         if(word[i].equals("the")){
            c++;
         }
       }
        str=br.readLine();
    }
    br.close();
    System.out.println("count="+c);   

}}
