package com.example.framgia.hrm_10.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.framgia.hrm_10.Controller.DBHelper;

/**
 * Created by framgia on 02/06/2016.
 */
public class ListViewStaffActivity extends AppCompatActivity{
    private DBHelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // create DB
        db = new DBHelper(this);
        //

    }
}
