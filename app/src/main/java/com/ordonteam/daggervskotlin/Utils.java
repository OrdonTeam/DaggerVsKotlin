package com.ordonteam.daggervskotlin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class Utils {

    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).bitmapTransform(new CropCircleTransformation(imageView.getContext())).into(imageView);
    }

    public static View inflate(ViewGroup parent, int layout) {
        return LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
    }
}
