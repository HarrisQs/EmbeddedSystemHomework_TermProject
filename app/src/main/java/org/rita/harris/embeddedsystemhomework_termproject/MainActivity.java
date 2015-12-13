package org.rita.harris.embeddedsystemhomework_termproject;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.rita.harris.embeddedsystemhomework_termproject.RainFall.RainFall_WebDataParse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //<共同>變數
    private Toolbar toolbar;
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Common_initialize();
        Navigation_initialize();
        ActionBar_initialize();
    }
    //<MainActivity> Context get
    public static Context MainActivity_Context()
    {
        return mContext;
    }
            //<共同> 初始化
    public void Common_initialize()
    {
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override // <共同>將MENU初始化的
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override // <共同>選擇 MENU中的哪一個
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
            //<Navigation> 初始化
    public void Navigation_initialize()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);//右上三條線 也是另一種觸發NAVIGATION的方法
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);//設置這個CLASS是navigation ITEM的監聽者
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override // <Navigation> 處裡返回鍵的
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override// <Navigation> Item監聽者
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
             //<ActionBar> 初始化
    public void ActionBar_initialize()
    {
        SectionsPagerAdapter mSectionsPagerAdapter =
                new SectionsPagerAdapter(getSupportFragmentManager());//處理要顯示幾頁

        ViewPager mViewPager = (ViewPager) findViewById(R.id.container); //處理內容顯示的
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs); //處理TOOLBAR的下一行
        tabLayout.setupWithViewPager(mViewPager);
    }
            //<ActionBar> 處理分業的CLASS
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }

            //<ActionBar> 處理內容的CLASS
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        //回傳一個新的入口為了這個fragment 給他一個section 數字
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            RainFall_CatchData( rootView);
            return rootView;
        }
    }

            // <RainFall> 去呼叫抓取雨量的資料
    public static void RainFall_CatchData(View rootView)
    {
        List<HashMap<String,String>> descript = new ArrayList<HashMap<String,String>>();
        SimpleAdapter adapter;
        RainFall_WebDataParse parse = new RainFall_WebDataParse();

        try {
            descript = parse.Showinfo();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Log.v("length == ",Integer.toString(descript.size()));
        adapter = new SimpleAdapter(MainActivity_Context(), descript, android.R.layout.simple_list_item_2,
                new String[] { "所在鄉鎮&觀測站","二十四小時累積雨量" }, new int[] { android.R.id.text1,android.R.id.text2 } );
        ListView Main_ListView= (ListView)rootView.findViewById(R.id.MainlistView);
            Main_ListView.setAdapter(adapter);
    }
}

