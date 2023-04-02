package com.sweng888.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import model.PatentPublication;
import model.PatentPublicationAdapter;

public class MainActivity extends AppCompatActivity {
    /*Declaring tag for this activity for logging, the list of patents, and the android ListView
    * object that will be displayed for user to interact with*/
    private static final String TAG = "MainActivity";
    private ArrayList<PatentPublication> patentPubs = new ArrayList<PatentPublication>();
    private ListView mListViewPatents;
    private Button mShowDetailsButton;
    private PatentPublication selectedPatent;

    /*onCreate triggers all necessary initialization for this Activity*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Calling the parent AppCompatActivity onCreate method to create the last snapshot of the
        * activity, setting the content view to this activity, logging started */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate: started");

        /*Initialazing the list of patents and the PatentPublicationAdapter object for adapting
        * the ArrayList to the ListView*/
        ArrayList<PatentPublication> arrayList = loadPatents();
        PatentPublicationAdapter patentListAdapter = new PatentPublicationAdapter(MainActivity.this,arrayList);

        /*Initalizes and Wires the ListView object and buttons to the ListView in the UI layout for this activity and sets
        * the adapter for the ListView*/
        mListViewPatents = findViewById(R.id.listview_patents);
        mListViewPatents.setAdapter(patentListAdapter);
        mShowDetailsButton = findViewById(R.id.show_details_Button);

        /*sets an OnItemClickListener to listen for the user clicking on a ListView item to store
        * the patent the user selected*/
        mListViewPatents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPatent = (PatentPublication) parent.getItemAtPosition(position);
            }
        });
        /*sets an OnClickListener for the ShowDetailsButton using an explicit intent to start the PatentActivity and pass the selected patent that the user
         * clicked as an extra*/
        mShowDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PatentActivity.class);
                intent.putExtra("selectedPatent", selectedPatent);
                startActivity(intent);
            }
        });
    }
    /*This method adds manually created patent data model objects to the ArrayList of
    PatentPublications*/
    private ArrayList<PatentPublication> loadPatents(){
        patentPubs.add(new PatentPublication("US11491656B2","Integrated item decanting " +
                "system","Walmart Apollo LLC"));
        patentPubs.add(new PatentPublication("US11467604B2","Control device and method for " +
                "a plurality of robots","LG Electronics Inc"));
        patentPubs.add(new PatentPublication("US11458627B2","Method and system of robot for " +
                "human following","National Chiao Tung University NCTU"));
        patentPubs.add(new PatentPublication("US11407114B2","Article conveying system",
                "Fanuc Corp"));
        return patentPubs;

    }
    /*Overrides the AppCompatActivity onResume method to listen for a boolean extra passed indicating
    * return from the PatentActivity to this MainActivity, and upon return, displays a SnackBar
    * welcoming the user back */
    @Override
    protected void onResume() {
        super.onResume();
        boolean returnFromPatentActivity = getIntent().getBooleanExtra("RETURN_FROM_PATENT_ACTIVITY", false);

        if (returnFromPatentActivity) {
            Snackbar.make(findViewById(R.id.listview_patents), "Welcome back to the patent list!", BaseTransientBottomBar.LENGTH_LONG).show();
        }
    }
}