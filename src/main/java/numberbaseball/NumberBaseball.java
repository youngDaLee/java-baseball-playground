package numberbaseball;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberBaseball {
    private static List<String> numList = IntStream.range(1,9)
            .mapToObj(i -> String.valueOf(i))
            .collect(Collectors.toList());
    private static String comNumber;
    private static Scanner sc = new Scanner(System.in);

    private static void initComNumber(){
        comNumber = "";
        Collections.shuffle(numList);
        for (int i=0; i<3; i++) {
            comNumber += numList.get(i);
        }
    }

    private static int isBall(char ch, int i){
        if (comNumber.charAt(i) != ch && comNumber.contains(String.valueOf(ch))) {
            return 1;
        }
        return 0;
    }

    private static int isStrike(char ch, int i) {
        if (comNumber.charAt(i) == ch) {
            return 1;
        }
        return 0;
    }

    private static void printResult(int ball, int strike) {
        String resString = "";
        if (ball > 0) {
            resString += ball + "볼 ";
        }
        if (strike > 0) {
            resString += strike + "스트라이크";
        }
        System.out.println(resString);
    }

    public static boolean isGameWin(String num) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            ball += isBall(num.charAt(i), i);
            strike += isStrike(num.charAt(i), i);
        }

        printResult(ball, strike);

        if (strike == 3) {
            return true;
        }
        return false;
    }

    public static void numberBaseball() {
        initComNumber();

        boolean game = true;
        while (game) {
            String num = sc.next("숫자를 입력해 주세요 : ");
            game = isGameWin(num);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void main(){
        while (true) {
            numberBaseball();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int isBreak = sc.nextInt();
            if (isBreak == 2){
                break;
            }
        }
    }
}
