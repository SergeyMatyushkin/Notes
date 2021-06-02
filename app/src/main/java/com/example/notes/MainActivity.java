package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private NotesEntity myNotes = new NotesEntity("Встреча", "20.07.2021", "Обязательно взять с собой Николая Петровича и документы по " +
            "Фонду");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.open_notes).setOnClickListener(v -> {
            Profile_kFragment profileKFragment = new Profile_kFragment(myNotes);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, profileKFragment)
                    .commit();
        });
    }
}