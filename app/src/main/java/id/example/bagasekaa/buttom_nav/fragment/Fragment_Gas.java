package id.example.bagasekaa.buttom_nav.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.pawelkleczkowski.customgauge.CustomGauge;

import java.util.ArrayList;
import java.util.List;
import id.example.bagasekaa.buttom_nav.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Gas extends Fragment {
    Integer status2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__gas, container, false);

        final CustomGauge gauge = (CustomGauge) view.findViewById(R.id.gauge3);
        DatabaseReference dref;
        dref= FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status2=dataSnapshot.child("GAS_STATUS").getValue(Integer.class);
                gauge.setValue(status2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return view;
    }


}
