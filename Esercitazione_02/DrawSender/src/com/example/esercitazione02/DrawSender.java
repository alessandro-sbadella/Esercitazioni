package com.example.esercitazione02;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DrawSender extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new Test(this));
	} 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_esercitazione2, menu);
		return true;
	}
}
