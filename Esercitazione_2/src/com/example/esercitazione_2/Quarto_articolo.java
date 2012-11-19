package com.example.esercitazione_2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Quarto_articolo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quarto_articolo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_quarto_articolo, menu);
		return true;
	}

}
