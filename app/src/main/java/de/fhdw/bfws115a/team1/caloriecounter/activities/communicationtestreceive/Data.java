package de.fhdw.bfws115a.team1.caloriecounter.activities.communicationtestreceive;

import android.os.Bundle;

public class Data {
    private Init mActivity;

    /* Data variables */
    private String mDummyString;
    private int mDummyInt;

    /* Default values */
    private final String DEFAULTDUMMYSTRING = "Dummy";
    private final int DEFAULTDUMMYINT = 937;

    /* Keys */
    private final String KEYDUMMYSTRING = "dailyoverview1";
    private final String KEYDUMMYINT = "dailyoverview2";

    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;

        if (savedInstanceState == null) {
            mDummyString = DEFAULTDUMMYSTRING;
            mDummyInt = DEFAULTDUMMYINT;
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putString(KEYDUMMYSTRING, mDummyString);
        b.putInt(KEYDUMMYINT, DEFAULTDUMMYINT);
    }

    private void restoreDataFromBundle(Bundle b) {
        mDummyString = b.getString(KEYDUMMYSTRING);
        mDummyInt = b.getInt(KEYDUMMYINT);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    /* Setter methods */
}
