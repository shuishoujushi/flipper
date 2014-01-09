package com.example.flipper;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class SingleActivity extends Activity {
	private static final int INVISIBLE = 4;
	
	private ImageView imageView;
	private TextView textView;
	private boolean bool = false;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single);
		
		imageView = (ImageView) findViewById(R.id.singleImage);
		textView = (TextView) findViewById(R.id.textView);
		registerClickListener(imageView);
	}
	
	private void registerClickListener(final ImageView imageView){
    	imageView.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View arg0) {
    			Animation animation = AnimationUtils.loadAnimation(SingleActivity.this, R.anim.back_scale);
    			animation.setAnimationListener(new Animation.AnimationListener() {
    				
    				@Override
    				public void onAnimationStart(Animation arg0) {
    					// TODO Auto-generated method stub
    					
    				}
    				
    				@Override
    				public void onAnimationRepeat(Animation arg0) {
    					// TODO Auto-generated method stub
    					
    				}
    				
    				TextView tv = new TextView(SingleActivity.this);
    				@Override
    				public void onAnimationEnd(Animation arg0) {
    					// TODO Auto-generated method stub
//    					imageView.setImageResource(R.drawable.b);
    					
//    					tv.setScrollX(imageView.getScrollX());
//    					tv.setScrollY(imageView.getScrollY());
    					tv.setWidth(imageView.getWidth());
    					tv.setHeight(imageView.getHeight());
    					tv.setTop(imageView.getTop());
    					tv.setBottom(imageView.getBottom());
    					tv.setLeft(imageView.getLeft());
    					tv.setRight(imageView.getRight());
    					tv.setText("万箭齐发");
    					System.out.println("top --> " + imageView.getTop());
    					System.out.println("bottom --> " + imageView.getTop());
    					System.out.println("top --> " + imageView.getTop());
    					System.out.println("top --> " + imageView.getTop());
    					textView.setText("万箭齐发");
    				}
    			});
    			imageView.startAnimation(animation);
    			imageView.setVisibility(INVISIBLE);
    			imageView.setEnabled(false);
    		}
    	});
    }
}
