import java.util.*;
public class Busrouteconnectivity {
    public static void main(String args[]) {
        int n = 4, m = 4;
        int a[] = {11, 22, 33, 44};
        int b[] = {55, 66, 33, 77};
        int src = 11, dest = 66;

        int srcidx = -1, destidx = -1;
        for (int i = 0; i < n; i++) {
            if (src == a[i]) {
                srcidx = i;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (dest == b[i]) {
                destidx = i;
                break;
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        int bcom = -1, acom = -1;
        int comm = -1;
        for (int i = 0; i < m; i++) {
            if (set.contains(b[i])) {
                bcom = i;
                comm = b[i];
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (comm == a[i]) {
                acom = i;
                break;
            }
        }

        if (srcidx <= acom && bcom <= destidx) {
            System.out.println("Yes.");
        } else {
            System.out.println("No.");
        }
    }
}