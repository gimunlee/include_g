package com.include.includeg.includegandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by IncludeTV on 2016-11-12.
 */

public class MemberListViewAdapter extends ArrayAdapter<Room.Member>{
    private ArrayList<Room.Member> items;
    Context context;

    public MemberListViewAdapter(Context context, int resourceId, ArrayList<Room.Member> l) {
        super(context,resourceId,l);
        this.context=context;
        this.items=l;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.member_list_item, null);
        }
        Room.Member member = items.get(position);
        String txt_name = member.name.toString();
        String txt_time = String.format("%d",member.time);
        String txt_place = member.place.toString();

        TextView name_textview = (TextView)convertView.findViewById(R.id.member_name_TextView);
        TextView time_textview = (TextView)convertView.findViewById(R.id.member_time_TextView);
        TextView place_textview = (TextView)convertView.findViewById(R.id.member_place_TextView);

        name_textview.setText(txt_name);
        time_textview.setText(txt_time);
        place_textview.setText(txt_place);
        return convertView;
    }
}

