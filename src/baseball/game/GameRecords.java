package baseball.game;

import java.util.ArrayList;
import java.util.List;

// 게임 기록을 저장하고 출력
public class GameRecords {
    private final List<Integer> records;

    public GameRecords() {
        this.records = new ArrayList<>();
    }

    public void addGameRecord(int attemptCount) {
        records.add(attemptCount);
    }

    public void showGameRecords(GameConsole console) {
        console.showGameRecords(records);
    }
}
