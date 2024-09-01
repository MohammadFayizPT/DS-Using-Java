public class fvrtsongs {
    public static void main(String args[]) {
        String s = "abbaacaaancanar";
        int k = 4;
        int left = 0;
        int right = 0;
        int cnt = 0, maxcnt = 0, ptr = 0;
        while (right < s.length()) {
            if (s.charAt(right) == 'a') {
                cnt++;
            }

            if (right - left + 1 == k) {
                if (maxcnt < cnt) {
                    maxcnt = cnt;
                    ptr = left;
                }
                if (s.charAt(left) == 'a') {
                    cnt--;
                }
                left++;
            }
            right++;
        }

        System.out.println(s.substring(ptr, ptr + k));
    }
}
