package com.adrianmoya.numberstotext;

/**
 * This is the main converter from numbers to text
 */
public class NumberToTextConverter {

    public static String convertNumber(String number) throws Exception {

        StringBuilder sb = new StringBuilder();

        int intNumber = Integer.valueOf(number);

        if(intNumber < 10){
            return NumberDictionary.ONES_DICTIONARY.get(number);
        }

        if(intNumber >=10 && intNumber < 20) {
            // Get position in the TENS_DICTIONARY
            int position = intNumber - 10;
            return NumberDictionary.TENS_10_TO_19_DICTIONARY.get(number);
        }

        if(intNumber >= 20 && intNumber < 100) {
            // Get position in the TENS_20_TO_90_DICTIONARY
            String[] digits = number.split("(?<=.)");
            sb.append(NumberDictionary.TENS_20_TO_90_DICTIONARY.get(digits[0]));
            if(!"0".equals(digits[1])) {
                sb.append(" ");
                sb.append(NumberDictionary.ONES_DICTIONARY.get(digits[1]));
            }
            return sb.toString();
        }
        throw new Exception("Can't convert number yet");
    }

}