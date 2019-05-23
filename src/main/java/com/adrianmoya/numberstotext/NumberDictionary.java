package com.adrianmoya.numberstotext;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the dictionary with the words that represent each number depending on
 * their position.
 */
public class NumberDictionary {

        public static Map<Character, String> ONES_DICTIONARY;
        static {
                ONES_DICTIONARY = new HashMap<>();
                ONES_DICTIONARY.put('0', "ZERO");
                ONES_DICTIONARY.put('1', "ONE");
                ONES_DICTIONARY.put('2', "TWO");
                ONES_DICTIONARY.put('3', "THREE");
                ONES_DICTIONARY.put('4', "FOUR");
                ONES_DICTIONARY.put('5', "FIVE");
                ONES_DICTIONARY.put('6', "SIX");
                ONES_DICTIONARY.put('7', "SEVEN");
                ONES_DICTIONARY.put('8', "EIGHT");
                ONES_DICTIONARY.put('9', "NINE");
        }

        public static Map<String, String> TENS_10_TO_19_DICTIONARY;
        static {
                TENS_10_TO_19_DICTIONARY = new HashMap<>();
                TENS_10_TO_19_DICTIONARY.put("10", "TEN");
                TENS_10_TO_19_DICTIONARY.put("11", "ELEVEN");
                TENS_10_TO_19_DICTIONARY.put("12", "TWELVE");
                TENS_10_TO_19_DICTIONARY.put("13", "THIRTEEN");
                TENS_10_TO_19_DICTIONARY.put("14", "FOURTEEN");
                TENS_10_TO_19_DICTIONARY.put("15", "FIFTEEN");
                TENS_10_TO_19_DICTIONARY.put("16", "SIXTEEN");
                TENS_10_TO_19_DICTIONARY.put("17", "SEVENTEEN");
                TENS_10_TO_19_DICTIONARY.put("18", "EIGHTEEN");
                TENS_10_TO_19_DICTIONARY.put("19", "NINETEEN");
        }

        public static Map<Character, String> TENS_20_TO_90_DICTIONARY;
        static {
                TENS_20_TO_90_DICTIONARY = new HashMap<>();
                TENS_20_TO_90_DICTIONARY.put('2', "TWENTY");
                TENS_20_TO_90_DICTIONARY.put('3', "THIRTY");
                TENS_20_TO_90_DICTIONARY.put('4', "FOURTY");
                TENS_20_TO_90_DICTIONARY.put('5', "FIFTY");
                TENS_20_TO_90_DICTIONARY.put('6', "SIXTY");
                TENS_20_TO_90_DICTIONARY.put('7', "SEVENTY");
                TENS_20_TO_90_DICTIONARY.put('8', "EIGHTY");
                TENS_20_TO_90_DICTIONARY.put('9', "NINETY");
        }

        public static Map<Character, String> CHUNK_SUFFIXES;
        static {
                CHUNK_SUFFIXES = new HashMap<>();
                CHUNK_SUFFIXES.put('1', "THOUSAND");
                CHUNK_SUFFIXES.put('2', "MILLION");
                CHUNK_SUFFIXES.put('3', "BILLION");
                CHUNK_SUFFIXES.put('4', "TRILLION");
                CHUNK_SUFFIXES.put('5', "QUADRILLION");
                CHUNK_SUFFIXES.put('6', "QUINILLION");
                CHUNK_SUFFIXES.put('7', "SEXTILLION");
                CHUNK_SUFFIXES.put('8', "SEPTILLION");
                CHUNK_SUFFIXES.put('9', "OCTILLION");
        }
}