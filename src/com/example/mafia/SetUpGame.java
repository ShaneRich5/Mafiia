package com.example.mafia;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SetUpGame extends Activity implements OnClickListener {

	private Button addPlayer;
	private Button startGame;
	private List<String> players;
	private ListView playerList;
	private ArrayAdapter<String> adapter;

	private void init() {
		addPlayer = (Button) findViewById(R.id.button_add_player);
		startGame = (Button) findViewById(R.id.button_start_game);
		players = new ArrayList<String>();
		playerList = (ListView) findViewById(R.id.list);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				players);
		playerList.setAdapter(adapter);
		addPlayer.setOnClickListener(this);
		startGame.setOnClickListener(this);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_up);
		init();
	}

	@Override
	public void onClick(View v) {

		if (v.getId() == addPlayer.getId()) {
			Intent i = new Intent(this, AddPlayer.class);
			startActivityForResult(i, 1);
		} else {
			Intent i = new Intent(this , NightPhase.class);
		    String[] p = new String[players.size()];
			players.toArray(p);
			i.putExtra("players" , p);
			startActivity(i);
			finish();
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1) {
			if (resultCode == RESULT_OK) {
				players.add(data.getStringExtra("player"));
				adapter.notifyDataSetChanged();
			}
		}
	}

}
