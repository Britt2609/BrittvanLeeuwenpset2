package com.example.britt.brittvanleeuwenpset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Intent intent = getIntent();
        String complete = intent.getStringExtra("story");

        TextView stor = (TextView) findViewById(R.id.complete_story);
        stor.setText(Html.fromHtml(complete));
    }

    public void CreateNewStory(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();
    }
}
