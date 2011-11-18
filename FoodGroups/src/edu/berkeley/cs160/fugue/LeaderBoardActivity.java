package edu.berkeley.cs160.fugue;


//import java.io.IOException;
//import java.io.InputStream;

import java.util.List;
import java.util.Vector;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class LeaderBoardActivity extends Activity implements OnClickListener {
	
	private LayoutInflater mInflater;
	private Vector<Meal> meals;
	
	String mealTitles[] = {"Veggie Pasta Salad - 86", "Lemon Butter Salmon - 69", "Bacon Wrapped Asparagus - 52", "Hamburger and Fries - 31", "Chili Cheese Omelette - 24"};
	String mealParticipants[] = {"Alice, Harry, Melissa", "Albert", "John, Matthew", "Fred, George", "Jessica"};
	Integer mealPics[] = {R.drawable.pastasalad, R.drawable.lemonbuttersalmon, R.drawable.baconwrappedasparagus, R.drawable.hamburgerandfries, R.drawable.chilicheeseomelette};

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard);
        
        mInflater = (LayoutInflater) getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        Button back = (Button) findViewById(R.id.leaderboardback);
        Button today = (Button) findViewById(R.id.todaybutton);
        Button thisWeek = (Button) findViewById(R.id.thisweekbutton);
        Button allTime = (Button) findViewById(R.id.alltimebutton);
        back.setOnClickListener(this);
        today.setOnClickListener(this);
        thisWeek.setOnClickListener(this);
        allTime.setOnClickListener(this);
        
        meals = new Vector<Meal>();
        
        for (int i = 0; i < 5; i++) {
        	meals.add(new Meal(i, mealPics[i], mealTitles[i], mealParticipants[i]));
        }
        
        ListView leaderboard = (ListView) findViewById(R.id.leaderboardlist);
        leaderboard.setAdapter(new MealAdapter(this, R.layout.leaderboarditem, R.id.title, meals));
        

    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		case R.id.todaybutton:
			break;
		case R.id.thisweekbutton:
			break;
		case R.id.alltimebutton:
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
	
	class Meal {
		protected int mIndex;
		protected int mId;
		protected String mTitle;
		protected String mDetail;
		Meal(int index, int id,String title,String detail){
			mIndex = index;
			mId = id;
			mTitle = title;
			mDetail = detail;
		}
		@Override
		public String toString() {
			return mId+" "+mTitle+" "+mDetail;
		}
	}
	
	class MealAdapter extends ArrayAdapter<Meal> {
		public MealAdapter(Context context, int resource, int textViewResourceId, List<Meal> objects) {               
			super(context, resource, textViewResourceId, objects);
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {   
			ViewHolder holder = null;
			TextView title = null;
			TextView detail = null;
			ImageView image = null;
			Meal meal = getItem(position);
			if (null == convertView) {
				convertView = mInflater.inflate(R.layout.leaderboarditem, null);
				holder = new ViewHolder(convertView);
	            convertView.setTag(holder);
	        }
			holder = (ViewHolder) convertView.getTag();
			title = holder.gettitle();
			title.setText(meal.mTitle);
			detail = holder.getdetail();
			detail.setText(meal.mDetail);                                                     
			image = holder.getImage();
			image.setImageResource(meal.mId);
			return convertView;
		}
	
		private class ViewHolder {
			private View mRow;
			private TextView title = null;
			private TextView detail = null;
			private ImageView image=null; 
			public ViewHolder(View row) {
				mRow = row;
			}
			public TextView gettitle() {
				if(null == title){
					title = (TextView) mRow.findViewById(R.id.title);
				}
				return title;
			}     
			public TextView getdetail() {
				if(null == detail){
					detail = (TextView) mRow.findViewById(R.id.detail);
				}
				return detail;
			}
	        public ImageView getImage() {
	        	if(null == image){
	        		image = (ImageView) mRow.findViewById(R.id.img);
	        	}
	        	return image;
	        }
		}
	} 
}

