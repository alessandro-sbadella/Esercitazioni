package com.example.drawreceiver;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.widget.RelativeLayout;

public class Test_receiver extends View{
	
	int x = 0 ;
	int y = 0 ;
	Paint punto = new Paint();
	Path disegno = new Path();
	XMPPConnection connessione ;
	RelativeLayout layout ;

	public Test_receiver(Context context) {
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
	
	public void connessione(){
	
	layout = (RelativeLayout) findViewById(R.id.receiver);
		
	ConnectionConfiguration conf = new ConnectionConfiguration("ppl.eln.uniroma2.it",5222);
	conf.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
    connessione = new XMPPConnection(conf);
    
    try {
		connessione.connect(); /** Ci connettiamo al server. */
		connessione.login("Sbardella","qwerty"); /** Username e password per accedere. */
		   
    }catch (XMPPException e1) {
    	// TODO Auto-generated catch block
	    e1.printStackTrace();
    }
   
   connessione.addPacketListener(new PacketListener() {
	    
	    @Override
		public void processPacket(Packet pa) {
			// TODO Auto-generated method stub
	    	
			Message msg = (Message) pa ;
		    final String[] mess ;
			final String body = msg.getBody();
			mess = body.split(":");
			/** Divide il messaggio in parti, in questo caso i ":" dividono
			 *  le singole parti. */
			layout.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					if(mess[0].equals("a")){
						x = Integer.parseInt(mess[1]);
					    y = Integer.parseInt(mess[2]);
					    /** Integer.parseInt prende il valore intero della parte di stringa 
					     *  selezionata. */
					    disegno.moveTo(x, y);
					    
					}
					else if(mess[0].equals("b")){
						x = Integer.parseInt(mess[1]);
						y = Integer.parseInt(mess[2]);
						disegno.lineTo(x, y);
					}
					else if(mess[0].equals("c")){
						x = Integer.parseInt(mess[1]);
						y = Integer.parseInt(mess[2]);
					}
				
			  }
				
		    });
			
	    }
	    
      },new MessageTypeFilter(Message.Type.normal));
   
	}
	
}