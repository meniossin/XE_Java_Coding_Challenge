

package com.xe_coding_challenge.controller;

import com.xe_coding_challenge.model.Classified;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 *
 * Class responsible for controlling the input received from the web page
 * and sending a post request to the server.
 *
 * @author: menios.sin@gmail.com
 * @version 1.0
 *
 */

@RestController
public class WordCounterController {



    @PostMapping(value = "/count", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Classified> countWordsInText(@RequestBody Classified classified){

        if(classified != null && !classified.getText().isEmpty()){
            classified.countWords();
        }

        else{
            return  new ResponseEntity<>(classified, HttpStatus.BAD_REQUEST);
        }

        return  new ResponseEntity<>(classified, HttpStatus.OK);
    }

    @PostMapping(value = "/countHtml", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Classified> countWordsFromHtml(@RequestBody Classified classified ){

        if(classified != null && !classified.getText().isEmpty()){
            classified.countWordsFromHtml();
        }

        else{
            return  new ResponseEntity<>(classified, HttpStatus.BAD_REQUEST);
        }

        return  new ResponseEntity<>(classified, HttpStatus.OK);
    }
}
