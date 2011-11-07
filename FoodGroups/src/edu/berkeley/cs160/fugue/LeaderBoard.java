package edu.berkeley.cs160.fugue;


import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.TextView;
import android.net.*;


public class LeaderBoard extends Activity {
	
	TextView aView;
	ImageView anImage;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard);

        Button previous = (Button) findViewById(R.id.button1);
        Button today = (Button) findViewById(R.id.button2);
        Button thisWeek = (Button) findViewById(R.id.button3);
        Button allTime = (Button) findViewById(R.id.button4);
        
        aView = (TextView) findViewById(R.id.textView1);
        anImage = (ImageView) findViewById(R.id.imageView1);
        loadDataFromAsset();        
        
        today.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Today.class);
                startActivityForResult(myIntent, 0);
            }

        });
        
        thisWeek.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ThisWeek.class);
                startActivityForResult(myIntent, 0);
            }
        });
        
        allTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AllTime.class);
                startActivityForResult(myIntent, 0);
            }

        });
        
        /*
        String filePath="file:///android_asset/images/test.png"; 
        Drawable d = Drawable.createFromPath(filePath); 
        aView.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null); 
        */       
        
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
       		anImage.setImageDrawable(d);        		
        }
       	catch(IOException ex){
       		return;
       	}
    }
}

// Change