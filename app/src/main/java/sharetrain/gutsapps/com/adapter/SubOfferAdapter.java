package sharetrain.gutsapps.com.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import sharetrain.gutsapps.com.fragment.OfferTableFragment;
import sharetrain.gutsapps.com.fragment.OfferTicketFragment;

/**
 * Created by Alejandro Gutierrez on 14/11/2016.
 */

public class SubOfferAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public SubOfferAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                OfferTicketFragment tab1 = new OfferTicketFragment();
                return tab1;
            case 1:
                OfferTableFragment tab2 = new OfferTableFragment();
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
