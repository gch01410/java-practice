import java.util.*;

/**
 * 형식에 맞는 사용자의 입력을 받는 클래스.
 */
public class User {

    /* 입력한 숫자의 자릿수 */
    private static final int NUMBER_OF_LENGTH = 3;

    /* 입력한 문자가 조건에 맞는 숫자이기 위한 최솟값*/
    private static final char MIN_NUM = '1';

    /* 입력한 문자가 조건에 맞는 숫자이기 위한 최댓값*/
    private static final char MAX_NUM = '9';

    Scanner sc = new Scanner(System.in);

    /* 유저가 선택한 수가 담길 변수 */
    protected String userNumber = "";

    /* 유저의 입력을 받는 메소드 */
    public void selectNumber() {
        while (true) {
            System.out.println("숫자를 입력 하세요 : ");
            String number = sc.next();
            if (checkLengthOfNumber(number) && vaildLengthOfNumber(number) && overlapNumber(number)) {
                userNumber = number;
                break;
            } else {
                System.out.println("형식에 맞지 않는 입력입니다. 중복되지 않는 세자리 정수를 입력해야합니다. ");
            }
        }
    }

    /* 유저가 입력한 숫자가 3자리 숫자인지 */
    private boolean checkLengthOfNumber(String userInputNumber) {
        if (userInputNumber.length() != NUMBER_OF_LENGTH) {
            return false;
        }
        return true;
    }

    /* 유저가 입력한 숫자가 1~9 까지의 숫자인지 */
    private boolean vaildLengthOfNumber(String userInputNumber) {
        for (int i = 0; i < userInputNumber.length(); i++) {
            if (userInputNumber.charAt(i) < MIN_NUM || userInputNumber.charAt(i) > MAX_NUM) {
                return false;
            }
        }
        return true;
    }

    /* 유저가 입력한 숫자에 중복된 수가 있는지  */
    private boolean overlapNumber(String userInputNumber) {
        String temp;
        for (int i = 0; i < userInputNumber.length(); i++) {
            temp = userInputNumber.substring(i + 1);

            if (temp.contains(Character.toString(userInputNumber.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
