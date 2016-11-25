package com.include.includeg.includegandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity{

    ArrayList<Room> mRooms;
    ArrayList<String> timeAndPlace;
    RoomListAdapter mRoomListAdapter;
    SwipeRefreshLayout mRoomListSwipeRefreshLayout;
    public void onFragmentInteraction(Uri uri) {

    }
    public ArrayList<Room> getRooms() {
        return this.mRooms;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRooms = new ArrayList<Room>();
        timeAndPlace = new ArrayList<String>();

        setContentView(R.layout.activity_main);

        ListView roomList = (ListView)findViewById(R.id.Room_ListView);
        mRoomListAdapter = new RoomListAdapter(this,R.layout.room_list_item,mRooms);
        roomList.setAdapter(mRoomListAdapter);

        roomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.i("Activity says",""+i);
//                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                intent.putExtra("room number",i);
//                startActivity(intent);

            }
        });

//
//        if(findViewById(R.id.detail_fragment)!=null){
//            if(savedInstanceState!=null){
//                return;
//            }
//            mDetailFragment=new DetailFragment();
//            getSupportFragmentManager().beginTransaction().add(R.id.detail_fragment,mDetailFragment).commit();
//        }

        new DownloadIndexTask().execute("http://192.168.0.110:3002/rooms");

        Comparator<Room.Member> sort = new Comparator<Room.Member>() {
            public int compare(Room.Member o1, Room.Member o2) {
                if(o2.getTime()!=o1.getTime())
                    return o2.getTime()-o1.getTime();
                else
                    return o2.place.compareTo(o1.place);
            }
        };

        mRoomListSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swiperefresh);
        mRoomListSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new DownloadIndexTask().execute("http://192.168.0.110:3002/rooms");
            }
        });


//        Collections.sort(mRooms.get(0).members, sort);
//
//        for(int i=0;i<mRooms.get(0).members.size();i++){
//            System.out.print(mRooms.get(0).members.get(i).name+" ");
//            System.out.print(mRooms.get(0).members.get(i).time+" ");
//            System.out.println(mRooms.get(0).members.get(i).place);
//        }


//        for(int i=0;i<mRooms.get(0).members.size();i++){
//            Room.Member member = mRooms.get(0).members.get(i);
//            timeAndPlace.add(String.format("%d",member.time)+member.place);
//        }
    }

    private class DownloadIndexTask extends AsyncTask<String, Void, JSONArray>{

        @Override
        protected JSONArray doInBackground(String... strings) {
            InputStream is = null;
            try{
                URL url = new URL(strings[0]);
                Log.d("getPort",String.format("%d",url.getPort()));
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();
                int response = conn.getResponseCode();
                Log.d("response", String.format("%d",response));
                is = conn.getInputStream();

                Scanner s = new Scanner(is).useDelimiter("\\A");
                JSONArray json = new JSONArray(s.hasNext() ? s.next() : "");

                return json;
            } catch(IOException e){
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }return null;
        }

        @Override
        protected void onPostExecute(JSONArray s) {
            try {
                mRooms.clear();
                Log.d("Network", s.toString());
                for (int i = 0; i < s.length(); i++) {
                    JSONObject jsonRoom = s.getJSONObject(i);

                    mRooms.add(new Room(Meal.valueOf(jsonRoom.getString("meal")),Location.valueOf(jsonRoom.getString("location")),jsonRoom.getInt("count")));
                }
                mRoomListAdapter.notifyDataSetChanged();
                mRoomListSwipeRefreshLayout.setRefreshing(false);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


}
