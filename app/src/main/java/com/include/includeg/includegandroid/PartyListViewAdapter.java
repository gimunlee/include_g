package com.include.includeg.includegandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by IncludeTV on 2016-11-18.
 */

public class PartyListViewAdapter extends ArrayAdapter<Room.Member> {
    private ArrayList<Room.Member> members;
    Context context;
    int count;
    Room.Member tempMember;
    int presentPosition;



    public PartyListViewAdapter(Context context, int resourceId, ArrayList<Room.Member> l) {
        super(context,resourceId,l);
        this.context=context;
        this.members=l;
    }

    @Override
    public int getCount() {
        int partyCount=1;
        for (int i = 0; i < members.size() - 1; i++) {
            if (members.get(i).place != members.get(i + 1).place || members.get(i).time != members.get(i + 1).time) {
                partyCount++;
            }
        }
        return partyCount;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.party_list_item, null);
        }


        presentPosition = 0;
        count=1;
        int presentTime=0;
        String presentPlace="";
        for(int i=0;i<members.size();i++){
            if(presentPosition==position){
                presentTime=members.get(i).time;
                presentPlace=members.get(i).place;
                if(i==members.size()-1){
                }
                else if(members.get(i).place == members.get(i+1).place && members.get(i).time == members.get(i+1).time) {
                    count++;
                }
                else{
                    break;
                }
            }
            else {
                if(i==members.size()-1){}
                else if (members.get(i).place != members.get(i + 1).place || members.get(i).time != members.get(i + 1).time) {
                    presentPosition++;
                }
            }
        }

        if (presentTime==0){
            return convertView;
        }
        TextView partyTimeTextview=(TextView)convertView.findViewById(R.id.party_time_TextView);
        TextView partyPlaceTextview=(TextView)convertView.findViewById(R.id.party_place_TextView);
        TextView partyCountTextview=(TextView)convertView.findViewById(R.id.party_count_TextView);

        partyTimeTextview.setText(String.format("%d",presentTime));
        partyPlaceTextview.setText(presentPlace);
        partyCountTextview.setText(String.format("%d",count));
        return convertView;
    }
}
