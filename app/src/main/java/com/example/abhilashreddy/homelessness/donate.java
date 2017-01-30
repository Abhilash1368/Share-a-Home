package com.example.abhilashreddy.homelessness;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class donate extends AppCompatActivity  {
    public Firebase donardb;public Button post;public String getdsingle;public String getdcenter;
    public GPSTracker gpstracker;public String getdshelter;public String getdclothes;
    public String getdfood;    public String getdother;
    private EditText dfirstname;private EditText dlastname;private EditText daddress;private EditText ddescription;
    private EditText dphone;private RadioButton dagency;
    private RadioButton dsingle;private CheckBox shelter;private CheckBox clothes;private CheckBox food;
private CheckBox other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        Firebase.setAndroidContext(donate.this);
        dfirstname=(EditText)findViewById(R.id.firstnameid);
        dlastname=(EditText)findViewById(R.id.lastnameid);
        daddress=(EditText)findViewById(R.id.addressid);
        ddescription=(EditText)findViewById(R.id.noteid);
        dphone=(EditText)findViewById(R.id.contactid);
        dagency=(RadioButton)findViewById(R.id.agencyid);
        dsingle=(RadioButton)findViewById(R.id.individualid);
        shelter=(CheckBox)findViewById(R.id.shelterid);clothes=(CheckBox)findViewById(R.id.Clothesid);
        food=(CheckBox)findViewById(R.id.foodid);other=(CheckBox)findViewById(R.id.othersid);
        donardb=new Firebase("https://helphomeless-847a9.firebaseio.com/donar");
        post=(Button)findViewById(R.id.submitids);
        //post.setOnClickListener(this);
        gpstracker=new GPSTracker(donate.this);

    }

//    @Override
//    public void onClick(View view) {
//        if(view==post){
//            Post();
//        }
//    }
    public void post(View v){
//        Toast.makeText(donate.this, "Posted Successfully", Toast.LENGTH_SHORT).show();
        String getdfirstname=dfirstname.getText().toString();
        String getdlastname=dlastname.getText().toString();
        String getdaddress=daddress.getText().toString();
        String getdddescription=ddescription.getText().toString();
        String dummyphone=dphone.getText().toString();
        Long getdphone=Long.parseLong(dummyphone);
        if(shelter.isChecked()){
            getdshelter=shelter.getText().toString();
        }else{getdshelter="";}

        if(clothes.isChecked()){
            getdclothes=clothes.getText().toString();
        }else{getdclothes="";}
        if(food.isChecked()){
            getdfood=food.getText().toString();
        }
        else{getdfood="";}
        if(other.isChecked()){
            getdother=other.getText().toString();}else{getdother="";}
        if(!dsingle.isChecked()){
            getdsingle="Individual";
        }
        else{
            getdsingle="Community Center";
        }


//            Toast.makeText(donate.this, "Posted Successfully", Toast.LENGTH_SHORT).show();
        Firebase parent =donardb.push();Toast.makeText(donate.this, "testing", Toast.LENGTH_SHORT).show();
        parent.child("daddress").setValue(getdaddress);
        parent.child("dresource").setValue(getdshelter+","+getdclothes+","+getdfood+","+getdother);
            parent.child("dcategory").setValue(getdsingle);
        parent.child("fname").setValue(getdfirstname);
        parent.child("dlat").setValue(gpstracker.getLatitude());
        parent.child("dlongi").setValue(gpstracker.getLongitude());
        parent.child("lname").setValue(getdlastname);
            parent.child("dphone").setValue(getdphone);
            parent.child("ddescription").setValue(getdddescription);
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(donate.this);
            alertDialog.setTitle("Great!");
            alertDialog.setMessage("Thanq for being a part of helping people");
            //alertDialog.setIcon(R.drawable.welcome);

            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(donate.this,Categoryactivity.class));
                }
            });

            alertDialog.show();


    }
}
