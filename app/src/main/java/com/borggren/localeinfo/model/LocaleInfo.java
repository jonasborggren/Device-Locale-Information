package com.borggren.localeinfo.model;

import android.content.Context;

import com.borggren.localeinfo.R;

/**
 * Created by jonas on 12/03/17.
 */

public class LocaleInfo {

    private int titleResId;
    private String summary;

    public LocaleInfo(int titleResId, String summary) {
        this.titleResId = titleResId;
        this.summary = summary;
    }

    public String getTitle(Context context) {
        return context.getString(titleResId);
    }

    public String getSummary() {
        return summary;
    }
}
