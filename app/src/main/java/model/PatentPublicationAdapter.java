package model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.sweng888.hw2.R;

import java.util.ArrayList;
import java.util.List;

public class PatentPublicationAdapter extends ArrayAdapter<PatentPublication> {
    /*Constructor for the PatentPublication Adapter passing the current context, list_item layout
    location, and list of PatentPublication objects to the parent ArrayAdapter constructor
    * */
    public PatentPublicationAdapter(@NonNull Context context,  @NonNull List<PatentPublication> objects) {
        super(context, R.layout.list_item, objects);
    }
    /*Overriding ArrayAdapter getView method to display the ID, title, and assignee for each patent
    * object in the list*/
        @Override
        public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
            View listViewElement = convertView;
            /*if the passed view object is null, we inflate the list_item view before initializing
            * the TextViews for each list item to avoid exceptions thrown*/
            if(listViewElement == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                listViewElement = inflater.inflate(R.layout.list_item, parent, false);
            }
            /*Initializing TextViews for each patent's ID, Title within the list item
            * */
            PatentPublication patent = getItem(position);
            TextView textViewID = listViewElement.findViewById(R.id.patent_id);
            TextView textViewTitle = listViewElement.findViewById(R.id.patent_title);
            //TextView textViewAssignee = listViewElement.findViewById(R.id.patent_assignee);

            /*Setting the text for each TextView in the list item by getting the ID, Title, and
            * Assignee from the data model object corresponding to each list item*/
            textViewID.setText("ID: "+patent.getId());
            textViewTitle.setText("Title: "+patent.getTitle());
            //textViewAssignee.setText("Assignee: "+patent.getAssignee());

            return listViewElement;
    }
}
