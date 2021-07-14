public class SimpleCalculator {
    
    int add(String numbers){
        if (numbers.length() == 0)
            return 0;
        else
            return Integer.parseInt(numbers);
    }
}
