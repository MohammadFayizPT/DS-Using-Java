import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class filesize_minsize {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size:");
        int n = sc.nextInt();
        ArrayList<Integer> file_size = new ArrayList<>();
        ArrayList<Integer> min_size = new ArrayList<>();
        
        System.out.println("Input element- file size and minimum size");
        for(int i = 0; i < n; i++) {
           file_size.add(sc.nextInt());
           min_size.add(sc.nextInt());
        }
        
        System.out.println("Minimum modifications required:");
        System.out.println(minModification(n, file_size, min_size));
    }

    public static int minModification(int n, ArrayList<Integer> file_size, ArrayList<Integer> min_size) {
        int min_modification = 0;
        ArrayList<Integer> difference = new ArrayList<>();
        ArrayList<Integer> lessthanzero = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int diff = file_size.get(i) - min_size.get(i);
            if(diff < 0) {
               min_modification ++;
               lessthanzero.add(diff);
            }
             
            difference.add(diff);
        }

        if(lessthanzero.size() == n)
         return -1;
        
        if(lessthanzero.size() > 0) {
         Collections.sort(difference);
         Collections.sort(lessthanzero);
         int j = 0;
         int i = difference.size() - 1;
         while(j < lessthanzero.size() && difference.get(i) > 0) {
            boolean isModified = false;
            if(difference.get(i) + lessthanzero.get(j) > 0) {
                if (!isModified) {
                    isModified = true;
                    min_modification++;
                }

                difference.set(i, difference.get(i) + lessthanzero.get(j));
                j++;
            } else {
                if (!isModified)
                 min_modification++;

                lessthanzero.set(j, lessthanzero.get(j) + difference.get(i));
                difference.set(i, 0);
                i--;
            }    
         }

        }
        return min_modification - 1;
    }
}
