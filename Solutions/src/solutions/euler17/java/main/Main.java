package solutions.euler17.java.main;

public class Main {

    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i <= 1000; i++) {
            sum += getLettersInNum(i);
        }
        System.out.println(sum);
    }

    public static int getLettersInNum(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1000) {
            return 11; // One thousand
        }
        switch(n) {
            case 1: return 3; // One
            case 2: return 3; // Two
            case 3: return 5; // Three
            case 4: return 4; // Four
            case 5: return 4; // Five
            case 6: return 3; // Six
            case 7: return 5; // Seven
            case 8: return 5; // Eight
            case 9: return 4; // Nine
            case 10: return 3; // Ten
            case 11: return 6; // Eleven
            case 12: return 6; // Twelve
            case 13: return 8; // Thirteen
            case 14: return 8; // Fourteen
            case 15: return 7; // Fifteen
            case 16: return 7; // Sixteen
            case 17: return 9; // Seventeen
            case 18: return 8; // Eighteen
            case 19: return 8; // Nineteen
            case 20: return 6; // Twenty
            case 30: return 6; // Thirty
            case 40: return 5; // Forty
            case 50: return 5; // Fifty
            case 60: return 5; // Sixty
            case 70: return 7; // Seventy
            case 80: return 6; // Eighty
            case 90: return 6; // Ninety
        }

        if(n < 100) {
            return getLettersInNum((n / 10) * 10) + getLettersInNum(n % 10);
        }
        if(n % 100 == 0) {
            return getLettersInNum(n / 100) + "hundred".length();
        }
        return getLettersInNum(n / 100) + "hundredand".length() + getLettersInNum(n % 100);
    }
}
