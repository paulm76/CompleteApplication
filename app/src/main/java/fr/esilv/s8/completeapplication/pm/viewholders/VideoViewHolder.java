package fr.esilv.s8.completeapplication.pm.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.net.MalformedURLException;

import fr.esilv.s8.completeapplication.R;
import fr.esilv.s8.completeapplication.pm.interfaces.OnVideoSelectedListener;
import fr.esilv.s8.completeapplication.pm.models.VideoList;

public class VideoViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView desc;
    private TextView date;
    private TextView author;
    private ImageView thumbnail;
    private OnVideoSelectedListener onVideoSelectedListener;

    public VideoViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        desc = (TextView) itemView.findViewById(R.id.desc);
        date = (TextView) itemView.findViewById(R.id.date);
        author = (TextView) itemView.findViewById(R.id.author);
        thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
    }

    public void bind(final VideoList videoList) throws MalformedURLException {
        title.setText(videoList.getSnippet().getTitle());
        desc.setText(videoList.getSnippet().getDescription());
        date.setText(videoList.getSnippet().getPublishedAt());
        author.setText(videoList.getSnippet().getChannelTitle());
        Glide.with(itemView.getContext()).load(videoList.getSnippet().getThumbnails().getMedium().getUrl()).override(1200,400).into(thumbnail);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onVideoSelectedListener == null) {
                    return;
                }
                onVideoSelectedListener.onVideoSelected(videoList);
            }
        });
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}
