package com.example.mafia;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class NightPhase extends Activity implements OnItemClickListener,
		OnClickListener {

	private ListView playerList;
	private Button doctorSave;
	private ArrayAdapter adapter;
	private ArrayList<String> names;

	private void init() {
		names = new ArrayList<String>();
		playerList = (ListView) findViewById(R.id.list);
		doctorSave = (Button) findViewById(R.id.doctor_save);
		playerList.setOnItemClickListener(this);
		doctorSave.setOnClickListener(this);
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.night_phase);
		init();
		String[] players = this.getIntent().getStringArrayExtra("players");
		for (String name : players) {
			names.add(name);
		}
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, names);
		playerList.setAdapter(adapter);
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View v, int position,
			long arg3) {
		names.remove(position);
		Intent i = new Intent(this , DayPhase.class);
		i.putExtra("players", names.toArray(new String[names.size()]));
		startActivity(i);
		finish();
	}

	@Override
	public void onClick(View v) {
		Intent i = new Intent(this , DayPhase.class);
		i.putExtra("players", names.toArray(new String[names.size()]));
		startActivity(i);
		finish();
	}

}
