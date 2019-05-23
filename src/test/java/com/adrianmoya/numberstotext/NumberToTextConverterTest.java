package com.adrianmoya.numberstotext;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

/**
 * Unit test for numbers to text converter
 */
public class NumberToTextConverterTest {
    @Test
    public void shouldConvertNumbersInTheOnesPlace() throws Exception {
        // Arrange
        String number = "0";

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat(result, equalTo("ZERO"));
    }

    @Test
    public void shouldConvertNumbersFromTenToNineteen() throws Exception {
        // Arrange
        String number = "13";

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat(result, equalTo("THIRTEEN"));
    }

    @Test
    public void shouldConvertNumbersFromTwentyToNinetyNine() throws Exception {
        // Arrange
        String number = "25";

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat(result, equalTo("TWENTY FIVE"));
    }

    @Test
    public void shouldNotShowZeroForTensWhenOnesIsZero() throws Exception {
        // Arrange
        String number = "30";

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat(result, equalTo("THIRTY"));
    }

    @Test
    public void shouldConvertNumbersInTheHundredsPlace() throws Exception {
        // Arrange
        String number = "227";

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat(result, equalTo("TWO HUNDRED TWENTY SEVEN"));
    }

    @Test
    public void shouldConvertNumbersInTheThousandsPlace() throws Exception {
        // Arrange
        String number = "34227";

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat(result, equalTo("THIRTY FOUR THOUSAND TWO HUNDRED TWENTY SEVEN"));
    }

    @Test
    public void shouldConvertNumbersInTheThousandsPlaceBorder() throws Exception {
        // Arrange
        String number = "999999";

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat(result, equalTo("NINE HUNDRED NINETY NINE THOUSAND NINE HUNDRED NINETY NINE"));
    }

    @Test
    public void shouldConvertNumbersInTheMillionsPlace() throws Exception {
        // Arrange
        String number = "234956436";

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat(result,
                equalTo("TWO HUNDRED THIRTY FOUR MILLION NINE HUNDRED FIFTY SIX THOUSAND FOUR HUNDRED THIRTY SIX"));
    }

    @Test
    public void shouldConvertNegativeNumbers() throws Exception {
        // Arrange
        String number = "-234956436";

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat(result, equalTo(
                "MINUS TWO HUNDRED THIRTY FOUR MILLION NINE HUNDRED FIFTY SIX THOUSAND FOUR HUNDRED THIRTY SIX"));
    }

    @Test
    public void shouldConvertMaxLongValue() throws Exception {
        // Arrange
        String number = String.valueOf(Long.MAX_VALUE); // 9,223,372,036,854,775,807

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat(result, equalTo(
                "NINE QUINILLION TWO HUNDRED TWENTY THREE QUADRILLION THREE HUNDRED SEVENTY TWO TRILLION THIRTY SIX BILLION EIGHT HUNDRED FIFTY FOUR MILLION SEVEN HUNDRED SEVENTY FIVE THOUSAND EIGHT HUNDRED SEVEN"));
    }

    @Test
    public void shouldConvertMinLongValue() throws Exception {
        // Arrange
        String number = String.valueOf(Long.MIN_VALUE); // -9,223,372,036,854,775,808

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat(result, equalTo(
                "MINUS NINE QUINILLION TWO HUNDRED TWENTY THREE QUADRILLION THREE HUNDRED SEVENTY TWO TRILLION THIRTY SIX BILLION EIGHT HUNDRED FIFTY FOUR MILLION SEVEN HUNDRED SEVENTY FIVE THOUSAND EIGHT HUNDRED EIGHT"));
    }

    @Test
    public void shouldConvertThreeDigitChunkWithOneLeadingZeroes() throws Exception {
        // Arrange
        String number = "036";

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat(result, equalTo("THIRTY SIX"));
    }


    @Test
    public void shouldConvertThreeDigitChunkWithTwoLeadingZeroes() throws Exception {
        // Arrange
        String number = "003";

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat(result, equalTo("THREE"));
    }

    @Test
    public void shouldConvertTwoDigitChunkWithLeadingZeroes() throws Exception {
        // Arrange
        String number = "08";

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat(result, equalTo("EIGHT"));
    }    
}
