package com.kloesen.mycontactchanel;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CallPhoneActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call_phone);
		
		Button buttonCall = (Button) findViewById(R.id.buttonCall);
		Button buttonCombackHome = (Button) findViewById(R.id.buttonBackHomeCallPhone);
		
		final EditText editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);
		
		buttonCall.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intentCall = new Intent(Intent.ACTION_CALL);
				intentCall.setData(Uri.parse("tel:" + editTextPhoneNumber.getText().toString()));
				startActivity(intentCall);
			}
		});
		
		buttonCombackHome.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CallPhoneActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		
	}

}
