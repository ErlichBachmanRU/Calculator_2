package com.example.calculator_2;

import android.os.Parcel;
import android.os.Parcelable;

public class DisplayResults implements Parcelable {
    private int value;

    public DisplayResults(){

    }

    protected DisplayResults(Parcel in) {
        value = in.readInt();
    }

    public static final Creator<DisplayResults> CREATOR = new Creator<DisplayResults>() {
        @Override
        public DisplayResults createFromParcel(Parcel in) {
            return new DisplayResults(in);
        }

        @Override
        public DisplayResults[] newArray(int size) {
            return new DisplayResults[size];
        }
    };

    public int getValue() {
        return value;
    }

    public void increase() {
        value++;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(value);
    }
}
