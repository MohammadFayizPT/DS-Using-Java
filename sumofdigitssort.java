import java.util.*;

public class sumofdigitssort {
    public static void main(String a[]) {
        Integer ar[] = {21, 11, 41, 76};

        Arrays.sort(ar, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return sumofdigits(a) - sumofdigits(b);
            }
        });

        for (Integer num : ar)
        System.out.println(num);
    }

    public static int sumofdigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
