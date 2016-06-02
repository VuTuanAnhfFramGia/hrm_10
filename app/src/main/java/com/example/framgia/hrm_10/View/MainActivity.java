package com.example.framgia.hrm_10.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.framgia.hrm_10.Controller.DBHelper;
import com.example.framgia.hrm_10.R;

public class MainActivity extends AppCompatActivity {
    private Button sign_in;
    private DBHelper db;
    private EditText name,pass;
    private TextView create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        db=new DBHelper(this);
        //
        sign_in=(Button)findViewById(R.id.button);
        name=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText2);
        create=(TextView)findViewById(R.id.textView2);
        create.setVisibility(View.GONE);

        //
        onClick();
    }

    private void onClick() {
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _name=name.getText().toString();
                String _pass=pass.getText().toString();
                int login = db.login(_name,_pass);
                if(login==1){
                    Toast.makeText(getBaseContext(),"Login in with admin",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getBaseContext(),ListDepartments.class));
                }
                else if (login==2){
                    Toast.makeText(getBaseContext(),"Logged in successfully",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getBaseContext(),ListDepartments.class));
                }else if(login==0){
                    Toast.makeText(getBaseContext(),"Login failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

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
