package com.FizzBuzzAPI.FizzBuzz.Service;

import com.FizzBuzzAPI.FizzBuzz.utils.IsValid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class FizzBuzzService {


    public List<String> getFizzBuzzList(Integer value) {
        List<String> fizzBuzzSolutionList = new ArrayList<>();
        for(int i = 1; i<=value; i++) fizzBuzzSolutionList.add(getFizzBuzzVal(i)); //Extra Methode, da man diese in den Tests gebrauchen kann
        return fizzBuzzSolutionList;
    }
    public String getFizzBuzzVal(int index){
        String fizzBuzzSolution = "";
        if(index % 3 == 0) fizzBuzzSolution = "Fizz"; //Wenn i durch 3 keinen Rest hat, wird dem String ein "Fizz" hinzugefügt
        if(index % 5 == 0) fizzBuzzSolution += "Buzz"; //Wenn er durch 5 teilbar ist, wird ein "Buzz" hinzugefügt und wenn er durch 3 und 5 teilbar ist, haben wir nun ein "FizzBuzz"
        if(fizzBuzzSolution.length() == 0) fizzBuzzSolution += index; //Wenn keiner der vorherigen Fälle eingetreten ist, ist der String leer und wird auf i gesetzt
        return fizzBuzzSolution;
    }
    public IsValid inputIsValid(String input){
        if(input.length() > 10) return new IsValid("Input is too long", false); //Wenn input länger als 10 Zeichen ist, kann es kein Integer mehr sein
        if(Pattern.compile("[^0-9]").matcher(input).find()) return new IsValid("Only digits are allowed", false); //Es wird nach einem Zeichen gesucht, welches keine Ziffer ist
        return new IsValid(true);
    }


}
