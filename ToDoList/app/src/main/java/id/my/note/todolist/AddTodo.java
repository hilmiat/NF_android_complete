package id.my.note.todolist;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddTodo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        //#1. buat variable
        Button simpan = (Button) findViewById(R.id.tbl_simpan);
        //#2. set listener
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //#3. simpan dan pindah ke MainActivity
                Intent i = new Intent(AddTodo.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void pilihTanggal(View v){
        //Munculkan date picker
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }
}
