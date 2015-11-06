package com.skilltradiez.skilltraderz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLDisplay;

/*
 *    Team15Alpha
 *    AppName: SkillTradiez (Subject to change)
 *    Copyright (C) 2015  Stephen Andersen, Falon Scheers, Elyse Hill, Noah Weninger, Cole Evans
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class MainActivity extends ActionBarActivity {

    private Context mainContext = this;

    private static UserDatabase userDB = new UserDatabase();

    //Main screen
    private Button searchButton;
    private Button searchAllSkillzButton;
    private Button searchAllUsersButton;
    private Button goToProfile;
    private EditText searchField;
    private String searchDatabase;

    //First time user screen
    private EditText newUserName;
    private EditText newUserEmail;
    private Button makeNewUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(userDB.getCurrentUser() != null){
            setContentView(R.layout.activity_main);
        }else{
            setContentView(R.layout.first_time_user);
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * onClick listeners and buttons go here
     */
    @Override
    public void onStart(){
        super.onStart();

        searchButton = (Button) findViewById(R.id.search_button);
        searchAllSkillzButton = (Button) findViewById(R.id.browse_skillz);
        searchAllUsersButton = (Button) findViewById(R.id.browse_users);
        goToProfile = (Button) findViewById(R.id.go_to_profile);
        searchField = (EditText) findViewById(R.id.search_bar);

        newUserName = (EditText) findViewById(R.id.makeUserName);
        newUserEmail = (EditText) findViewById(R.id.emailField);
        makeNewUser = (Button) findViewById(R.id.beginApp);

        searchDatabase = "";
    }

    /**
     * Make a thread with a string. Used to search the database for a specific user or skill.
     * @param
     */
    public void makeSearchThread(String stringToSearch){
        /*
        Like in the lab Get a string and search
        SearchThread thread = new SearchThread(string);
        thread.start();*/
    }

    public void newUser(View view){
        final Context context = getApplicationContext();
        if(newUserName.getText().toString() == ""){
            //@todo toast! "You need a name"
            Toast.makeText(context, "You need a name!", Toast.LENGTH_SHORT).show();
        }else {
            //Toast.makeText(context, "Hello " + newUserName.getText().toString(), Toast.LENGTH_SHORT).show();
            final String username = newUserName.getText().toString();

                new Thread() {
                    public void run() {
                        try {
                            userDB.createUser(username);
                        } catch (UserAlreadyExistsException e) {
                            // Failed
                            Toast.makeText(context, username + " Already Exists!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }.start();
                Toast.makeText(context, username, Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_main);

            //@todo email if needed
        }

        /*try {
            if(newUserName.getText().toString() == ""){
                //@todo toast! "You need a name"
                //Toast.makeText(context, "You need a name!", Toast.LENGTH_SHORT).show();
            }else {
                userDB.createUser(newUserName.getText().toString());
                //@todo email if needed
            }
        } catch (UserAlreadyExistsException e) {
            //@todo that don't work toast or etc
        }*/
    }

    /**
     * Browse all skillz or users in the database. Might be able to combine this with refined search
     * for better code reuse. EEDIT
     * @param view
     */
    public void beginAllSearch(View view){
        Intent intent = new Intent(mainContext, SearchScreenActivity.class);
        startActivity(intent);
        //@todo need to send the proper context to search.
        // Browse Skills/Users/Refined search are three separate
    }

    /**
     * Begin a refined search of the database from user input
     * @param view
     */
    public void beginRefinedSearch(View view){
        Intent intent = new Intent(mainContext, SearchScreenActivity.class);
        //intent.putExtra(SearchScreenActivity.TO_SEARCH, searchDatabase)
        startActivity(intent);
    }

    /**
     * Take user to their own profile when "Your Profile" button is pressed
     * @param view
     * @ TODO:
     */
    public void showProfile(View view){
        //get user id to sent to the profileActivity so that we open up the right profile
        Intent intent = new Intent(mainContext, ProfileActivity.class);

        startActivity(intent);
    }

    /**
     * Sends user to the EditSkill activity to make a new skill
     * @param view
     * @ TODO:
     */
    public void createNewSkill(View view){
        //need to differentiate 'createnewskill' and 'edit skill'
        Intent intent = new Intent(mainContext, EditSkillActivity.class);
        startActivity(intent);
    }
}