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

public class ViewHolder extends RecyclerView.ViewHolder {

    private CardView cv;
    private TextView etExit;
    private TextView etArrival;
    private TextView etTrain;
    private TextView etSeller;
    private TextView etPrice;

    public ViewHolder(View itemView) {
        super(itemView);
        setCv((CardView) itemView.findViewById(R.id.cardView));
        setEtExit((TextView) itemView.findViewById(R.id.etExit));
        setEtArrival((TextView) itemView.findViewById(R.id.etArrival));
        setEtTrain((TextView) itemView.findViewById(R.id.etTrain));
        setEtSeller((TextView) itemView.findViewById(R.id.etSeller));
        setEtPrice((TextView) itemView.findViewById(R.id.etPrice));
    }

    public void bind(final Data item, final RecyclerViewAdapter.OnItemClickListener listener) {
        etExit.setText(item.getExit());
        etArrival.setText(item.getArrival());
        etTrain.setText(item.getTrain());
        etSeller.setText(item.getSeller());
        etPrice.setText(item.getPrice());
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
        return etExit;
    }

    public void setEtExit(TextView etExit) {
        this.etExit = etExit;
    }

    public TextView getEtArrival() {
        return etArrival;
    }

    public void setEtArrival(TextView etArrival) {
        this.etArrival = etArrival;
    }

    public TextView getEtTrain() {
        return etTrain;
    }

    public void setEtTrain(TextView etTrain) {
        this.etTrain = etTrain;
    }

    public TextView getEtSeller() {
        return etSeller;
    }

    public void setEtSeller(TextView etSeller) {
        this.etSeller = etSeller;
    }

    public TextView getEtPrice() {
        return etPrice;
    }

    public void setEtPrice(TextView etPrice) {
        this.etPrice = etPrice;
    }
}