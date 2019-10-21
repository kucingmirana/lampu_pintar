package id.example.bagasekaa.buttom_nav;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import id.example.bagasekaa.buttom_nav.fragment.Fragment_Gas;
import id.example.bagasekaa.buttom_nav.fragment.Fragment_Home;
import id.example.bagasekaa.buttom_nav.fragment.Fragment_Kelembaban;
import id.example.bagasekaa.buttom_nav.fragment.Fragment_lampu;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    MenuItem prevMenuItem;
    Fragment_Home fragmenthome;
    Fragment_Gas fragmentgas;
    Fragment_Kelembaban fragmentkelembaban;
    Fragment_lampu fragmentlampu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.navigation_lampu:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.navigation_kelembaban:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.navigation_gas:
                        viewPager.setCurrentItem(3);
                        break;
                }

                return false;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: " + position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        fragmenthome = new Fragment_Home();
        fragmentlampu = new Fragment_lampu();
        fragmentgas = new Fragment_Gas();
        fragmentkelembaban = new Fragment_Kelembaban();
        viewPagerAdapter.addFragment(fragmenthome);
        viewPagerAdapter.addFragment(fragmentlampu);
        viewPagerAdapter.addFragment(fragmentkelembaban);
        viewPagerAdapter.addFragment(fragmentgas);
        viewPager.setAdapter(viewPagerAdapter);
    }

}
