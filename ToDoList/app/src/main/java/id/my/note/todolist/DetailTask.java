package id.my.note.todolist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class DetailTask extends AppCompatActivity {
        TextView date,kategori,deskripsi;
        SeekBar priority;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //baca id yang dikirim dari main activity
        final int id = getIntent().getIntExtra("_id",0);

        //jika id tidak 0, cari data di database
        //#1 buat obj SQLiteDatabase
        final SQLiteDatabase db = new TaskDbHelper(this).getReadableDatabase();
        //#2 Query data
        Cursor cur = db.query("table_todo",
                new String[]{"title",
                        "description",
                        "date",
                        "priority",
                        "_id",
                        "category"},
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
        //get category
        todo.setCategory(cur.getInt(cur.getColumnIndex("category")));


        //set konten
        deskripsi = (TextView) findViewById(R.id.txt_konten);
        deskripsi.setText("Task description:"+todo.getDescription());

        date = (TextView) findViewById(R.id.text_date);
        date.setText(todo.getDate());

        kategori = (TextView) findViewById(R.id.text_kat);
        String[] pilihan_kategori = getResources().getStringArray(R.array.pilihan);
        kategori.setText(pilihan_kategori[todo.getCategory()]);

        priority = (SeekBar) findViewById(R.id.seek_priority);
        priority.setProgress(todo.getPriority());

        //set judul activity
        setTitle(todo.getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hapus task ini
                db.delete("table_todo","_id=?",new String[]{id+""});
                //pindah kembali ke list
                Intent i = new Intent(DetailTask.this,MainActivity.class);
                startActivity(i);

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
