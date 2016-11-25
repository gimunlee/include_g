package com.include.includeg.includegandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by IncludeTV on 2016-11-05.
 */

public class RoomListAdapter extends ArrayAdapter<Room>{
    private ArrayList<Room> items;
    Context context;

    public RoomListAdapter(Context context, int resourceId, ArrayList<Room> l) {
        super(context,resourceId,l);
        this.context=context;
        this.items=l;
    }
    public void clear(){
        items.clear();
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.room_list_item, null);
        }
        Room item=items.get(position);
        TextView mealTextView = (TextView)convertView.findViewById(R.id.textViewMeal);
        TextView locationTextView = (TextView)convertView.findViewById(R.id.textViewLocation);
        String mealText="";
        String locationText="";
        switch(item.meal) {
            case Lunch : mealText="점심"; break;
            case Breakfast: mealText="아침"; break;
            case Dinner: mealText="저녁"; break;
            case Yasik: mealText="야식"; break;
        }
        switch(item.location){
            case North : locationText="북측"; break;
            case East : locationText="동측"; break;
            case West : locationText="서측"; break;
        }
        mealTextView.setText(mealText);
        locationTextView.setText(locationText);
        return convertView;
    }
}
