package classes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.allinone_benin.fongbe.fongbe.R;

import java.util.List;

/**
 * Created by Marie-Parisius D. HOUESSOU on 04/11/2016.
 */

public class CustomListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<MyItem> items;

    public CustomListAdapter(Activity activity, List<MyItem> mItems) {
        this.activity = activity;
        this.items = mItems;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return (items.get(position).getNameFon().equals("titre")) ? 0 : 1;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyItem m = items.get(i);

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int type = getItemViewType(i);

        if (view == null )
            if(type==0)
                view = inflater.inflate(R.layout.alph_titl_lay, viewGroup, false);
            else
                view = inflater.inflate(R.layout.item_lay, viewGroup, false);

        if (type == 0) {

            TextView title = (TextView) view.findViewById(R.id.alphtitle);
            title.setText(m.getNameFrench());
        }
        else {
            // view = inflater.inflate(R.layout.item_lay, viewGroup, false);

            ImageView image = (ImageView) view.findViewById(R.id.nameimage);
            TextView namefrench = (TextView) view.findViewById(R.id.name_fr);
            TextView namefon = (TextView) view.findViewById(R.id.name_fon);

            image.setImageResource(m.getImage());
            namefrench.setText(m.getNameFrench());
            namefon.setText(m.getNameFon());
        }

        return view;
    }
}

/**
 * Created by Marie-Parisius D. HOUESSOU on 04/11/2016.
 */