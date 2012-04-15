package com.example.android;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

public class GameTimer extends AsyncTask<Void, Void, Void>

{

    private boolean isCancelled = false;
    Main main = null;
    public GameTimer(Main main)
    {
        this.main = main;
    }

    @Override
    protected Void doInBackground(Void... params)
    {
        Log.v(null, "sleeping");
        SystemClock.sleep(10000);
        Log.v(null, "done sleeping");
        
            Intent goToNextActivity = new Intent(main.getApplicationContext(), Test.class);
            /*Sending some arguments*/ 
            Bundle bundle = new Bundle();
            bundle.putString("count",""+main.getCount());
            goToNextActivity.putExtras(bundle);
            main.startActivity(goToNextActivity);
        
        return null;
    }

    @Override
    protected void onCancelled()
    {
        Log.v(null, "cancel called");
        //isCancelled = true;
    }
}
