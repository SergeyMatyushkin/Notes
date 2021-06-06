package com.example.notes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileListFragment extends Fragment {

    private final NotesEntity myNotes = new NotesEntity("Встреча", "20.07.2021",
            "Обязательно взять с собой Николая Петровича и документы по " +
                    "Фонду");
    private final NotesEntity myNotes1 = new NotesEntity("Мероприятие", "22.07.2021",
            "Провести мероприятие на крыше небоскреба");
    private final NotesEntity myNotes2 = new NotesEntity("Праздник", "28.07.2021",
            "Посетить день рождение Начальника");
    private final NotesEntity myNotes3 = new NotesEntity("Футбольный матч", "30.07.2021",
            "Играем в футбол с Производственным отделом");
    private LinearLayout linearLayout;

    private void addNotesToList(NotesEntity notesEntity) {
        Button button = new Button(getContext());
        button.setText(notesEntity.toString());
        button.setOnClickListener(v -> {
            ((Controller) getActivity()).openProfileScreen(notesEntity);
        });
        linearLayout.addView(button);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_list, null);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof Controller)) {
            throw new RuntimeException("Activity must implement ProfileListFragment");

        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        linearLayout = view.findViewById(R.id.linear);
        addNotesToList(myNotes);
        addNotesToList(myNotes1);
        addNotesToList(myNotes2);
        addNotesToList(myNotes3);
    }

    interface Controller {
        void openProfileScreen(NotesEntity myNotes);
    }


}
