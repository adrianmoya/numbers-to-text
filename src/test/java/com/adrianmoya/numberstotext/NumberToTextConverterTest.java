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
        assertThat("Result was not ZERO", result, equalTo("ZERO"));
    }

    @Test
    public void shouldConvertNumbersFromTenToNineteen() throws Exception {
        // Arrange
        String number = "13";

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat("Result was not THIRTEEN", result, equalTo("THIRTEEN"));
    }

    @Test
    public void shouldConvertNumbersFromTwentyToNinetyNine() throws Exception {
        // Arrange
        String number = "25";

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat("Result was not TWENTY FIVE", result, equalTo("TWENTY FIVE"));
    }

    @Test
    public void shouldNotShowZeroForTensWhenOnesIsZero() throws Exception {
        // Arrange
        String number = "30";

        // Act
        String result = NumberToTextConverter.convertNumber(number);

        // Assert
        assertThat("Result was not THIRTY", result, equalTo("THIRTY"));
    }
}
