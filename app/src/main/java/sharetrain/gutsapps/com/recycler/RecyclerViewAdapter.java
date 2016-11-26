package sharetrain.gutsapps.com.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sharetrain.gutsapps.com.activity.R;
import sharetrain.gutsapps.com.constants.ParamsConstants;
import sharetrain.gutsapps.com.data.Data;

/**
 * Created by Alejandro Gutierrez on 12/11/2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final OnItemClickListener listener;
    private List<Data> dataList = new ArrayList<Data>();
    private Context context;
    private String codeView;
    public RecyclerViewAdapter(List<Data> dataList, Context context, OnItemClickListener listener, String codeView) {
        this.dataList = dataList;
        this.context = context;
        this.listener = listener;
        this.codeView = codeView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        if (ParamsConstants.CODE_ACTIVITY_LIST_TABLE.equals(codeView)) {
            //Inflate the layout, initialize the View Holder
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_table_layout, parent, false);
        } else if (ParamsConstants.CODE_ACTIVITY_LIST_TICKET.equals(codeView)) {
            //Inflate the layout, initialize the View Holder
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ticket_layout, parent, false);
        }
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.getEtExit().setText(dataList.get(position).getExit());
        holder.getEtArrival().setText(dataList.get(position).getArrival());
        holder.getEtPrice().setText(dataList.get(position).getPrice());
        holder.getEtSeller().setText(dataList.get(position).getSeller());
        holder.getEtTrain().setText(dataList.get(position).getTrain());
        //animate(holder);
        holder.bind(dataList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return dataList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Data data) {
        dataList.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Data data) {
        int position = dataList.indexOf(data);
        dataList.remove(position);
        notifyItemRemoved(position);
    }

    public interface OnItemClickListener {
        void onItemClick(Data item);
    }

}
