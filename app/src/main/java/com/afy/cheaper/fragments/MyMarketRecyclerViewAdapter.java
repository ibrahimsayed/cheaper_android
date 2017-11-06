package com.afy.cheaper.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afy.cheaper.R;
import com.afy.cheaper.fragments.MarketFragment.OnMarketListFragmentInteractionListener;
import com.afy.cheaper.fragments.market.MarketContent.MarketItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link MarketItem} and makes a call to the
 * specified {@link OnMarketListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyMarketRecyclerViewAdapter extends RecyclerView.Adapter<MyMarketRecyclerViewAdapter.MarketViewHolder> {

    private final List<MarketItem> mValues;
    private final OnMarketListFragmentInteractionListener mListener;

    public MyMarketRecyclerViewAdapter(List<MarketItem> items, OnMarketListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public MarketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_market, parent, false);
        return new MarketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MarketViewHolder mHolder, int position) {
        mHolder.mItem = mValues.get(position);
        mHolder.mIdView.setText(mValues.get(position).id);
        mHolder.mContentView.setText(mValues.get(position).content);

        mHolder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(mHolder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class MarketViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public MarketItem mItem;

        public MarketViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
