import java.util.*;

/**
 * 게임을 진행하는 클래스.
 */
public class Game {

    /* 정답일때의 스트라이크 수 */
    private static final int CORRECT_STRIKE = 3;

    /* 게임 종료를 위한 수 */
    private static final int END_GAME = 2;

    /* 난수를 생성하는 컴퓨터 객체 */
    private Computer computer;

    /* 유저 객체 */
    private User user;

    /* 유저의 정답 여부 판단을 위한 변수 */
    private boolean gameResult;

    /* 재게임 또는 종료 선택을 위한 변수 */
    private int selectRegame = 0;

    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("게임을 시작합니다. ");

        /* 사용자가 종료할 때 까지 게임 진 */
        while (selectRegame != END_GAME) {

            /* 새로운 게임이 시작 될 때, 정답 여부를 초기화 */
            gameResult = false;
            computer = new Computer();
            user = new User();
            while (!gameResult) {
                user.selectNumber();
                strikeAndBall();
            }

            /* 정답을 맞춘 후 재게임 또는 종료 선택을 위한 메소드 호출 */
            endGame();
        }

        /* 사용자가 2번을 눌러 게임을 종료하기를 원하면 while문을 빠져나와 이곳에 도달한다 */
        System.out.println("게임을 종료합니다.");
    }

    /* 스트라이크와 볼 수를 출력 */
    private void strikeAndBall() {
        int strike = 0;
        int ball = 0;

        /* 만든 컴퓨터 객체의 난수를 가져와서 변수에 저장 */
        String computerNumber = computer.computerNumber;

        /* 만든 유저 객체에 입력한 수를 가져와서 변수에 저장 */
        String userNumber = user.userNumber;

        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) == computerNumber.charAt(i)) {
                strike++;
            } else if (computerNumber.contains(Character.toString(userNumber.charAt(i)))) {
                ball++;
            }
        }

        if (strike == CORRECT_STRIKE) {
            System.out.println("정답을 맞추셨습니다. ");
            gameResult = true;
        } else if (strike == 0 && ball == 0) {
            System.out.println("nothing!!!");
            gameResult = false;
        } else {
            System.out.println(strike + " 스트라이크 " + ball + " 볼");
            gameResult = false;
        }
    }

    /* 재게임 또는 종료 선택 */
    private void endGame() {
        System.out.println("새 게임을 하려면 1번 , 종료하시려면 2 번을 눌러주세요");
        selectRegame = sc.nextInt();
    }

}
