package com.sweng888.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import model.PatentPublication;
import model.PatentPublicationAdapter;

public class PatentActivity extends AppCompatActivity {
    /*Declaring tag for this activity for logging, Views for user interaction with all UI layout
    objects, and a PatentPublication object storing the selected patent passed in the extra from
    the MainActivity*/
    private static final String TAG = "PatentActivity";
    private TextView mTextViewID;
    private TextView mTextViewTitle;
    private TextView mTextViewAssignee;
    private ImageView mImageViewFigure;
    private Button mBackButton;
    private PatentPublication selectedPatent;


    /*onCreate triggers all necessary initialization for this Activity*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patent);
        Log.d(TAG, "onCreate: started");
        /*initializes and wires the the android View objects to corresponding to UI layout objects
        * so that the user can interact with them*/
        mTextViewID = findViewById(R.id.patent_id);
        mTextViewTitle = findViewById(R.id.patent_title);
        mTextViewAssignee = findViewById(R.id.patent_assignee);
        mImageViewFigure = findViewById(R.id.imageViewFigure);
        mBackButton = findViewById(R.id.back_button);

        /*Gets the intent passed from MainActivity and the selected patent passed in the extra */
        Intent intent = getIntent();
        selectedPatent = (PatentPublication) intent.getSerializableExtra("selectedPatent");

        /*Sets the Text to display to the user the ID, Title, and Assignee of the selected patent*/
        mTextViewID.setText("ID: " + selectedPatent.getId());
        mTextViewTitle.setText("Title: " + selectedPatent.getTitle());
        mTextViewAssignee.setText("Assignee: " + selectedPatent.getAssignee());

        /*Sets the Image to display to the user the drawing of the selected patent*/
        setImage(selectedPatent.getId());

        /*Sets a click listener for the back button that uses explicit intent to navigate back to
        * the MainActivity, and passes the MainActivity the boolean extra indicating the user has
        * returned from the patent activity*/
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatentActivity.this,MainActivity.class);
                intent.putExtra("RETURN_FROM_PATENT_ACTIVITY", true);
                startActivity(intent);

            }
        });


    }
    /*method for setting the image in the ImageView displayed to the user in the PatentActivity using
    * a simple switch statement with the patentID that retrieves the corresponding image file from the
    * app/res/Drawable folder*/
    private void setImage(String patentID) {
        int imageResource;
        switch (selectedPatent.getId()) {
            case "US11491656B2":
                imageResource = getResources().getIdentifier("@drawable/us11491656", null, this.getPackageName());
                mImageViewFigure.setImageResource(imageResource);
                break;
            case "US11467604B2":
                imageResource = getResources().getIdentifier("@drawable/us11467604", null, this.getPackageName());
                mImageViewFigure.setImageResource(imageResource);
                break;
            case "US11458627B2":
                imageResource = getResources().getIdentifier("@drawable/us11458627", null, this.getPackageName());
                mImageViewFigure.setImageResource(imageResource);
                break;
            case "US11407114B2":
                imageResource = getResources().getIdentifier("@drawable/us11407114", null, this.getPackageName());
                mImageViewFigure.setImageResource(imageResource);
                break;
            default:
                break;
        }
    }
}