package com.example.parcelserial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Formulario extends Activity {
	
	TextView txtNombre, txtEdad;
	String sNombre, sEdad;
	Button btnSerializar;
	
	public  final static String SER_KEY = "com.example.parcelserial.ser"; 
    public  final static String PAR_KEY = "com.example.parcelserial.par";
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_formulario);
		
		txtNombre = (TextView)findViewById(R.id.txtNombre);
		txtEdad = (TextView)findViewById(R.id.txtEdad);
		
		btnSerializar = (Button)findViewById(R.id.btnSerializar);
		
		btnSerializar.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				sNombre = txtNombre.getText().toString();
				sEdad = txtEdad.getText().toString();
				SerializeMethod(sNombre, sEdad);
			}
		});
	}

	public void SerializeMethod(String Nombre, String edad){ 
		
        Person mPerson = new Person(); 
        mPerson.setName(Nombre); 
        mPerson.setAge(edad); 
        Intent mIntent = new Intent(this,ObjectTranDemo1.class); 
        Bundle mBundle = new Bundle(); 
        mBundle.putSerializable(SER_KEY,mPerson); 
        mIntent.putExtras(mBundle); 
           
        startActivity(mIntent); 
    } 
	
}
