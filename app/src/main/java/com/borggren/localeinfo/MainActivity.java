package com.borggren.localeinfo;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.borggren.localeinfo.model.LocaleInfo;
import com.borggren.localeinfo.adapter.LocaleRecyclerAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseAnalytics.getInstance(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(getAdapter());
    }

    private LocaleRecyclerAdapter getAdapter() {
        List<LocaleInfo> items = new ArrayList<>();
        items.add(new LocaleInfo(R.string.title_locale, Locale.getDefault().toString()));
        items.add(new LocaleInfo(R.string.title_language, Locale.getDefault().getLanguage()));
        items.add(new LocaleInfo(R.string.title_country, Locale.getDefault().getCountry()));
        items.add(new LocaleInfo(R.string.title_iso3_country, Locale.getDefault().getISO3Country()));
        items.add(new LocaleInfo(R.string.title_iso3_language, Locale.getDefault().getISO3Language()));
        items.add(new LocaleInfo(R.string.title_display_country, Locale.getDefault().getDisplayCountry()));
        items.add(new LocaleInfo(R.string.title_display_language, Locale.getDefault().getDisplayLanguage()));
        items.add(new LocaleInfo(R.string.title_display_name, Locale.getDefault().getDisplayName()));
        items.add(new LocaleInfo(R.string.title_display_variant, Locale.getDefault().getDisplayVariant()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            items.add(new LocaleInfo(R.string.title_display_script, Locale.getDefault().getDisplayScript()));
        }
        return new LocaleRecyclerAdapter(items);
    }
}
