package com.example.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HelloAndroidActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        
        final EditText ET = (EditText) findViewById(R.id.entry);
        Button B1 = (Button) findViewById(R.id.ok);
        B1.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v) {
                            /*ET.setVisibility(View.INVISIBLE);
                            if(ET.getText().toString() == "BYE")
                            {
                                //do something if it is "BYE"
                            } else {
                                Context context = getApplicationContext();
                            CharSequence text = "Please enter BYE";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show(); 
                            }
                            ET.setVisibility(View.VISIBLE); */
                            String str = ET.getText().toString() + " test";
                            ET.setText(str);
                            
                            
                        } });
        
        
    }
}