package sg.edu.rp.c346.id22015056.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import kotlinx.coroutines.scheduling.Task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextTask, editTextDate;
    Button btnInsert, btnGetTasks;
    ListView lv;
    ArrayAdapter<Tasks> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask = findViewById(R.id.editTextTask);
        editTextDate = findViewById(R.id.editTextDate);
        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        lv = findViewById(R.id.lv);

        ArrayList<Tasks> taskList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        lv.setAdapter(adapter);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = editTextTask.getText().toString().trim();
                String date = editTextDate.getText().toString().trim();

                if (!task.isEmpty() && !date.isEmpty()) {
                    DBHelper dbHelper = new DBHelper(MainActivity.this);
                    dbHelper.insertTask(task, date);
                    Toast.makeText(MainActivity.this, "Task inserted successfully", Toast.LENGTH_SHORT).show();

                    editTextTask.setText("");
                    editTextDate.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a task and date", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                ArrayList<Tasks> tasks = dbHelper.getTasks();
                dbHelper.close();

                adapter.clear();
                adapter.addAll(tasks);
            }
        });
    }
}
