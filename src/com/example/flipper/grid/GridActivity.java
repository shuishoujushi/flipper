package com.example.flipper.grid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.flipper.R;


public class GridActivity extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
        GridView view = (GridView) findViewById(R.id.grid);
        view.setAdapter(new GridAdapter(getBaseContext()));
    }


}
