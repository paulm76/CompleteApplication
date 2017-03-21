package fr.esilv.s8.completeapplication.pm.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.esilv.s8.completeapplication.R;

public class VideoDescriptionActivity extends AppCompatActivity {

    private static final String TITLE = "TITLE";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String URL = "URL";
    private RecyclerView recyclerView;
    private String titleStr;
    private String descStr;
    private String urlStr = "https://www.youtube.com/watch?v=";
    private TextView title;
    private TextView desc;
    private Button videoBtn;

    public static void start(Context context, String title, String desc, String url) {
        Intent intent = new Intent(context, VideoDescriptionActivity.class);
        intent.putExtra(TITLE, title);
        intent.putExtra(DESCRIPTION, desc);
        intent.putExtra(URL, url);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_description);
        titleStr = getIntent().getStringExtra(TITLE);
        descStr = getIntent().getStringExtra(DESCRIPTION);
        urlStr += getIntent().getStringExtra(URL);
        title = (TextView) findViewById(R.id.title_desc);
        desc = (TextView) findViewById(R.id.desc_desc);
        videoBtn = (Button)findViewById(R.id.videoBtn);
        title.setText(titleStr);
        desc.setText(descStr);
        final Context context = this;
        videoBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //VideoActivity.start(context, urlStr);
            }
        });
    }
}
