public class emailvalidation {
    public static void main(String args[]) {
        int n = 7;
        String emails[] = {
            "abc784@gmail.com",
            "af",
            "5653@-jf.in",
            "eufhue@jfj",
            "fejfe@efehf.gif",
            "user@.com",
            "user.name@example.com"
        };

        for (int i = 0; i < n; i++) {
            String email = emails[i];
            int flag = 0;
            if (email.indexOf("@") == -1) {
                System.out.println("false");
                continue;
            }

            String parts[] = email.split("@");
            if (parts[0].charAt(0) == '.' || parts[0].charAt(parts[0].length() - 1) == '.') {
                System.out.println("false");
                continue;
            }

            if (parts[1].indexOf(".") == -1) {
                System.out.println("false");
                continue;
            }

            if (parts[1].charAt(0) == '.' || parts[1].charAt(parts[1].length() - 1) == '.' || parts[1].charAt(0) == '-') {
                System.out.println("false");
                continue;
            }

            for (int j = 1; j < parts[0].length() - 1; j++) {
                char ch = parts[0].charAt(j);
                char ch_r = parts[0].charAt(j + 1);

                if (ch == '.' && ch_r == '.') {
                    flag = 1;
                    break;
                } else if (ch == '(' || ch == ')') {
                    flag = 1;
                    break;
                } 
            }

            if (flag == 1) {
                System.out.println("false");
                continue;
            }

            System.out.println("true"); 
        }

    }
}