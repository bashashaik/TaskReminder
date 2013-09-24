package com.appspot.mapconapp.taskreminder;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ReminderList extends ListActivity {

	Context context;
	final String OS[] = { "OS X", "Windows XP", "Ubuntu", "Read Hat",
			"Android", "IOS", "Windows Phone" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reminder_list);
		context = this;
		ListAdapter adapter = new ArrayAdapter<String>(context,
				android.R.layout.simple_list_item_1, android.R.id.text1, OS);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		// super.onListItemClick(l, v, position, id);
		Toast.makeText(context, OS[position], Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reminder_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.addReminder:
			Intent intent = new Intent(context, ReminderEdit.class);
			startActivity(intent);
			break;
		}
		//return super.onOptionsItemSelected(item);
		return true;
	}

}
