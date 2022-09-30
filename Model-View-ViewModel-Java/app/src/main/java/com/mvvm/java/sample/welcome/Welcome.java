package com.mvvm.java.sample.welcome;

public class Welcome {
    private final int image;
    private final int headline;
    private final int description;

    public Welcome(int image, int headline, int description) {
        this.image = image;
        this.headline = headline;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public int getHeadline() {
        return headline;
    }

    public int getDescription() {
        return description;
    }
}