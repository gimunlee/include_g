package com.include.includeg.includegandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity{

    ArrayList<Room> mRooms;
    ArrayList<String> timeAndPlace;
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

        ListView RoomList = (ListView)findViewById(R.id.Room_ListView);
        RoomListAdapter adapter = new RoomListAdapter(this,R.layout.room_list_item,mRooms);
        RoomList.setAdapter(adapter);

        RoomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Activity says",""+i);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("room number",i);
                startActivity(intent);
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

        mRooms.add(new Room(Meal.Lunch, Location.East, 1));
        mRooms.get(0).addMember("이진우",1600,"정문 앞");
        mRooms.get(0).addMember("이기문",1930,"뚝배기");
        mRooms.get(0).addMember("인클루드",1720,"카이마루");
        mRooms.get(0).addMember("abc",1600,"서측");
        mRooms.get(0).addMember("def",1600,"정문 앞");
        mRooms.get(0).addMember("ghi",1600,"정문 앞");
        mRooms.add(new Room(Meal.Dinner, Location.West, 1));
        mRooms.add(new Room(Meal.Breakfast, Location.North, 1));

        Comparator<Room.Member> sort = new Comparator<Room.Member>() {
            public int compare(Room.Member o1, Room.Member o2) {
                if(o2.getTime()!=o1.getTime())
                    return o2.getTime()-o1.getTime();
                else
                    return o2.place.compareTo(o1.place);
            }
        };


        Collections.sort(mRooms.get(0).members, sort);

        for(int i=0;i<mRooms.get(0).members.size();i++){
            System.out.print(mRooms.get(0).members.get(i).name+" ");
            System.out.print(mRooms.get(0).members.get(i).time+" ");
            System.out.println(mRooms.get(0).members.get(i).place);
        }


        for(int i=0;i<mRooms.get(0).members.size();i++){
            Room.Member member = mRooms.get(0).members.get(i);
            timeAndPlace.add(String.format("%d",member.time)+member.place);
        }

//        Collections.sort(timeAndPlace);



//        mDetailFragment.setRoom(mRooms.get(0));

    }


}
