package com.framgia.music_25.screen.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.framgia.music_25.R;
import com.framgia.music_25.data.model.TabScreen;
import com.framgia.music_25.screen.BaseActivity;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initToolbar();
        initDrawer();
        initViewPager();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START, true);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        mDrawerLayout.closeDrawer(GravityCompat.START, true);
        switch (item.getItemId()) {
            case R.id.navigation_home:
                mViewPager.setCurrentItem(TabScreen.HOME);
                return true;
            case R.id.navigation_search:
                return true;
            case R.id.navigation_downloaded:
                return true;
            case R.id.navigation_favorite:
                return true;
            case R.id.navigation_playlist:
                return true;
            case R.id.navigation_settings:
                return true;
            case R.id.navigation_about:
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mNavigationView.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
    }

    private void initViewPager() {
        mViewPager = findViewById(R.id.view_pager);
        FragmentChangeAdapter fragmentChangeAdapter =
                new FragmentChangeAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(fragmentChangeAdapter);
        mViewPager.addOnPageChangeListener(this);
    }

    private void initDrawer() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(this);
        mNavigationView.setCheckedItem(R.id.navigation_home);
    }
}
