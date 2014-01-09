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

public class ImageActivity extends Activity {
	private static final int INVISIBLE = 4;
	
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
	
	private TableLayout tableLayout;
	
	private TableRow tr1;
	private TableRow tr2;
	private TableRow tr3;
	private TableRow tr4;
	
	private boolean bool = false;
	
	List<ImageView> imageViewList = new ArrayList<ImageView>();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		
		tableLayout = (TableLayout) findViewById(R.id.tableLayout);
		tr1 = (TableRow) findViewById(R.id.tableRow_1);
		tr2 = (TableRow) findViewById(R.id.tableRow_2);
		tr3 = (TableRow) findViewById(R.id.tableRow_3);
		tr4 = (TableRow) findViewById(R.id.tableRow_4);
		
		imageView_11 = (ImageView) findViewById(R.id.imageView_11);
		imageView_12 = (ImageView) findViewById(R.id.imageView_12);
		imageView_13 = (ImageView) findViewById(R.id.imageView_13);
		imageView_14 = (ImageView) findViewById(R.id.imageView_14);
		
		imageView_21 = (ImageView) findViewById(R.id.imageView_21);
		imageView_22 = (ImageView) findViewById(R.id.imageView_22);
		imageView_23 = (ImageView) findViewById(R.id.imageView_23);
		imageView_24 = (ImageView) findViewById(R.id.imageView_24);
		
		imageView_31 = (ImageView) findViewById(R.id.imageView_31);
		imageView_32 = (ImageView) findViewById(R.id.imageView_32);
		imageView_33 = (ImageView) findViewById(R.id.imageView_33);
		imageView_34 = (ImageView) findViewById(R.id.imageView_34);
		
		imageView_41 = (ImageView) findViewById(R.id.imageView_41);
		imageView_42 = (ImageView) findViewById(R.id.imageView_42);
		imageView_43 = (ImageView) findViewById(R.id.imageView_43);
		imageView_44 = (ImageView) findViewById(R.id.imageView_44);
		
		registerClickListener(imageView_11);
		registerClickListener(imageView_12);
		registerClickListener(imageView_13);
		registerClickListener(imageView_14);
		registerClickListener(imageView_21);
		registerClickListener(imageView_22);
		registerClickListener(imageView_23);
		registerClickListener(imageView_24);
		registerClickListener(imageView_31);
		registerClickListener(imageView_32);
		registerClickListener(imageView_33);
		registerClickListener(imageView_34);
		registerClickListener(imageView_41);
		registerClickListener(imageView_42);
		registerClickListener(imageView_43);
		registerClickListener(imageView_44);
	}
	
	private void registerClickListener(final ImageView imageView){
    	imageView.setOnClickListener(new OnClickListener() {
    		ArrayList<View> textView = new ArrayList<View>();
    		@Override
    		public void onClick(View arg0) {
    			Animation animation = AnimationUtils.loadAnimation(ImageActivity.this, R.anim.back_scale);
    			animation.setAnimationListener(new Animation.AnimationListener() {
    				
    				@Override
    				public void onAnimationStart(Animation arg0) {
    					// TODO Auto-generated method stub
    					
    				}
    				
    				@Override
    				public void onAnimationRepeat(Animation arg0) {
    					// TODO Auto-generated method stub
    					
    				}
    				
    				TextView tv = new TextView(ImageActivity.this);
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
    					tv.setText("Íò¼ýÆë·¢");
    					textView.add(tv);
//    					tr1.addView(tv);
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
    			TextView tv2 = new TextView(ImageActivity.this);
    			textView.add(tv2);
    			imageView.addChildrenForAccessibility(textView);
    			imageView.startAnimation(animation);
//    			imageView.setVisibility(INVISIBLE);
    			imageView.setEnabled(false);
    			tr1.removeView(imageView);
    			tr1.addView(tv2);
    		}
    	});
    }
}
