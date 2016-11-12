package com.include.includeg.includegandroid;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IndexFragment.OnFragmentInteractionListener, DetailFragment.DetailFragmentListener{

    ArrayList<Room> mRooms;
    DetailFragment mDetailFragment;
    public void onFragmentInteraction(Uri uri) {

    }
    public ArrayList<Room> getRooms() {
        return this.mRooms;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRooms = new ArrayList<Room>();

        setContentView(R.layout.activity_main);

        if(findViewById(R.id.index_fragment)!=null) {
            if(savedInstanceState!=null) {
                return;
            }
            IndexFragment indexFragment=new IndexFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.index_fragment, indexFragment).commit();
        }

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
        mRooms.add(new Room(Meal.Dinner, Location.West, 1));
        mRooms.add(new Room(Meal.Breakfast, Location.North, 1));

//        mDetailFragment.setRoom(mRooms.get(0));

    }


}
