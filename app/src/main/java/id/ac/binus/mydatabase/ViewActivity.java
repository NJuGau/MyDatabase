package id.ac.binus.mydatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Vector;

import id.ac.binus.mydatabase.adapter.StudentAdapter;
import id.ac.binus.mydatabase.model.Student;
import id.ac.binus.mydatabase.sqlite_helper.SQLiteHelper;

public class ViewActivity extends AppCompatActivity {

    RecyclerView studentView;
    SQLiteHelper helper;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.inputMenu){
            Intent i = new Intent(getApplicationContext(), InputActivity.class);
            startActivity(i);
        }else if(item.getItemId() == R.id.aboutUsMenu){
            Intent i = new Intent(getApplicationContext(), AboutUsActivity.class);
            startActivity(i);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        helper = new SQLiteHelper(ViewActivity.this);
        studentView = findViewById(R.id.studentRecyclerView);

        Vector<Student> studentList = helper.getAllStudent();
        studentView.setLayoutManager(new LinearLayoutManager(this));
        studentView.setAdapter(new StudentAdapter(this, studentList));
    }
}