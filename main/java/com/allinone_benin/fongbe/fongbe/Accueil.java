package com.allinone_benin.fongbe.fongbe;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
/**
 * Created by Marie-Parisius D. HOUESSOU on 04/11/2016.
 */
public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        centerTitle();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Accueil");
    }

    public void goToPartager(View view)
    {
        Intent intent = new Intent (this, Partager.class);
        startActivity(intent);
    }

    public void goToAlphabet(View view)
    {
        Intent intent = new Intent (this, Alphabet.class);
        startActivity(intent);
    }
    public void goToAliment(View view)
    {
        Intent intent = new Intent (this, Aliments.class);
        startActivity(intent);
    }

    public void goToChiffre(View view)
    {
        Intent intent = new Intent (this, Chiffre.class);
        startActivity(intent);

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