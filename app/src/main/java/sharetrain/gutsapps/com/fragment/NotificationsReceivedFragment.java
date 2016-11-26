package sharetrain.gutsapps.com.fragment;

/**
 * Created by Alejandro Gutierrez on 15/11/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import sharetrain.gutsapps.com.activity.R;

public class NotificationsReceivedFragment extends Fragment implements
        View.OnClickListener {

    private View notificationsReceivedFragment;
    private ListView listNotificationsReceived;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        notificationsReceivedFragment = inflater.inflate(R.layout.fragment_notifications_received, container, false);


        return notificationsReceivedFragment;
    }

    @Override
    public void onClick(View v) {

    }
}
