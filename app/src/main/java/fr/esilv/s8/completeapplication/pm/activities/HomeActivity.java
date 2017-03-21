package fr.esilv.s8.completeapplication.pm.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.esilv.s8.completeapplication.R;

public class HomeActivity extends AppCompatActivity {

    EditText editText = null;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        editText = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.button);
        final Context context = this;
        editText.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                editText.setText("");
            }
        });
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                VideoListActivity.start(context, editText.getText().toString());
            }
        });
    }
}

