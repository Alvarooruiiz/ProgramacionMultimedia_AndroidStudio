package com.example.exament7_13_02_ruizenriquezalvaro;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import androidx.annotation.Nullable;
import androidx.preference.PreferenceCategory;

public class configPreferences extends PreferenceActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.configpreferences);
    }
}
