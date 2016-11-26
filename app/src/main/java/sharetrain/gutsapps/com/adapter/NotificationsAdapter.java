package sharetrain.gutsapps.com.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import sharetrain.gutsapps.com.fragment.NotificationsReceivedFragment;
import sharetrain.gutsapps.com.fragment.NotificationsSentFragment;

/**
 * Created by Alejandro Gutierrez on 14/11/2016.
 */

public class NotificationsAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public NotificationsAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                NotificationsSentFragment tab1 = new NotificationsSentFragment();
                return tab1;
            case 1:
                NotificationsReceivedFragment tab2 = new NotificationsReceivedFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
