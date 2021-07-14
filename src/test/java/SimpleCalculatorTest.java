import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SimpleCalculatorTest {
    
    private SimpleCalculator simpleCalculator;
    
    
    @BeforeEach
    void setUp() {
        simpleCalculator = new SimpleCalculator();
    }
    
    @Test
    void returnZeroToEmptyString() {
        assertThat(simpleCalculator.add(""), is(0));
    }
    
    @Test
    void returnSameValueForOneNumber() {
        
        assertThat(simpleCalculator.add("4"), is(4));
    }
    
    
    @Test
    void returnSumOfTwoValues() {
        
        assertThat(simpleCalculator.add("1,2"), is(3));
    }
    
    
    @Test
    void returnSumOfMultipleValues() {
        
        assertThat(simpleCalculator.add("1,2,3,4,5,6,7,8,9"), is(45));
    }
    
    @Test
    void returnSumWithNewlineSeparatorValues() {
        
        assertThat(simpleCalculator.add("1\n2,3"), is(6));
    }
    
    
    @Test
    void returnSumWithCustomSeparatorValues() {
        
        assertThat(simpleCalculator.add("//;\n1;2"), is(3));
    }
    
    
    @Test
    void returnExceptionWithNegativeValues() {
        
        NegativeValueException negativeValueException = assertThrows(NegativeValueException.class, () -> {
            assertThat(simpleCalculator.add("1,-2,-3"), is(3));
        });
        
        assertEquals("negatives not allowed: -2 -3", negativeValueException.getMessage());
    }
    
    @Test
    void returnSumIgnoringValuesOver1000() {
        
        assertThat(simpleCalculator.add("1001,2"), is(2));
    }
    
}