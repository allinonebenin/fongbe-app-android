package com.allinone_benin.fongbe.fongbe;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import classes.CustomListAdapter;
import classes.MyItem;

/**
 * Created by Marie-Parisius D. HOUESSOU on 04/11/2016.
 */
public class Chiffre extends AppCompatActivity {

    ListView lv;
    private List<MyItem> numMyItems =new ArrayList<MyItem>();

    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chiffres);
        centerTitle();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Chiffres");
        actionBar.setDisplayHomeAsUpEnabled(true);

        ////////**********Liste des aliments***********///////
        MyItem zero=new MyItem(R.drawable.c0,"Zero","Vo",R.raw.c0);
        numMyItems.add(zero);
        MyItem un=new MyItem(R.drawable.c1,"Un","ɖe", R.raw.c1);
        numMyItems.add(un);
        MyItem deux=new MyItem(R.drawable.c2,"Deux","We", R.raw.c2);
        numMyItems.add(deux);
        MyItem trois=new MyItem(R.drawable.c3,"Trois","Aton", R.raw.c3);
        numMyItems.add(trois);
        MyItem quatre=new MyItem(R.drawable.c4,"Quatre","ɛnɛ", R.raw.c4);
        numMyItems.add(quatre);
        MyItem cinq=new MyItem(R.drawable.c5,"Cinq","Atɔɔn",R.raw.c5);
        numMyItems.add(cinq);
        MyItem six=new MyItem(R.drawable.c6,"Six","Ayizɛn", R.raw.c6);
        numMyItems.add(six);
        MyItem sept=new MyItem(R.drawable.c7,"Sept","Tɛnwe", R.raw.c7);
        numMyItems.add(sept);
        MyItem huit=new MyItem(R.drawable.c8,"Huit","Tantɔn", R.raw.c8);
        numMyItems.add(huit);
        MyItem neuf=new MyItem(R.drawable.c9,"Neuf","Tɛnnɛ", R.raw.c9);
        numMyItems.add(neuf);
        MyItem dix=new MyItem(R.drawable.c10,"Dix","Wo", R.raw.c10);
        numMyItems.add(dix);
        MyItem onze=new MyItem(R.drawable.c11,"Onze","Wo-ɖokpo",R.raw.c11);
        numMyItems.add(onze);
        MyItem douze=new MyItem(R.drawable.c12,"Douze","Wewe", R.raw.c12);
        numMyItems.add(douze);
        MyItem treize=new MyItem(R.drawable.c13,"Treize","Watɔn", R.raw.c13);
        numMyItems.add(treize);
        MyItem quatorze=new MyItem(R.drawable.c14,"Quatorze","Wɛnɛ", R.raw.c14);
        numMyItems.add(quatorze);
        MyItem quinze=new MyItem(R.drawable.c15,"Quinze","Afɔtɔn", R.raw.c15);
        numMyItems.add(quinze);
        MyItem seize=new MyItem(R.drawable.c16,"Seize","Afɔtɔn nukun ɖokpo",R.raw.c16);
        numMyItems.add(seize);
        MyItem dixsept=new MyItem(R.drawable.c17,"Dix-sept","Afɔtɔn nukun we", R.raw.c17);
        numMyItems.add(dixsept);
        MyItem dixhuit=new MyItem(R.drawable.c18,"Dix-huit","Afɔtɔn nukun atɔn", R.raw.c18);
        numMyItems.add(dixhuit);
        MyItem dixneuf=new MyItem(R.drawable.c19,"Dix-neuf","Afɔtɔn nukun ɛnɛ", R.raw.c19);
        numMyItems.add(dixneuf);
        MyItem vingt=new MyItem(R.drawable.c20,"Vingt","Ko", R.raw.c20);
        numMyItems.add(vingt);
        MyItem vingtun=new MyItem(R.drawable.c21,"Vingt-et-un","Ko nukun ɖokpo", R.raw.c21);
        numMyItems.add(vingtun);
        MyItem vingtdeux=new MyItem(R.drawable.c22,"Vingt-deux","Ko nukun we", R.raw.c22);
        numMyItems.add(vingtdeux);
        MyItem vtrois=new MyItem(R.drawable.c23,"Vingt-trois","Ko nukun atɔn", R.raw.c23);
        numMyItems.add(vtrois);
        MyItem vquatre=new MyItem(R.drawable.c24,"Vingt-quatre","Ko nukun ɛnɛ", R.raw.c24);
        numMyItems.add(vquatre);
        MyItem vcinq=new MyItem(R.drawable.c25,"Vingt-cinq","Ko atɔɔn",R.raw.c25);
        numMyItems.add(vcinq);
        MyItem vsix=new MyItem(R.drawable.c26,"Vingt-six","Ko atɔɔn nukun ɖokpo", R.raw.c26);
        numMyItems.add(vsix);
        MyItem vsept=new MyItem(R.drawable.c27,"Vingt-sept","Ko atɔɔn nukun we", R.raw.c27);
        numMyItems.add(vsept);
        MyItem vhuit=new MyItem(R.drawable.c28,"Vingt-huit","Ko atɔɔn nukun atɔn", R.raw.c28);
        numMyItems.add(vhuit);
        MyItem vneuf=new MyItem(R.drawable.c29,"Vingt-neuf","Ko atɔɔn nukun ɛnɛ", R.raw.c29);
        numMyItems.add(vneuf);
        MyItem trente=new MyItem(R.drawable.c30,"Trente","Gban",R.raw.c30);
        numMyItems.add(trente);
        MyItem quarante=new MyItem(R.drawable.c40,"Quarante","Kanɖe", R.raw.c40);
        numMyItems.add(quarante);
        MyItem cinquante=new MyItem(R.drawable.c50,"Cinquante","Kanɖe wo", R.raw.c50);
        numMyItems.add(cinquante);
        MyItem soixante=new MyItem(R.drawable.c60,"Soixante","Kanɖe ko", R.raw.c60);
        numMyItems.add(soixante);
        MyItem soixdix=new MyItem(R.drawable.c70,"Soixante-dix","Kanɖe gban", R.raw.c70);
        numMyItems.add(soixdix);
        MyItem quatrov=new MyItem(R.drawable.c80,"Quatre-vingt","Kanwe", R.raw.c80);
        numMyItems.add(quatrov);
        MyItem qtrdix=new MyItem(R.drawable.c90,"Quatre-vingt-dix","Kanwe wo", R.raw.c90);
        numMyItems.add(qtrdix);
        MyItem cent=new MyItem(R.drawable.c100,"Cent","Kanwe ko", R.raw.c100);
        numMyItems.add(cent);
        ///////////////*****************///////////////////////
        lv=(ListView) findViewById(R.id.numberlist);
        lv.setAdapter(new CustomListAdapter(this, numMyItems));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyItem itm=numMyItems.get(position);

                mp = MediaPlayer.create(Chiffre.this, itm.getAudio());
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mp.start();
                mp.setOnCompletionListener(onCompletionListener);
            }
        });
    }



    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
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
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            // TODO Auto-generated method stub
            mp.release();
            mp = null;
        }
    };

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

}

/**
 * Created by Marie-Parisius D. HOUESSOU on 04/11/2016.
 */