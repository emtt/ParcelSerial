package com.example.parcelserial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ObjectPassDemo2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Parcelable");
		long startTime = System.nanoTime();
		//setContentView(R.layout.activity_object_pass_demo2);
		
		TextView mTextView = new TextView(this); 
		Book mBook = (Book)getIntent().getParcelableExtra(MainActivity.PAR_KEY); 
		mTextView.setText("Título del libro: " + mBook.getBookName()+" - "+ 
				"Autor: " + mBook.getAuthor() + " - " + 
				"Publicado en: " + mBook.getPublishTime()); 
		setContentView(mTextView); 
		
		long endTime = System.nanoTime();
		Toast.makeText(getApplicationContext(), "Ejecución en "+(endTime - startTime)/0.000001 + " ms", Toast.LENGTH_LONG).show();
	}  
}



