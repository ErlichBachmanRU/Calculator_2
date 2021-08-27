package com.example.calculator_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn0,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn1;

    private TextView displayResultsView;
    private DisplayResults displayResults = new DisplayResults();
    private static final String ARG_DISPRES_VALUE = "ARG_DISPRES_VALUE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayResultsView = findViewById(R.id.user_input);

        if (savedInstanceState == null) {

            displayResults = new DisplayResults();

        } else {
            displayResults = savedInstanceState.getParcelable(ARG_DISPRES_VALUE);
        }


        findViewById(R.id.key_0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayResults.increase();
                updateDisplayResults();
            }
        });

    }

    private void updateDisplayResults() {
        displayResultsView.setText(String.valueOf(111));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.info_button_activity_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnInfo:
                onClickBtnInfo();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void onClickBtnInfo() {
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(ARG_DISPRES_VALUE, displayResults );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onClick(View view) {

    }
}