package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    //initializing variables
    private EditText e_firstname,e_familyname,e_dob,e_emailid,e_password;
  private String firstname,familyname,dob,emailid,password;
    Button rstrbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //declaring variables
        setContentView(R.layout.activity_register);
        e_firstname= (EditText) findViewById(R.id.firstname);
        e_familyname= (EditText) findViewById(R.id.familyname);
        e_dob= (EditText) findViewById(R.id.dob);
        e_emailid= (EditText) findViewById(R.id.emailid);
        e_password= (EditText) findViewById(R.id.password);
        rstrbtn=(Button)findViewById(R.id.rstrbtn);

        rstrbtn.setOnClickListener(new View.OnClickListener(){
     @Override
            public void onClick(View view) {
        //checking the validation functions if they pass
         if ((validateEmail() && validateUsername() && !validateUserfamilyname() && !validateDateFormat() && !validatePassword()))
         {

             Toast.makeText(Register.this, "Registration is successfull", Toast.LENGTH_SHORT).show();
         }
         }
             //validating Username
             private boolean validateUsername() {
             String firstname=e_firstname.getText().toString().trim();
             if (firstname.isEmpty()) {
                 Toast.makeText(Register.this, "Please enter Username", Toast.LENGTH_SHORT).show();
             } else if (firstname.length() > 31) {
                 e_firstname.setError("Username is too long");
                 return false;
             } else {
                 e_firstname.setError(null);
                 return true;
             }
           return false;
         }
           //to validate user family name
            private boolean validateUserfamilyname() {
                String firstname=e_familyname.getText().toString().trim();
                if (firstname.isEmpty()) {
                    Toast.makeText(Register.this, "Please enter family name", Toast.LENGTH_SHORT).show();
                }  else {
                    e_familyname.setError(null);
                    return true;
                }
                return false;
            }
              //to validate user email
            private boolean validateEmail() {
                String emailid=e_emailid.getText().toString().trim();
                if (emailid.isEmpty()) {
                    Toast.makeText(Register.this, "Please enter email id", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailid).matches()){
                    Toast.makeText(Register.this, "Enter a valid email id", Toast.LENGTH_SHORT).show();
                    return false;
                } else {
                    e_emailid.setError(null);
                    return true;
                }
            }
            //user validate date format
            private boolean validateDateFormat(){
                String dob=e_dob.getText().toString().trim();
                if (dob == null || !dob.matches("^(1[0-9]|0[1-9]|3[0-1]|2[1-9])/(0[1-9]|1[0-2])/[0-9]{4}$")) {
                    Toast.makeText(Register.this, "Please enter date in MM/DD/YYY format", Toast.LENGTH_SHORT).show();
                    return false;
                }
                SimpleDateFormat format=new SimpleDateFormat("MM/DD/yyyy");
                try {
                    format.parse(dob);
                    return true;
                }catch (ParseException e){
                    return false;
                }
            }
            ///to validate user password
           private boolean validatePassword(){
               String password=e_password.getText().toString().trim();
               if (password.isEmpty()) {
                   Toast.makeText(Register.this, "Please enter password", Toast.LENGTH_SHORT).show();

               }
               return false;
           }
        });
    }

}



