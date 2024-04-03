package com.example.actividades7tema5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private final String[] animalNames;
    private final int[] animalImages;

    public ImageAdapter(Context context, String[] animalNames, int[] animalImages) {
        this.context = context;
        this.animalNames = animalNames;
        this.animalImages = animalImages;
    }

    @Override
    public int getCount() {
        return animalNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            int imageSize = 200;
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 5, 5, 5);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(animalImages[position]);
        return imageView;
    }
}