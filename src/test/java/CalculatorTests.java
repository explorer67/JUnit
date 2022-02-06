import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTests {
    Calculator sut;

    @BeforeEach
    public void  init(){
        System.out.println("test started");
        sut = new Calculator();
    }

    @BeforeAll
    public static void started(){
        System.out.println("tests started");
    }

    @AfterEach
    public void finished() {
        sut = null;
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll(){
        System.out.println("tests completed");
    }

    @Test
    public void testDivideByZero(){
        //arrange
        Integer x = 1, y = 0;
        var expected = ArithmeticException.class;

        //assert
        assertThrows(expected,
                //act
                () -> sut.devide.apply(x,y));
    }

    @ParameterizedTest
    @MethodSource("sourceOfPlus")
        public void testPlus(/*arrange*/Integer x, Integer y, Integer expected){
        //act
        Integer result = sut.plus.apply(x,y);
        //assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> sourceOfPlus(){
        return Stream.of(Arguments.of(3,5,8));
    }

    @ParameterizedTest
    @MethodSource("sourceOfMultiply")
    public void testMultiply(/*arrange*/Integer x, Integer y, Integer expected){
        //act
        Integer result = sut.multiply.apply(x,y);
        //assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> sourceOfMultiply(){
        return Stream.of(Arguments.of(10,8,80));
    }

    @Test
    public void testPow(){
       //arrange
       Integer x = 10, expected = 100;

       //act
       Integer result = sut.pow.apply(x);

       //assert
        assertEquals(expected, result);
    }
}
