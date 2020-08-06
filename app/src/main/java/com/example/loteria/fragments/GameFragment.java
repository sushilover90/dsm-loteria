package com.example.loteria.fragments;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.loteria.R;
import com.example.loteria.classes.GameEngine;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GameFragment extends Fragment {

    ArrayList<Integer> cardNumbers = new ArrayList<>();
    ArrayList<Integer> boardCardNumbers = new ArrayList<>();
    ImageView[] board = new ImageView[16];
    Drawable bean;
    ColorMatrixColorFilter filter;


    public GameFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bean = getActivity().getDrawable(R.drawable.ic_launcher_foreground);

        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        filter = new ColorMatrixColorFilter(matrix);

        for(int i = 0; i<54; i++){
            cardNumbers.add(i);
        }

        boardCardNumbers.add(ThreadLocalRandom.current().nextInt(0,54));
        boolean repeatedNumber;

        for (int i = 0; i< board.length;){
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

        board[0] = view.findViewById(R.id.iv_0);
        board[0].setImageResource(GameEngine.getCard(boardCardNumbers.get(0)));
        board[0].setColorFilter(filter);
        board[0].setForeground(bean);
        board[1] = view.findViewById(R.id.iv_1);
        board[1].setImageResource(GameEngine.getCard(boardCardNumbers.get(1)));
        board[2] = view.findViewById(R.id.iv_2);
        board[2].setImageResource(GameEngine.getCard(boardCardNumbers.get(2)));
        board[3] = view.findViewById(R.id.iv_3);
        board[3].setImageResource(GameEngine.getCard(boardCardNumbers.get(3)));
        board[4] = view.findViewById(R.id.iv_4);
        board[4].setImageResource(GameEngine.getCard(boardCardNumbers.get(4)));
        board[5] = view.findViewById(R.id.iv_5);
        board[5].setImageResource(GameEngine.getCard(boardCardNumbers.get(5)));
        board[6] = view.findViewById(R.id.iv_6);
        board[6].setImageResource(GameEngine.getCard(boardCardNumbers.get(6)));
        board[7] = view.findViewById(R.id.iv_7);
        board[7].setImageResource(GameEngine.getCard(boardCardNumbers.get(7)));
        board[8] = view.findViewById(R.id.iv_8);
        board[8].setImageResource(GameEngine.getCard(boardCardNumbers.get(8)));
        board[9] = view.findViewById(R.id.iv_9);
        board[9].setImageResource(GameEngine.getCard(boardCardNumbers.get(9)));
        board[10] = view.findViewById(R.id.iv_10);
        board[10].setImageResource(GameEngine.getCard(boardCardNumbers.get(10)));
        board[11] = view.findViewById(R.id.iv_11);
        board[11].setImageResource(GameEngine.getCard(boardCardNumbers.get(11)));
        board[12] = view.findViewById(R.id.iv_12);
        board[12].setImageResource(GameEngine.getCard(boardCardNumbers.get(12)));
        board[13] = view.findViewById(R.id.iv_13);
        board[13].setImageResource(GameEngine.getCard(boardCardNumbers.get(13)));
        board[14] = view.findViewById(R.id.iv_14);
        board[14].setImageResource(GameEngine.getCard(boardCardNumbers.get(14)));
        board[15] = view.findViewById(R.id.iv_15);
        board[15].setImageResource(GameEngine.getCard(boardCardNumbers.get(15)));

        return view;
    }

}