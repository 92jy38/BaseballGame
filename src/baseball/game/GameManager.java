package baseball.game;

import baseball.answer.AnswerGenerator;
import baseball.answer.AnswerChecker;
import baseball.util.InputValidator;
import baseball.util.NumberUtil;

import java.util.Scanner;

public class GameManager {
    private static int digitCount = 3; // 기본 자릿수는 3자리
    private final GameConsole console = new GameConsole();
    private final GameRecords gameRecords = new GameRecords();
    private final NumberUtil numberUtil = new NumberUtil();
    private final AnswerGenerator answerGenerator = new AnswerGenerator();
    private final InputValidator inputValidator = new InputValidator();
    private final AnswerChecker answerChecker = new AnswerChecker();

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        //noinspection InfiniteLoopStatement
        while (true) {
            console.showMenu();
            String option = scanner.nextLine();

            switch (option) {
                case "0" -> setDifficulty(scanner);
                case "1" -> startGame(scanner);
                case "2" -> gameRecords.showGameRecords(console);
                case "3" -> console.showExitMessage();
                default -> console.showInvalidInputMessage();
            }
        }
    }

    private void setDifficulty(Scanner scanner) {
        console.showDifficultySettingPrompt();
        String input = scanner.nextLine();

        try {
            int difficulty = Integer.parseInt(input);
            if (difficulty >= 3 && difficulty <= 5) {
                digitCount = difficulty;
                console.showDifficultySetMessage(digitCount);
            } else {
                console.showInvalidDifficultyMessage();
            }
        } catch (NumberFormatException e) {
            console.showErrorMessage("자릿수는 숫자로 입력해야 합니다. 다시 시도해주세요.");
        }
    }

    private void startGame(Scanner scanner) {
        console.showGameStartMessage();
        var answer = answerGenerator.generateAnswer(digitCount);
        int attemptCount = 0;

        while (true) {
            console.showInputPrompt();
            String input = scanner.nextLine();

            try {
                if (!inputValidator.isValidInput(input, digitCount)) {
                    throw new IllegalArgumentException("잘못된 입력입니다: " + input);
                }

                attemptCount++;
                var inputNumbers = numberUtil.parseInput(input);
                int[] result = answerChecker.checkAnswer(inputNumbers, answer, digitCount);

                int strikes = result[0];
                int balls = result[1];

                if (strikes == digitCount) {
                    console.showCorrectAnswerMessage(attemptCount);
                    gameRecords.addGameRecord(attemptCount);
                    handlePostGame(scanner);
                    break;
                } else if (strikes == 0 && balls == 0) {
                    console.showOutMessage();
                } else {
                    console.showResultMessage(strikes, balls);
                }
            } catch (IllegalArgumentException e) {
                console.showErrorMessage(e.getMessage());
            }
        }
    }

    private void handlePostGame(Scanner scanner) {
        console.showPostGameMenu();
        String nextOption = scanner.nextLine();

        switch (nextOption) {
            case "0" -> setDifficulty(scanner);
            case "1" -> startGame(scanner); // 다시 시작
            case "2" -> gameRecords.showGameRecords(console);
            case "3" -> console.showExitMessage();
        }
    }
}
