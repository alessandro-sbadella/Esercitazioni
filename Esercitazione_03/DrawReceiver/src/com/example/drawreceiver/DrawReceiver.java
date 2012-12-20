package com.example.drawreceiver;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DrawReceiver extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new Test_receiver(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_draw_receiver, menu);
		return true;
	}

}
