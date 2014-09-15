package com.example.mafia;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class DayPhaseAdapter extends BaseAdapter implements OnClickListener {
	private Activity activity;
	private ArrayList<Player> players;
	private static LayoutInflater inflater = null;
	private int row_layout;

	public DayPhaseAdapter(Activity a, ArrayList<Player> d, int layout) {
		activity = a;
		players = d;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		row_layout = layout;
	}

	@Override
	public int getCount() {
		return players.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(row_layout, null);
		Player list_item = new Player();
		list_item = players.get(position);
		TextView name = (TextView) vi.findViewById(R.id.villager_name);
		TextView votes = (TextView) vi.findViewById(R.id.number_of_votes);
		ImageButton addVote = (ImageButton) vi.findViewById(R.id.addVote);
		ImageButton subVote = (ImageButton) vi.findViewById(R.id.subVote);
		addVote.setOnClickListener(this);
		addVote.setTag(position);
		subVote.setOnClickListener(this);
		subVote.setTag(position);
		name.setText(list_item.getName());
		votes.setText(list_item.getVotes() + "");
		return vi;
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.addVote) {
			players.get((Integer) v.getTag()).addVote();
		} else {
			players.get((Integer) v.getTag()).subVote();
			if(players.get((Integer)v.getTag()).getVotes() < 0){
				players.get((Integer) v.getTag()).addVote();
			}
		}
		notifyDataSetChanged();
	}
}
