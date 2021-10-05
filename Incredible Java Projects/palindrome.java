package savuckovi;

public class palindrome {

    public static void main(String[] args) {

        System.out.print("Enter the text to check if it is palindrome: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine(); 

        System.out.println(" Is text a palindrome: " + isPalindrome(text));

    }

    public static boolean isPalindrome(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        int length = clean.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
    return true;
    }
}
