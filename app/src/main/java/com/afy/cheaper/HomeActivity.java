package com.afy.cheaper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.afy.cheaper.fragments.OfferFragment;
import com.afy.cheaper.fragments.OfferFragment.OnOfferListFragmentInteractionListener;
import com.afy.cheaper.fragments.MarketFragment;
import com.afy.cheaper.fragments.market.MarketContent;
import com.afy.cheaper.fragments.MarketFragment.OnMarketListFragmentInteractionListener;

import com.afy.cheaper.fragments.offer.OfferContent;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnOfferListFragmentInteractionListener, OnMarketListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                /* Create the Intent */
                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

/* Fill it with Data */
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"support@cheaper.com"});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Cheaper Support");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "KOKO");

/* Send it off to the Activity-Chooser */
               startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //textView
        String s = getIntent().getStringExtra("LOGINEMAIL");
        View v = navigationView.getHeaderView(0);

        TextView emailV = (TextView) v.findViewById(R.id.textView);
        emailV.setText(s);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_logout) {
            //System.
            Intent intent = new Intent(this, LoginActivity.class);
            //intent.putExtra("LOGINEMAIL",email);

            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_offers) {
            // Handle the camera action
            Fragment offerFragments = new OfferFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_home, offerFragments ).commit();
        } else if (id == R.id.nav_market) {
            Fragment marketFragments = new MarketFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_home, marketFragments ).commit();
        } else if (id == R.id.nav_search) {

        } else if (id == R.id.nav_town) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_feedback) {

        } else if (id == R.id.nav_exit) {
            finish();
            //System.exit(0);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onOfferListFragmentInteraction(OfferContent.OfferItem item) {

    }

    @Override
    public void onListFragmentInteraction(MarketContent.MarketItem item) {

    }
}
