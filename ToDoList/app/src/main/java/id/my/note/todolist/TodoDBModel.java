package id.my.note.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hilmiat on 16/09/17.
 */

public class TodoDBModel {
    SQLiteDatabase db;

    public TodoDBModel(Context ctx) {
        this.db = new TaskDbHelper(ctx).getWritableDatabase();
    }

    public ArrayList<Todo> getAllTodo(){
        //#1 siapkan penampungan data
        ArrayList<Todo> taskList = new ArrayList<>();
        //#3 query data
        Cursor cur = db.query("table_todo",
                new String[]{"title",
                            "description",
                            "date",
                            "priority",
                            "category",
                            "_id"},
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
        return taskList;
    }

    public void deleteTodo(int id){
        db.delete("table_todo","_id=?",new String[]{id+""});
    }
    public Todo getById(int id){
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
        return todo;
    }

    public void insertTodo(Todo todo){
        ContentValues cv = this.todoToCV(todo);
        db.insert("table_todo",null,cv);
    }
    public void updateTodo(Todo todo){
        ContentValues cv = this.todoToCV(todo);
        //update data
        db.update("table_todo",
                cv,
                "_id=?",
                new String[]{todo.get_id()+""});
    }
    public ContentValues todoToCV(Todo todo){
        ContentValues cv = new ContentValues();
        cv.put("title",todo.getTitle());
        cv.put("description",todo.getDescription());
        cv.put("priority",todo.getPriority());
        cv.put("date",todo.getDate());
        cv.put("category",todo.getCategory());
        return cv;
    }
}
