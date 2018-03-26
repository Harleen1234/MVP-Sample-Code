package com.mvpsamplecode.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.mvpsamplecode.R;
import com.mvpsamplecode.model.Country;

import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.MyViewHolder> {

    private Context mContext;
    private List<Country> mCountryList;

    public CountriesAdapter(Context context, List<Country> mCountryList) {
        this.mContext = context;
        this.mCountryList = mCountryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_country_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.mCountryName.setText(mCountryList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mCountryList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mCountryName;

        public MyViewHolder(View view) {
            super(view);
            mCountryName = (TextView) view.findViewById(R.id.country_name);
        }
    }
}