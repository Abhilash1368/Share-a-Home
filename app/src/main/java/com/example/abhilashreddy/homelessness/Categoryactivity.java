package com.example.abhilashreddy.homelessness;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Categoryactivity extends AppCompatActivity implements View.OnClickListener {
    private Button helpmebutton;
    private Button Donate;
    private Button inneedofhelp;
    public Firebase datalistener;
    public int count=-1;
    NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this);
    public Button finalbutton;
    public static ArrayList<objects> updatedarray;
    public objects obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryactivity);
        Firebase.setAndroidContext(Categoryactivity.this);
        helpmebutton=(Button)findViewById(R.id.helpmebutton);
        Donate=(Button)findViewById(R.id.Donatebutton);
        inneedofhelp=(Button)findViewById(R.id.inneedofhelpbutton);
        finalbutton=(Button) findViewById(R.id.dqwerty);
        finalbutton.setOnClickListener(this);
        helpmebutton.setOnClickListener(this);
        Donate.setOnClickListener(this);
        inneedofhelp.setOnClickListener(this);
        datalistener=new Firebase("https://helphomeless-847a9.firebaseio.com/root");
        datalistener.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
               // updatedarray = new ArrayList<objects>();//Declaration of arraylist

                count++;
                //Log.e("camera.this","size"+ updatedarray.size()+" "+ dataSnapshot.getChildrenCount());
                if(count==14){
                    Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    Intent notificationIntent = new Intent(getApplicationContext(), homelesslist.class);
                    notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    PendingIntent contentIntent = PendingIntent.getActivity(Categoryactivity.this, 0,
                            notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                    builder.setTicker("Ticker Title");
                    builder.setContentTitle("Share a Home");
                    builder.setContentText("New person is in need of help" +
                            "");
                    builder.setSmallIcon(R.drawable.ic_launcher);
                    builder.setAutoCancel(true);
                    //.setContentIntent(pIntent);

                    builder.setSound(notificationSound);
                    Notification noti = builder.build();
                    builder.setContentIntent(contentIntent);
                    //noti.flags = Notification.FLAG_AUTO_CANCEL;
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.notify(123, noti);
                    Log.e("camera","working "+count);
                    count=0;
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }


    @Override
    public void onClick(View view) {
        if(view==helpmebutton){
            Intent helpmeintent=new Intent(this,Helpmeactivity.class);
            startActivity(helpmeintent);
        }
        if(view==Donate){
            Intent Donateintent=new Intent(this,donate.class);
            startActivity(Donateintent);
        }
        if(view==inneedofhelp){
            Intent inneedofhelpintent=new Intent(this,homelesslist.class);
            startActivity(inneedofhelpintent);
        }
        if(view==finalbutton){
            Intent donarslistintent=new Intent(this,donarsdblist.class);
            startActivity(donarslistintent);
        }
    }
}
