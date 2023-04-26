package com.example.my;

public class status {
    private String text;
    private int layout;

    public status(String text, int layout) {
        this.text = text;
        this.layout = layout;
    }

    public String getText() {
        return text;
    }

    public int getLayout() { return layout;}
}
