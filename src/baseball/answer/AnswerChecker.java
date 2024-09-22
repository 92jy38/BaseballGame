package baseball.answer;

import java.util.List;

// 정답과 사용자의 입력을 비교하는 클래스
public class AnswerChecker {

    // 정답과 입력값을 비교하여 스트라이크와 볼 계산
    public int[] checkAnswer(List<Integer> inputNumbers, List<Integer> answer, int digitCount) {
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
