package com.example.mafia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayer extends Activity implements OnClickListener {

	private EditText playerName;
	private Button addplayer;

	private void init() {
		playerName = (EditText) findViewById(R.id.editText_player_name);
		addplayer = (Button) findViewById(R.id.button_addPlayer);
		addplayer.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String name = playerName.getText().toString();
		if (name == null || name.length() == 0) {
			Toast.makeText(getApplicationContext(), "Name must be entered.",
					Toast.LENGTH_SHORT).show();
			
		} else {
			Intent resultData = new Intent();
			resultData.putExtra("player", name);
			setResult(RESULT_OK, resultData);
			finish();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_player);
		init();
	}

}
