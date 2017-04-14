package com.developer4droid.radiostations.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roger developer4droid@gmail.com
 * Date: 13.04.2017
 * Time: 18:46
 */

public class SectionedAdapter extends FlexibleAdapter<AbstractFlexibleItem> {

	public SectionedAdapter(@Nullable List<AbstractFlexibleItem> items) {
		super(items);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return super.onCreateViewHolder(parent, viewType);
	}
}
