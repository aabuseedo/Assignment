//package com.example.assignment;
//
//import android.os.Bundle;
//
//import androidx.activity.EdgeToEdge;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentActivity;
//import androidx.viewpager2.adapter.FragmentStateAdapter;
//import androidx.viewpager2.widget.ViewPager2;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.google.android.material.tabs.TabLayout;
//import com.google.android.material.tabs.TabLayoutMediator;
//
/////**
//// * A simple {@link Fragment} subclass.
//// * Use the {@link NewsFragment#newInstance} factory method to
//// * create an instance of this fragment.
//// */
//public class NewsFragment extends Fragment { //AppCompatActivity
//
//    //-------------------------------------------------------------
//
//    //TODO اولا: تعريف العناصر في الواجهاة الرئيسية   و انشاء ادابتر
//    private TabLayout tl_newsFragment;
//    private ViewPager2 vp__newsFragment;
//
//    ViewPagerFragmentAdapter adabter;
//
//    //--------------------------------------------------------------
//
//    //TODO ثانيا: عمل النصوص او العناون التي سيتم وضعها في  التاب لي اوت
//    private final String[] labels = new String[]{"TAB 1", "TAB 2", "TAB 3"};
//
//    //--------------------------------------------------------------
//
////    // TODO: Rename parameter arguments, choose names that match
////    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
////    private static final String ARG_PARAM1 = "param1";
////    private static final String ARG_PARAM2 = "param2";
////
////    // TODO: Rename and change types of parameters
////    private String mParam1;
////    private String mParam2;
////
////    public NewsFragment() {
////        // Required empty public constructor
////    }
////
////    /**
////     * Use this factory method to create a new instance of
////     * this fragment using the provided parameters.
////     *
////     * @param param1 Parameter 1.
////     * @param param2 Parameter 2.
////     * @return A new instance of fragment NewsFragment.
////     */
////    // TODO: Rename and change types and number of parameters
////    public static NewsFragment newInstance(String param1, String param2) {
////        NewsFragment fragment = new NewsFragment();
////        Bundle args = new Bundle();
////        args.putString(ARG_PARAM1, param1);
////        args.putString(ARG_PARAM2, param2);
////        fragment.setArguments(args);
////        return fragment;
////    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//
//        //TODO سادسا: بدي اعرف المثود الي عملتها هان
//        init();
//
//        //TODO ثالثا: بدي اربط المصفوفة الي عملتها للعناوين ب التاب لي اوت
//        new TabLayoutMediator(tl_newsFragment, vp__newsFragment, (tab, position) -> {
//            tab.setText(labels[position]);
//        }).attach();
//
//        //TODO رابعا: بدي اعين اي عنوان تظهر الواجهة تبعته اول اشي اي بشكل افتراضي /ملاحظة ترتيب العناوين من اليسار
//        vp__newsFragment.setCurrentItem(0, false);
//
//    }
//    //TODO خامسا: انشاء مثود لربط الاكس ام ال مع الجافا
//
//    private void init() {
//        tl_newsFragment = findViewById(R.id.tl_newsFragment);
//        vp__newsFragment = findViewById(R.id.vp__newsFragment);
//        adabter = new ViewPagerFragmentAdapter(this);
//        vp__newsFragment.setAdapter(adabter);
//
//        getSupportActionBar().setElevation(0);
//    }
//    //TODO اولا  وسادسا : انشاء كلاس الادابتر لربط الفراجمنت مع التاب لي اوت و الفيو بجر
//    private class ViewPagerFragmentAdapter extends FragmentStateAdapter {
//
//        public ViewPagerFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
//            super(fragmentActivity);
//        }
//
//        @NonNull
//        @Override
//        public Fragment createFragment(int position) {
//            switch (position) {
//                case 0:
//                    return new Tab_1_Fragment();
//                case 1:
//                    return new Tab_2_Fragment();
//                case 2:
//                    return new Tab_3_Fragment();
//
//            }
//            return new Tab_1_Fragment();
//        }
//
//        @Override
//        public int getItemCount() {
//            return labels.length;
//        }
//    }
////
////    @Override
////    public View onCreateView(LayoutInflater inflater, ViewGroup container,
////                             Bundle savedInstanceState) {
////        // Inflate the layout for this fragment
////        return inflater.inflate(R.layout.fragment_news, container, false);
////    }
//
//}
package com.example.assignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class NewsFragment extends Fragment {

    private TabLayout tl_newsFragment;
    private ViewPager2 vp_newsFragment;
    private ViewPagerFragmentAdapter adapter;

    private final String[] labels = new String[]{"TAB 1", "TAB 2", "TAB 3"};

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize views
        tl_newsFragment = view.findViewById(R.id.tl_newsFragment);
        vp_newsFragment = view.findViewById(R.id.vp__newsFragment);

        // Set up ViewPager adapter
        adapter = new ViewPagerFragmentAdapter(requireActivity());
        vp_newsFragment.setAdapter(adapter);

        // Link TabLayout with ViewPager2
        new TabLayoutMediator(tl_newsFragment, vp_newsFragment, (tab, position) -> {
            tab.setText(labels[position]);
        }).attach();

        // Set default tab
        vp_newsFragment.setCurrentItem(0, false);
    }

    private class ViewPagerFragmentAdapter extends FragmentStateAdapter {
        public ViewPagerFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new Tab_1_Fragment();
                case 1:
                    return new Tab_2_Fragment();
                case 2:
                    return new Tab_3_Fragment();
                default:
                    return new Tab_1_Fragment();
            }
        }

        @Override
        public int getItemCount() {
            return labels.length;
        }
    }
}
