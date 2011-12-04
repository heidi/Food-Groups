package edu.berkeley.cs160.fugue;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class PlanMealActivity extends Activity implements OnClickListener {
	
	private TextView mDateDisplay;
    private Button mPickDate;
    private int mYear;
    private int mMonth;
    private int mDay;

    static final int DATE_DIALOG_ID = 0;
    
    private TextView mTimeDisplay;
    private Button mPickTime;

    private int mHour;
    private int mMinute;

    static final int TIME_DIALOG_ID = 1;
    
    private TextView friends;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planmeal);
        
        friends = (TextView) findViewById(R.id.friendsview);
        //friends.setText(FriendSearchActivity.friends);
        
        mDateDisplay = (TextView) findViewById(R.id.dateview);
        mPickDate = (Button) findViewById(R.id.datepicker_button);
        
        mTimeDisplay = (TextView) findViewById(R.id.timeview);
        mPickTime = (Button) findViewById(R.id.timepicker_button);
        
        mPickDate.setOnClickListener(this);
        mPickTime.setOnClickListener(this);
        
        // get the current date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        
        // get the current time
        //final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR);//.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // display the current date (this method is below)
        updateDisplay();
        
        
        Button backButton = (Button) findViewById(R.id.planmealback_button);
        backButton.setOnClickListener(this);
        Button doneButton = (Button) findViewById(R.id.planmealdone_button);
        doneButton.setOnClickListener(this);
        Button addFriendsButton = (Button) findViewById(R.id.addfriends_button);
        addFriendsButton.setOnClickListener(this);
        
        Button fbButton = (Button) findViewById(R.id.fb_button);
        fbButton.setOnClickListener(this);
	}
	
	protected void onActivityResult(int requestCode, int resultCode,
            Intent data) {
        updateDisplay();
    }

	@Override
	public void onClick(View v) {
		
		switch(v.getId()) {
			case R.id.datepicker_button:
				showDialog(DATE_DIALOG_ID);
				break;
			case R.id.timepicker_button:
				showDialog(TIME_DIALOG_ID);
				break;
		
			case R.id.planmealdone_button:
				// TODO
			
			case R.id.planmealback_button:
				Intent back = new Intent();
                setResult(RESULT_OK, back);
                finish();
                break;
			
			case R.id.addfriends_button:
				Intent i = new Intent(v.getContext(), FriendSearchActivity.class);
				startActivityForResult(i, 0);
				
				//updateDisplay();
				break;
			
			case R.id.fb_button:
				Intent fb = new Intent(v.getContext(), FaceBookActivity.class);
				startActivityForResult(fb, 0);
				break;
		}
		
	}
	
	// updates the date in the TextView
    private void updateDisplay() {
    	friends.setText(FriendSearchActivity.friends);
        mDateDisplay.setText(
            new StringBuilder()
                    // Month is 0 based so add 1
                    .append(mMonth + 1).append("-")
                    .append(mDay).append("-")
                    .append(mYear).append(" "));
        
        if (mHour <= 12) {
        	mTimeDisplay.setText(
                new StringBuilder()
                        .append(mHour).append(":")
                        .append(pad(mMinute))
                        .append(" AM"));
        } else {
        	mTimeDisplay.setText(
        			new StringBuilder()
        			.append(mHour-12).append(":")
        			.append(pad(mMinute))
        			.append(" PM"));
        }
    }
    
    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    
    // the callback received when the user "sets" the date in the dialog
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

    			@Override
                public void onDateSet(DatePicker view, int year, 
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay();
                }

            };
            
    // the callback received when the user "sets" the time in the dialog
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
    	
    			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    mHour = hourOfDay;
                    mMinute = minute;
                    updateDisplay();
                }
            };
            
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        	case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                            mDateSetListener,
                            mYear, mMonth, mDay);
        	case TIME_DIALOG_ID:
                return new TimePickerDialog(this,
                        mTimeSetListener, mHour, mMinute, false);
        }
        return null;
    }
}
