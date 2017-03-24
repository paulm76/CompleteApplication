package fr.esilv.s8.completeapplication.pm.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.MalformedURLException;
import java.util.ArrayList;

import fr.esilv.s8.completeapplication.R;
import fr.esilv.s8.completeapplication.pm.interfaces.OnVideoSelectedListener;
import fr.esilv.s8.completeapplication.pm.models.VideoList;
import fr.esilv.s8.completeapplication.pm.viewholders.VideoViewHolder;

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    private final ArrayList<VideoList> videoList;
    private OnVideoSelectedListener onVideoSelectedListener;

    public VideoAdapter(ArrayList<VideoList> videoList) {
        this.videoList = videoList;
    }

    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_list_video, parent, false);
        return new VideoViewHolder(view);
    }


    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.setOnVideoSelectedListener(onVideoSelectedListener);
        try {
            holder.bind(videoList.get(position));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    public int getItemCount() {
        return videoList != null ? videoList.size() : 0;
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}
