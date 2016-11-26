package sharetrain.gutsapps.com.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sharetrain.gutsapps.com.activity.R;
import sharetrain.gutsapps.com.adapter.NotificationsListAdapter;
import sharetrain.gutsapps.com.data.NotificationData;

/**
 * Created by Alejandro Gutierrez on 15/11/2016.
 */

public class NotificationsSentFragment extends Fragment {

    private View notificationsSentFragment;
    private ListView listNotificationsSent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        notificationsSentFragment = inflater.inflate(R.layout.fragment_notifications_sent, container, false);

        listNotificationsSent = (ListView) notificationsSentFragment.findViewById(R.id.listNotificationsSent);

        List<NotificationData> data = new ArrayList<NotificationData>();
        data.add(new NotificationData("Madrid", "Valencia", new Date(), "Mario"));
        data.add(new NotificationData("Barcelona", "Valencia", new Date(), "Rosa"));
        data.add(new NotificationData("Lugo", "Las Palmas", new Date(), "Ana"));
        data.add(new NotificationData("Alicante", "Castellon", new Date(), "Calisto"));

        NotificationsListAdapter adapter = new NotificationsListAdapter(this.getContext(),
                android.R.layout.simple_list_item_1, data);
        // Assign adapter to ListView
        listNotificationsSent.setAdapter(adapter);
        // ListView Item Click Listener
        listNotificationsSent.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item index
                int itemPosition = position;
                // ListView Clicked item value
                NotificationData itemValue = (NotificationData) listNotificationsSent.getItemAtPosition(position);
                // Show Alert
                Toast.makeText(listNotificationsSent.getContext().getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue.toString(), Toast.LENGTH_LONG)
                        .show();
            }
        });
        return notificationsSentFragment;
    }
}
