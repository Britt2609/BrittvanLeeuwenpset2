package com.example.britt.brittvanleeuwenpset2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.service.autofill.FillEventHistory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    Story story;
    public String[] Stories = {"madlib0_simple.txt", "madlib1_tarzan.txt", "madlib2_university.txt", "madlib3_clothes.txt", "madlib4_dance.txt"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void goToThirth(View view) {
        Intent intent = new Intent(this, ThirthActivity.class);
        String choose_story = null;

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.simplestory:
                choose_story = Stories[0];
                break;
            case R.id.clothesstory:
                choose_story = Stories[3];
                break;
            case R.id.dancestory:
                choose_story = Stories[4];
                break;
            case R.id.randomstory:
                List<Integer> index = Arrays.asList(0,1,2,3,4);
                Random choose = new Random();
                int Random_index = index.get(choose.nextInt(index.size()));
                choose_story = Stories[Random_index];
                break;
            case R.id.tarzanstory:
                choose_story = Stories[1];
                break;
            case R.id.universitystory:
                choose_story = Stories[2];
                break;
        }


        intent.putExtra("story", choose_story);
        startActivity(intent);
        finish();
    }
}