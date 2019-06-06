/***
 * Class responsible for controlling the input received from the web page
 * and sending a post request to the server.
 */

package com.xe_coding_challenge;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
public class WordCounterController {

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public String classifiedForm(Model model){
        model.addAttribute("classified", new Classified());
        return "index";
    }

    @RequestMapping(value = "/count", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Classified> countWordsInText(@RequestBody Classified classified, HttpServletResponse response){

        if(classified != null && !classified.getText().isEmpty()){
            classified.countWords();
        }

        else{
            return  new ResponseEntity<>(classified, HttpStatus.BAD_REQUEST);
        }

        return  new ResponseEntity<>(classified, HttpStatus.OK);
    }

    @RequestMapping(value = "/countHtml", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Classified> countWordsFromHtml(@RequestBody Classified classified, HttpServletResponse response){

        if(classified != null && !classified.getText().isEmpty()){
            classified.countWordsFromHtml();
        }

        else{
            return  new ResponseEntity<>(classified, HttpStatus.BAD_REQUEST);
        }

        return  new ResponseEntity<>(classified, HttpStatus.OK);
    }


}
