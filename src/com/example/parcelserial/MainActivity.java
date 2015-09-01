package com.example.parcelserial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener; 

public class MainActivity extends Activity implements OnClickListener{
	private Button sButton,pButton, fButton; 
	public  final static String SER_KEY = "com.example.parcelserial.ser"; 
    public  final static String PAR_KEY = "com.example.parcelserial.par"; 
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 setupViews(); 
	}

	public void setupViews(){ 
        sButton = (Button)findViewById(R.id.button1); 
        pButton = (Button)findViewById(R.id.button2); 
        fButton = (Button)findViewById(R.id.button3);
        sButton.setOnClickListener(this); 
        pButton.setOnClickListener(this); 
        fButton.setOnClickListener(this);
    }  
	
	public void SerializeMethod(){ 
        Person mPerson = new Person(); 
        mPerson.setName("Pepe"); 
        mPerson.setAge("25"); 
        Intent mIntent = new Intent(this,ObjectTranDemo1.class); 
        Bundle mBundle = new Bundle(); 
        mBundle.putSerializable(SER_KEY,mPerson); 
        mIntent.putExtras(mBundle); 
           
        startActivity(mIntent); 
    } 
 
    public void PacelableMethod(){ 
        Book mBook = new Book(); 
        mBook.setBookName("Android Developer Guide"); 
        mBook.setAuthor("Pepe"); 
        mBook.setPublishTime(2014); 
        Intent mIntent = new Intent(this,ObjectPassDemo2.class); 
        Bundle mBundle = new Bundle(); 
        mBundle.putParcelable(PAR_KEY, mBook); 
        mIntent.putExtras(mBundle); 
           
        startActivity(mIntent); 
    } 
 
 
    public void onClick(View v) { 
        if(v == sButton){ 
            SerializeMethod(); 
        }else if (v == pButton){ 
            PacelableMethod(); 
        } else{
        	Intent in = new Intent(this, Formulario.class);
        	startActivity(in);
        	
        }
    }  
    //End of example
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
