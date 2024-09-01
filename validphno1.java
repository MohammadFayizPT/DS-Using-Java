import java.util.Scanner;

public class PhoneNumberValidator {
    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Remove all spaces from the phone number
        phoneNumber = phoneNumber.replaceAll("\\s", "");

        // Check if the number starts with +91, 0, 7, 8, or 9
        if (!phoneNumber.startsWith("+91") && !phoneNumber.startsWith("0") && !phoneNumber.startsWith("7") && !phoneNumber.startsWith("8") && !phoneNumber.startsWith("9")) {
            return false;
        }

        // Remove the prefix (+91 or 0)
        if (phoneNumber.startsWith("+91")) {
            phoneNumber = phoneNumber.substring(3);
        } else if (phoneNumber.startsWith("0")) {
            phoneNumber = phoneNumber.substring(1);
        }

        // Check if the remaining number contains only digits and is of length 10
        if (phoneNumber.length() != 10) {
            return false;
        }
        for (char c : phoneNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String phoneNumber = scanner.nextLine();
            System.out.println(isValidPhoneNumber(phoneNumber));
        }
    }
}