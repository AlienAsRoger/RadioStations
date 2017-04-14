package com.developer4droid.radiostations.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.developer4droid.radiostations.R;
import com.developer4droid.radiostations.databinding.OutlineRowViewBinding;
import com.developer4droid.radiostations.model.Outline;
import com.developer4droid.radiostations.viewmodel.OutlineViewModel;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractHeaderItem;
import eu.davidea.viewholders.FlexibleViewHolder;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 18:53
 */

public class HeaderItem extends AbstractHeaderItem<HeaderItem.HeaderViewHolder> {

	private Outline item;

	public HeaderItem(Outline item) {
		this.item = item;
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

	@Override
	public int getLayoutRes() {
		return R.layout.outline_row_view;
	}

	@Override
	public HeaderViewHolder createViewHolder(FlexibleAdapter adapter, LayoutInflater inflater, ViewGroup parent) {
		View itemView = inflater.inflate(getLayoutRes(), parent, false);
		OutlineViewModel viewModel = new OutlineViewModel();
		OutlineRowViewBinding binding = OutlineRowViewBinding.bind(itemView);
		binding.setOutline(viewModel);

		return new HeaderViewHolder(itemView,adapter, binding, viewModel);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void bindViewHolder(FlexibleAdapter adapter, HeaderViewHolder holder, int position, List payloads) {
		holder.setItem(item);
	}

	public static class HeaderViewHolder extends FlexibleViewHolder {

		protected OutlineRowViewBinding binding;
		protected OutlineViewModel viewModel;

		public HeaderViewHolder(View view, FlexibleAdapter adapter, OutlineRowViewBinding binding, OutlineViewModel viewModel) {
			super(view, adapter);
			this.binding = binding;
			this.viewModel = viewModel;
		}

		public void setItem(Outline station) {
			viewModel.setModel(station);
			binding.executePendingBindings();
		}
	}
}
