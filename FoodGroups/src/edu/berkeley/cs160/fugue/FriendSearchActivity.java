package edu.berkeley.cs160.fugue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FriendSearchActivity extends Activity implements OnClickListener {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friendsearch);
        
        Button backButton = (Button)findViewById(R.id.friendsearchback_button);
        backButton.setOnClickListener(this);
        Button doneButton = (Button)findViewById(R.id.friendsearchdone_button);
        doneButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
			case R.id.friendsearchdone_button:
			// TODO: save selected friends
		
			case R.id.friendsearchback_button:
				Intent back = new Intent();
                setResult(RESULT_OK, back);
                finish();
			break;
			
		}
		
	}
}
