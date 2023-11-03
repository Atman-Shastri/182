package com.example.sql_application;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sql_activity extends AppCompatActivity {

    EditText id_field, name_field, salary_field;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        id_field = findViewById(R.id.id_field);
        name_field = findViewById(R.id.name_field);
        salary_field = findViewById(R.id.salary_field);
    }

    public void viewButtonClicked(View view) {
        Integer Id = Integer.parseInt(id_field.getText().toString());
        name_field.setText("");
        salary_field.setText("");

        Cursor result = databaseHelper.getAllData();
        if (result.getCount() == 0) {
            Toast.makeText(this, "Database is empty!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            StringBuffer buffer = new StringBuffer();
            while (result.moveToNext()) {
                buffer.append("Id: " + result.getString(0) + "\n");
                buffer.append("Name: " + result.getString(1) + "\n");
                name_field.setText(result.getString(1));
                buffer.append("Salary: " + result.getString(2) + "\n");
                salary_field.setText(result.getString(2));
            }
            Toast.makeText(this, buffer.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void insertButtonClicked(View view) {
        String name = name_field.getText().toString();
        Integer salary = Integer.parseInt(salary_field.getText().toString());
        boolean isInserted = databaseHelper.insertData(name, salary);
        if (isInserted == true) {
            Toast.makeText(this, "Inserted data successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to insert data", Toast.LENGTH_SHORT).show();
        }

    }

    public void updateButtonClicked(View view) {
        String Id = id_field.getText().toString();
        String Name = name_field.getText().toString();
        String salary = salary_field.getText().toString();

        boolean isUpdated = databaseHelper.updateData(Id, Name, salary);

        if (isUpdated == true) {
            Toast.makeText(this, "Updated data successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to update data", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteButtonClicked(View view) {
        String Id = id_field.getText().toString();

        Integer isDeleted = databaseHelper.deleteData(Id);

        if (isDeleted == 1) {
            Toast.makeText(this, "Deleted data successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to delete data", Toast.LENGTH_SHORT).show();
        }
    }
}