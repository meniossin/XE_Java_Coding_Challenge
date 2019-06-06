package com.xe_coding_challenge;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;


public class XeCodingChallengeApplicationTests extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    static final String uri = "/count";

   @Test
    public void givenClassifiedOne_countWordsAndReturnJson() throws Exception{

          String text = "ΚΥΒΕΡΝΗΤΗΣ Γ' πιστοποιημένος ζητείται για ημερόπλοιο μοντέλου Πέραμα στη Μύκονο there@gmail.com";

          Classified classified = new Classified(text);

          String inputJson = super.mapToJson(classified);

          MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(inputJson)).andReturn();

          int status = mvcResult.getResponse().getStatus();

          Classified jsonToClassified = super.mapFromJson(mvcResult.getResponse().getContentAsString(), Classified.class);
          assertEquals(200, status);

          assertEquals(jsonToClassified.getWords(), 11);
    }

    @Test
    public void givenClassifiedTwo_countWordsAndReturnJson() throws  Exception{
         String text = "ABARTH S4 595FL, 1.400 cc, μοντ. 6/'17, 160 hp, μαύρο μεταλλικό, 4.000 χλμ., 3θυρο, Τ-Jet Pista 1368, 10 φορολογίσιμοι ίπποι, τιμή 10.000€";

         Classified classified = new Classified(text);

         String inputJson = super.mapToJson(classified);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        Classified jsonToClassified = super.mapFromJson(mvcResult.getResponse().getContentAsString(), Classified.class);
        assertEquals(200, status);

        assertEquals(jsonToClassified.getWords(), 22);
    }

    @Test
    public void givenClassifiedThree_countWordsAndReturnJson() throws  Exception{
       String text = "ΑΝΑΒΥΣΣΟΣ μεζονέτα 195 τ.μ., ισόγεια, 3 υ/δ, κατασκευή '12, 2 μπάνια, σε οικόπεδο 375 τ.μ., αυτόνομη θέρμανση, κλιματισμός, τζάκι, θέα θάλασσα, κλειστό πάρκιν, αποθήκη, κήπος, άριστη κατάσταση, 2 κυρίως επιπέδων, ευήλιο καθιστικό με θέα, υπόγειο φωτεινό που χρησιμοποιείται ως πλήρης ξενώνας, πισίνα με εξοπλισμένο περιβάλλοντα χώρο χαλάρωσης, walking distance από οργανωμένη παραλία, τιμή 570.000€";

        Classified classified = new Classified(text);

        String inputJson = super.mapToJson(classified);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        Classified jsonToClassified = super.mapFromJson(mvcResult.getResponse().getContentAsString(), Classified.class);
        assertEquals(200, status);

        assertEquals(jsonToClassified.getWords(), 51);


   }



}
