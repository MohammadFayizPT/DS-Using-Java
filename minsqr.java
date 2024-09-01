import java.util.*;
public class minsqr {
    public static void main(String args[]) {
        int n = 80;
        int sqr = 0;
        int temp = n;
        int cnt = 0;
        while (temp > 0) {
            cnt++;
            sqr = (int)Math.floor(Math.sqrt(temp));
            temp -= (sqr * sqr);
        }

        System.out.println(cnt);
    }
}
