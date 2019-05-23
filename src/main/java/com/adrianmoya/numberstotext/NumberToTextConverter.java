package com.adrianmoya.numberstotext;

/**
 * This is the main converter from numbers to text
 */
public class NumberToTextConverter {

    public static String convertNumber(String number) throws Exception {

        // Process minus sign if present
        if (Long.valueOf(number) < 0l) {
            StringBuilder sb = new StringBuilder();
            return sb.append("MINUS ").append(convertNumber(number.replace("-", ""))).toString();
        }

        // Process number in the range of hundreds
        if(number.length() < 4) {
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
        int chunksLeft = chunksCount -1;
        String chunk = number.substring(0, number.length() - chunksLeft*3 );
        sb.append(convertChunk(chunk, NumberDictionary.CHUNK_SUFFIXES.get((char)(chunksLeft+'0'))));
        sb.append(convertNumber(number.substring(chunk.length())));
        return sb.toString();
    }

    private static String convertChunk(String chunk, String suffix) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(convertNumber(chunk)).append(" ").append(suffix).append(" ");
        return sb.toString();
    }

    private static String convertHundreds(String number) throws Exception {
        StringBuilder sb = new StringBuilder();
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