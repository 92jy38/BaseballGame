package baseball.util;

import java.util.HashSet;

// 입력값 검증을 위한 클래스
public class InputValidator {

    // 입력값이 올바른지 확인 (digitCount 자리, 중복 없음, 숫자만)
    public boolean isValidInput(String input, int digitCount) {
        try {
            if (input.length() != digitCount) {
                throw new IllegalArgumentException("입력 값의 자리 수가 잘못되었습니다.");
            }

            HashSet<Character> digits = new HashSet<>();
            for (char ch : input.toCharArray()) {
                if (!Character.isDigit(ch) || ch == '0') { // 0 제외
                    throw new IllegalArgumentException("잘못된 숫자가 포함되었습니다.");
                }
                digits.add(ch);
            }

            if (digits.size() != digitCount) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }
            return true; // 중복 없을 때만 true
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력 검증 실패: " + e.getMessage());
        }
    }
}