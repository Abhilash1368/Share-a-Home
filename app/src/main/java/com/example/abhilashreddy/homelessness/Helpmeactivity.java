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
import android.widget.Toast;

import com.firebase.client.Firebase;

public class Helpmeactivity extends AppCompatActivity {
    private EditText firstname;private EditText lastname;private EditText phone; private EditText age;private EditText address;
    private CheckBox shelter;private CheckBox clothes;private CheckBox food;private CheckBox other;
    private CheckBox lostjob;private CheckBox healthissues;private CheckBox familyissues;private CheckBox otherissue;
    private EditText note;
    private Button submit;
    private Firebase databaseref;
    public String getshelter;public String getclothes;public String getfood;public String getother;
    public String getlostjob;public String gethealthissue;public String getfamilyissue;public String getothersissue;
    public GPSTracker gpstracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpmeactivity);
        firstname=(EditText)findViewById(R.id.firstnameid);
        lastname=(EditText)findViewById(R.id.lastnameid);
        age=(EditText)findViewById(R.id.ageid);
        phone=(EditText)findViewById(R.id.contactid);
        address=(EditText)findViewById(R.id.addressid);
        shelter=(CheckBox)findViewById(R.id.shelterid);clothes=(CheckBox)findViewById(R.id.Clothesid);
        food=(CheckBox)findViewById(R.id.foodid);other=(CheckBox)findViewById(R.id.othersid);
        lostjob=(CheckBox)findViewById(R.id.lostjobid);healthissues=(CheckBox)findViewById(R.id.healthissueid);
        familyissues=(CheckBox)findViewById(R.id.Familyid);otherissue=(CheckBox)findViewById(R.id.otherissueid);
        note=(EditText)findViewById(R.id.noteid);
        submit=(Button)findViewById(R.id.submitid);
        Firebase.setAndroidContext(Helpmeactivity.this);
        databaseref=new Firebase("https://helphomeless-847a9.firebaseio.com/root");
        gpstracker=new GPSTracker(Helpmeactivity.this);

    }
    public void submit(View v){
        String getfirstname=firstname.getText().toString();String getlastname=lastname.getText().toString();
        String getphone=phone.getText().toString();String getaddress=address.getText().toString();
        Long getlongphone=Long.parseLong(getphone);
        String getage=age.getText().toString();
        if(shelter.isChecked()){
            getshelter=shelter.getText().toString();
        }else{getshelter="";}
        if(clothes.isChecked()){
            getclothes=clothes.getText().toString();
        }else{getclothes="";}
        if(food.isChecked()){
            getfood=food.getText().toString();
        }
        else{getfood="";}
        if(other.isChecked()){
            getother=other.getText().toString();
        }else{getother="";}
        if(lostjob.isChecked()){
            getlostjob=lostjob.getText().toString();
        }else{getlostjob="";}
        if(healthissues.isChecked()){
            gethealthissue=healthissues.getText().toString();
        }else{gethealthissue="";}
        if(familyissues.isChecked()){
            getfamilyissue=familyissues.getText().toString();
        }else{getfamilyissue="";}
        if(otherissue.isChecked()){
            getothersissue=otherissue.getText().toString();
        }else{getothersissue="";}
        String getnote=note.getText().toString();
        Firebase parent =databaseref.push();
        parent.child("address").setValue(getaddress);
        parent.child("dlat").setValue(gpstracker.getLatitude());
        parent.child("dlongi").setValue(gpstracker.getLongitude());
        parent.child("firstname").setValue(getfirstname);
        parent.child("hlat").setValue(gpstracker.getLatitude());
        parent.child("hlongi").setValue(gpstracker.getLongitude());
        parent.child("lastname").setValue(getlastname);
        parent.child("lookingfor").setValue(getshelter+","+getclothes+","+getfood+","+getother);
        parent.child("nameofdonar").setValue("");
        parent.child("note").setValue(getnote);
        parent.child("phone").setValue(getlongphone);
        parent.child("reasonforhelp").setValue(getlostjob+","+gethealthissue+","+getfamilyissue+","+getothersissue);
        parent.child("resources").setValue("");
        parent.child("age").setValue(getage);
        Toast.makeText(Helpmeactivity.this,"Your Details are Submitted",Toast.LENGTH_SHORT).show();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Helpmeactivity.this);
        alertDialog.setTitle("Submitted Successfully!");
        alertDialog.setMessage("Service providers will get in touch with you soon!.Thank you.");
        //alertDialog.setIcon(R.drawable.welcome);

        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Helpmeactivity.this,Categoryactivity.class));
            }
        });

        alertDialog.show();

    }
}
