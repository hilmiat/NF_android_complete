package id.my.note.todolist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //# 1. Buat variable bertipe list view
    ListView list;
    ArrayAdapter<Todo> adapter;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mengisi list view dengan data
        //#2. Hubungkan variable dengan view pada xml (dgn id)
        list = (ListView) findViewById(R.id.my_list);
        //#3. Siapkan data yang akan diisi kedalam list
//        String[] data = getData();
        //#4. Konversi data kedalam bentuk adapter agar sesuai dengan tampilan
//        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        //#5. Set isi list dengan adapter yang telah dibuat
//        list.setAdapter(adapter);

        this.updateIsiData();

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
                Todo todo = (Todo) list.getItemAtPosition(position);
                Toast.makeText(
                        getApplicationContext(),
                        "Dipilih "+todo.getTitle()+" id: "+todo.get_id(),
                        Toast.LENGTH_LONG).show();

                //#3. pindah ke Activity DetailTask
                Intent ii = new Intent(MainActivity.this, DetailTask.class);
                //kirimkan id item yang dipilih
                ii.putExtra("_id",todo.get_id());
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
//        String dipilih = (String) list.getItemAtPosition(info.position);
        Todo dipilih = (Todo) list.getItemAtPosition(info.position);
        //#1. Baca menu apa yang dipilih
        if(item.getItemId()==R.id.selesai){
            Toast.makeText(this,dipilih+" Selesai",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.hapus){
            //hapus item
            db = new TaskDbHelper(this).getWritableDatabase();
            db.delete("table_todo","_id=?",new String[]{dipilih.get_id()+""});
            db.close();
            //refresh list
            updateIsiData();

            Toast.makeText(this,"Hapus Item "+dipilih,Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.ubah){
            //pindah ke form (halaman add)dengan memberikan id
            Intent i = new Intent(MainActivity.this,AddTodo.class);
            i.putExtra("_id",dipilih.get_id());
            startActivity(i);
//            Toast.makeText(this,"Update item "+dipilih,Toast.LENGTH_SHORT).show();
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

    private void updateIsiData(){
        //#1 siapkan penampungan data
        ArrayList<Todo> taskList = new ArrayList<>();
        //#2 buat obj SQLiteDatabase
        db = new TaskDbHelper(this).getWritableDatabase();
        //#3 query data
        Cursor cur = db.query("table_todo",
                                new String[]{"title","description","date","priority","_id"},
                                null,null,null,null,null);
        //#4 looping cursor untuk disimpan dalam penampungan data
        while (cur.moveToNext()){
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

            taskList.add(todo);
        }
        //#4b Jika data belum ada, munculkan pesan
        if(taskList.size() < 1){
            Todo t = new Todo();t.setTitle("Belum ada Todo");
            taskList.add(t);
        }
        if(adapter == null) {
            //#5. Konversi data kedalam bentuk adapter agar sesuai dengan tampilan
            adapter = new ArrayAdapter<Todo>(this,
                    android.R.layout.simple_list_item_1,
                    taskList);
            //#6. Set isi list dengan adapter yang telah dibuat
            list.setAdapter(adapter);
        } else {
            //#5b jika adapter sudah ada (update isi data)
            adapter.clear();
            adapter.addAll(taskList);
            adapter.notifyDataSetChanged();
        }
        //#7 Close cursor dan db
        cur.close();
        db.close();

    }


}
