package com.xe_coding_challenge.model;

import org.jsoup.Jsoup;

import java.util.regex.Pattern;

/**
 * Class which represents a classified object.
 * A classified is a text along with the number of words it contains
 */
public class Classified {
    private String text;
    private int words;
    private String price;

    public Classified(){

    }

   public Classified(String text){
        this.text = text;
    }

    /**
     * Getter for text
     * @return String
     */
    public String getText(){
        return  this.text;
    }

    /**
     * Getter for price
     */
    public String getPrice(){
        return this.price;
    }

    /**
     * Getter for word count
     * @return
     */
    public int getWords(){
        return  this.words;
    }

    /**
     * Method that calculates the number of words in a given classified text
     * @return
     */
    public void countWords(){
        int count = 0;

        this.words = splitStringAndCount(text);

        System.out.println("Number of words in the given classified are: " +count);
    }

    /**
     * Method that counts the words from given HTML text by first stripping away all the HTML tags.
     * We use a regex to achieve this and its logic is the following: "<[^>]*>"
     *
     * < - start bracket
     * [^>] - followed by any character which is not closing bracket ">"
     * * - zero or more times
     * > - followed by closing bracket
     *
     * @return
     */
    public void countWordsFromHtml(){

        //strip HTML tags using the Jsoup library
        String parsedText = Jsoup.parse(text).text();

        this.text = parsedText;

        //split the parsed text and count its words
        this.words = splitStringAndCount(this.text);

    }

    private int splitStringAndCount(String text){
        int count = 0;

        /**Split the text on whitespaces, then iterate on this array to figure out the exact number of words**/
        String[] array = text.split("\\s+");

        for (int i = 0; i < array.length; i++) {

            //if the word is greater or equal than 2 characters and regex pattern does not match punctuation chars, count it as one word
            if (array[i].length() >= 2 && !Pattern.matches("\\p{Punct}", array[i])) {
                count++;

                //if the word contains the euro sign, treat it as price, also increment the count
                if(array[i].contains("€")){
                    price = array[i];
                }
            }


        }

        return count;
    }
}
