package id.my.note.todolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hilmiat on 09/09/17.
 */

public class TaskDbHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "DBTODO";
    private static final int DBVERSION = 1;

    public TaskDbHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE table_todo (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "title TEXT," +
                "priority INTEGER," +
                "category INTEGER," +
                "description TEXT," +
                "date TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion > oldVersion){
            //drop table
            db.execSQL("DROP TABLE IF EXISTS table_todo");
            //create ulang
            onCreate(db);
        }
    }
}
