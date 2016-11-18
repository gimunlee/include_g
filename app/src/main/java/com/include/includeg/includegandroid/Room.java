package com.include.includeg.includegandroid;

import java.util.ArrayList;

/**
 * Created by IncludeTV on 2016-11-12.
 */

public class Room {
    Meal meal;
    Location location;
    int count;
    ArrayList<Member> members;
    public Room(Meal _meal, Location _location, int _count) {
        meal=_meal;
        location=_location;
        count=_count;
        members=new ArrayList<>();
    }

    public void addMember(String name, int time, String place){
        members.add(new Member(name, time, place));
//        for(int i=0;i<members.size();i++) {
//            if(members.)
//        }
    }


    public class Member {
        String name;
        int time;
        String place;
        int partyIndex;

        public Member(String name, int time, String place) {
            this.name=name;
            this.time=time;
            this.place=place;
            partyIndex=-1;
        }

        public int getTime(){
            return time;
        }
    }
}

enum Meal {
    Lunch, Breakfast, Dinner, Yasik
}
enum Location {
    North, East, West
}
