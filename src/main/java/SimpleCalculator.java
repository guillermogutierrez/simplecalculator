import java.util.Arrays;

public class SimpleCalculator {
    
    int add(String numbers){
        if (numbers.length() == 0)
            return 0;
    
        return Arrays.stream(Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).toArray()).reduce(Integer.parseInt("0"), Integer::sum);
    }
}
