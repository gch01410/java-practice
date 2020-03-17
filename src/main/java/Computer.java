import java.util.*;

/**
 * 사용자가 맞추어야 할 컴퓨터의 난수를 생성하는 클래스.
 */
public class Computer {

    /* 난수 발생시 최소 수 */
    private static final int MIN_RANGE = 1;

    /* 난수 발생시 최대 수 */
    private static final int MAX_RANGE = 9;

    /* 난수 발생시 자릿 수  */
    private static final int NUMBER_LENGTH = 3;

    Random random = new Random();

    /* 확정된 컴퓨터의 수가 담길 변수 */
    String computerNumber="";

    /* 컴퓨터 객체 생성시 난수 발생 생성자 */
    public Computer(){

        while (computerNumber.length()<NUMBER_LENGTH) {
            int number = random.nextInt(MAX_RANGE) + MIN_RANGE;

            /* 3자리 수가 각각 다른 수가 될 수 있도록 만든다. */
            if (!computerNumber.contains(Integer.toString(number))) {
                computerNumber += Integer.toString(number);
            }
        }

    }

}
