package edu.berkeley.cs160.fugue;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.Button;


public class Today extends Activity {
	
	TextView todayView;
	ImageView todayImage;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today);

        Button previous = (Button) findViewById(R.id.button1);
        todayView = (TextView) findViewById(R.id.button1);
        todayImage = (ImageView) findViewById(R.id.imageView1);
        loadDataFromAsset();        
        
        previous.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }

        });
    }
    
    public void loadDataFromAsset(){
       	try{
       		InputStream ims = getAssets().open("TodayLeaderboard.png");
       		Drawable d = Drawable.createFromStream(ims, null);
       		todayImage.setImageDrawable(d);        		
        }
       	catch(IOException ex){
       		return;
       	}
    }
}