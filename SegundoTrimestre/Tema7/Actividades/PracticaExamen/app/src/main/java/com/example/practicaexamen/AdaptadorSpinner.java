package com.example.practicaexamen;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class AdaptadorSpinner extends ArrayAdapter {
    public AdaptadorSpinner(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
