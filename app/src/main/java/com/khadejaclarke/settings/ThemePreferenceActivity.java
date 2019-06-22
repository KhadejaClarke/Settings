package com.khadejaclarke.settings;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;

import java.util.List;

public class ThemePreferenceActivity extends PreferenceActivity {
    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.headers, target);
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return StylesThemes.class.getName().equals(fragmentName);
    }

    public static class StylesThemes extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.stylesthemes);
            final SwitchPreference enableDisable = (SwitchPreference) findPreference("Dark Theme");
            enableDisable.setOnPreferenceChangeListener((preference, o) -> {
                if (enableDisable.isChecked())
                    enableDisable.setChecked(false);
                else
                    enableDisable.setChecked(true);

                return false;
            });
        }
    }
}
