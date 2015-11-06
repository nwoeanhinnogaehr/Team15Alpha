package com.skilltradiez.skilltraderz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class SearchScreenActivity extends ActionBarActivity {

    //@todo what context are we getting things from? private int searchContext?

    private Context searchScreenContext = this;

    private Skill skills;
    private User users;

    private Button searchButton;
    private EditText searchField;
    private String searchInventory;
    private Spinner categorySpinner;

    private ListView searchResultsList;
    private ArrayAdapter<Skill> skillViewAdapter;
    private ArrayAdapter<User> userViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);
    }

    @Override
    public void onStart(){
        super.onStart();

        searchViewAdapter = new ArrayAdapter<Skill>(this, R.id.search_list, skills);
        searchResultsList.setAdapter(searchViewAdapter);

        searchButton = (Button) findViewById(R.id.search_button);
        searchField = (EditText) findViewById(R.id.search_bar);

        categorySpinner = (Spinner) findViewById(R.id.category_spinner);

    }

    /**
     * Take a string and refine the list of Users/Skills
     * @ TODO:
     */
    public void refineSearch(){
        //get whatever is in searchField
        //apply it to the list of results
        //update view
    }

    /**
     * Change category. Yes I know this is a bad comment I'll come back to it.
     * @ TODO:
     */
    public void changeCategory(){
        //inflate the category spinner
        //refine the search results
    }

    /**
     * Populate the screen with Users or Skills based on requirements ie: search strings
     * @ TODO:
     */
    public void populateSearchResults(){
        //need to get available list of users and skills
        // searchResultsList = change this to show this
        // update view
    }

}
