package com.skilltradiez.skilltraderz;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.EditText;

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

public class EditSkillActivity extends ActionBarActivity {

    private EditText skillName;
    private EditText skillDescription;
    private EditText skillCategory;
    private Button addSkillToDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_skill);
    }

    public void onStart(){
        super.onStart();
        skillName = (EditText) findViewById(R.id.new_skill_name);
        skillDescription = (EditText) findViewById(R.id.new_skill_description);
        skillCategory = (EditText) findViewById(R.id.new_category);
        addSkillToDB = (Button) findViewById(R.id.add_skill_to_database);

    }

    /**
     * add skill to the database
     * @ TODO:
     */
    public void addSkill(){

    }

}