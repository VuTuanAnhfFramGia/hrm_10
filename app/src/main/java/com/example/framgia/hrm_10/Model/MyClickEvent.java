package com.example.framgia.hrm_10.Model;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

/**
 * Created by framgia on 02/06/2016.
 */
public class MyClickEvent implements OnItemSelectedListener {
    private  String[] arr;

    public void setArr(String[] arr) {
        this.arr = arr;
    }
    public void MyClickEvent(){
//        Log.d("check","vao day ");
    }
    //Khi có chọn lựa thì vào hàm này
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //arg2 là phần tử được chọn trong data source
    }
    //Nếu không chọn gì cả
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}
