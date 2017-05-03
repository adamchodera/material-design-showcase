package pl.adamchodera.materialdesignshowcase.dashboard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class DashboardPagerAdapter extends FragmentPagerAdapter {

    public DashboardPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                return DashboardFragment.newInstance(position);
//            case 1:
//                return DashboardFragment.newInstance(position);
//        }

        return DashboardFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Fragment " + position;
    }
}