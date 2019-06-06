package com.xe_coding_challenge;

import org.jsoup.Jsoup;

import java.util.regex.Pattern;

/**
 * Class which represents a classified object.
 * A classified is a text along with the number of words it contains
 */
public class Classified {
    private String text;
    private int words;


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
     * setter for text input
     * @param text
     */
    public void setText(String text){
        this.text = text;
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
        //match HTML tags
       /* String strRegEx = "<[^>]*>";

        // split by new line
        String[] htmlLines = text.split("\\s+");

        //clear text variable
        this.text = "";

        //replace all html tags with an empty string
        for (String line : htmlLines) {
            line.replaceAll(strRegEx, "");
            this.text += line;
        }*/

        String parsedText = Jsoup.parse(text).text();

        this.text = parsedText;
        this.words = splitStringAndCount(this.text);

    }

    private int splitStringAndCount(String text){
        int count = 0;


        /**Split the text on whitespaces, then iterate on this array to figure out the exact number of words**/
        String[] array = text.split("\\s+");

        for (int i = 0; i < array.length; i++) {
            if (array[i].length() >= 2 && !Pattern.matches("\\p{Punct}", array[i])) {
                count++;
            }
        }

        return count;
    }
}
