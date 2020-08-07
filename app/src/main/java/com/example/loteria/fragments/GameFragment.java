package com.example.loteria.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loteria.R;
import com.example.loteria.classes.Card;
import com.example.loteria.classes.GameEngine;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GameFragment extends Fragment {

    // for local testing, will be remove when making it with the json request
    ArrayList<Integer> cardNumbers = new ArrayList<>();

    // the card *numbers* to your initial 16 cards (board)
    ArrayList<Integer> boardCardNumbers = new ArrayList<>();

    // 16 checks to win
    int cardChecks;

    // only 54 times presses are allowed (54 cards max)
    int timesPressed;

    // your game board
    Card[] board = new Card[16];

    // game card button (to begin game/ask for a card)
    Card cardButton = new Card();

    // grayscale and "bean"
    Drawable bean;
    ColorMatrixColorFilter filter;

    // played cards count textview (tv)
    TextView tvPlayedCardsCount;

    // current played card textview
    TextView tvCurrentPlayedCard;


    public GameFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        timesPressed = 0;

        cardChecks = 0;

        bean = getActivity().getDrawable(R.drawable.ic_launcher_foreground);

        // for grayscale and place the "bean" over the image
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        filter = new ColorMatrixColorFilter(matrix);

        for(int i = 0; i<54; i++){
            cardNumbers.add(i);
        }

        for(int i = 0; i<board.length;i++){
            board[i] = new Card();
        }

        boardCardNumbers.add(ThreadLocalRandom.current().nextInt(0,54));
        boolean repeatedNumber;

        for (int i = 0; i< board.length - 1;){
            repeatedNumber = false;
            int number = ThreadLocalRandom.current().nextInt(0,54);

            for(int j = 0; j<boardCardNumbers.size();j++){
                if(number == boardCardNumbers.get(j)){
                    repeatedNumber = true;
                    break;
                }
            }
            if(!repeatedNumber){
                boardCardNumbers.add(number);
                i++;
            }

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        setGame(view);

        return view;
    }

    public void askCard(){

    }

    @SuppressLint("SetTextI18n")
    public void setGame(View view){

        tvPlayedCardsCount = view.findViewById(R.id.tv_gamePlayedCardsCount);

        tvPlayedCardsCount.setText(String.valueOf(timesPressed));

        tvCurrentPlayedCard = view.findViewById(R.id.tv_gameCurrentCard);

        cardButton.setImageView( (ImageView) view.findViewById(R.id.iv_current));

        tvCurrentPlayedCard.setText("Press begin to start.");

        cardButton.getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Game has begun", Toast.LENGTH_SHORT).show();

                tvCurrentPlayedCard.setText("Current played card:");

                cardButton.getImageView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        timesPressed++;

                        int cardNumber = cardNumbers.get(ThreadLocalRandom.current().nextInt(0, cardNumbers.size()));
                        cardNumbers.remove((Integer) cardNumber);

                        tvPlayedCardsCount.setText(String.valueOf(timesPressed));

                        cardButton.getImageView().setImageResource(GameEngine.getCard(cardNumber));

                        for (Card card : board) {
                            if (cardNumber == card.getCard_number() && !card.isChecked()) {
                                card.getImageView().setForeground(bean);
                                card.getImageView().setColorFilter(filter);
                                card.checkCard();
                                cardChecks++;
                                break;
                            }
                        }

                        if(timesPressed>=54 || cardChecks >=16){
                            cardButton.getImageView().setImageResource(R.drawable.finished);

                            String infoText = "Press Finished to restart.";

                            if(cardChecks >= 16){
                                cardButton.getImageView().setImageResource(R.drawable.loteria_win);
                                Toast.makeText(getActivity(), "You win", Toast.LENGTH_SHORT).show();
                                infoText = "Press lotería to restart.";
                            }

                            tvCurrentPlayedCard.setText(infoText);

                            cardButton.getImageView().setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = getActivity().getIntent();
                                    getActivity().finish();
                                    startActivity(intent);
                                }
                            });
                        }

                    }
                });

                cardButton.getImageView().performClick();

            }
        });

        board[0].setImageView( (ImageView) view.findViewById(R.id.iv_0));
        board[1].setImageView( (ImageView) view.findViewById(R.id.iv_1));
        board[2].setImageView( (ImageView) view.findViewById(R.id.iv_2));
        board[3].setImageView( (ImageView) view.findViewById(R.id.iv_3));
        board[4].setImageView( (ImageView) view.findViewById(R.id.iv_4));
        board[5].setImageView( (ImageView) view.findViewById(R.id.iv_5));
        board[6].setImageView( (ImageView) view.findViewById(R.id.iv_6));
        board[7].setImageView( (ImageView) view.findViewById(R.id.iv_7));
        board[8].setImageView( (ImageView) view.findViewById(R.id.iv_8));
        board[9].setImageView( (ImageView) view.findViewById(R.id.iv_9));
        board[10].setImageView( (ImageView) view.findViewById(R.id.iv_10));
        board[11].setImageView( (ImageView) view.findViewById(R.id.iv_11));
        board[12].setImageView( (ImageView) view.findViewById(R.id.iv_12));
        board[13].setImageView( (ImageView) view.findViewById(R.id.iv_13));
        board[14].setImageView( (ImageView) view.findViewById(R.id.iv_14));
        board[15].setImageView( (ImageView) view.findViewById(R.id.iv_15));

        for(int i = 0; i<board.length;i++){

            board[i].getImageView().setImageResource(GameEngine.getCard(boardCardNumbers.get(i)));
            board[i].setCard_number(boardCardNumbers.get(i));

        }

    }

}