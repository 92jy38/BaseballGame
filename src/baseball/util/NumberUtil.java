package baseball.util;

import java.util.ArrayList;
import java.util.List;

// 입력 변환 및 기타 숫자 관련 유틸리티 기능 제공
public class NumberUtil {

    // 입력값을 숫자 리스트로 변환
    public List<Integer> parseInput(String input) {
        List<Integer> inputNumbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            inputNumbers.add(Character.getNumericValue(ch));
        }
        return inputNumbers;
    }
}
