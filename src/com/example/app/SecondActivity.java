package com.example.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private Button btn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        btn = (Button)findViewById(R.id.button1);
        ((TextView)findViewById(R.id.textMessage)).setText(getIntent().getStringExtra("textMail"));
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				intent.putExtra("textAnswer", ((TextView)findViewById(R.id.textAnswer)).getText().toString());
				intent.putExtra("textMessage", ((TextView)findViewById(R.id.textMessage)).getText().toString());
				intent.putExtra("answer", true);
				startActivity(intent);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
