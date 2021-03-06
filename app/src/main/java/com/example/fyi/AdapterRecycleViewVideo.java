package com.example.fyi;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRecycleViewVideo extends RecyclerView.Adapter<AdapterRecycleViewVideo.ViewHolder> {
    //Pengerjaan : 28 April - 9 Mei 2022
    //Nim : 10119241
    //Nama : Ahmad Fahmi Fahlevi
    //Kelas : IF6
    private String[] SubjectValuesVideo;
    private String[] SubjectUrlVideo;
    private Context contextVideo;

    public AdapterRecycleViewVideo(String[] subjectValuesVideo, String[] subjectUrlVideo, Context contextVideo) {
        SubjectValuesVideo = subjectValuesVideo;
        SubjectUrlVideo = subjectUrlVideo;
        this.contextVideo = contextVideo;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        VideoView videoView;

        ViewHolder(View v) {

            super(v);
            videoView = v.findViewById(R.id.itemVideo);
            textView = v.findViewById(R.id.TittleItem);
        }
    }

    @NonNull
    @Override
    public AdapterRecycleViewVideo.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(contextVideo).inflate(R.layout.list_video_item, parent, false);
        return new AdapterRecycleViewVideo.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(AdapterRecycleViewVideo.ViewHolder holder, int position) {

        holder.textView.setText(SubjectValuesVideo[position]);
        holder.videoView.setVideoURI(Uri.parse(SubjectUrlVideo[position]));

        MediaController mc = new MediaController(contextVideo);
        mc.setAnchorView(holder.videoView);
        mc.setMediaPlayer(holder.videoView);
        holder.videoView.setMediaController(mc);
    }

    @Override
    public int getItemCount() {
        return SubjectValuesVideo.length;
    }

}


