package sharetrain.gutsapps.com.recycler;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import sharetrain.gutsapps.com.activity.R;
import sharetrain.gutsapps.com.data.Data;

/**
 * Created by Alejandro Gutierrez on 12/11/2016.
 */

public class ViewHolderTable extends RecyclerView.ViewHolder {

    private CardView cv;
    private TextView etExitTable;
    private TextView etArrivalTable;
    private TextView etTrainTable;
    private TextView etSellerTable;

    public ViewHolderTable(View itemView) {
        super(itemView);
        setCv((CardView) itemView.findViewById(R.id.cardViewTable));
        setEtExit((TextView) itemView.findViewById(R.id.etExitTable));
        setEtArrival((TextView) itemView.findViewById(R.id.etArrivalTable));
        setEtTrain((TextView) itemView.findViewById(R.id.etTrainTable));
        setEtSeller((TextView) itemView.findViewById(R.id.etSellerTable));
    }

    public void bind(final Data item, final RecyclerViewAdapterTable.OnItemClickListenerTable listener) {
        etExitTable.setText(item.getExit());
        etArrivalTable.setText(item.getArrival());
        etTrainTable.setText(item.getTrain());
        etSellerTable.setText(item.getSeller());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(item);
            }
        });
    }


    public CardView getCv() {
        return cv;
    }

    public void setCv(CardView cv) {
        this.cv = cv;
    }

    public TextView getEtExit() {
        return etExitTable;
    }

    public void setEtExit(TextView etExit) {
        this.etExitTable = etExit;
    }

    public TextView getEtArrival() {
        return etArrivalTable;
    }

    public void setEtArrival(TextView etArrival) {
        this.etArrivalTable = etArrival;
    }

    public TextView getEtTrain() {
        return etTrainTable;
    }

    public void setEtTrain(TextView etTrain) {
        this.etTrainTable = etTrain;
    }

    public TextView getEtSeller() {
        return etSellerTable;
    }

    public void setEtSeller(TextView etSeller) {
        this.etSellerTable = etSeller;
    }
}