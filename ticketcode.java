public class ticketcode {
    public static void main(String args[]) {
        int n = 4;

        String res = "A";
        
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            char prevchar = res.charAt(0);

            for (int j = 1; j < res.length(); j++) {
                char currchar = res.charAt(j);
                if (prevchar == currchar) {
                    cnt++;
                } else {
                    sb.append(cnt).append(prevchar);
                    cnt = 1;
                    prevchar = currchar;
                }
            }
            sb.append(cnt).append(prevchar);
            res = sb.toString();
        }

        System.out.println(res);
    }
}