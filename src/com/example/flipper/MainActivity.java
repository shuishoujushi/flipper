package com.example.flipper;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends Activity {

	private ImageView imageView_11;
	private ImageView imageView_12;
	private ImageView imageView_13;
	private ImageView imageView_14;
	
	private ImageView imageView_21;
	private ImageView imageView_22;
	private ImageView imageView_23;
	private ImageView imageView_24;
	
	private ImageView imageView_31;
	private ImageView imageView_32;
	private ImageView imageView_33;
	private ImageView imageView_34;
	
	private ImageView imageView_41;
	private ImageView imageView_42;
	private ImageView imageView_43;
	private ImageView imageView_44;
	private boolean bool = false;
	
	private TableLayout tableLayout;
	
	private static final int ROW_COUNT = 4;
	private static final int COLUMN_COUNT = 4;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.test2);
        
        tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        tableLayout.setStretchAllColumns(true);
        for(int i = 0; i < ROW_COUNT; i++){
        	addRow(COLUMN_COUNT);
        }
    }


    private void registerClickListener(final ImageView imageView){
    	imageView.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View arg0) {
    			Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.back_scale);
    			animation.setAnimationListener(new Animation.AnimationListener() {
    				
    				@Override
    				public void onAnimationStart(Animation arg0) {
    					// TODO Auto-generated method stub
    					
    				}
    				
    				@Override
    				public void onAnimationRepeat(Animation arg0) {
    					// TODO Auto-generated method stub
    					
    				}
    				
    				@Override
    				public void onAnimationEnd(Animation arg0) {
    					// TODO Auto-generated method stub
    					if(bool){
    						imageView.setImageResource(R.drawable.b);
    						bool = false;
    					} else {
    						imageView.setImageResource(R.drawable.c);
    						bool = true;
    					}
    					imageView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.front_scale));
    				}
    			});
    			imageView.startAnimation(animation);
    		}
    	});
    }
    
    private List<String> constructName(int m, int n){
    	int len = 0;
    	if(m == 0){
    		len = n;
    	} else if(n == 0){
    		len = m;
    	} else {
    		len = m * n;
    	}
    	
    	List<String> imageNames = new ArrayList<String>(); 
    	for(int i = 0; i < m; i++){
    		for(int j = 0; j < n; j++){
    			String name = "imageView_" + String.valueOf(i + 1) + String.valueOf(j + 1);
    			imageNames.add(name);
    		}
    	}
    	return imageNames;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private ImageView getImageView(){
    	ImageView imageView = new ImageView(this);
    	LayoutParams params = new LayoutParams(0, -2);
    	imageView.setLayoutParams(params);
    	imageView.setPadding(3, 3, 3, 3);
    	imageView.setAdjustViewBounds(true);
    	imageView.setImageResource(R.drawable.a);
    	return imageView;
    }

    private void addRow(int m){
    	TableRow row = new TableRow(this);
    	for(int i = 0; i < m; i++){
    		row.addView(getImageView());
    	}
    	tableLayout.addView(row);
    }
}
