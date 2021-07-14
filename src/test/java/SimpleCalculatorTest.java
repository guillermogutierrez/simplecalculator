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
    void testEmptyNumbers(){
        assertThat(simpleCalculator.add(""), is(0));
    }
    
    @Test
    void testSingleNumber(){
        
        assertThat(simpleCalculator.add("4"), is(4));
    }
}