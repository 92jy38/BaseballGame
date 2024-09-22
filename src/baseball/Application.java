package baseball;

public class Application {
    public static void main(String[] args) {
        // 게임 매니저 인스턴스를 생성하고 게임 실행
        baseball.game.GameManager gameManager = new baseball.game.GameManager();
        gameManager.run();
    }
}
