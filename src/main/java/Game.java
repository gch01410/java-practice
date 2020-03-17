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
    private int selectButton=0;

    Scanner sc = new Scanner(System.in);

    /* 게임 진행 컨트롤 */
    public void start(){
        System.out.println("게임을 시작합니다. ");

        /* 사용자가 종료할 때 까지 게임 진 */
        while (selectButton!= END_GAME) {
            /* 정답 여부를 초기화 */
            gameResult=false;

            /* 게임이 시작될 때 마다 새로운 컴퓨터 객체를 통해 새로운 난수 생성 */
            computer = new Computer();

            /* 게임이 시작되면 유저객체를 만들어 숫자를 입력고 스트라이크 수와 볼수를 확인하며 게임 진행. */
            user = new User();
            while (!gameResult) {
                user.selectNumber();
                strikeAndBall();
            }

            /* 정답을 맞춘 후 재게임 또는 종료 선택을 위한 메소드 호출 */
            endGame();
        }
        System.out.println("게임을 종료합니다.");
    }

    /* 스트라이크와 볼 수를 출력 */
    private void strikeAndBall(){
        int strike=0;
        int ball=0;

        /* 만든 컴퓨터 객체의 난수를 가져와서 변수에 저장 */
        String computerNumber = computer.computerNumber;
        /* 만든 유저 객체에 입력한 수를 가져와서 변수에 저장 */
        String userNumber = user.userNumber;

        for (int i=0; i<userNumber.length(); i++) {
            if (userNumber.charAt(i) == computerNumber.charAt(i)) {
                strike ++;
            }
            else if (computerNumber.contains(Character.toString(userNumber.charAt(i)))) {
                ball ++;
            }
        }

        if (strike == CORRECT_STRIKE) {
            System.out.println("정답을 맞추셨습니다. ");
            gameResult = true;
        }else if (strike ==0 && ball == 0) {
            System.out.println("nothing!!!");
            gameResult = false;
        }
        else{
            System.out.println(strike + " 스트라이크 " + ball + " 볼");
            gameResult = false;
        }

    }

    /* 재게임 또는 종료 선택 */
    private void endGame(){
        System.out.println("새 게임을 하려면 1번 , 종료하시려면 2 번을 눌러주세요");
        selectButton = sc.nextInt();
    }

}
