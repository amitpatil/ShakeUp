package com.example.android;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity
{
    
    private boolean wasExecuted = false;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        init();
    }
    
    public void init()
    {
        Log.v(null, "init called");
        wasExecuted = false;
    }
    
    public void beginCountdown(View view)
    {
        if(!wasExecuted)
        {
            Log.v(null, "countdown started");
            wasExecuted = true;
            new CountDownTask().execute();
        }
    }
    
    private class CountDownTask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... urls)
        {
        	
            for (int i = 5; i >= 0; --i)
            {
            	publishProgress(i);
            	SystemClock.sleep(1000);
            }
            Intent i = new Intent(getApplicationContext(), Main.class);
            startActivity(i);
            return null;
        }

        private void publishProgress(final int i)
        {
        	runOnUiThread(new Runnable()
        	{
        		@Override
                public void run()
        		{
	            	TextView t = (TextView)findViewById(R.id.textViewCountDown);
	            	t.setText("Training starts in " + i + " seconds.");
        		}
        	});
		}

		@SuppressWarnings("unused")
		protected void onProgressUpdate(Integer... count) {}

        @SuppressWarnings("unused")
		protected void onPostExecute(Long result) {}
    }
}