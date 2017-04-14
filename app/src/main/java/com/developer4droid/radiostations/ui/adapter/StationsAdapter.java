package com.developer4droid.radiostations.ui.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.developer4droid.radiostations.R;
import com.developer4droid.radiostations.databinding.OutlineRowViewBinding;
import com.developer4droid.radiostations.model.Station;
import com.developer4droid.radiostations.ui.interfaces.ImageLoader;
import com.developer4droid.radiostations.viewmodel.StationViewModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 16:19
 */

public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.StationViewHolder> {

	private List<Station> itemsList;

	public StationsAdapter(List<Station> itemsList) {
		this.itemsList = itemsList;
	}

	@Override
	public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View itemView = inflater.inflate(R.layout.outline_row_view, parent, false);
		StationViewModel viewModel = new StationViewModel();
		OutlineRowViewBinding binding = OutlineRowViewBinding.bind(itemView);
		binding.setOutline(viewModel);

		return new StationViewHolder(itemView, binding, viewModel);
	}

	@Override
	public void onBindViewHolder(StationViewHolder holder, int position) {
		holder.setItem(itemsList.get(position));
	}

	@Override
	public int getItemCount() {
		return itemsList == null ? 0 : itemsList.size();
	}

	public void updateItems(List<Station> itemList) {
		this.itemsList = itemList;
		notifyDataSetChanged();
	}

	public static class StationViewHolder extends OutlineAdapter.OutlineViewHolder implements ImageLoader {

		public StationViewHolder(View itemView, OutlineRowViewBinding binding, StationViewModel viewModel) {
			super(itemView, binding, viewModel);
		}

		public void setItem(Station station) {
			((StationViewModel)viewModel).setModel(station, this);
			binding.executePendingBindings();
		}

		@Override
		public void loadImage(String uri) {
			Glide.with(binding.imageView.getContext())
					.load(Uri.parse(uri))
					.into(binding.imageView);
		}
	}
}
