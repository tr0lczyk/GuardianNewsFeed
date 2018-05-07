package com.example.android.guardiannewsfeed.util;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NullLoop {

    public static String defaultStatement = "No info";

    public static void nullVerifier(TextView one, TextView two, TextView three, TextView four){
        List<TextView> textList = new ArrayList<>();
        textList.add(one);
        textList.add(two);
        textList.add(three);
        textList.add(four);
        for (int i = 0; i < textList.size(); i++) {
            TextView currentTextView = textList.get(i);
            if(currentTextView.getText().equals("")){
                currentTextView.setText(defaultStatement);
            }
        }
    }
}
