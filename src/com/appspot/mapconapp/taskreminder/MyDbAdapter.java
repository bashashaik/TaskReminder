package com.appspot.mapconapp.taskreminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDbAdapter {

	static final String KEY_SNO = "_id";
	static final String KEY_TITLE = "title";
	static final String KEY_BODY = "body";
	static final String KEY_DATE_TIME = "dateTime";

	private static final String DB_NAME = "reminder";
	private static final String DB_TABLE = "reminderTable";
	private final int DB_VERSION = 1;

	private final String DB_CREATE = "create table " + DB_TABLE + " ( "
			+ KEY_SNO + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
			+ KEY_TITLE + " TEXT NOT NULL, " + KEY_BODY + " TEXT NOT NULL, "
			+ KEY_DATE_TIME + " TEXT NOT NULL);";

	MyDbHelper myDbHealper;
	SQLiteDatabase myDb;

	Context context;

	public MyDbAdapter(Context context) {
		this.context = context;
	}

	public MyDbAdapter open()throws SQLException{
		myDbHealper = new MyDbHelper(context);
		myDb = myDbHealper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		myDb.close();
	}
	
	public long myInsert(String title, String body, String dateTime) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(MyDbAdapter.KEY_TITLE, title);
		contentValues.put(MyDbAdapter.KEY_BODY, body);
		contentValues.put(MyDbAdapter.KEY_DATE_TIME, dateTime);
		return myDb.insert(MyDbAdapter.DB_TABLE, null, contentValues);
	}

	public Cursor getAll() {
		return myDb.query(DB_TABLE, new String[] { KEY_SNO, KEY_TITLE,
				KEY_BODY, KEY_DATE_TIME }, null, null, null, null, null);
	}

	class MyDbHelper extends SQLiteOpenHelper {
		
		public MyDbHelper(Context context) {
			super(context, DB_NAME, null, DB_VERSION);
			// TODO Auto-generated constructor stub

		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL(DB_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			Toast.makeText(context, "Table updated", Toast.LENGTH_LONG).show();
		}

	}

}
