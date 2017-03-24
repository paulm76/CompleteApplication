package fr.esilv.s8.completeapplication.pm.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;

import fr.esilv.s8.completeapplication.R;
import fr.esilv.s8.completeapplication.pm.Constants;
import fr.esilv.s8.completeapplication.pm.adapters.VideoAdapter;
import fr.esilv.s8.completeapplication.pm.interfaces.OnVideoSelectedListener;
import fr.esilv.s8.completeapplication.pm.models.Video;
import fr.esilv.s8.completeapplication.pm.models.VideoList;


public class VideoListActivity extends AppCompatActivity implements OnVideoSelectedListener{

    private static final String RESEARCH = "RESEARCH";
    private static final String YOUTUBE_URL = "https://www.googleapis.com/youtube/v3/search";
    private RecyclerView recyclerView;
    private String research;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        research = getIntent().getStringExtra(RESEARCH);

        setContentView(R.layout.activity_video_list);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getVideos();
    }

    public static void start(Context context, String research){
        Intent intent = new Intent(context, VideoListActivity.class);
        intent.putExtra(RESEARCH, research);
        context.startActivity(intent);
    }

    private void getVideos() {
        research = research.replaceAll("\\s", "+");
        final StringRequest videoRequest = new StringRequest(YOUTUBE_URL + "?key=" + Constants.API_KEY + "&q=" + research + "&part=snippet&maxResults=15", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //parse data from webservice to get Contracts as Java object
                Video video = new Gson().fromJson(response, Video.class);
                setAdapter(video.getVideoList());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("videoList", "Error");
            }
        });

        Volley.newRequestQueue(this).add(videoRequest);
    }

    private void setAdapter(ArrayList<VideoList> videoList) {
        VideoAdapter adapter = new VideoAdapter(videoList);
        adapter.setOnVideoSelectedListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onVideoSelected(VideoList videoList) {
        VideoDescriptionActivity.start(this, videoList.getSnippet().getTitle(), videoList.getSnippet().getDescription(), videoList.getId().getVideoId());
    }
}
