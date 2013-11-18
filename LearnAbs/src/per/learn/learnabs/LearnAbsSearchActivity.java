package per.learn.learnabs;

import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.SearchView;

public class LearnAbsSearchActivity extends SherlockActivity implements
        SearchView.OnQueryTextListener, SearchView.OnSuggestionListener{
    private TextView mContentTv;
    private MenuItem mSearchMenuItem;
    private SearchView mSearchView;
    private SuggestionsAdapter mSuggestionsAdapter;
    private Cursor mCursor;

    private static final String[] mColumns = new String[] {
        BaseColumns._ID, SearchManager.SUGGEST_COLUMN_TEXT_1
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.learn_abs_search, menu);
        mSearchMenuItem = menu.findItem(R.id.action_search)
                .setActionView(mSearchView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home: {
                finish();
            }break;
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_abs);
        setTitle("Searh view");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mContentTv = (TextView)findViewById(R.id.content_tv);
        mContentTv.setText("Search view");

        if(mSearchView == null) {
            mSearchView = new SearchView(this);
            mSearchView.setQueryHint("Search one city...");
            mSearchView.setOnQueryTextListener(this);
            mSearchView.setOnSuggestionListener(this);
        }
        if(mSuggestionsAdapter == null) {
            MatrixCursor cursor = new MatrixCursor(mColumns);
            cursor.addRow(new String[] {"1", "Shanghai"});
            cursor.addRow(new String[] {"2", "Beijing"});
            cursor.addRow(new String[] {"3", "Guangzhou"});
            cursor.addRow(new String[] {"4", "Shenzhen"});
            cursor.addRow(new String[] {"5", "Hangzhou"});
            mSuggestionsAdapter = new SuggestionsAdapter(this, cursor);
        }
        mSearchView.setSuggestionsAdapter(mSuggestionsAdapter);
    }

    @Override
    public boolean onSuggestionSelect(int position) {
        return false;
    }

    @Override
    public boolean onSuggestionClick(int position) {
        mCursor = (Cursor) mSuggestionsAdapter.getItem(position);
        String query = mCursor.getString(mCursor.getColumnIndexOrThrow(
                SearchManager.SUGGEST_COLUMN_TEXT_1));
        mContentTv.setText("click suggestion : " + query);
        mSearchView.setQuery(query, true);

        mCursor.close();
        mCursor = null;

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        mSearchView.clearFocus();
        mContentTv.setText("Submit query text : " + query);

        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }


    public class SuggestionsAdapter extends CursorAdapter {

        public SuggestionsAdapter(Context context, Cursor c) {
            super(context, c, 0);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            ((TextView)view).setText(cursor.getString(cursor.getColumnIndexOrThrow(
                    SearchManager.SUGGEST_COLUMN_TEXT_1)));
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            View itemView = LayoutInflater.from(context).inflate(
                    android.R.layout.simple_list_item_1, parent, false);
            return itemView;
        }
    }
}
