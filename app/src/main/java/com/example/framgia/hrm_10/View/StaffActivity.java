package com.example.framgia.hrm_10.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.framgia.hrm_10.Controller.DBHelper;
import com.example.framgia.hrm_10.Controller.DatePickerFragment;
import com.example.framgia.hrm_10.Model.MyClickEvent;
import com.example.framgia.hrm_10.R;


/**
 * Created by framgia on 02/06/2016.
 */
public class StaffActivity extends AppCompatActivity {
    private DBHelper db;
    private Bundle extras;
    private Spinner spinner;
//    private  TextView selection;
    //Tạo một mảng dữ liệu giả
    private String[] arr={
            "Trainee",
            "Internship",
            "Official staff"
    };
    private EditText name,place_of_birthy,phone,position_in_company;
    private TextView birthday;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff);
        // create DB
        db=new DBHelper(this);
        //
        name=(EditText)findViewById(R.id.editText);
        place_of_birthy=(EditText)findViewById(R.id.editText2);
        phone=(EditText)findViewById(R.id.editText4);
        position_in_company=(EditText)findViewById(R.id.editText5);

        birthday =(TextView)findViewById(R.id.textView7);

        //
        createSpinner();

        extras=getIntent().getExtras();
        //
        if(extras!=null){
            int Value = extras.getInt("id");
            if(Value>0) {
                createData(Value);
            }
        }
        onClick();
    }

    private void onClick() {
        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(v);
            }
        });
    }

    private void createSpinner(){
        //Lấy đối tượng Spinner ra
        spinner = (Spinner) findViewById(R.id.spinner);

        //Gán Data source (arr) vào Adapter
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        arr
                );
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        //Thiết lập adapter cho Spinner
        spinner.setAdapter(adapter);
        //thiết lập sự kiện chọn phần tử cho Spinner
        MyClickEvent myClickEvent=new MyClickEvent();
        myClickEvent.setArr(arr);
        spinner.setOnItemSelectedListener(myClickEvent);
    }
    private void createData(int value) {

    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = (new DatePickerFragment()).setBirthday(birthday);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    // menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

}
