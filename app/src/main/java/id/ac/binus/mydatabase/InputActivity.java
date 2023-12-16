package id.ac.binus.mydatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.binus.mydatabase.sqlite_helper.SQLiteHelper;

public class InputActivity extends AppCompatActivity {
    EditText nameFld, nimFld, emailFld, phoneFld;
    Button submitBtn;
    SQLiteHelper helper;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.viewMenu){
            Intent i = new Intent(getApplicationContext(), ViewActivity.class);
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
        setContentView(R.layout.activity_input);
        helper = new SQLiteHelper(InputActivity.this);
        nameFld = findViewById(R.id.nameFld);
        nimFld = findViewById(R.id.nimFld);
        emailFld = findViewById(R.id.emailFld);
        phoneFld = findViewById(R.id.phoneFld);
        submitBtn = findViewById(R.id.submitBtn);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameFld.getText().toString();
                String nim = nimFld.getText().toString();
                String email = emailFld.getText().toString();
                String phone = phoneFld.getText().toString();
                if(name.isEmpty()){
                    Toast.makeText(view.getContext(), "Name must not be empty!", Toast.LENGTH_SHORT).show();
                }else if(nim.isEmpty()){
                    Toast.makeText(view.getContext(), "NIM must not be empty!", Toast.LENGTH_SHORT).show();
                }else if(email.isEmpty()){
                    Toast.makeText(view.getContext(), "Email must not be empty!", Toast.LENGTH_SHORT).show();
                }else if(!email.endsWith("@binus.ac.id")){
                    Toast.makeText(view.getContext(), "Email must ends with '@binus.ac.id'!", Toast.LENGTH_SHORT).show();
                }else if(phone.isEmpty()){
                    Toast.makeText(view.getContext(), "Phone number must not be empty!", Toast.LENGTH_SHORT).show();
                }else if(phone.length() < 6){
                    Toast.makeText(view.getContext(), "Phone number must be at least 6 characters long!", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkSuccess = helper.insertStudent(name, nim, email, phone);
                    if(checkSuccess){
                        nameFld.setText("");
                        nimFld.setText("");
                        emailFld.setText("");
                        phoneFld.setText("");
                        Toast.makeText(InputActivity.this, "Data has been successfully inserted!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(InputActivity.this, "Database insetion failed!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}