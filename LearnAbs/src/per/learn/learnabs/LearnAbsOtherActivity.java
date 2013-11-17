package per.learn.learnabs;

import per.learn.learnabs.utils.LogUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class LearnAbsOtherActivity extends SherlockActivity implements ActionBar.TabListener{
    public static final int TAB_NUM = 5;
    public static final String TAB_ITEM_NO_TITLEBAR = "no_titlebar";

    private boolean mIsTitleBarShowing = true;
    private MenuItem mNoTitleItem;

    TextView mContentTv;

    ActionBar.Tab mTab;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.learn_abs_other, menu);
        mNoTitleItem = menu.findItem(R.id.action_no_titlebar);
        if(mNoTitleItem != null && mIsTitleBarShowing)
            mNoTitleItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        else if(mNoTitleItem != null && !mIsTitleBarShowing)
            mNoTitleItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home: {
                finish();
            }break;

            case R.id.action_no_titlebar: {
                mIsTitleBarShowing = !mIsTitleBarShowing;
                getSupportActionBar().setDisplayShowTitleEnabled(mIsTitleBarShowing);
                getSupportActionBar().setDisplayShowHomeEnabled(mIsTitleBarShowing);

                invalidateOptionsMenu();
            }break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_abs);
        setTitle(R.string.other_learn_abs_activity_title);

        mContentTv = (TextView)findViewById(R.id.content_tv);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //init tab mode
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for(int i = 0; i < TAB_NUM; i++) {
            mTab = getSupportActionBar().newTab();
            mTab.setText("Tab " + (i + 1));
            mTab.setTabListener(this);

            getSupportActionBar().addTab(mTab);
        }
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        mContentTv.setText("current tab : " +tab.getText());
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        
    }

}
