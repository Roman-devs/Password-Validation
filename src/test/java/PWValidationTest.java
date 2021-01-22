import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PWValidationTest {
/*  Requirements:
  - Check Length of the Password (Minimum 8 characters)
  - Check if Input contains numbers
  - Check if capital letters are included in Input
    BONUS:
  - Create Possibility to check a list of Passwords
 */
    @ParameterizedTest
    @MethodSource
    // Check the length of the password
    public void PasswordValidationTest(String inputString, String expected, int minLength, int minNum, int minCap){
        // Requirements for this Test
//        int minLength = 8;
//        int minNum = 2;
//        int minCap = 2;
        // Calling Method
        String result = PWValidationApp.PWValidation(inputString, minLength, minNum, minCap);
        assertEquals(expected,result);
    }
    private static Stream<Arguments> PasswordValidationTest(){
        //
        int minLength = 8;
        int minNum = 2;
        int minCap = 2;
        //
        return Stream.of(
                Arguments.of("PassWord123","You are good to go!", minLength, minNum, minCap),
                Arguments.of("123", "Please enter at least " + minNum + "Numbers, " + minCap + "capital Letters and " + minLength + "Letters!", minLength, minNum, minCap),
                Arguments.of("password123", "Please enter at least " + minNum + "Numbers, " + minCap + "capital Letters and " + minLength + "Letters!", minLength, minNum, minCap),
                Arguments.of("pass123", "Please enter at least " + minNum + "Numbers, " + minCap + "capital Letters and " + minLength + "Letters!", minLength, minNum, minCap),
                Arguments.of("Pass123", "Please enter at least " + minNum + "Numbers, " + minCap + "capital Letters and " + minLength + "Letters!", minLength, minNum, minCap),
                Arguments.of("LlllllWWWll45", "You are good to go!", minLength, minNum, minCap)
        );
    }


}
