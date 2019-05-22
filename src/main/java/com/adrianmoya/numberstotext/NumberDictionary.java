package com.adrianmoya.numberstotext;

import java.util.AbstractMap;
import java.util.Map;

/**
 * This is the dictionary with the words that represent each number depending on
 * their position.
 */
public class NumberDictionary {

    // public static String ONES_DICTIONARY[] = { "ZERO", "ONE", "TWO", "THREE",
    // "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT",
    // "NINE" };

    // public static String TENS_DICTIONARY[] = { "TEN", "ELEVEN", "TWELVE",
    // "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN",
    // "SEVENTEEN", "EIGHTEEN", "NINETEEN" };

    // public static String TENS_20_TO_90_DICTIONARY[] = { "TWENTY", "THIRTY",
    // "FORTY", "FIFTY", "SIXTY", "SEVENTY",
    // "EIGHTY", "NINETY" };

    public static Map<String, String> ONES_DICTIONARY = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, String>("0", "ZERO"),
            new AbstractMap.SimpleEntry<String, String>("1", "ONE"),
            new AbstractMap.SimpleEntry<String, String>("2", "TWO"),
            new AbstractMap.SimpleEntry<String, String>("3", "THREE"),
            new AbstractMap.SimpleEntry<String, String>("4", "FOUR"),
            new AbstractMap.SimpleEntry<String, String>("5", "FIVE"),
            new AbstractMap.SimpleEntry<String, String>("6", "SIX"),
            new AbstractMap.SimpleEntry<String, String>("7", "SEVEN"),
            new AbstractMap.SimpleEntry<String, String>("8", "EIGHT"),
            new AbstractMap.SimpleEntry<String, String>("9", "NINE"));

    public static Map<String, String> TENS_10_TO_19_DICTIONARY = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, String>("10", "TEN"),
            new AbstractMap.SimpleEntry<String, String>("11", "ELEVEN"),
            new AbstractMap.SimpleEntry<String, String>("12", "TWELVE"),
            new AbstractMap.SimpleEntry<String, String>("13", "THIRTEEN"),
            new AbstractMap.SimpleEntry<String, String>("14", "FOURTEEN"),
            new AbstractMap.SimpleEntry<String, String>("15", "FIFTEEN"),
            new AbstractMap.SimpleEntry<String, String>("16", "SIXTEEN"),
            new AbstractMap.SimpleEntry<String, String>("17", "SEVENTEEN"),
            new AbstractMap.SimpleEntry<String, String>("18", "EIGHTEEN"),
            new AbstractMap.SimpleEntry<String, String>("19", "NINETEEN"));

    public static Map<String, String> TENS_20_TO_90_DICTIONARY = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, String>("2", "TWENTY"),
            new AbstractMap.SimpleEntry<String, String>("3", "THIRTY"),
            new AbstractMap.SimpleEntry<String, String>("4", "FOURTY"),
            new AbstractMap.SimpleEntry<String, String>("5", "FIFTY"),
            new AbstractMap.SimpleEntry<String, String>("6", "SIXTY"),
            new AbstractMap.SimpleEntry<String, String>("7", "SEVENTY"),
            new AbstractMap.SimpleEntry<String, String>("8", "EIGHTY"),
            new AbstractMap.SimpleEntry<String, String>("9", "NINETY"));

}