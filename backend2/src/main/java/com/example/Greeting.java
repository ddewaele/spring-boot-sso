package com.example;

/**
 * Created by ddewaele on 18/02/16.
 */
public class Greeting {

    private String text;

    public Greeting() {

    }

    public Greeting(String text) {
        this.text=text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
