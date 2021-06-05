package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ProfileFragment.Controller{

    private TextView resultTextView;

    private NotesEntity myNotes = new NotesEntity("Встреча", "20.07.2021", "Обязательно взять с собой Николая Петровича и документы по " +
            "Фонду");
    private ProfileFragment profileFragment = ProfileFragment.newInstance(myNotes);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result_text_view);

        findViewById(R.id.open_notes).setOnClickListener(v -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, profileFragment)
                    .commit();
        });
    }

    @Override
    public void saveResult(NotesEntity myNotes) {

    resultTextView.setText(String.format("%s %s %s",
            myNotes.name,
            myNotes.date,
            myNotes.description));

    }
}