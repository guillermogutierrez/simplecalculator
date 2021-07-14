import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class SimpleCalculatorTest {
    
    private SimpleCalculator simpleCalculator;
    
    
    @BeforeEach
    void setUp(){
        simpleCalculator = new SimpleCalculator();
    }
    
    @Test
    void returnZeroToEmptyString(){
        assertThat(simpleCalculator.add(""), is(0));
    }
    
    @Test
    void returnSameValueForOneNumber(){
        
        assertThat(simpleCalculator.add("4"), is(4));
    }
    
    
    @Test
    void returnSumOfAllValues(){
        
        assertThat(simpleCalculator.add("1,2"), is(3));
    }
    
}