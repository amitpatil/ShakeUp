package com.example.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Main extends Activity
{
    private SensorManager mSensorManager;

    private ShakeEventListner mSensorListener;
    private int count = 0;
    private GameTimer gameTimer;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mSensorListener = new ShakeEventListner();
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorManager.registerListener(mSensorListener,
            mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_UI);


        mSensorListener.setOnShakeListener(new ShakeEventListner.OnShakeListener() {

          @Override
        public void onShake() {
              count ++;
              final EditText ET = (EditText) findViewById(R.id.entry);
              ET.setText(""+count);
              
//              ImageView iv = (ImageView) findViewById(R.id.image);
//              
//              if((count%2) == 0)
//              {    
//                  iv.setImageResource(R.drawable.ninja01);
//              }
//              else
//              {    
//                  iv.setImageResource(R.drawable.ninja02);
//              }    
          }
        });
        
      
//        final EditText ET = (EditText) findViewById(R.id.entry);
//        Button B1 = (Button) findViewById(R.id.clear);
//        B1.setOnClickListener(new View.OnClickListener() {
//
//                        @Override
//                        public void onClick(View v) {
//                            //count=0;
//                            Intent goToNextActivity = new Intent(getApplicationContext(), Test.class);
//                            /*Sending some arguments*/ 
//                            Bundle bundle = new Bundle();
//                            bundle.putString("count",""+count );
//                            goToNextActivity.putExtras(bundle);
//                            startActivity(goToNextActivity);
//                        } });
        
        gameTimer = new GameTimer(this);
        
        gameTimer.execute();
    }
    
    @Override
    protected void onResume() {
      super.onResume();
      mSensorManager.registerListener(mSensorListener,
          mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
          SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onStop() {
      mSensorManager.unregisterListener(mSensorListener);
      super.onStop();
    }

    public String getCount()
    {
        // TODO Auto-generated method stub
        return ""+count;
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Log.d(this.getClass().getName(), "back button pressed");
            return true;
        }
        
        return super.onKeyDown(keyCode, event);
    }

    
}
