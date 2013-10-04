package com.appspot.mapconapp.taskreminder;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ReminderList extends ListActivity {

	Context context;
	final String OS[] = { "OS X", "Windows XP", "Ubuntu", "Read Hat",
			"Android", "IOS", "Windows Phone" };

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reminder_list);
		context = this;
		/*
		 * ListAdapter adapter = new ArrayAdapter<String>(context,
		 * android.R.layout.simple_list_item_1, android.R.id.text1, OS);
		 * setListAdapter(adapter);
		 */
		MyDbAdapter myDbAdapter = new MyDbAdapter(context);
		myDbAdapter = myDbAdapter.open();
		Cursor cursor = myDbAdapter.getAll();
		startManagingCursor(cursor);
		String from[] = { MyDbAdapter.KEY_TITLE, MyDbAdapter.KEY_DATE_TIME };
		int to[] = { android.R.id.text1, android.R.id.text2 };
		ListAdapter adapter = new SimpleCursorAdapter(context,
				android.R.layout.two_line_list_item, cursor, from, to);
		setListAdapter(adapter);
		myDbAdapter.close();
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
		case R.id.exit:
			ReminderList.this.finish();
			break;
		}
		// return super.onOptionsItemSelected(item);
		return true;
	}

}
