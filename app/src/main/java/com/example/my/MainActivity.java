package com.example.my;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    TextView Welocme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create the adapter of recycler view
        ArrayList <status> state = new ArrayList<>();
        state.add(new status("Angry",R.drawable.black));
        state.add(new status("Anxious",R.drawable.tale));
        state.add(new status("Bored",R.drawable.tale));
        state.add(new status("Confident",R.drawable.white));
        state.add(new status("Confused",R.drawable.tale));
        state.add(new status("Content",R.drawable.tale));
        state.add(new status("Depressed",R.drawable.black));
        state.add(new status("Doubtful",R.drawable.tale));
        state.add(new status("Grateful",R.drawable.tale));
        state.add(new status("Greedy",R.drawable.white));
        state.add(new status("Guilty",R.drawable.tale));
        state.add(new status("Happy",R.drawable.tale));
        state.add(new status("Hunt",R.drawable.black));
        state.add(new status("Hypocritical",R.drawable.tale));
        state.add(new status("Jealous",R.drawable.tale));
        state.add(new status("Lonely",R.drawable.white));
        state.add(new status("Lost",R.drawable.tale));
        state.add(new status("Sad",R.drawable.tale));
        state.add(new status("Tired",R.drawable.tale));
        state.add(new status("Weak",R.drawable.tale));
        state.add(new status("Scared",R.drawable.tale));
        state.add(new status("Hatred",R.drawable.tale));
        state.add(new status("Love",R.drawable.tale));
        state.add(new status("Peaceful",R.drawable.tale));

        CustomAdapter Adapter = new CustomAdapter(this,state);
        RecyclerView rv = findViewById(R.id.rv);
        GridLayoutManager grid = new GridLayoutManager(this,2);
        rv.setLayoutManager(grid);
        rv.setAdapter(Adapter);


        // Create a new JobInfo object that describes the job to be scheduled
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this, job_scadular.class));
        builder.setMinimumLatency(1000); // Start immediately
        builder.setOverrideDeadline(2000); // Complete within 2 seconds
        JobInfo jobInfo = builder.build();

        // Schedule the job with the JobScheduler
        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(jobInfo);


        //go in welcome page
        Welocme = findViewById(R.id.welcome);
        Welocme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,welcomeActivity.class);
                startActivity(intent);
            }
        });







    }
}