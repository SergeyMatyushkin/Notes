package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ProfileFragment.Controller,
        ProfileListFragment.Controller {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new ProfileListFragment())
                .commit();


    }


    @Override
    public void saveResult(NotesEntity myNotes) {

    }

    @Override
    public void openProfileScreen(NotesEntity myNotes) {

        boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        getSupportFragmentManager()
                .beginTransaction()
                .add(isLandscape ? R.id.detail_container : R.id.container, ProfileFragment.newInstance(myNotes))
                .addToBackStack(null)
                .commit();

    }
}