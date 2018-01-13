package com.allinone_benin.fongbe.fongbe;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Marie-Parisius D. HOUESSOU on 04/11/2016.
 */
public class Partager extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    String message = "Retrouvez l'application Fongbe sur: http://allinone-benin.com/fongbe";
    EditText number;

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partager);
        centerTitle();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Partager");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9400D3")));
        number = (EditText) findViewById(R.id.number);

    }


    public void shareSocial(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Fongbe Application");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(intent, "Partager"));
    }
    /*public void openDialog(View view)
    {
        sendSMSMessage(number.getText().toString(), message);
    }*/

    public void openDialog(View view)
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_message, null);
        dialogBuilder.setView(dialogView);

        final EditText number = (EditText) dialogView.findViewById(R.id.number);
        dialogBuilder.setPositiveButton("Envoyer", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton)
            {
                try{
                    sendSMSMessage(number.getText().toString(), message);
                    Toast.makeText(getApplicationContext(),"SMS Envoyé", Toast.LENGTH_LONG).show();

                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),
                            "Echec de l'envoi. Veuiller réessayer s'il vous plaît.", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        });
        dialogBuilder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
                Toast.makeText(getApplicationContext(), "Envoi annulé",
                        Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private void centerTitle() {
        ArrayList<View> textViews = new ArrayList<>();

        getWindow().getDecorView().findViewsWithText(textViews, getTitle(), View.FIND_VIEWS_WITH_TEXT);

        if(textViews.size() > 0) {
            AppCompatTextView appCompatTextView = null;
            if(textViews.size() == 1) {
                appCompatTextView = (AppCompatTextView) textViews.get(0);
            } else {
                for(View v : textViews) {
                    if(v.getParent() instanceof Toolbar) {
                        appCompatTextView = (AppCompatTextView) v;
                        break;
                    }
                }
            }

            if(appCompatTextView != null) {
                ViewGroup.LayoutParams params = appCompatTextView.getLayoutParams();
                params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                appCompatTextView.setLayoutParams(params);
                appCompatTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
        }
    }

    /*protected void sendSMSMessage(String phoneNo, String message)
    {


        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }*/

   /* @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number.getText().toString(), null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS envoyé.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Echec de l'envoi. Veuiller réessayer s'il vous plaît.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent myIntent = new Intent(this, Accueil.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void sendSMSMessage(String s, String message) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(s, null, message, null, null);
    }
}

/**
 * Created by Marie-Parisius D. HOUESSOU on 04/11/2016.
 */