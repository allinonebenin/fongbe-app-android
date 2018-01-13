package com.allinone_benin.fongbe.fongbe;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import classes.CustomListAdapter;
import classes.MyItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marie-Parisius D. HOUESSOU on 04/11/2016.
 */
public class Alphabet extends AppCompatActivity {


    ListView lv;
    private List<MyItem> alphMyItems =new ArrayList<MyItem>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        centerTitle();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Alphabet");
        actionBar.setDisplayHomeAsUpEnabled(true);

        ///////////////////////////////////////////
        MyItem voyl=new MyItem(0,"Voyelles","titre", 0);
        alphMyItems.add(voyl);
        MyItem a=new MyItem(R.drawable.a,"a","a comme dans tracas", R.raw.a);
        alphMyItems.add(a);
        MyItem i=new MyItem(R.drawable.i,"i","i comme dans habit", R.raw.i);
        alphMyItems.add(i);
        MyItem ee=new MyItem(R.drawable.ee,"","ɛ antérieure ouverte \n comme dans fête", R.raw.ee);
        alphMyItems.add(ee);
        MyItem e=new MyItem(R.drawable.e,"","e antérieure comme dans métro", R.raw.e);
        alphMyItems.add(e);
        MyItem u=new MyItem(R.drawable.u,"","u Postérieure fermée comme dans coucou", R.raw.u);
        alphMyItems.add(u);
        MyItem or=new MyItem(R.drawable.or,"","ɔ Postérieure ouverte comme dans sorte", R.raw.or);
        alphMyItems.add(or);
        MyItem o=new MyItem(R.drawable.o,"","o Postérieure moyenne comme dans château", R.raw.o);
        alphMyItems.add(o);
        MyItem an=new MyItem(R.drawable.an,"","an \"a\" nasalisé comme dans danse", R.raw.an);
        alphMyItems.add(an);
        MyItem orn=new MyItem(R.drawable.orn,"","ɔn \"ɔ\" nasalisé comme dans fonte mais assez ouvert", R.raw.orn);
        alphMyItems.add(orn);
        MyItem on=new MyItem(R.drawable.on,"","on \"ɔ\" nasalisé comme dans fonte mais assez fermé", R.raw.on);
        alphMyItems.add(on);
        MyItem een=new MyItem(R.drawable.een,"ɛn","ɛn \"ɛ\" comme dans pain", R.raw.een);
        alphMyItems.add(een);
        MyItem un= new MyItem(R.drawable.un, "", "Pas de correspondance en français", R.raw.un);
        alphMyItems.add(un);
        MyItem in=new MyItem(R.drawable.in,"","Pas de correspondance en français", R.raw.in);
        alphMyItems.add(in);
        MyItem consonnes=new MyItem(0,"Consonnes","titre", 0);
        alphMyItems.add(consonnes);
        MyItem b=new MyItem(R.drawable.b,"b","b comme dans bouche", R.raw.b);
        alphMyItems.add(b);
        MyItem c=new MyItem(R.drawable.c,"c","c comme dans tchao", R.raw.c);
        alphMyItems.add(c);
        MyItem d=new MyItem(R.drawable.d,"d","d comme dans doute", R.raw.d);
        alphMyItems.add(d);
        MyItem dd =new MyItem(R.drawable.dd,"","ɖ Se prononce comme \"d\", mais en\n appuyant la pointe de la langue sur la racine des dents", R.raw.dd);
        alphMyItems.add(dd);
        MyItem f=new MyItem(R.drawable.f,"f","f comme dans foule", R.raw.f);
        alphMyItems.add(f);
        MyItem g=new MyItem(R.drawable.g,"g","g comme dans gamin", R.raw.g);
        alphMyItems.add(g);
        MyItem gb=new MyItem(R.drawable.gb,"gb","gb en un seul son", R.raw.gb);
        alphMyItems.add(gb);
        MyItem h=new MyItem(R.drawable.h,"","h Se prononce avec une expiration venant de la poitrine", R.raw.h);
        alphMyItems.add(h);
        MyItem j=new MyItem(R.drawable.j,"j","j comme dans djin", R.raw.j);
        alphMyItems.add(j);
        MyItem k=new MyItem(R.drawable.k,"k","k comme dans képi", R.raw.k);
        alphMyItems.add(k);
        MyItem kp=new MyItem(R.drawable.kp,"kp","kp en un seul son", R.raw.kp);
        alphMyItems.add(kp);
        MyItem l=new MyItem(R.drawable.l,"l","l comme lame, le R léger", R.raw.l);
        alphMyItems.add(l);
        MyItem m=new MyItem(R.drawable.m,"m","m comme dans marine", R.raw.m);
        alphMyItems.add(m);
        MyItem n=new MyItem(R.drawable.n,"n","n comme dans noce", R.raw.n);
        alphMyItems.add(n);
        MyItem ny=new MyItem(R.drawable.ny,"ny","ny comme dans magnifique", R.raw.ny);
        alphMyItems.add(ny);
        MyItem p=new MyItem(R.drawable.p,"","p comme dans pouce (n'existe pas en fon sauf pɛpɛpɛ, pinpan)", R.raw.p);
        alphMyItems.add(p);
        MyItem s=new MyItem(R.drawable.s,"s","s comme dans sale", R.raw.s);
        alphMyItems.add(s);
        MyItem t=new MyItem(R.drawable.t,"t","t comme dans tasse", R.raw.t);
        alphMyItems.add(t);
        MyItem v=new MyItem(R.drawable.v,"v","v comme dans vase", R.raw.v);
        alphMyItems.add(v);
        MyItem w=new MyItem(R.drawable.w,"w","w comme dans ouate", R.raw.w);
        alphMyItems.add(w);
        MyItem x=new MyItem(R.drawable.x,"x","x comme la jota espagnol", R.raw.x);
        alphMyItems.add(x);
        MyItem y=new MyItem(R.drawable.y,"y","y comme dans yaourt", R.raw.y);
        alphMyItems.add(y);
        MyItem z=new MyItem(R.drawable.z,"z","z comme dans zone", R.raw.z);
        alphMyItems.add(z);

        ///////////////*****************///////////////////////
        lv=(ListView) findViewById(R.id.alphlist);
        lv.setAdapter(new CustomListAdapter(this, alphMyItems));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyItem itm=alphMyItems.get(position);
                //
                if(itm.getAudio()!=0){
                    final MediaPlayer mp = MediaPlayer.create(Alphabet.this, itm.getAudio());
                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();

                        };
                    });
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                        }
                    });}

            }
        });

    }
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

}

/**
 * Created by Marie-Parisius D. HOUESSOU on 04/11/2016.
 */


