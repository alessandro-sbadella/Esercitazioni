package com.example.esercitazione02;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class Test extends View{

	boolean selezione ;
	Paint punto = new Paint();
	Path disegno = new Path();
	String parola ;
	XMPPConnection connessione ;

	public Test(Context context) {
		// TODO Auto-generated constructor stub
		super(context);
		punto.setColor(Color.BLACK);
		/** Con questo comando indichiamo il colore del punto sul background. */
		punto.setStrokeWidth(4);
		/** Spessore della linea che verrà disegnata. */
		punto.setStyle(Paint.Style.STROKE);
		/** Serve per disegnare una linea continua; senza di esso nel background il path
		 *  disegnerà l'area sottessa della geometria creata. */
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawPath(disegno, punto);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int evento_azione = event.getAction();
		int touch_x = (int) event.getX();
		int touch_y = (int) event.getY();
		
		switch(evento_azione){
		case MotionEvent.ACTION_DOWN:
			disegno.moveTo(touch_x, touch_y);
			/** Il punto di partenza del disegno. */
			selezione = true ;
			parola = "a:" + touch_x + ":" + touch_y ;
		break ;
		case MotionEvent.ACTION_MOVE:
			disegno.lineTo(touch_x, touch_y);
			/** Inserisce una linea dal punto di partenza, scelto nel 
			 *  moveTo, e nel punto di arrivo, variabili inserite nel lineTo. */
			parola = "b:" + touch_x + ":" + touch_y ;
			invalidate() ;
		break ;
		case MotionEvent.ACTION_UP:
			selezione = false ;
			parola = "c:" + touch_x + ":" + touch_y ;
		break ;
		default:
		break ;
		}
		return true;
	} 
	
	public void connessione(){
	
		ConnectionConfiguration conf = new ConnectionConfiguration("ppl.eln.uniroma2.it",5222);
		conf.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
	    connessione = new XMPPConnection(conf);
			    
		try {
			connessione.connect(); /** Ci connettiamo al server. */
			connessione.login("Sbardella","qwerty"); /** Username e password per accedere.*/
			
		} catch (XMPPException e1) {
			// TODO Auto-generated catch block
		    e1.printStackTrace();
		}
		
		Message msg = new Message();
		msg.setTo("all@broadcast.ppl.eln.uniroma2.it");
		msg.setBody(parola);
		connessione.sendPacket(msg);
		
	} 
} 