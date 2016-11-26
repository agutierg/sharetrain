package sharetrain.gutsapps.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import sharetrain.gutsapps.com.activity.R;
import sharetrain.gutsapps.com.data.NotificationData;

/**
 * Created by Alejandro Gutierrez on 24/11/2016.
 */

public class NotificationsListAdapter extends ArrayAdapter<NotificationData> {

    public NotificationsListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public NotificationsListAdapter(Context context, int resource, List<NotificationData> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.row_notifications_list, null);
        }

        NotificationData p = getItem(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.tvFromNotListValue);
            TextView tt2 = (TextView) v.findViewById(R.id.tvToNotListValue);
            TextView tt3 = (TextView) v.findViewById(R.id.tvUserNotListValue);
            TextView tt4 = (TextView) v.findViewById(R.id.tvDateNotListValue);

            if (tt1 != null) {
                tt1.setText(p.getFrom());
            }

            if (tt2 != null) {
                tt2.setText(p.getTo());
            }

            if (tt3 != null) {
                tt3.setText(p.getUser());
            }

            if (tt4 != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
                String date = sdf.format(p.getDateOfSubmit());
                tt4.setText(date);
            }
        }

        return v;
    }

}
