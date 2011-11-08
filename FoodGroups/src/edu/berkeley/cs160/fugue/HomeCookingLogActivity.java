package edu.berkeley.cs160.fugue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeCookingLogActivity extends Activity implements OnClickListener {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homecookinglog);
        
        Button backButton = (Button) findViewById(R.id.homecookingback_button);
        backButton.setOnClickListener(this);
        Button searchButton = (Button) findViewById(R.id.addcooks_button);

        searchButton.setOnClickListener(this);        
        searchButton.setOnClickListener(this);
        Button doneButton = (Button) findViewById(R.id.homecookingdone_button);
        doneButton.setOnClickListener(this);
        

	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
			case R.id.homecookingdone_button:
			// TODO: record meal
			case R.id.homecookingback_button:
				Intent back = new Intent();
                setResult(RESULT_OK, back);
                finish();
			break;
			case R.id.addcooks_button:
				Intent i = new Intent(v.getContext(), FriendSearchActivity.class);
				startActivityForResult(i, 0);
			break;
		}
	}
}
