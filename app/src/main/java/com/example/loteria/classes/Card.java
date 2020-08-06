package com.example.loteria.classes;

import android.widget.ImageView;

public class Card {

    ImageView imageView;
    int card_number;

    public Card(){

    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int getCard_number() {
        return card_number;
    }

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    }
}
