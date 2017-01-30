package com.example.abhilashreddy.homelessness;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class donarsdblist extends AppCompatActivity {
    private TextView getdname;private TextView getdresources;private TextView getdcategory;
    public ListView newlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donarsdblist);
        newlistView=(ListView)findViewById(R.id.listviewid);
        DatabaseReference donarlistdbref= FirebaseDatabase.getInstance().getReferenceFromUrl("https://helphomeless-847a9.firebaseio.com/donar");
        FirebaseListAdapter<donarslist> firebaseListAdapter= new FirebaseListAdapter<donarslist>(this, donarslist.class, R.layout.donaradapter, donarlistdbref) {

            @Override
            protected void populateView(View v, donarslist model, int position) {
                getdname=(TextView) v.findViewById(R.id.nameid);
                getdresources=(TextView) v.findViewById(R.id.resourceid);
                getdcategory=(TextView) v.findViewById(R.id.categoryid);
                getdname.setText(model.getFname());
                getdresources.setText(model.getDresource());
                getdcategory.setText(model.getDcategory());

            }
        };
        newlistView.setAdapter(firebaseListAdapter);
        newlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final donarslist d = (donarslist) adapterView.getItemAtPosition(i);
                final CharSequence[] items = {
                        "View Location",
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(donarsdblist.this);
                builder.setTitle("Make your selection");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {
                        if (item == 0) {
                            Intent mapintent = new Intent(donarsdblist.this, MapsActivitydonars.class);
                            mapintent.putExtra("lati", d.getDlat());
                            mapintent.putExtra("longi", d.getDlongi());
                            mapintent.putExtra("hnameonmap", d.getFname());
                            mapintent.putExtra("inneed", d.getLname());
                            startActivity(mapintent);
                        }}
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}
