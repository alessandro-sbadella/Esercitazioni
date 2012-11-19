package com.example.esercitazione_2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Esercitazione_2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_esercitazione_2);
		
		Button Articolo_1 = (Button) findViewById(R.id.button1);
		Button Articolo_2 = (Button) findViewById(R.id.button2);
		Button Articolo_3 = (Button) findViewById(R.id.button3);
		Button Articolo_4 = (Button) findViewById(R.id.button4);
		
		/** Con questi comandi abbiamo creato degli oggetti di tipo bottone, con riferimento
		 *  ai rispettivi id registrati nel file R.java e presenti nel file xml 
		 *  activity_esercitazione_2. */
		
		Articolo_1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent primo = new Intent(Esercitazione_2.this,Primo_articolo.class);
				startActivity(primo);
				
			}
		});
		
		Articolo_2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent secondo = new Intent(Esercitazione_2.this,Secondo_articolo.class);
				startActivity(secondo);
			}
		});
		
	    Articolo_3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent terzo = new Intent(Esercitazione_2.this,Terzo_articolo.class);
				startActivity(terzo);
			}
		});
	    
        Articolo_4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent quarto = new Intent(Esercitazione_2.this,Quarto_articolo.class);
				startActivity(quarto);
			}
		});
	    
	    /** Con questi ulteriori quattro comandi, abbiamo comandato al programma di aprire, una volta
	     *  cliccato il rispettivo bottone, la rispettiva seconda activity che ci permetterà di
	     *  visualizzate la descrizione dell'articolo stesso. Il comando onCLickListener è 
	     *  necessario per far si che il programma esegua un comando dopo che noi avremo cliccato
	     *  il bottone. L'oggetto di tipo Intent ci permetterà di andare nella seconda activity
	     *  utlizzando il metodo startActivity.
	     */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_esercitazione_2, menu);
		return true;
	}

}
