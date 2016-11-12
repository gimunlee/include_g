package com.include.includeg.includegandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    Room mRoom;

    public DetailFragment() {
        // Required empty public constructor
    }
    public interface DetailFragmentListener{
        ArrayList<Room> getRooms();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_detail, container, false);

        TextView time = (TextView)v.findViewById(R.id.time_TextView);
        time.setText("1600");
        TextView place =(TextView)v.findViewById(R.id.place_TextView);
        place.setText("정문 앞");

        if(mRoom!=null) {
            ListView memberListView = (ListView) v.findViewById(R.id.member_ListView);
            MemberListViewAdapter memberAdapter = new MemberListViewAdapter(this.getContext(), R.layout.member_list_item, mRoom.members);
            memberListView.setAdapter(memberAdapter);
        }

        return v;
    }
    public void setRoom(Room room) {
        mRoom=room;
    }

}
