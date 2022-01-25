package utils;

public class Random {
    public static String getRandomNumber(int lenghtOfNumber) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lenghtOfNumber; i++) {
            sb.append(String.valueOf((int) (Math.random() * 9)));
        }

        return sb.toString();
    }

    public static String getRandomUserEmail() {
        return "myEmail" + getRandomNumber(10) + "@gmail.com";
    }
}
