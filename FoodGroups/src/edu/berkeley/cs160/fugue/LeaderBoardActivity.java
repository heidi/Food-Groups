package edu.berkeley.cs160.fugue;


//import java.io.IOException;
//import java.io.InputStream;

import java.util.List;
import java.util.Vector;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class LeaderBoardActivity extends Activity implements OnClickListener, OnItemClickListener, DialogInterface.OnClickListener {
	
	private LayoutInflater mInflater;
	private Vector<LBItem> meals;
	private Vector<LBItem> weekList;
	private Vector<LBItem> allTimeList;
	private LBAdapter day;
	private LBAdapter week;
	private LBAdapter all;
	private ListView leaderboard;
	private Button today;
	private Button thisWeek;
	private Button allTime;
	AlertDialog aDialog;
	
	String mealTitles[] = {"Veggie Pasta Salad", "Lemon Butter Salmon", "Bacon Wrapped Asparagus", "Hamburger and Fries", "Chili Cheese Omelet"};
	String mealParticipants[] = {"Alice, Harry, Melissa", "Albert", "John, Matthew", "Fred, George", "Jessica"};
	Integer mealPics[] = {R.drawable.pastasalad, R.drawable.lemonbuttersalmon, R.drawable.baconwrappedasparagus, R.drawable.hamburgerandfries, R.drawable.chilicheeseomelet};
	String mealScores[] = {"86", "69", "52", "31", "24"};
	
	String weekPeople[] = {"Jessica", "Albert", "Matthew", "Heather", "Chris"};
	String weekScores[] = {"82.4", "75.7", "68.9", "57.2", "48.1"};
	Integer weekPics[] = {R.drawable.jessica, R.drawable.albert, R.drawable.matthew, R.drawable.heather, R.drawable.chris};
	
	String topPeople[] = {"Alice", "John", "Chris", "Hidalgo", "Bob"};
	String topDishes[] = {"Grilled Salmon and Asparagus", "Pork Roast with Kale Chips", "Spinach Salad", "Ahi Tuna with Salad", "Roast Beef with Potatoes and Veggies"};
	Integer topPics[] = {R.drawable.alice, R.drawable.john, R.drawable.chris, R.drawable.hidalgo, R.drawable.bob};
	String topScores[] = {"75.42", "72.39", "71.73", "68.96", "67.69"};
	
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard);
        
        mInflater = (LayoutInflater) getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        Button back = (Button) findViewById(R.id.leaderboardback);
        today = (Button) findViewById(R.id.todaybutton);
        thisWeek = (Button) findViewById(R.id.thisweekbutton);
        allTime = (Button) findViewById(R.id.alltimebutton);
        
        back.setOnClickListener(this);
        today.setOnClickListener(this);
        thisWeek.setOnClickListener(this);
        allTime.setOnClickListener(this);
        
        meals = new Vector<LBItem>();
        weekList = new Vector<LBItem>();
        allTimeList = new Vector<LBItem>();
        
        for (int i = 0; i < 5; i++) {
        	meals.add(new LBItem(i, mealPics[i], mealTitles[i], mealParticipants[i], mealScores[i]));
        	weekList.add(new LBItem(i, weekPics[i], weekPeople[i], "", weekScores[i]));
        	allTimeList.add(new LBItem(i, topPics[i], topPeople[i], "Top Dish: "+topDishes[i], topScores[i]));
        }
        
        day = new LBAdapter(this, R.layout.leaderboarditem, R.id.title, meals);
        week = new LBAdapter(this, R.layout.leaderboarditem, R.id.title, weekList);
        all = new LBAdapter(this, R.layout.leaderboarditem, R.id.title, allTimeList);
        
        leaderboard = (ListView) findViewById(R.id.leaderboardlist);
        leaderboard.setAdapter(day);
        leaderboard.setOnItemClickListener(this);
        
        today.setTextSize(20);
        
        
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("2 egg omlete with shreded cheddar cheese and leftover chili. topped with avacado :)").setTitle("Chili Cheese Omlette").setCancelable(true).setIcon(R.drawable.chilicheeseomelet);
        aDialog = builder.create();
        

    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		case R.id.todaybutton:
			leaderboard.setAdapter(day);
			today.setTextSize(20);
			thisWeek.setTextSize(14);
			allTime.setTextSize(14);
			break;
		case R.id.thisweekbutton:
			leaderboard.setAdapter(week);
			today.setTextSize(14);
			thisWeek.setTextSize(20);
			allTime.setTextSize(14);
			break;
		case R.id.alltimebutton:
			leaderboard.setAdapter(all);
			today.setTextSize(14);
			thisWeek.setTextSize(14);
			allTime.setTextSize(20);
			break;
		case R.id.leaderboardback:
			Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
            break;
		
		}	
	}    
	    
	 
	
	
	// ********** //	Stole this code from web:
	//						http://blog.sptechnolab.com/2011/02/01/android/android-custom-listview-items-and-adapters/
	
	class LBItem {
		protected int mIndex;
		protected int mId;
		protected String mTitle;
		protected String mDetail;
		protected String mScore;
		LBItem(int index, int id, String title, String detail, String score){
			mIndex = index;
			mId = id;
			mTitle = title;
			mDetail = detail;
			mScore = score;
		}
		@Override
		public String toString() {
			return mIndex+" "+mTitle+" "+mDetail+" "+mScore;
		}
		
	}
	
	class LBAdapter extends ArrayAdapter<LBItem> {
		public LBAdapter(Context context, int resource, int textViewResourceId, List<LBItem> objects) {               
			super(context, resource, textViewResourceId, objects);
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {   
			ViewHolder holder = null;
			TextView title = null;
			TextView detail = null;
			ImageView image = null;
			TextView score = null;
			LBItem it = getItem(position);
			if (null == convertView) {
				convertView = mInflater.inflate(R.layout.leaderboarditem, null);
				holder = new ViewHolder(convertView);
	            convertView.setTag(holder);
	        }
			holder = (ViewHolder) convertView.getTag();
			title = holder.getTitle();
			title.setText(it.mTitle);
			detail = holder.getDetail();
			detail.setText(it.mDetail);                                                     
			image = holder.getImage();
			image.setImageResource(it.mId);
			score = holder.getScore();
			score.setText(it.mScore);
			return convertView;
		}
	
		private class ViewHolder {
			private View mRow;
			private TextView title = null;
			private TextView detail = null;
			private ImageView image = null; 
			private TextView score = null;
			public ViewHolder(View row) {
				mRow = row;
			}
			public TextView getTitle() {
				if (null == title) {
					title = (TextView) mRow.findViewById(R.id.title);
				}
				return title;
			}     
			public TextView getDetail() {
				if (null == detail) {
					detail = (TextView) mRow.findViewById(R.id.detail);
				}
				return detail;
			}
	        public ImageView getImage() {
	        	if (null == image) {
	        		image = (ImageView) mRow.findViewById(R.id.img);
	        	}
	        	return image;
	        }
	        public TextView getScore() {
	        	if (null == score) {
	        		score = (TextView) mRow.findViewById(R.id.score);
	        	}
	        	return score;
	        }
		}
	}

	@Override
	public void onItemClick(AdapterView<?> list, View view, int pos, long i) {
		// TODO Auto-generated method stub
		aDialog.show();
		//Intent intent = new Intent();
        //setResult(RESULT_OK, intent);
		//finish();
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
		Intent intent = new Intent();
        setResult(RESULT_OK, intent);
		finish();
	} 
}

