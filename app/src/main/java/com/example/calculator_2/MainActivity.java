package com.example.calculator_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.calculator_2.calculator.Calculator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Calculator calculator;

    private TextView userinput ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] idsNumb = new int[]{
                R.id.key_0,
                R.id.key_1,
                R.id.key_2,
                R.id.key_3,
                R.id.key_4,
                R.id.key_5,
                R.id.key_6,
                R.id.key_7,
                R.id.key_8,
                R.id.key_9,
        };

        int[] idsOperators = new int[]{
                R.id.division,
                R.id.key_plus,
                R.id.multiplication,
                R.id.key_minus,
                R.id.btn_result,
                R.id.percent
        };

        userinput = findViewById(R.id.user_input);
        calculator = new Calculator();

        View.OnClickListener numbButtonClicked = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.numbClicked(view.getId());
                userinput.setText(calculator.getText());
            }
        };

        View.OnClickListener operationButtonClicked = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.operatorClicked(view.getId());
                userinput.setText(calculator.getText());
            }
        };
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.reset();
                userinput.setText(calculator.getText());
            }
        });

        for (int i = 0; i < idsNumb.length; i++) {
            findViewById(idsNumb[i]).setOnClickListener(numbButtonClicked);
        }

        for (int i = 0; i < idsOperators.length; i++) {
            findViewById(idsOperators[i]).setOnClickListener(operationButtonClicked);
        }

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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onClick(View view) {

    }
}