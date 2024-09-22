package baseballgame;
import java.util.*;

public class BaseballGame {

    private static List<Integer> answer;
    private static int attemptCount;
    private static List<Integer> gameRecords = new ArrayList<>();
    private static int digitCount = 3; // 기본 자리수는 3자리

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("0. 자리수 설정  1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기");

            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    setDifficulty(scanner);
                    break;
                case "1":
                    startGame(scanner);
                    break;
                case "2":
                    showGameRecords();
                    break;
                case "3":
                    System.out.println("< 숫자 야구 게임을 종료합니다 >");
                    return;
                default:
                    System.out.println("올바른 숫자를 입력해주세요!");
            }
        }
    }

    // 게임 난이도 설정
    private static void setDifficulty(Scanner scanner) {
        System.out.println("설정하고자 하는 자리수를 입력하세요. (3, 4, 5)");
        String input = scanner.nextLine();

        try {
            int difficulty = Integer.parseInt(input);
            if (difficulty >= 3 && difficulty <= 5) {
                digitCount = difficulty;
                System.out.printf("%d자리수 난이도로 설정되었습니다.\n", digitCount);
            } else {
                System.out.println("올바른 난이도를 입력해주세요. (3, 4, 5)");
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
        }
    }

    // 게임 시작
    private static void startGame(Scanner scanner) {
        System.out.println("< 게임을 시작합니다 >");
        answer = generateAnswer(digitCount);
        attemptCount = 0;

        while (true) {
            System.out.println("숫자를 입력하세요");
            String input = scanner.nextLine();

            // 입력값 검증
            if (!isValidInput(input)) {
                System.out.println("올바르지 않은 입력값입니다");
                continue;
            }

            attemptCount++;
            List<Integer> inputNumbers = parseInput(input);
            int[] result = checkAnswer(inputNumbers, answer);

            int strikes = result[0];
            int balls = result[1];

            // 결과 출력
            if (strikes == digitCount) {
                System.out.println("정답입니다!");
                System.out.printf("총 시도 횟수: %d\n", attemptCount);
                gameRecords.add(attemptCount);
                System.out.println("1. 계속하기 2. 게임 기록 보기 3. 종료하기");
                String nextOption = scanner.nextLine();

                if (nextOption.equals("1")) {
                    startGame(scanner); // 다시 시작
                } else if (nextOption.equals("2")) {
                    showGameRecords();
                } else if (nextOption.equals("3")) {
                    System.out.println("< 숫자 야구 게임을 종료합니다 >");
                    return;
                }
                break;
            } else if (strikes == 0 && balls == 0) {
                System.out.println("아웃");
            } else {
                System.out.printf("%d스트라이크 %d볼\n", strikes, balls);
            }
        }
    }

    // 게임 기록 보기
    private static void showGameRecords() {
        if (gameRecords.isEmpty()) {
            System.out.println("아직 게임 기록이 없습니다.");
        } else {
            System.out.println("< 게임 기록 보기 >");
            for (int i = 0; i < gameRecords.size(); i++) {
                System.out.printf("%d번째 게임: 시도 횟수 - %d\n", i + 1, gameRecords.get(i));
            }
        }
    }

    // 랜덤한 숫자 생성
    private static List<Integer> generateAnswer(int digitCount) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, digitCount);
    }

    // 입력값이 올바른지 확인 (digitCount 자리, 중복 없음, 숫자만)
    private static boolean isValidInput(String input) {
        if (input.length() != digitCount) {
            return false;
        }

        HashSet<Character> digits = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch) || ch == '0') { // 0 제외
                return false;
            }
            digits.add(ch);
        }

        return digits.size() == digitCount; // 중복 없을 때만 true
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

        for (int i = 0; i < digitCount; i++) {
            if (inputNumbers.get(i).equals(answer.get(i))) {
                strikes++;
            } else if (answer.contains(inputNumbers.get(i))) {
                balls++;
            }
        }

        return new int[]{strikes, balls};
    }
}
