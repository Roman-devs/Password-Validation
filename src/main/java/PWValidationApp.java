import java.util.List;

public class PWValidationApp {

    public static void main(String[] args) {
    }
//
//Password Validation Method calling three specific validation Methods
//
    public static String pwValidation(String inputString, int minimumLength, int minimumNumbers, int minimumCapital){
        boolean resultNumbers = checkIfInputContainsNumbers(inputString, minimumNumbers);
        boolean resultLength = checkLengthOfInput(inputString, minimumLength);
        boolean resultCapitalLetters =checkCapitalLetters(inputString, minimumCapital);
        //
        if (resultNumbers && resultLength && resultCapitalLetters) {
            return "You are good to go!";
        } else {
            return "Please enter at least " + minimumNumbers + "Numbers, " + minimumCapital + "capital Letters and " + minimumLength + "Letters!";
        }
    }
//
// Method that checks if the minimum Capital Letter requirement is met
//
    private static boolean checkCapitalLetters(String inputString, int minimumCapital){
        char[] charactersFromInput = new char[inputString.length()];
        int counterCapital = 0;
        //
        for (int i = 0; i < inputString.length(); i++) {
            charactersFromInput[i] = inputString.charAt(i);
            if (Character.isUpperCase(charactersFromInput[i])){
                counterCapital++;
            };
        };
        if (counterCapital>=minimumCapital){
        return true;
        } else{
            return false;
        }

    }
//
//  Method that checks if the minimum Length requirement is met
//
    private static boolean checkLengthOfInput(String inputString, int minimumLength){
        return inputString.length() >= minimumLength;
    }
//
//  Method that checks if the input-contains-numbers requirement is met
//
    private static boolean checkIfInputContainsNumbers(String inputString, int minimumNumbers){
        char[] charactersFromInput = new char[inputString.length()];
        int counterNumbers = 0;
        //
            for (int i = 0; i < inputString.length(); i++) {
                charactersFromInput[i] = inputString.charAt(i);
                if (Character.isDigit(charactersFromInput[i])){
                    counterNumbers++;
                };
            };
        if (counterNumbers>=minimumNumbers){
            return true;
        } else {
            return false;
        }
    }
//
// Bonus
//
    public static String[] pwListValidation (String[] inputStringList, int minimumLength, int minimumNumbers, int minimumCapital){
        String[] outputValidated = new String[inputStringList.length];
        //
        for (int i = 0; i < inputStringList.length; i++) {
            outputValidated[i] = pwValidation(inputStringList[i], minimumLength, minimumNumbers, minimumCapital);
        }
        return outputValidated;
    }
}
