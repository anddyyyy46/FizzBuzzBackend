package com.FizzBuzzAPI.FizzBuzz.Controller;

import com.FizzBuzzAPI.FizzBuzz.utils.IsValid;
import com.FizzBuzzAPI.FizzBuzz.Service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") //damit jeder auf die API zugreifen kann
public class FizzBuzzController {

    FizzBuzzService fizzBuzzService;
    @Autowired //Konstruktorinjektion um Dependency Injection zu ermöglichen
    public FizzBuzzController(FizzBuzzService fizzBuzzService){
        this.fizzBuzzService = fizzBuzzService;
    }


    @GetMapping("/getFizzBuzz") //http://localhost:8080/api/getFizzBuzz endpoint um bei einer Erweiterung der API klare Strukturen zu haben
    //Input Übergabe über die URL, um den endpoint so leicht es geht zu verwenden. URL-Parameter als String damit man auf Fehlerfälle reagieren kann
    public ResponseEntity<?> getInput(@RequestParam("value")String input){ //ResponseEntity damit erst zur Laufzeit entschieden wird, womit geantwortet wird, damit man sauber eine Fehlermeldung bzw. das Ergebnis anzeigen kann
        IsValid isValidObj = fizzBuzzService.inputIsValid(input); //Es wird geprüft, ob der Input ein Integer sein kann, extra IsValid Objekt, damit die Methode ein boolean und eine Fehlermeldung zurückgeben kann
        if(!isValidObj.isValid()) return ResponseEntity.ok(isValidObj.getErrorText()); //Wenn der Input ungültig ist, wird mit einer Fehlermeldung inkl. Möglicher Begründung geantwortet
        else return ResponseEntity.ok(fizzBuzzService.getFizzBuzzList(Integer.parseInt(input))); // Und wenn der Input gültig ist, wird mit einer FizzBuzz-Liste geantwortet, welche automatisch in json Format gebracht wird
    }



}
