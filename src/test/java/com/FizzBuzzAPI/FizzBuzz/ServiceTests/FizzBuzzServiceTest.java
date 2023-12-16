package com.FizzBuzzAPI.FizzBuzz.ServiceTests;

import com.FizzBuzzAPI.FizzBuzz.Service.FizzBuzzService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzServiceTest {

    private FizzBuzzService fizzBuzzService = new FizzBuzzService(); //direkte initialliesierung damit man unit Tests machen kann und keinen Integrationstest machen muss

    @ParameterizedTest
    @CsvSource(value = {"1,1","13,13"})
    void numberTest(int value, String solution) { // testet, ob normale zahlen auch normal zurückgegeben werden
        assertThat(fizzBuzzService.getFizzBuzzVal(value)).isEqualTo(solution);
    }

    @ParameterizedTest
    @ValueSource(ints = {3,27})
    void fizzTest(int value) { //testet, ob die Zahlen, die nur durch 3 teilbar sind nur "Fizz" zurückgeben
        assertThat(fizzBuzzService.getFizzBuzzVal(value)).isEqualTo("Fizz");

    }

    @ParameterizedTest
    @ValueSource(ints = {5,20})
    void buzzTest(int value) { //testes, ob die Zahlen, die nur durch 5 teilbar sind nur "Buzz" zurückgeben
        assertThat(fizzBuzzService.getFizzBuzzVal(value)).isEqualTo("Buzz");

    }
    @ParameterizedTest
    @ValueSource(ints = {15,90})
    void fizzBuzzTest(int value) { //testes, ob die Zahlen, die durch 5 und 3 teilbar sind "FizzBuzz" zurückgeben
        assertThat(fizzBuzzService.getFizzBuzzVal(value)).isEqualTo("FizzBuzz");

    }
    @Test
    void listTest(){ // tested, ob auch richtige Listen für z.B. 0 und 5 zurückgegeben werden
        List<String> input0 = Arrays.asList();
        List<String> input5 = Arrays.asList("1", "2", "Fizz", "4", "Buzz");
        Assertions.assertIterableEquals(fizzBuzzService.getFizzBuzzList(0), input0);
        Assertions.assertIterableEquals(fizzBuzzService.getFizzBuzzList(5), input5);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,true","1fdf43, false", "4324543, true", "X, false"})
    void validatTest(String input, boolean solution){
        assertThat(fizzBuzzService.inputIsValid(input).isValid()).isEqualTo(solution);
    }
}
