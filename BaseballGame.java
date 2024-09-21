package baseballgame;
import java.util.*;

public class BaseballGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
        System.out.println("1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기");

        while (true) {
            String option = scanner.nextLine();

            if (option.equals("1")) {
                startGame(scanner);
            } else if (option.equals("3")) {
                System.out.println("게임을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 1, 2, 3 중 하나를 선택해주세요.");
            }
        }
    }

    private static void startGame(Scanner scanner) {
        System.out.println("< 게임을 시작합니다 >");

        // 랜덤한 정답 숫자 생성
        List<Integer> answer = generateAnswer();

        while (true) {
            System.out.println("숫자를 입력하세요");
            String input = scanner.nextLine();

            // 입력값 검증
            if (!isValidInput(input)) {
                System.out.println("올바르지 않은 입력값입니다");
                continue;
            }

            // 스트라이크와 볼 계산
            List<Integer> inputNumbers = parseInput(input);
            int[] result = checkAnswer(inputNumbers, answer);

            int strikes = result[0];
            int balls = result[1];

            // 결과 출력
            if (strikes == 3) {
                System.out.println("정답입니다!");
                System.out.println("1. 계속하기 2. 게임 기록 보기 3. 종료하기");
                break;
            } else if (strikes == 0 && balls == 0) {
                System.out.println("아웃");
            } else {
                System.out.printf("%d스트라이크 %d볼\n", strikes, balls);
            }
        }
    }

    // 랜덤한 3자리 숫자 생성
    private static List<Integer> generateAnswer() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 3);
    }

    // 입력값이 올바른지 확인 (3자리, 중복 없음, 숫자만)
    private static boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }

        HashSet<Character> digits = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch) || ch == '0') { // 0 제외
                return false;
            }
            digits.add(ch);
        }

        return digits.size() == 3; // 중복 없을 때만 true
    }

    // 입력값을 숫자 리스트로 변환
    private static List<Integer> parseInput(String input) {
        List<Integer> inputNumbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            inputNumbers.add(Character.getNumericValue(ch));
        }
        return inputNumbers;
    }

    // 정답과 입력값을 비교하여 스트라이크와 볼 계산
    private static int[] checkAnswer(List<Integer> inputNumbers, List<Integer> answer) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (inputNumbers.get(i).equals(answer.get(i))) {
                strikes++;
            } else if (answer.contains(inputNumbers.get(i))) {
                balls++;
            }
        }

        return new int[]{strikes, balls};
    }
}
