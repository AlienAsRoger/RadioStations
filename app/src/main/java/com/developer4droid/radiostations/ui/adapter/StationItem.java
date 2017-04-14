package com.developer4droid.radiostations.ui.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.developer4droid.radiostations.R;
import com.developer4droid.radiostations.databinding.StationRowViewBinding;
import com.developer4droid.radiostations.model.Station;
import com.developer4droid.radiostations.ui.interfaces.ImageLoader;
import com.developer4droid.radiostations.viewmodel.StationViewModel;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractSectionableItem;
import eu.davidea.viewholders.FlexibleViewHolder;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 18:48
 */

public class StationItem extends AbstractSectionableItem<StationItem.StationViewHolder, HeaderItem> {

	private Station station;

	public StationItem(Station station, HeaderItem headerItem) {
		super(headerItem);
		this.station = station;
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

	@Override
	public int getLayoutRes() {
		return R.layout.station_row_view;
	}

	@Override
	public StationViewHolder createViewHolder(FlexibleAdapter adapter, LayoutInflater inflater, ViewGroup parent) {
		View itemView = inflater.inflate(getLayoutRes(), parent, false);
		StationViewModel viewModel = new StationViewModel();
		StationRowViewBinding binding = StationRowViewBinding.bind(itemView);
		binding.setStation(viewModel);

		return new StationViewHolder(itemView, adapter, binding, viewModel);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void bindViewHolder(FlexibleAdapter adapter, StationViewHolder holder, int position, List payloads) {
		holder.setItem(station);
	}

	public static class StationViewHolder extends FlexibleViewHolder implements ImageLoader {

		private final StationRowViewBinding binding;
		private final StationViewModel viewModel;

		public StationViewHolder(View view, FlexibleAdapter adapter, StationRowViewBinding binding, StationViewModel viewModel) {
			super(view, adapter);
			this.binding = binding;
			this.viewModel = viewModel;
		}

		public void setItem(Station station) {
			viewModel.setModel(station, this);
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
