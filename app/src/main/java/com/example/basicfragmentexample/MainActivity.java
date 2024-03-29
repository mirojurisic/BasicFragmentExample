package com.example.basicfragmentexample;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {
    Button activityButton;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// get the reference of Button
        activityButton = (Button) findViewById(R.id.activity_button);

// perform setOnClickListener event on Button
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment f = fragmentManager.findFragmentByTag("FRAGMENT2");
                if (f  != null && f .isVisible()) {
                    fragmentTransaction. replace( R.id.main_frame,new MyFragment3(), "FRAGMENT3").addToBackStack("FRAGMENT3").commit();
                    Toast.makeText(getApplicationContext(), "FRAGMENT3", Toast.LENGTH_LONG).show();
                }
                else {
                    fragmentTransaction.replace(R.id.main_frame, new MyFragment2(), "FRAGMENT2").addToBackStack("FRAGMENT3").commit();
                    Toast.makeText(getApplicationContext(), "FRAGMENT2", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}