package com.example.mafia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private TextView startScreenTitle;
    private Typeface mafia;
	private Button startButton;

	private void init() {
		startScreenTitle = (TextView) findViewById(R.id.start_screen_title);
		mafia = Typeface.createFromAsset(getAssets(), "fonts/leadcoat.ttf");
		startScreenTitle.setTypeface(mafia);
		startButton = (Button)findViewById(R.id.button_start);
		startButton.setTypeface(mafia);
		startButton.setOnClickListener(this);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	@Override
	public void onClick(View v) {
		Intent i = new Intent(this , SetUpGame.class);
		startActivity(i);
	}
}
