package com.example.calculator_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity_Log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            log("Fresh Create");
        } else {
            log("Recreate");
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
        log("Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("Stopped");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        log("Save Instance State");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("Destroyed");
    }

    private void log(String message) {
        Log.d(TAG, message);
        Toast.makeText(this, "сейчас " + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}