package baseball;

import java.util.Scanner;

public class Baseball {
    public void play() {
        // 1. 랜덤 세자리 수 생성
        int[] randomThreeDigits = createRandomThreeDigits();

        // 2. 사용자 숫자 입력
        Scanner sc = new Scanner(System.in);
        int userGuessThreeDigits = guessThreeDigits(sc);
    }

    public int guessThreeDigits(Scanner scanner) {
        int userDigits = scanner.nextInt();

        return userDigits;
    }

    public int[] createRandomThreeDigits() {
        int[] threeDigits = new int[3];
        int minDigit = 0;
        int maxDigit = 9;

        for (int i = 0; i < threeDigits.length; i++) {
            threeDigits[i] = getRandomNumber(minDigit, maxDigit);
        }
        return threeDigits;
    }

    /*
    * origin source: https://www.baeldung.com/java-generating-random-numbers-in-range
    */
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
