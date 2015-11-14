package com.ordonteam.daggervskotlin;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import rx.functions.Action1;

public class Utils {

    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).bitmapTransform(new CropCircleTransformation(imageView.getContext())).into(imageView);
    }

    public static void addOnTextChangedListener(EditText viewById, final Action1<String> onQueryChanged) {
        viewById.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                onQueryChanged.call(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public static View inflate(ViewGroup parent, int layout) {
        return LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
    }
}
