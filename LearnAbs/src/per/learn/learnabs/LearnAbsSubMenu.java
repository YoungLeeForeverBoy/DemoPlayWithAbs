package per.learn.learnabs;

import android.os.Bundle;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;

public class LearnAbsSubMenu extends SherlockActivity {
    TextView mContentTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_abs);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("SubMenu");

        mContentTv = (TextView)findViewById(R.id.content_tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu sub2 = menu.addSubMenu(Menu.NONE, 2, 100, "submenu2");
        sub2.add("Four");
        sub2.add("Five");
        sub2.add("Six");
        MenuItem item2 = sub2.getItem();
        item2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        item2.setIcon(R.drawable.ic_launcher_settings);

        getSupportMenuInflater().inflate(R.menu.learn_abs_submenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mContentTv.setText("item.id = " + item.getItemId()
                + ", item.title = " + item.getTitle()
                + " , hasSubMenu = " + item.hasSubMenu());
        switch(item.getItemId()) {
            case android.R.id.home: {
                mContentTv.setText("click home button");
                finish();
            }break;
        }

        return super.onOptionsItemSelected(item);
    }

}
