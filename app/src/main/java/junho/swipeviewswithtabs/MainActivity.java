package junho.swipeviewswithtabs;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    MainPagerAdapter mMainPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //페이저어댑터생성
        mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        //액션바 가져오기와 설정
        final ActionBar actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        //뷰페이져 위젯에 어댑터 연결+페이지전환리스너 설정
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mMainPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
               getActionBar().setSelectedNavigationItem(position);
            }
        });
        //액션바에 탭붙이기
        actionBar.addTab(
                actionBar.newTab()
                        .setIcon(R.drawable.tab_home)
                                //.setText(mMainPagerAdapter.getPageTitle(i))
                        .setTabListener(this));
        actionBar.addTab(
                actionBar.newTab()
                        .setIcon(R.drawable.tab_box)
                                //.setText(mMainPagerAdapter.getPageTitle(i))
                        .setTabListener(this));
        actionBar.addTab(
                actionBar.newTab()
                        .setIcon(R.drawable.tab_favorite)
                                //.setText(mMainPagerAdapter.getPageTitle(i))
                        .setTabListener(this));
        actionBar.addTab(
                actionBar.newTab()
                        .setIcon(R.drawable.tab_profile)
                                //.setText(mMainPagerAdapter.getPageTitle(i))
                        .setTabListener(this));


    }


    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }
    //탭이 클릭됐을 때 선택될 탭 설정
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    public static class MainPagerAdapter extends FragmentStatePagerAdapter {
        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        //탭이 선택됐을 때 이동할 프래그먼트 선택
        @Override
        public Fragment getItem(int i) {
            //Log.e("Fragment arrange", String.valueOf(i)); it's not increase linearly
            switch (i) {
                case 0:
                    return new HomeSectionFragment();
                case 1:
                    return new BoxSectionFragment();
                case 2:
                    return new FavoriteSectionFragment();
                case 3:
                    return new PersonalSectionFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Section" + (position + 1);
        }
    }


////////////////////////각 프래그먼트 인플래이트 및 선언/////////////////////////////

    public static class HomeSectionFragment extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState){
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);

            /////리스트뷰 만들기 (this 대신에 rootView를 통해 context 획득하였음)
            RecyclerView recyclerView=(RecyclerView)rootView.findViewById(R.id.recyclerview);
            LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(layoutManager);

            List<Home_item> items=new ArrayList<>();
            Home_item[] item=new Home_item[5];
            item[0]=new Home_item(R.drawable.drawer_profile,"This is how we created", R.drawable.mainpage_image, "김길동", "네이버", "2");
            item[1]=new Home_item(R.drawable.drawer_profile,"This is how we created", R.drawable.mainpage_image, "홍길동", "스타트업", "3");
            item[2]=new Home_item(R.drawable.drawer_profile,"This is how we created", R.drawable.mainpage_image, "박길동", "좋은지식", "0");
            item[3]=new Home_item(R.drawable.drawer_profile,"This is how we created", R.drawable.mainpage_image, "최길동", "벤쳐스퀘어", "0");
            item[4]=new Home_item(R.drawable.drawer_profile,"This is how we created", R.drawable.mainpage_image, "동동", "서울시챌린지1000", "23");

            for(int i = 0; i < 5; i++) {
                items.add(item[i]);
            }

            recyclerView.setAdapter(new RecyclerAdapter(rootView.getContext(), items, R.layout.activity_main));

            return rootView;
        }
    }

    public static class BoxSectionFragment extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState){
            View rootView = inflater.inflate(R.layout.fragment_boxpage, container, false);

            return rootView;
        }
    }

    public static class FavoriteSectionFragment extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState){
            View rootView = inflater.inflate(R.layout.fragment_favorite, container, false);

            return rootView;
        }
    }

    public static class PersonalSectionFragment extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState){
            View rootView = inflater.inflate(R.layout.fragment_personalpage, container, false);

            return rootView;
        }
    }
}

