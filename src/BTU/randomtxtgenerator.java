package com.company;

import java.util.HashMap;
import java.util.Random;


public class RandomTextGenerator implements TextGenerator{
    private String alphabet;
    private String language;

    private Parameter paragraph;
    private Parameter sentence;
    private Parameter word;

    private HashMap<String,String> alphabets;

    public RandomTextGenerator(String language, String parameters) {
        this.language = language;
        setParameters(parameters);
        setAlphabets();
        this.alphabet = alphabets.get(this.language);
    }

    private void setAlphabets() {
        this.alphabets = new HashMap<>();
        this.alphabets.put("en",generateAlpha('a','z'));
        this.alphabets.put("ge",generateAlpha('ა','ჰ'));
        this.alphabets.put("ru",generateAlpha('а','я'));
    }

    // „p-2-s-5-7-w-7-9“,
    private void setParameters(String parameters) {
        String[] params = parameters.split("-");
        this.paragraph = new Parameter("paragraph",params[1],params[1]);
        this.sentence = new Parameter("sentence",params[3],params[4]);
        this.word = new Parameter("word",params[6],params[7]);
    }

    private String generateAlpha(char startSymbol,char endSymbol){
        StringBuilder sb = new StringBuilder();
        for (int i = (int)startSymbol; i <= (int)endSymbol ; i++) {
            sb.append((char)i);
        }
        return sb.toString();
    }

    @Override
    public String generateArticle() {
        StringBuilder sb = new StringBuilder();
        int numberOfSentences = generateRandomIntWithRange(this.paragraph.getMinRange(),this.paragraph.getMaxRange());
        for (int i = 0; i < numberOfSentences; i++) {
            sb.append(generateSentence()).append(".").append("\n");
        }
        return sb.toString();
    }

    @Override
    public String generateSentence() {
        StringBuilder sb = new StringBuilder();
        int numberOfWords = generateRandomIntWithRange(this.sentence.getMinRange(),this.sentence.getMaxRange());
        for (int i = 0; i < numberOfWords; i++) {
            sb.append(generateWord()).append(" ");
        }
        return sb.toString();
    }

    @Override
    public String generateWord() {
        StringBuilder sb = new StringBuilder();
        int numberOfchars = generateRandomIntWithRange(this.word.getMinRange(),this.word.getMaxRange());
        for (int i = 0; i < numberOfchars; i++) {
            sb.append(generateChar());
        }
        return sb.toString();
    }

    @Override
    public String generateChar() {
        return String.valueOf(this.alphabet.charAt(getRandomCharIndex(this.alphabet.length()-1)));
    }

    private int getRandomCharIndex(int maxValue){
        Random ran = new Random();
        return ran.nextInt(maxValue);
    }

    private int generateRandomIntWithRange(int min,int max){
        Random random = new Random();
        return min == max? min : (random.nextInt(max-min) + min);
    }
}
