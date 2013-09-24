package com.appspot.mapconapp.taskreminder;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ReminderEdit extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reminder_edit);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reminder_edit, menu);
		return true;
	}

}
