package com.include.includeg.includegandroid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class IndexFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    public IndexFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    /////////////////////////////////////
    public class RoomListOnItemClickListener implements ListView.OnItemClickListener {
        IndexFragment mFragment;

        public RoomListOnItemClickListener(IndexFragment indexFragment) { mFragment=indexFragment; }
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { mFragment.roomListOnItemClick(i); }
    }
    public void roomListOnItemClick(int pos) {
        System.out.println("Fragment says, " + pos);
    }
    /////////////////////////////////////
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_index, container, false);

        ListView RoomList = (ListView)v.findViewById(R.id.Room_ListView);
        RoomListAdapter adapter = new RoomListAdapter(this.getContext(),R.layout.room_list_item,mListener.getRooms());
        RoomList.setAdapter(adapter);
        RoomList.setOnItemClickListener(new RoomListOnItemClickListener(this));

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
        ArrayList<Room> getRooms();
    }
}
