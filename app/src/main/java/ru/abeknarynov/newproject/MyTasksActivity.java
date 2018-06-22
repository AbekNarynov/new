package ru.abeknarynov.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MyTasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tasks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_my_tasks);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView myTasksRecyclerView = (RecyclerView)findViewById(R.id.all_tasks_recycler_view);
        myTasksRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        myTasksRecyclerView.setLayoutManager(linearLayoutManager);

        List<Task> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new Task(
                    "dsdfsd",
                    "fdgfg",
                    123
            ));
        }

        TasksRVAdapter adapter = new TasksRVAdapter(users, new TasksRVAdapter.OnItemClickListener() {
            @Override public void onItemClick(Task item) {
//                searchUserId = item.id;
//                showSessionsInRecyclerView("http://abeknarynov.ru/mytiming/changed/search_sessions.php?user_id=" + encodeToBase64(searchUserId));
            }
        });
        myTasksRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
