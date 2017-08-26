package id.my.note.todolist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //# 1. Buat variable bertipe list view
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mengisi list view dengan data
        //#2. Hubungkan variable dengan view pada xml (dgn id)
        list = (ListView) findViewById(R.id.my_list);
        //#3. Siapkan data yang akan diisi kedalam list
        String[] data = getData();
        //#4. Konversi data kedalam bentuk adapter agar sesuai dengan tampilan
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        //#5. Set isi list dengan adapter yang telah dibuat
        list.setAdapter(adapter);

        //Pindah ke AddTodo ketika tombol di click
        //#1. buat variable
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.tbl_add);
        //#2. set listener
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //#3. pindah activity
                Intent i = new Intent(MainActivity.this,AddTodo.class);
                startActivity(i);
            }
        });

        //Pindah ke DetailTask ketika item pada list dipilih
        //#1. Set listener pada list item
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //#2. baca siapa yang di click
                //#3. pindah ke Activity DetailTask
                Intent ii = new Intent(MainActivity.this, DetailTask.class);
                startActivity(ii);
            }
        });

        //Tambahkan context menu
        //#1. register listview agar menampilkan context menu
        registerForContextMenu(list);
    }
    //#2. override onCreateContextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //#3. set menu yang ingin ditampilkan
        getMenuInflater().inflate(R.menu.opsi_task,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //#0. Membaca item apa yang di longClick
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String dipilih = (String) list.getItemAtPosition(info.position);
        //#1. Baca menu apa yang dipilih
        if(item.getItemId()==R.id.selesai){
            Toast.makeText(this,dipilih+" Selesai",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.hapus){
            Toast.makeText(this,"Hapus Item "+dipilih,Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.ubah){
            Toast.makeText(this,"Update item "+dipilih,Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    /**
     * Method untuk mendapatkan data, bisa diganti dari sumber data lain spt database atau webservice
     * @return Array of string
     */
    private String[] getData() {
        String[] isi = {"Task 1","Task 2","Task 3"};
        return isi;
    }
}
