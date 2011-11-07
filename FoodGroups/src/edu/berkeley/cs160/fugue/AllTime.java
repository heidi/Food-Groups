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


public class AllTime extends Activity {
	
	TextView allTime;
	ImageView allTimeImage;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alltime);

        Button previous = (Button) findViewById(R.id.button1);
        allTime = (TextView) findViewById(R.id.button1);
        allTimeImage = (ImageView) findViewById(R.id.imageView1);
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
       		InputStream ims = getAssets().open("AlltimeLeaderboard.png");
       		Drawable d = Drawable.createFromStream(ims, null);
       		allTimeImage.setImageDrawable(d);        		
        }
       	catch(IOException ex){
       		return;
       	}
    } 
}