package com.developer4droid.radiostations.ui.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.developer4droid.radiostations.R;
import com.developer4droid.radiostations.databinding.StationRowViewBinding;
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
		View itemView = inflater.inflate(R.layout.station_row_view, parent, false);
		StationViewModel viewModel = new StationViewModel();
		StationRowViewBinding binding = StationRowViewBinding.bind(itemView);
		binding.setStation(viewModel);

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

	static class StationViewHolder extends RecyclerView.ViewHolder implements ImageLoader {

		private StationRowViewBinding binding;
		private StationViewModel viewModel;

		public StationViewHolder(View itemView, StationRowViewBinding binding, StationViewModel viewModel) {
			super(itemView);
			this.binding = binding;
			this.viewModel = viewModel;
		}

		public void setItem(Station Station) {
			viewModel.setModel(Station, this);
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
