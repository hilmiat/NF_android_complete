package id.my.note.todolist;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DetailTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //baca id yang dikirim dari main activity
        int id = getIntent().getIntExtra("_id",0);
        //jika id tidak 0, cari data di database
        //#1 buat obj SQLiteDatabase
        SQLiteDatabase db = new TaskDbHelper(this).getReadableDatabase();
        //#2 Query data
        Cursor cur = db.query("table_todo",
                new String[]{"title","description","date","priority","_id"},
                "_id = ?",
                new String[]{id+""},
                null,null,null
                );
        //baca data
        cur.moveToFirst();
        Todo todo = new Todo();
        //get title
        int title_index = cur.getColumnIndex("title");
        todo.setTitle(cur.getString(title_index));
        //get description
        todo.setDescription(cur.getString(cur.getColumnIndex("description")));
        //get date
        todo.setDate(cur.getString(cur.getColumnIndex("date")));
        //get priority
        todo.setPriority(cur.getInt(cur.getColumnIndex("priority")));
        //get _id
        todo.set_id(cur.getInt(cur.getColumnIndex("_id")));


        TextView konten = (TextView) findViewById(R.id.txt_konten);
        konten.setText("Task description:"+todo.getDescription());

        setTitle(todo.getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
