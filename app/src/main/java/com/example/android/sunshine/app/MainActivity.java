package com.example.android.sunshine.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.dieguinho.sunshine.R;


public class MainActivity extends ActionBarActivity {
    private final String TAG = "MainActivity";
    private final String PARAM_GEO_LOCATION = "q";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Entered OnCreate");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Entered OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Entered OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Entered OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Entered OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Entered OnDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            Intent intentSettings = new Intent(this, SettingsActivity.class);
            startActivity(intentSettings);
            return true;
        }else if(id == R.id.action_map){
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            String selectedLocation = preferences.getString(getString(R.string.pref_location_key), getString(R.string.pref_location_value));

            Uri geoLocation = Uri.parse("geo:0,0?").buildUpon()
                    .appendQueryParameter(PARAM_GEO_LOCATION, selectedLocation)
                    .build();

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(geoLocation);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
