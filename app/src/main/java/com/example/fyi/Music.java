package com.example.fyi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class Music extends AppCompatActivity {
    //Pengerjaan : 28 April - 9 Mei 2022
    //Nim : 10119241
    //Nama : Ahmad Fahmi Fahlevi
    //Kelas : IF6
    Context contextVideo, context;
    RecyclerView recyclerViewVideo, recyclerViewMusic;
    RecyclerView.Adapter recyclerViewAdapterVideo, recyclerViewAdapterMusic;
    RecyclerView.LayoutManager recylerViewLayoutManagerVideo, recylerViewLayoutManagerMusic;
    VideoView videoView;
    String[] subjectValuesVideo = {
            "Dat Stick", "All of me", "Till It Hurts"
    };
    String[] subjectUrlVideo;
    String[] subjectValuesMusic = {
            "Industry Baby - Lil Nas X",
            "Style - Taylor Swift",
            "Perfect - Ed Sheeran",
            "Just Give Me A Reason - Pink",
            "Demons - Imagine Dragons",
            "To Good At Goodbyes - Sam Smiths",
            "Enemy - Imagine Dragons",
            "Photograph - Ed Sheeran",
            "Go Easy On Me - Adele",
            "Happier - Ed Sheeran",
            "Treat You Better - Shawn Mendes",
            "Thinking Out Loud - Ed Sheeran",
            "Angel Baby - Troye Sivan"
};
    DrawerLayout drawerLayout;
@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        subjectUrlVideo=new String[]{
        "android.resource://"+getPackageName()+"/"+R.raw.video,
        "android.resource://"+getPackageName()+"/"+R.raw.video2,
        "android.resource://"+getPackageName()+"/"+R.raw.video3
        };
        contextVideo=getApplicationContext();
        recyclerViewVideo=findViewById(R.id.recyclerViewVideo);
        recylerViewLayoutManagerVideo=new LinearLayoutManager(this);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewVideo.setLayoutManager(recylerViewLayoutManagerVideo);
        recyclerViewAdapterVideo=new AdapterRecycleViewVideo(subjectValuesVideo,subjectUrlVideo,this);
        recyclerViewVideo.setAdapter(recyclerViewAdapterVideo);

        context=getApplicationContext();
        recyclerViewMusic=findViewById(R.id.recyclerViewMusic);
        recylerViewLayoutManagerMusic=new LinearLayoutManager(context);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewMusic.setLayoutManager(recylerViewLayoutManagerMusic);
        recyclerViewAdapterMusic=new AdapterRecycleViewMusic(subjectValuesMusic,context);
        recyclerViewMusic.setAdapter(recyclerViewAdapterMusic);

        //ass
        drawerLayout=findViewById(R.id.DrawerLayout);
        }
public void ClickMenu(View view){
        //Open drawer
        HomeActivity.openDrawer(drawerLayout);

        }
public void ClickLogo(View view){
        HomeActivity.closeDrawer(drawerLayout);
        }
public void ClickHome(View view){
        //redirect to home
        HomeActivity.redirectActivity(this,HomeActivity.class);
        }
public void ClickGallery(View view){
        //redirect to gallery
        HomeActivity.redirectActivity(this,Gallery.class);
        }

public void ClickDaily(View view){
        //redirect to gallery
        HomeActivity.redirectActivity(this,Daily.class);
        }
public void ClickMusic(View view){

        //recreate
        recreate();
        }
public void ClickProfile(View view){
        //redirect to profile
        HomeActivity.redirectActivity(this,Profile.class);
        }
public void ClickLogout(View view){
        //close
        HomeActivity.logout(this);
        }

@Override
protected void onPause(){
        super.onPause();
        //close drawer
        HomeActivity.closeDrawer(drawerLayout);
        }
        }