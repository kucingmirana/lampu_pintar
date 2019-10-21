package id.example.bagasekaa.buttom_nav.fragment;

import android.os.Bundle;
import android.view.View;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import id.example.bagasekaa.buttom_nav.R;
import pl.pawelkleczkowski.customgauge.CustomGauge;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Kelembaban extends Fragment {
    Integer status;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment__kelembaban, container, false);
            final CustomGauge gauge = (CustomGauge) view.findViewById(R.id.gauge2);
        final TextView soil = (TextView) view.findViewById(R.id.status);
        DatabaseReference dref;
        dref= FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status=dataSnapshot.child("SOIL_STATUS").getValue(Integer.class);
                gauge.setValue(status);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return view;
    }
}
