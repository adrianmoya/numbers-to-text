package com.adrianmoya.numberstotext;

/**
 * This is the main converter from numbers to text
 */
public class NumberToTextConverter {

    static final Character CHAR_ZERO = '0';
    static final String LEADING_ZEROES_REGEXP = "^0+(?!$)";
    static final Character MINUS = '-';

    /**
     * Converts a number into it's text representation.
     * @param number A positive or negative integer number
     * @return The text that represents the number in english words
     */
    public static String convertNumber(String number) {
        
        if (MINUS.equals(number.charAt(0))) {
            StringBuilder sb = new StringBuilder();
            return sb.append("MINUS ").append(convertNumber(number.replace("-", ""))).toString();
        }

        // Remove leading zeroes if present
        number = number.replaceFirst(LEADING_ZEROES_REGEXP, "");

        // Process number in the range of hundreds
        if (number.length() < 4) {
            int intNumber = Integer.valueOf(number);

            if (intNumber >= 0 && intNumber < 10) {
                return convertOnes(number.charAt(0));
            }

            if (intNumber >= 10 && intNumber < 100) {
                return convertTens(number);
            }

            if (intNumber >= 100 && intNumber < 1000) {
                return convertHundreds(number);
            }
        }

        // Process bigger number in chunks of 3 digits + corresponding suffix
        StringBuilder sb = new StringBuilder();
        int chunksCount = (int) Math.ceil(Double.valueOf(number.length()) / 3);
        int chunksLeft = chunksCount - 1;
        String chunk = number.substring(0, number.length() - chunksLeft * 3);
        sb.append(convertChunk(chunk, NumberDictionary.CHUNK_SUFFIXES.get((char) (chunksLeft + '0'))));
        sb.append(convertNumber(number.substring(chunk.length())));
        return sb.toString();
    }

    private static String convertChunk(String chunk, String suffix) {
        StringBuilder sb = new StringBuilder();
        sb.append(convertNumber(chunk)).append(" ").append(suffix).append(" ");
        return sb.toString();
    }

    private static String convertHundreds(String number) {
        StringBuilder sb = new StringBuilder();
        char[] digits = number.toCharArray();
        sb.append(NumberDictionary.ONES_DICTIONARY.get(digits[0]));
        sb.append(" HUNDRED");
        String rest = String.valueOf(digits, 1, 2).replaceFirst(LEADING_ZEROES_REGEXP, "");
        if (!"0".equals(rest)) {
            sb.append(" ").append(convertNumber(rest));
        }
        return sb.toString();
    }

    private static String convertTens(String number) {
        int intNumber = Integer.valueOf(number);
        StringBuilder sb = new StringBuilder();

        if (intNumber >= 10 && intNumber < 20) {
            // Get position in the TENS_DICTIONARY
            return NumberDictionary.TENS_10_TO_19_DICTIONARY.get(number);
        } else {
            // Get position in the TENS_20_TO_90_DICTIONARY
            char[] digits = number.toCharArray();
            sb.append(NumberDictionary.TENS_20_TO_90_DICTIONARY.get(digits[0]));
            if (!CHAR_ZERO.equals(digits[1])) {
                sb.append(" ");
                sb.append(convertOnes(digits[1]));
            }
            return sb.toString();
        }
    }

    private static String convertOnes(char digit) {
        return NumberDictionary.ONES_DICTIONARY.get(digit);
    }
}