package com.example.fyi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;


public class Daily extends AppCompatActivity {

    //Pengerjaan : 28 April - 9 Mei 2022
    //Nim : 10119241
    //Nama : Ahmad Fahmi Fahlevi
    //Kelas : IF6
    DrawerLayout drawerLayout;
    Context context, contextFriend;
    RecyclerView recyclerView, recyclerViewFriend;
    RecyclerView.Adapter recyclerViewAdapter, recyclerViewAdapterFriend;
    RecyclerView.LayoutManager recylerViewLayoutManager,recylerViewLayoutManageFriend;
    String[] subjects = {
            "Bangun", "Mandi", "Bersih-bersih", "Kuliah", "Makan", "Main Game", "Besih-bersih","Istirahat"};
    int[] subjectImage ={
            R.drawable.ic_bangun,R.drawable.ic_mandi,
            R.drawable.ic_bersihbersih,R.drawable.ic_kuliah,
            R.drawable.ic_baseline_fastfood_24,
            R.drawable.ic_console,R.drawable.ic_bersihbersih,
            R.drawable.ic_tidur
    };
    String[] subjectsName = {
            "Strange", "Wanda", "Tony"
    };
    int[] subjectImageFriend ={
            R.drawable.myfriend1,R.drawable.myfriend3,
            R.drawable.myfriend2
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        context = getApplicationContext();
        recyclerView = findViewById(R.id.recyclerView);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new AdapterRecyclerView(subjects, subjectImage,context );
        recyclerView.setAdapter(recyclerViewAdapter);

        contextFriend = getApplicationContext();
        recyclerViewFriend = findViewById(R.id.recyclerViewFriend);
        recylerViewLayoutManageFriend = new LinearLayoutManager(contextFriend,LinearLayoutManager.HORIZONTAL,false);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewFriend.setLayoutManager(recylerViewLayoutManageFriend);
        recyclerViewAdapterFriend = new AdapterRecyclerViewFriend(subjectsName, subjectImageFriend,contextFriend );
        recyclerViewFriend.setAdapter(recyclerViewAdapterFriend);



        drawerLayout = findViewById(R.id.DrawerLayout);
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
    public void ClickDaily(View view){
        //recreate
        recreate();
    }

    public void ClickGallery(View view){
        //redirect to gallery
        HomeActivity.redirectActivity(this,Gallery.class);
    }
    public void ClickMusic(View view){
        //redirect to music
        HomeActivity.redirectActivity(this,Music.class);
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
    protected void onPause() {
        super.onPause();
        //close drawer
        HomeActivity.closeDrawer(drawerLayout);
    }
}