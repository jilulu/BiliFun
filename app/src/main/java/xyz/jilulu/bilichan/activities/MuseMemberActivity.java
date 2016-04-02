package xyz.jilulu.bilichan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import xyz.jilulu.bilichan.adapters.MuseMemberAdapter;
import xyz.jilulu.bilichan.helpers.data.MuseMemberProfiles;
import xyz.jilulu.bilichan.R;

/**
 * Created by jamesji on 25/2/2016.
 */
public class MuseMemberActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muse_member);

        mRecyclerView = (RecyclerView) findViewById(R.id.museMemberRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        String liveMuseMemberName = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        MuseMemberProfiles museMemberProfiles = new MuseMemberProfiles(liveMuseMemberName);

        mAdapter = new MuseMemberAdapter(museMemberProfiles);
        mRecyclerView.setAdapter(mAdapter);
    }
}
