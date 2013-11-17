package per.learn.learnabs;

import per.learn.learnabs.utils.LogUtil;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.MenuItem;

public class SettingsActivity extends SherlockPreferenceActivity
        implements Preference.OnPreferenceChangeListener{
    private static final String KEY_LIST_PREFS = "prefs_listprefs";
    PreferenceCategory mDialogPrefCategory;
    Preference mListPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListPrefs = (Preference)findPreference(KEY_LIST_PREFS);
        mListPrefs.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home: {
                finish();
            }break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if(KEY_LIST_PREFS.equals(preference.getKey())) {
            Toast.makeText(this, "Click prefs " + (String)newValue,
                    Toast.LENGTH_SHORT).show();
        }
        return true;
    }

}
