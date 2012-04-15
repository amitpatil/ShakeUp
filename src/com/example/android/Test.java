package com.example.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class Test extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Bundle extras = this.getIntent().getExtras();
        final String count=extras.getString("count");
        final TextView TV = (TextView) findViewById(R.id.t1);
        TV.setTextSize(50);
        TV.setText("Your Score is ");
        
        final TextView TV1 = (TextView) findViewById(R.id.t2);
        TV1.setTextSize(70);
        TV1.setText(""+count);
        
        
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Log.d(this.getClass().getName(), "back button pressed");
            Intent goToNextActivity = new Intent(getApplicationContext(), MainActivity.class);
            
            startActivity(goToNextActivity);
        }
        return super.onKeyDown(keyCode, event);
    }
}
