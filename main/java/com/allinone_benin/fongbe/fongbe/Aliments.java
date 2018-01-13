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
public class Aliments extends AppCompatActivity {

    ListView lv;
    private List<MyItem> foodMyItems =new ArrayList<MyItem>();
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aliments);
        centerTitle();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Aliments");

            ////////**********Liste des aliments***********///////
            MyItem mais=new MyItem(R.drawable.maize,"Mais","Gbade",R.raw.ma);
            foodMyItems.add(mais);
            MyItem haricot=new MyItem(R.drawable.haricot,"Haricot","Ayikun", R.raw.ha);
            foodMyItems.add(haricot);
            MyItem noixpalm=new MyItem(R.drawable.np,"Noix de plame","Dekin", R.raw.np);
            foodMyItems.add(noixpalm);
            MyItem noixcoco=new MyItem(R.drawable.coco,"Noix de coco","Agonkɛ", R.raw.nc);
            foodMyItems.add(noixcoco);
            MyItem ignam=new MyItem(R.drawable.yam,"Igname","Tévi", R.raw.ig);
            foodMyItems.add(ignam);
            MyItem pimant=new MyItem(R.drawable.pep,"Piment","Takin",R.raw.pi);
            foodMyItems.add(pimant);
            MyItem oeuf=new MyItem(R.drawable.egg,"Oeuf","Azin", R.raw.oe);
            foodMyItems.add(oeuf);
            MyItem mani=new MyItem(R.drawable.foor,"Manioc","Fɛnnyɛ", R.raw.fe);
            foodMyItems.add(mani);
            MyItem gombo=new MyItem(R.drawable.okra,"Gombo","Févi", R.raw.go);
            foodMyItems.add(gombo);
            MyItem ginge=new MyItem(R.drawable.gin,"Gingembre","Dotɛ", R.raw.gi);
            foodMyItems.add(ginge);
            MyItem riz=new MyItem(R.drawable.riz,"Riz","Mɔ̆likún", R.raw.ri);
            foodMyItems.add(riz);
            MyItem banane=new MyItem(R.drawable.banane,"Banane","Kókwé", R.raw.ba);
            foodMyItems.add(banane);
            MyItem citron=new MyItem(R.drawable.citron,"Citron","Klé", R.raw.ci);
            foodMyItems.add(citron);
            MyItem poisson=new MyItem(R.drawable.ch,"Poisson","Hweví", R.raw.po);
            foodMyItems.add(poisson);
            MyItem crabe=new MyItem(R.drawable.crabe,"Crabe","Asɔ́n", R.raw.cr);
            foodMyItems.add(crabe);
            MyItem crev=new MyItem(R.drawable.crevettes,"Crevette","Dégon", R.raw.cre);
            foodMyItems.add(crev);
            MyItem poivr=new MyItem(R.drawable.po,"Poivre","Lɛ̆nlɛnkún", R.raw.poi);
            foodMyItems.add(poivr);
            MyItem mangu=new MyItem(R.drawable.mangue,"Mangue","Amăgà", R.raw.man);
            foodMyItems.add(mangu);
            MyItem oignon=new MyItem(R.drawable.oignon,"Oignon","Ayomà", R.raw.oi);
            foodMyItems.add(oignon);
            MyItem tomate=new MyItem(R.drawable.tomate,"Tomate","Timáti", R.raw.to);
            foodMyItems.add(tomate);
            ///////////////*****************///////////////////////
            lv=(ListView) findViewById(R.id.foodlist);
            lv.setAdapter(new CustomListAdapter(this, foodMyItems));
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    MyItem itm=foodMyItems.get(position);               //

                    mp = MediaPlayer.create(Aliments.this, itm.getAudio());
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
