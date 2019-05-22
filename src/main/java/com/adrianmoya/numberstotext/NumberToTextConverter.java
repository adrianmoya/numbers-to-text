package com.adrianmoya.numberstotext;

/**
 * This is the main converter from numbers to text
 */
public class NumberToTextConverter {

    public static String convertNumber(String number) throws Exception {

        int chunks = number.length() % 3 + 1;

        int intNumber = Integer.valueOf(number);

        if (intNumber < 0) {
            StringBuilder sb = new StringBuilder();
            return sb.append("MINUS ").append(convertNumber(number.replace("-", ""))).toString();
        }

        if (intNumber >= 0 && intNumber < 10) {
            return convertOnes(number.charAt(0));
        }

        if (intNumber >= 10 && intNumber < 100) {
            return convertTens(number);
        }

        if (intNumber >= 100 && intNumber < 1000) {
            return convertHundreds(number);
        }

        if (intNumber >= 1000 && intNumber < 1000000) {
            return convertThousands(number);
        }

        if (intNumber >= 1000000 && intNumber < 1000000000) {
            StringBuilder sb = new StringBuilder();
            String millionChunk = number.substring(0, number.length() - 6);
            sb.append(convertNumber(millionChunk)).append(" MILLION ");
            sb.append(convertNumber(number.substring(number.length() - 6, number.length())));
            return sb.toString();
        }

        throw new Exception("Can't convert this number yet");
    }

    private static String convertThousands(String number) throws Exception {
        StringBuilder sb = new StringBuilder();
        String thousandChunk = number.substring(0, number.length() - 3);
        sb.append(convertNumber(thousandChunk)).append(" THOUSAND ");
        sb.append(convertNumber(number.substring(number.length() - 3, number.length())));
        return sb.toString();
    }

    private static String convertHundreds(String number) throws Exception {
        StringBuilder sb = new StringBuilder();
        // Get position in the HUNDREDS_DICTIONARY
        char[] digits = number.toCharArray();
        sb.append(NumberDictionary.ONES_DICTIONARY.get(digits[0]));
        sb.append(" HUNDRED ");
        sb.append(convertNumber(String.valueOf(digits, 1, 2)));
        return sb.toString();
    }

    private static String convertTens(String number) {
        int intNumber = Integer.valueOf(number);
        StringBuilder sb = new StringBuilder();

        if (intNumber >= 10 && intNumber < 20) {
            // Get position in the TENS_DICTIONARY
            return NumberDictionary.TENS_10_TO_19_DICTIONARY.get(number);
        }

        if (intNumber >= 20 && intNumber < 100) {
            // Get position in the TENS_20_TO_90_DICTIONARY
            char[] digits = number.toCharArray();
            sb.append(NumberDictionary.TENS_20_TO_90_DICTIONARY.get(digits[0]));
            Character zero = '0';
            if (!zero.equals(digits[1])) {
                sb.append(" ");
                sb.append(convertOnes(digits[1]));
            }
            return sb.toString();
        }
        return "";
    }

    private static String convertOnes(char digit) {
        return NumberDictionary.ONES_DICTIONARY.get(digit);
    }
}