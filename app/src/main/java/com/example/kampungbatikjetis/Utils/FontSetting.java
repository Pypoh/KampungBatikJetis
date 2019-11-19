package com.example.kampungbatikjetis.Utils;

import android.app.Application;

public class FontSetting extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/raleway_regular.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/raleway_regular.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/raleway_regular.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/raleway_regular.ttf");
    }
}
