package com.example.parcelserial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ObjectTranDemo1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Serializable");
		long startTime = System.nanoTime();
		
		//setContentView(R.layout.activity_object_tran_demo1);
		TextView mTextView = new TextView(this); 
		 Person mPerson = (Person)getIntent().getSerializableExtra(Formulario.SER_KEY); 
		 mTextView.setText("Tu nombre es: " + mPerson.getName() + " - "+ 
		  "Tu edad es: " + mPerson.getAge()); 
		    
		 setContentView(mTextView);  

		long endTime = System.nanoTime();
		Toast.makeText(getApplicationContext(), "Ejecución en "+(endTime - startTime)/0.000001 + " ms", Toast.LENGTH_LONG).show();
	}

}
