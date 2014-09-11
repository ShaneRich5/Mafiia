package com.example.mafia;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class DayPhase extends ListActivity implements OnClickListener {

	private DayPhaseAdapter adapter;
	private ArrayList<Player> p;
	private Button nightPhase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day_phase);
		String[] players = getIntent().getStringArrayExtra("players");
		p = new ArrayList<Player>();
		for (String play : players) {
			p.add(new Player(play));
		}
		adapter = new DayPhaseAdapter(this, p, R.layout.villager_list_row);
		setListAdapter(adapter);
		nightPhase = (Button) findViewById(R.id.button_start_night_phase);
		nightPhase.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int max = 0;
		for (Player player : p) {
			if (player.getVotes() > max) {
				max = player.getVotes();
			}

		}
		ArrayList<Player> maxPlayers = new ArrayList<Player>();
		for (Player player : p) {
			if (player.getVotes() == max) {
				maxPlayers.add(player);
			}
		}
		if (maxPlayers.size() > 1) {
			String MaxPlayerNames = "";
			for (Player p : maxPlayers) {
				MaxPlayerNames += (p.getName() + ",");
			}
			StringBuilder m = new StringBuilder(MaxPlayerNames);
			m.setCharAt(m.length() - 1, '.');
			Toast.makeText(getApplicationContext(), "Must break tie: " + m,
					Toast.LENGTH_LONG).show();
		} else {
			for (int i = 0; i < p.size(); i++) {
				if (p.get(i) == maxPlayers.get(0)) {
					p.remove(i);
					break;
				}
			}
			Intent i = new Intent(this, NightPhase.class);
			String[] names = new String[p.size()];
			for (int index = 0; index < p.size(); index++) {
				names[index] = p.get(index).getName();
			}
			i.putExtra("players", names);
			startActivity(i);
			finish();
		}

	}

}
