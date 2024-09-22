package baseball.game;

import java.util.List;

public class GameConsole {
    public void showMenu() {
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
        System.out.println("0. 자릿수 설정  1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기");
    }

    public void showDifficultySettingPrompt() {
        System.out.println("설정하고자 하는 자릿수를 입력하세요. (3, 4, 5)");
    }

    public void showDifficultySetMessage(int digitCount) {
        System.out.printf("%d 자릿수 난이도로 설정되었습니다.\n", digitCount);
    }

    public void showInvalidDifficultyMessage() {
        System.out.println("올바른 난이도를 입력해주세요. (3, 4, 5)");
    }

    public void showGameStartMessage() {
        System.out.println("< 게임을 시작합니다 >");
    }

    public void showInputPrompt() {
        System.out.println("숫자를 입력하세요");
    }

    public void showInvalidInputMessage() {
        System.out.println("자릿수는 숫자로 입력해야 합니다. 다시 시도해주세요.");
    }

    public void showCorrectAnswerMessage(int attemptCount) {
        System.out.println("정답입니다!");
        System.out.printf("총 시도 횟수: %d\n", attemptCount);
    }

    public void showPostGameMenu() {
        System.out.println("0. 자릿수 설정 1. 계속하기 2. 게임 기록 보기 3. 종료하기");
    }

    public void showExitMessage() {
        System.out.println("< 숫자 야구 게임을 종료합니다 >");
    }

    public void showOutMessage() {
        System.out.println("아웃");
    }

    public void showResultMessage(int strikes, int balls) {
        System.out.printf("%d 스트라이크, %d 볼\n", strikes, balls);
    }

    public void showGameRecords(List<Integer> records) {
        if (records.isEmpty()) {
            System.out.println("아직 게임 기록이 없습니다.");
        } else {
            System.out.println("< 게임 기록 보기 >");
            for (int i = 0; i < records.size(); i++) {
                System.out.printf("%d 번째 게임: 시도 횟수 - %d\n", i + 1, records.get(i));
            }
        }
    }

    public void showErrorMessage(String message) {
        System.out.println("에러: " + message);
    }
}
