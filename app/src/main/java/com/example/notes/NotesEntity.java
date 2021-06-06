package com.example.notes;

import android.os.Parcel;
import android.os.Parcelable;

public class NotesEntity implements Parcelable {
    public String name;
    public String date;
    public String description;

    @Override
    public String toString() {

        return name + ' ' + date + ' ' + description;
    }

    public NotesEntity(String name, String date, String description) {
        this.name = name;
        this.date = date;
        this.description = description;
    }

    protected NotesEntity(Parcel in) {
        name = in.readString();
        date = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(date);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NotesEntity> CREATOR = new Creator<NotesEntity>() {
        @Override
        public NotesEntity createFromParcel(Parcel in) {
            return new NotesEntity(in);
        }

        @Override
        public NotesEntity[] newArray(int size) {
            return new NotesEntity[size];
        }
    };


}
