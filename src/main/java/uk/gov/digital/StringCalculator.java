package uk.gov.digital;
import java.util.Objects;
import static java.lang.Integer.parseInt;

public class StringCalculator {

    static int calculate(String nums) throws IllegalArgumentException {
        if(Objects.equals(nums, "")) {
            return 0;
        }
        int total = 0;
        String[] arrOfStr = nums.split("[,\n]");



        for (String num : arrOfStr ) {
            int parsedNum = parseInt(num);
            if (parsedNum < 0){
                throw new IllegalArgumentException("numbers cannot be negative");
            }

                total += parseInt(num);
        }

    return  total;
        }
}
