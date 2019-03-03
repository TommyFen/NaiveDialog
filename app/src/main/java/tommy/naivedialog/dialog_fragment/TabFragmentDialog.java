package tommy.naivedialog.dialog_fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import tommy.naivedialog.R;
import tommy.naivedialog.dialog_fragment.tab_dialog.MyFragmentPagerAdapter;

/**
 * @author : TommyFen
 * @e-mail : tommyfenv@163.com
 * @date : 2018/6/14
 */
public class TabFragmentDialog extends DialogFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);


        View view = inflater.inflate(R.layout.dialog_tab, container);
        viewPager = view.findViewById(R.id.vp_pager);
        tabLayout = view.findViewById(R.id.tabs);
        // getChildFragmentManager()
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
            }

            @Override
            public void onPageSelected(int i) {
//                mTabHost.setCurrentTab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int i = tab.getPosition();
                viewPager.setCurrentItem(i, false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    public void show(FragmentManager manager) {
        show(manager, "tab_dialog");
    }

}


