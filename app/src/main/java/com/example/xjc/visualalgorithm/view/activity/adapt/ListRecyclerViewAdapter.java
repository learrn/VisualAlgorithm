package com.example.xjc.visualalgorithm.view.activity.adapt;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.xjc.visualalgorithm.R;

import java.util.List;

public class ListRecyclerViewAdapter extends RecyclerView.Adapter<ListRecyclerViewAdapter.ListViewHolder> {

    private Context context;
    private List<String> itemList;
    private LayoutInflater inflater;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public ListRecyclerViewAdapter(Context context, List<String> itemList) {
        this.itemList = itemList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListViewHolder mViewHolder = new ListViewHolder(inflater.inflate(R.layout.list_item_view, parent, false));
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final ListViewHolder holder, int position) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
        }
        holder.sortTitle.setText(String.format("%d: %s", 1 + position, itemList.get(position)));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView sortTitle;

        public ListViewHolder(View itemView) {
            super(itemView);
            sortTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
