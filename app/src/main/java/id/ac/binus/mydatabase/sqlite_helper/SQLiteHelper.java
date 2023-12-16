package id.ac.binus.mydatabase.sqlite_helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Vector;

import id.ac.binus.mydatabase.model.Student;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabasedb";
    private static final int DB_VERSION = 2;
    private static final String STUDENT_TABLE = "msstudent";
    private static final String ID_COLUMN = "studentid";
    private static final String NAME_COLUMN = "studentname";
    private static final String NIM_COLUMN = "studentnim";
    private static final String EMAIL_COLUMN = "studentemail";
    private static final String PHONE_COLUMN = "studentphone";
    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableQuery = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)", STUDENT_TABLE, ID_COLUMN, NAME_COLUMN, NIM_COLUMN, EMAIL_COLUMN, PHONE_COLUMN);
        sqLiteDatabase.execSQL(createTableQuery);
    }

    public Boolean insertStudent(String name, String nim, String email, String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues insertedData = new ContentValues();
        insertedData.put(NAME_COLUMN, name);
        insertedData.put(NIM_COLUMN, nim);
        insertedData.put(EMAIL_COLUMN, email);
        insertedData.put(PHONE_COLUMN, phone);

        Long checkSuccess = sqLiteDatabase.insert(STUDENT_TABLE, null, insertedData);
        sqLiteDatabase.close();

        if(checkSuccess == -1){
            return false;
        }else{
            return true;
        }
    }

    public Vector<Student> getAllStudent(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor getQuery = sqLiteDatabase.rawQuery("SELECT * FROM " + STUDENT_TABLE, null);

        Vector<Student> studentList = new Vector<>();

        if(getQuery.moveToFirst()){
            do{
                String name = getQuery.getString(1);
                String nim = getQuery.getString(2);
                String email = getQuery.getString(3);
                String phone = getQuery.getString(4);
                Student newStudent = new Student(name, nim, email, phone);
                studentList.add(newStudent);
            }while(getQuery.moveToNext());
        }
        getQuery.close();
        return studentList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        onCreate(sqLiteDatabase);
    }
}
