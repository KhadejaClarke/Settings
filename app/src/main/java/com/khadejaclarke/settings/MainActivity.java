package com.khadejaclarke.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        showUpdateDialog();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isChecked = sharedPreferences.getBoolean("Dark Theme", false);

        if (isChecked)
            setTheme(R.style.DarkTheme);
        else
            setTheme(R.style.LightTheme);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            startActivity(new Intent(this, ThemePreferenceActivity.class));

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showUpdateDialog(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("App version upgrade")
                .setMessage("Would you like to upgrade now or later?")
                .setPositiveButton("Now", (dialog, which) -> progressBar.setVisibility(View.VISIBLE))
                .setNegativeButton("Later", (dialog, which) -> textView.setVisibility(View.VISIBLE))
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
