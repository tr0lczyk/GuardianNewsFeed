package com.example.android.guardiannewsfeed;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
    }

    public static class GuardianPreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener{

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_main);
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            String updatedValue = newValue.toString();
            preference.setSummary(updatedValue);
            return false;
        }
    }
}
