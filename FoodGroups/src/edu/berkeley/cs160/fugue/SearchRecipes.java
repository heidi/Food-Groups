package edu.berkeley.cs160.fugue;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.content.Intent;
import android.widget.Button;
import java.util.ArrayList;

public class SearchRecipes extends Activity {
	
	private ListView aView;
	private EditText typing;
	private String lv_arr[]={"Carrot","Beef","Pork","Fugue","Chicken","Green Onion","Fish", "Broccoli", "Cat Fish"};
	private ArrayList<String> arr_sort = new ArrayList<String>();
	int textlength = 0;

	/** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchrecipes);
        
        aView = (ListView) findViewById(R.id.listView1);
        typing = (EditText) findViewById(R.id.editText1);
        aView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lv_arr));
        typing.addTextChangedListener(new TextWatcher(){
        	
        	public void afterTextChanged(Editable s) {
        	}
        	
        	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        	}
        	
        	public void onTextChanged(CharSequence s, int start, int before, int count) {
        		textlength=typing.getText().length();
        		arr_sort.clear();
        		for(int i=0;i<lv_arr.length;i++)
        		{
        			if(textlength<=lv_arr[i].length())
        			{
        				if(typing.getText().toString().equalsIgnoreCase((String) lv_arr[i].subSequence(0, textlength)))
        				{
        					arr_sort.add(lv_arr[i]);
        				}
        			}
        		}
        		
        			aView.setAdapter(new ArrayAdapter<String>(SearchRecipes.this,android.R.layout.simple_list_item_1 , arr_sort));
        		}
        });


        
        
        

        Button previous = (Button) findViewById(R.id.button1);               
        
        previous.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }

        });
    }
}