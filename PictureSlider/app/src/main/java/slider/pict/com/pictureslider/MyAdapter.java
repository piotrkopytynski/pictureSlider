package slider.pict.com.pictureslider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 204862 on 08.03.2017.
 */

public final class MyAdapter extends BaseAdapter{
    private final List<Item> mItems = new ArrayList<>();
    private final LayoutInflater mInflater;

    public MyAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mItems.add(new Item(context, "Bambi",        R.drawable.bambi));
        mItems.add(new Item(context, "Cat",          R.drawable.cat));
        mItems.add(new Item(context, "Dalmatians",   R.drawable.dalmatians));
        mItems.add(new Item(context, "Donald",       R.drawable.donald));
        mItems.add(new Item(context, "Ducktales",    R.drawable.ducktales));
        mItems.add(new Item(context, "Dumbo",        R.drawable.dumbo));
        mItems.add(new Item(context, "Gin",          R.drawable.gin));
        mItems.add(new Item(context, "Goofy",        R.drawable.goofy));
        mItems.add(new Item(context, "Mickey",       R.drawable.mickey));
        mItems.add(new Item(context, "Pluto",        R.drawable.pluto));
        mItems.add(new Item(context, "Rabbit",       R.drawable.rabbit));
        mItems.add(new Item(context, "Stich",        R.drawable.stich));

    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mItems.get(i).drawableId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;
        TextView name;

        if (v == null) {
            v = mInflater.inflate(R.layout.grid_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView) v.getTag(R.id.picture);
        name = (TextView) v.getTag(R.id.text);

        Item item = getItem(i);

        picture.setImageResource(item.drawableId);
        name.setText(item.name);

        return v;
    }

    @SuppressLint("AppCompatCustomView")
    private static class Item extends Button{
        public final String name;
        public final int drawableId;

        Item(final Context context, String name, int drawableId) {
            super(context);
            this.name = name;
            this.drawableId = drawableId;
            setBackgroundResource(drawableId);
            this.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBackgroundColor(0);
                }
            });
        }

    }
}
