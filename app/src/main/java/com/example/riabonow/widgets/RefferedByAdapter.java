package com.example.riabonow.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.riabonow.R;

import java.util.List;

public class RefferedByAdapter extends BaseAdapter {
    Context context;
    String[]  name;
    LayoutInflater inflter;

    public RefferedByAdapter(Context applicationContext , String[] name) {
        this.context = applicationContext;
        this.name = name;
        inflter = (LayoutInflater.from(applicationContext));
    }


    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.row_item_spinner, null);
        TextView names = (TextView) view.findViewById(R.id.tv_name);
        names.setText(name[i]);
        return view;
    }


    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View v = null;
        if (position == 0) {
            TextView tv = new TextView(context);
            tv.setVisibility(View.GONE);
            v = tv;
        } else {
            v = super.getDropDownView(position, null, parent);
        }
        return v;
    }
}