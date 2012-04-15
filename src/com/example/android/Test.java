package com.example.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;

public class Test extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Bundle extras = this.getIntent().getExtras();
        final String count=extras.getString("count");
        final EditText ET = (EditText) findViewById(R.id.t1);
        ET.setText(count);
        
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
