import org.junit.jupiter.api.DisplayName;
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
    @ParameterizedTest(name = "Test Password: - {0} - with minimum length of {2} characters, minimum of {3} digits and {4} capital letters ")
    @DisplayName("Password validation based on String input")
    @MethodSource
        // Check the length of the password
    public void PasswordValidationTest(String inputString, String expected, int minLength, int minNum, int minCap){
        // Calling Method
        String result = PWValidationApp.PWValidation(inputString, minLength, minNum, minCap);
        assertEquals(expected,result);
    }
    private static Stream<Arguments> PasswordValidationTest(){
        // Constant variables throughout testing. Can be altered to match requirements
        int minLength = 8;
        int minNum = 2;
        int minCap = 2;
        // Output of the test method
        String FAIL = "Please enter at least " + minNum + "Numbers, " + minCap + "capital Letters and " + minLength + "Letters!";
        String WIN = "You are good to go!";
        // Define Stream of Arguments with relevant Datainput for the test method
        return Stream.of(
                Arguments.of("PassWord123",WIN, minLength, minNum, minCap),
                Arguments.of("123", FAIL, minLength, minNum, minCap),
                Arguments.of("password123", FAIL, minLength, minNum, minCap),
                Arguments.of("pass123", FAIL, minLength, minNum, minCap),
                Arguments.of("Pass123", FAIL, minLength, minNum, minCap),
                Arguments.of("LlllllWWWll45", WIN, minLength, minNum, minCap)
        );
    }


}
