package com.example.flipper.grid;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.flipper.R;

public class MyGrid extends Activity {
	
	private RelativeLayout myRelativeLayout;
	private ImageView iv;
	private GridView gridView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single2);
		
		myRelativeLayout = (RelativeLayout) findViewById(R.id.myRelativeLayout);
		gridView = (GridView) findViewById(R.id.grid);
		
		constructImageView();
		
		
	}
	
	private void constructImageView(){
		iv = new ImageView(this);
		LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		iv.setLayoutParams(lp);
		iv.setImageResource(R.drawable.a);
		iv.setId(View.generateViewId());
		iv.setBackgroundColor(Color.BLUE);
		iv.setScaleType(ScaleType.FIT_XY);
//		myRelativeLayout.addView(iv);
		gridView.addView(iv);
		registerClickListener(iv);
		
	}
	
	private void constructTextView(){
		int ivId = iv.getId();
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
//		layoutParams.topMargin = ivId;
//		layoutParams.bottomMargin = ivId;
//		layoutParams.leftMargin = ivId;
//		layoutParams.rightMargin = ivId;
		layoutParams.setMargins(1, 1, 1, 1);
		
		layoutParams.addRule(RelativeLayout.ALIGN_TOP, ivId);
		layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, ivId);
		layoutParams.addRule(RelativeLayout.ALIGN_LEFT, ivId);
		layoutParams.addRule(RelativeLayout.ALIGN_RIGHT, ivId);
		
		TextView tv = new TextView(this);
		tv.setLayoutParams(layoutParams);
		tv.setGravity(Gravity.CENTER);
		tv.setBackgroundColor(Color.RED);
		tv.setText("Íò¼ýÆë·¢£¡");
		
		gridView.addView(tv);
		
	}
	
	private void registerClickListener(final ImageView imageView){
    	imageView.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View arg0) {
    			Animation animation = AnimationUtils.loadAnimation(MyGrid.this, R.anim.back_scale);
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
    					constructTextView();
//    					imageView.setImageResource(R.drawable.b);
//    					if(bool){
//    						imageView.setImageResource(R.drawable.b);
//    						bool = false;
//    					} else {
//    						imageView.setImageResource(R.drawable.c);
//    						bool = true;
//    					}
//    					imageView.startAnimation(AnimationUtils.loadAnimation(ImageActivity.this, R.anim.front_scale));
    				}
    			});
    			imageView.startAnimation(animation);
//    			imageView.setVisibility(View.INVISIBLE);
//    			imageView.setEnabled(false);
    		}
    	});
    }
}
