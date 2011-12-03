package edu.berkeley.cs160.fugue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class FriendSearchActivity extends Activity implements OnClickListener, OnItemClickListener {
	
	// TODO: eventually this shouldn't be hardcoded
	String contacts[] = {"Albert", "Alice", "Bob", "Bonnie", "Calvin", "Chris"};//, "Colleen", "Fred", "George", 
	//		"Harry", "Heather", "Hidalgo", "Hyde", "Jessica", "John", "Matthew", "Melissa", "Vince"};
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friendsearch);
        
        Button backButton = (Button)findViewById(R.id.friendsearchback_button);
        backButton.setOnClickListener(this);
        Button doneButton = (Button)findViewById(R.id.friendsearchdone_button);
        doneButton.setOnClickListener(this);
        
        ListView friendList = (ListView) findViewById(R.id.friendlist);
        friendList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, contacts));
        friendList.setOnItemClickListener(this);
        
        // TODO: add search bar listener that calls list.setSelection on the correct position in the list based on query
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

	@Override
	public void onItemClick(AdapterView<?> list, View view, int pos, long i) {
		
		CheckedTextView checkView = (CheckedTextView) view;
		
		checkView.setChecked(!checkView.isChecked());
		
	}
}
