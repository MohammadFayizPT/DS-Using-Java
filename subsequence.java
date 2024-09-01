import java.util.*;
class subsequence {
    public static void main(String args[]) {
        String str = "dbca";
        fun(str);
    }

    public static void fun(String str) {
        int n = str.length();

        String res[] = new String[n];
        res[n - 1] = str.charAt(n - 1) + "";

        for (int i = n - 2; i >= 0; i--) {
            if (str.charAt(i) > res[i + 1].charAt(0)) {
                res[i] = str.substring(i, i + 1);
            } else {
                res[i] = str.charAt(i) + res[i + 1];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }

    }
}