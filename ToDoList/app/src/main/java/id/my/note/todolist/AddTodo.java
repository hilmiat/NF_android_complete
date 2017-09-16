package id.my.note.todolist;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;

public class AddTodo extends AppCompatActivity {
    EditText txt_title,txt_des;
    //karena ingin diakses via fragment, maka dijadikan static
    static EditText txt_date;
    SeekBar priority;
    Spinner kategori;
    int id;
    Button simpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);



        txt_title = (EditText) findViewById(R.id.txt_title);
        txt_des = (EditText) findViewById(R.id.txt_des);
        txt_date = (EditText) findViewById(R.id.txt_date);
        priority = (SeekBar) findViewById(R.id.priority);
        kategori = (Spinner) findViewById(R.id.kategori);
        simpan = (Button) findViewById(R.id.tbl_simpan);

        //baca id yang dikirim dari main activity
        id = getIntent().getIntExtra("_id",0);
        //jika id tidak 0, cari data di database
        if(id > 0){
            tampilkanData();
        }

        //#2. set listener
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //#3. simpan dan pindah ke MainActivity
                //isi data ke database
                simpanData();
                //pindah ke main
                Intent i = new Intent(AddTodo.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void tampilkanData() {
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


        //isi form dengan data
        txt_title.setText(todo.getTitle());
        txt_date.setText(todo.getDate());
        txt_des.setText(todo.getDescription());

        priority.setProgress(todo.getPriority());
        kategori.setSelection(todo.getCategory());
        simpan.setText("UPDATE");
        simpan.setBackgroundColor(Color.GREEN);
    }

    public void simpanData(){
        //baca data
        String title = txt_title.getText().toString().trim();
        String desc = txt_des.getText().toString().trim();
        String date = txt_date.getText().toString().trim();
        int int_priority = priority.getProgress();
        int kat = kategori.getSelectedItemPosition();
        //simpan data
        //#1. buat obj SQLiteDatabase
        SQLiteDatabase db = new TaskDbHelper(this).getWritableDatabase();
        //#2. siapkan data yang mau ditulis
        ContentValues cv = new ContentValues();
        cv.put("title",title);
        cv.put("description",desc);
        cv.put("priority",int_priority);
        cv.put("date",date);
        cv.put("category",kat);

        if(id>0){
            //update data
            db.update("table_todo",
                    cv,
                    "_id=?",
                    new String[]{id+""});
        }else{
            //#3. insert data
            db.insert("table_todo",null,cv);
        }

    }

    public void pilihTanggal(View v){
        //Munculkan date picker
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }


}
