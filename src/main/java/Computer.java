import java.util.*;

/**
 * 사용자가 맞추어야 할 컴퓨터의 난수를 생성하는 클래스.
 */
public class Computer {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int NUMBER_LENGTH = 3;

    Random random = new Random();

    /* 확정된 컴퓨터의 수가 담길 변수 */
    protected String computerNumber = "";

    public Computer() {
        while (computerNumber.length() < NUMBER_LENGTH) {
            int number = random.nextInt(MAX_RANGE) + MIN_RANGE;
            if (!computerNumber.contains(Integer.toString(number))) {
                computerNumber += Integer.toString(number);
            }
        }
    }

}
