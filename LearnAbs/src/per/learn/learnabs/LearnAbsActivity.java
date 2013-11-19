package per.learn.learnabs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class LearnAbsActivity extends SherlockActivity implements ActionMode.Callback{
    TextView mContentTv;

    ActionMode mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_abs);

        mContentTv = (TextView)findViewById(R.id.content_tv);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Settings");
        getSupportActionBar().setIcon(R.drawable.ic_launcher_settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.learn_abs, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mContentTv != null)
            mContentTv.setText("U click item " + item.getTitle());
        switch(item.getItemId()) {
            case R.id.action_go: {
                startActivity(new Intent(this, LearnAbsOtherActivity.class));
            }break;

            case R.id.action_mode: {
                mActionMode = startActionMode(this);
            }break;

            case android.R.id.home: {
                startActivity(new Intent(this, SettingsActivity.class));
            }break;

            case R.id.action_search: {
                startActivity(new Intent(this, LearnAbsSearchActivity.class));
            }break;

            case R.id.action_attach: {
                startActivity(new Intent(this, LearnAbsStaticAttachActivity.class));
            }break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getSupportMenuInflater().inflate(R.menu.learn_abs, menu);
        menu.removeItem(R.id.action_mode);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_go: {
                startActivity(new Intent(this, LearnAbsOtherActivity.class));
            }
        }
        if(mActionMode != null)
            mActionMode.finish();

        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
    }

}
