package com.example.notes;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class ProfileFragment extends Fragment {

    public static final String NOTES_ARGS_KEY = "NOTES_ARGS_KEY";


    private NotesEntity myNotes = null;

    private EditText nameEt;
    private EditText dateEt;
    private EditText descriptionEt;
    private Button saveButton;

    public static ProfileFragment newInstance(NotesEntity notesEntity) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putParcelable(NOTES_ARGS_KEY, notesEntity);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, null);
        nameEt = view.findViewById(R.id.name_note);
        dateEt = view.findViewById(R.id.note_date);
        descriptionEt = view.findViewById(R.id.description_note);

        saveButton = view.findViewById((R.id.save_button));
        saveButton.setOnClickListener(v -> {
            Controller controller = (Controller) getActivity();
            controller.saveResult(new NotesEntity(
                    nameEt.getText().toString(),
                    dateEt.getText().toString(),
                    descriptionEt.getText().toString()
            ));
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle saveInstanceState) {
        nameEt.setText(myNotes.name);
        dateEt.setText(myNotes.date);
        descriptionEt.setText(myNotes.description);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof Controller))
            throw new RuntimeException("Activity must implement ProfileController");
        if (getArguments() != null) {
            myNotes = getArguments().getParcelable(NOTES_ARGS_KEY);
        }
    }

    public interface Controller {
        void saveResult(NotesEntity myNotes);

    }


}