package com.example.framgia.hrm_10.Controller;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by framgia on 02/06/2016.
 */
public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {
    private TextView birthday;

    public DatePickerFragment setBirthday(TextView birthday) {
        this.birthday = birthday;
        return this;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        month=month+1;
        // Do something with the date chosen by the user
        if(day<10){
            if(month<10) {
                birthday.setText("0" + day + "/0" + month + "/" + year);
            }
            else{
                birthday.setText("0"+day+"/"+month+"/"+year);
            }
        }
        else{
            if(month<10) {
                birthday.setText("" + day + "/0" + month + "/" + year);
            }
            else{
                birthday.setText(""+day+"/"+month+"/"+year);
            }
        }

    }

}
