package com.include.includeg.includegandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;

public class DetailActivity extends AppCompatActivity {
    Room mRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent myIntent = getIntent();
        int roomListNum = myIntent.getIntExtra("room number",0);
        mRoom = new Room(Meal.Breakfast,Location.East,3);
        mRoom.addMember("이진우",1600,"정문 앞");
        mRoom.addMember("이기문",1930,"뚝배기");
        mRoom.addMember("인클루드",1720,"카이마루");
        mRoom.addMember("abc",1600,"서측");
        mRoom.addMember("def",1600,"정문 앞");
        mRoom.addMember("ghi",1600,"정문 앞");
        mRoom.addMember("이진우",1600,"정문 앞");
        mRoom.addMember("이기문",1930,"뚝배기");
        mRoom.addMember("인클루드",1720,"카이마루");
        mRoom.addMember("abc",1600,"서측");
        mRoom.addMember("def",1600,"정문 앞");
        mRoom.addMember("ghi",1600,"정문 앞");
        mRoom.addMember("이진우",1600,"정문 앞");
        mRoom.addMember("이기문",1930,"뚝배기");
        mRoom.addMember("인클루드",1720,"카이마루");
        mRoom.addMember("abc",1600,"서측");
        mRoom.addMember("def",1600,"정문 앞");
        mRoom.addMember("ghi",1600,"정문 앞");
        mRoom.addMember("이진우",1600,"정문 앞");
        mRoom.addMember("이기문",1930,"뚝배기");
        mRoom.addMember("인클루드",1720,"카이마루");
        mRoom.addMember("abc",1600,"서측");
        mRoom.addMember("def",1600,"정문 앞");
        mRoom.addMember("ghi",1600,"정문 앞");
        Comparator<Room.Member> sort = new Comparator<Room.Member>() {
            public int compare(Room.Member o1, Room.Member o2) {
                if(o2.getTime()!=o1.getTime())
                    return o2.getTime()-o1.getTime();
                else
                    return o2.place.compareTo(o1.place);
            }
        };


//        Collections.sort(mRoom.members, sort);
        TextView time = (TextView)findViewById(R.id.time_TextView);
        time.setText("1600");
        TextView place =(TextView)findViewById(R.id.place_TextView);
        place.setText("정문 앞");

        if(mRoom!=null){
            ListView partyListView = (ListView) findViewById(R.id.party_ListView);
//            PartyListViewAdapter partyAdapter = new PartyListViewAdapter(this,R.layout.party_list_item, mRoom.members);
//            partyListView.setAdapter(partyAdapter);
        }

        if(mRoom!=null) {
            ListView memberListView = (ListView) findViewById(R.id.member_ListView);
//            MemberListViewAdapter memberAdapter = new MemberListViewAdapter(this, R.layout.member_list_item, mRoom.members);
//            memberListView.setAdapter(memberAdapter);
        }
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
    public void setRoom(Room room) {
        mRoom=room;
    }
}
