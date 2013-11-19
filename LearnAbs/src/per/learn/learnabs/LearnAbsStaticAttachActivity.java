package per.learn.learnabs;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.ActionBarSherlock;

public class LearnAbsStaticAttachActivity extends Activity
        implements ActionBarSherlock.OnCreateOptionsMenuListener,
        ActionBarSherlock.OnOptionsItemSelectedListener{
    ActionBarSherlock mSherlockBar = ActionBarSherlock.wrap(this);
    TextView mContentTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //mSherlockBar.setUiOptions(ActivityInfo.UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW);
        mSherlockBar.setContentView(R.layout.activity_learn_abs);
        mSherlockBar.getActionBar().setDisplayHomeAsUpEnabled(true);

        mContentTv = (TextView)findViewById(R.id.content_tv);
        mContentTv.setText("static attach a action bar for a activity");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return mSherlockBar.dispatchCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mSherlockBar.dispatchOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
        mSherlockBar.getMenuInflater().inflate(R.menu.learn_abs, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(
            com.actionbarsherlock.view.MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_mode: {
                mContentTv.setText("U click item action mode");
            }break;

            case R.id.action_go: {
                mContentTv.setText("U click item action go");
            }break;

            case android.R.id.home: {
                finish();
            }break;
        }

        return true;
    }

}
