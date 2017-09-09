package id.my.note.todolist;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTodo extends AppCompatActivity {
    EditText txt_title,txt_des;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        txt_title = (EditText) findViewById(R.id.txt_title);
        txt_des = (EditText) findViewById(R.id.txt_des);

        //#1. buat variable
        Button simpan = (Button) findViewById(R.id.tbl_simpan);
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
    public void simpanData(){
        //baca data
        String title = txt_title.getText().toString().trim();
        String desc = txt_des.getText().toString().trim();
        //simpan data
        //#1. buat obj SQLiteDatabase
        SQLiteDatabase db = new TaskDbHelper(this).getWritableDatabase();
        //#2. siapkan data yang mau ditulis
        ContentValues cv = new ContentValues();
        cv.put("title",title);
        cv.put("description",desc);
        //#3. insert data
        db.insert("table_todo",null,cv);
    }

    public void pilihTanggal(View v){
        //Munculkan date picker
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }


}
