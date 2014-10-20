package com.kloesen.mycontactchanel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendEmailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_email);
		
		
		Button buttonSend = (Button) findViewById(R.id.buttonSend);
		Button buttonCombackHome = (Button) findViewById(R.id.buttonBackHomeSendEmail);
		
		final EditText editTextEmailAddress = (EditText) findViewById(R.id.editTextEmail);
		final EditText editTextMessage = (EditText) findViewById(R.id.editTextMessage);
		
		
		buttonSend.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intentEmail = new Intent(Intent.ACTION_SEND);
				intentEmail.setType("message/rfc822");
				intentEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{editTextEmailAddress.getText().toString()});
				intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Subject: test thu choi");
				intentEmail.putExtra(Intent.EXTRA_TEXT, editTextMessage.getText().toString());
				startActivity(Intent.createChooser(intentEmail,"Select email application."));
				
			}
		});
		
		buttonCombackHome.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SendEmailActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		
		
	}
}
