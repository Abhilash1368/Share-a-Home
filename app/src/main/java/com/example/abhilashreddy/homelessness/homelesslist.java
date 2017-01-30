package com.example.abhilashreddy.homelessness;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class homelesslist extends AppCompatActivity {
    public TextView nameinthelist;
    public TextView age;
    public  TextView request;
    public TextView situation;
   // public DatabaseReference listdbref;
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homelesslist);
        Firebase.setAndroidContext(homelesslist.this);

        listView=(ListView)findViewById(R.id.listview);
       DatabaseReference listdbref= FirebaseDatabase.getInstance().getReferenceFromUrl("https://helphomeless-847a9.firebaseio.com/root");
        FirebaseListAdapter<objects> firebaseListAdapter= new FirebaseListAdapter<objects>(this, objects.class, R.layout.adapterlayout, listdbref) {
            @Override
            protected void populateView(View v, objects model, int position) {
                Log.e("homelesslist",model.getFirstname()+" "+model.getLastname());
                nameinthelist=(TextView) v.findViewById(R.id.nameid);
                age=(TextView) v.findViewById(R.id.ageid);
                request=(TextView) v.findViewById(R.id.requestid);
                situation=(TextView) v.findViewById(R.id.situationid);
               nameinthelist.setText(model.getFirstname()+" "+model.getLastname());
                age.setText(model.getAge());
                request.setText(model.getLookingfor());
                situation.setText(model.getReasonforhelp());
            }
        };

    listView.setAdapter(firebaseListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final objects o = (objects) adapterView.getItemAtPosition(i);
                final CharSequence[] items = {
                         "View Location",
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(homelesslist.this);
                builder.setTitle("Make your selection");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item){
                        if(item == 0){
                            Intent locationintent=new Intent(homelesslist.this,MapsActivity.class);
                            locationintent.putExtra("lati", o.getHlat());
                            locationintent.putExtra("longi", o.getHlongi());
                            locationintent.putExtra("hnameonmap",o.getLastname());
                            locationintent.putExtra("inneed",o.getLookingfor());
                            startActivity(locationintent);



                    }}
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}
