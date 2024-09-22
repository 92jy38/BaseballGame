package baseball.answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 정답 숫자를 생성하는 클래스
public class AnswerGenerator {

    public List<Integer> generateAnswer(int digitCount) {
        if (digitCount < 3 || digitCount > 5) {
            throw new IllegalArgumentException("자릿수는 3, 4, 5 중 하나여야 합니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, digitCount);
    }
}
