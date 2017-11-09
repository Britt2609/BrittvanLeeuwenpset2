package com.example.britt.brittvanleeuwenpset2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class ThirthActivity extends AppCompatActivity {
    public Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirth);

        Intent intent = getIntent();
        String name = intent.getStringExtra("story");

        AssetManager assetManager = getAssets();
        InputStream input = null;
        try {
            input = assetManager.open(name);
        } catch (IOException e) {
            Log.e("message", e.getMessage());
        }
        story = new Story(input);

        TextView count = (TextView) findViewById(R.id.wordCount);
        EditText filling = (EditText) findViewById(R.id.fillwords);
        TextView word = (TextView) findViewById(R.id.wordType);


        count.setText(story.getPlaceholderCount() + " words to go!");
        filling.setHint(story.getNextPlaceholder());
        word.setText("Fill in a/an " + story.getNextPlaceholder());
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("story", story);
    }

    @Override
    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);

        TextView count = (TextView) findViewById(R.id.wordCount);
        EditText filling = (EditText) findViewById(R.id.fillwords);
        TextView word = (TextView) findViewById(R.id.wordType);

        story = (Story) inState.getSerializable("story");
        count.setText(story.getPlaceholderRemainingCount() + " words to go!");
        filling.setHint(story.getNextPlaceholder());
        word.setText("Fill in a/an " + story.getNextPlaceholder());

    }




    public void Refresh(View view) {
        EditText wordfill = findViewById(R.id.fillwords);
        if (wordfill.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "At least one character must be given", Toast.LENGTH_SHORT).show();
        }

        else {
            story.fillInPlaceholder(wordfill.getText().toString());

            if (story.isFilledIn()) {
                Intent intent = new Intent(this, FourthActivity.class);
                String completeStory = story.toString();
                intent.putExtra("story", completeStory);
                startActivity(intent);
                finish();
            } else {

                TextView count = (TextView) findViewById(R.id.wordCount);

                count.setText(story.getPlaceholderRemainingCount() + " words to go!");

                EditText filling = (EditText) findViewById(R.id.fillwords);
                filling.setText(null);
                filling.setHint(story.getNextPlaceholder());
                TextView word = (TextView) findViewById(R.id.wordType);
                word.setText("Fill in a/an " + story.getNextPlaceholder());
            }
        }

    }
}
