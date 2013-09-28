package com.appspot.mapconapp.taskreminder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class ReminderEdit extends Activity {

	Context context;

	Button buttonClick;
	EditText titleBox;
	EditText bodyBox;
	DatePicker datePicker;
	TimePicker timePicker;

	String title;
	String body;
	String time;
	String date;
	String dateTime;

	String monthList[] = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL",
			"AUG", "SEP", "OCT", "NOV", "DEC" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reminder_edit);
		context = this;
		buttonClick = (Button) findViewById(R.id.create);
		titleBox = (EditText) findViewById(R.id.title);
		bodyBox = (EditText) findViewById(R.id.body);
		datePicker = (DatePicker) findViewById(R.id.date);
		timePicker = (TimePicker) findViewById(R.id.time);
		onSubmit();
	}

	public void onSubmit() {
		buttonClick.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show();
				inflateData();
			}
		});
	}

	public void inflateData() {
		// Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show();
		title = titleBox.getText().toString();
		body = bodyBox.getText().toString();
		StringBuilder dateBuilder = new StringBuilder();
		dateBuilder.append(datePicker.getDayOfMonth());
		dateBuilder.append("-");
		//dateBuilder.append(datePicker.getMonth());
		switch(datePicker.getMonth()){
		case 0:
			dateBuilder.append(monthList[0]);
			break;
		case 1:
			dateBuilder.append(monthList[1]);
			break;
		case 2:
			dateBuilder.append(monthList[2]);
			break;
		case 3:
			dateBuilder.append(monthList[3]);
			break;
		case 4:
			dateBuilder.append(monthList[4]);
			break;
		case 5:
			dateBuilder.append(monthList[5]);
			break;
		case 6:
			dateBuilder.append(monthList[6]);
			break;
		case 7:
			dateBuilder.append(monthList[7]);
			break;
		case 8:
			dateBuilder.append(monthList[8]);
			break;
		case 9:
			dateBuilder.append(monthList[9]);
			break;
		case 10:
			dateBuilder.append(monthList[10]);
			break;
		case 11:
			dateBuilder.append(monthList[11]);
			break;
		}
		dateBuilder.append("-");
		dateBuilder.append(datePicker.getYear());
		date = dateBuilder.toString();
		StringBuilder timeBuilder = new StringBuilder();
		timeBuilder.append(timePicker.getCurrentHour());
		timeBuilder.append(":");
		timeBuilder.append(timePicker.getCurrentMinute());
		time = timeBuilder.toString();
		dateTime = date + "   " + time;
		storeData(title, body, dateTime);
		//Toast.makeText(context, dateTime, Toast.LENGTH_LONG).show();
	}
	
	public void storeData(String title, String body, String dateTime){
		MyDbAdapter dbAdapter = new MyDbAdapter(context);
		dbAdapter = dbAdapter.open();
		long n = dbAdapter.myInsert(title, body, dateTime);
		if(n >=1 ){
			Intent intent = new Intent(context, ReminderList.class);
			Toast.makeText(context, String.valueOf(n), Toast.LENGTH_LONG).show();
			startActivity(intent);
		}
		else{
			Toast.makeText(context, "Error occurred ", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reminder_edit, menu);
		return true;
	}

}
