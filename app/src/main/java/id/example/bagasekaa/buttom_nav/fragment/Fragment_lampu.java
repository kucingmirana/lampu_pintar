package id.example.bagasekaa.buttom_nav.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import id.example.bagasekaa.buttom_nav.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_lampu extends Fragment {
    Integer lampu1;
    Integer lampu2;
    Integer lampu3;
    Integer lampu4;

    public Fragment_lampu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_lampu, container, false);

        final ImageView indikator_kamar_off = (ImageView) view.findViewById(R.id.img_indikator_off);
        final ImageView indikator_kamar_on = (ImageView) view.findViewById(R.id.img_indikator_on);
        final ImageView indikator_tidur_off = (ImageView) view.findViewById(R.id.img_indikator1_off);
        final ImageView indikator_tidur_on = (ImageView) view.findViewById(R.id.img_indikator1_on);
        final ImageView indikator_dapur_off = (ImageView) view.findViewById(R.id.img_indikator2_off);
        final ImageView indikator_dapur_on = (ImageView) view.findViewById(R.id.img_indikator2_on);
        final ImageView indikator_ruang_tamu_off = (ImageView) view.findViewById(R.id.img_indikator3_off);
        final ImageView indikator_ruang_tamu_on = (ImageView) view.findViewById(R.id.img_indikator3_on);

        DatabaseReference dref;
        dref= FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lampu1=dataSnapshot.child("LED_STATUS").getValue(Integer.class);
                lampu2=dataSnapshot.child("LED_STATUS_2").getValue(Integer.class);
                lampu3=dataSnapshot.child("LED_STATUS_3").getValue(Integer.class);
                lampu4=dataSnapshot.child("LED_STATUS_4").getValue(Integer.class);
                if (lampu1==0){
                    indikator_kamar_on.setVisibility(View.VISIBLE);
                    indikator_kamar_off.setVisibility(View.INVISIBLE);
                }
                else {
                    indikator_kamar_off.setVisibility(View.VISIBLE);
                    indikator_kamar_on.setVisibility(View.INVISIBLE);
                }
                if (lampu2==0){
                    indikator_tidur_on.setVisibility(View.VISIBLE);
                    indikator_tidur_off.setVisibility(View.INVISIBLE);
                }
                else {
                    indikator_tidur_off.setVisibility(View.VISIBLE);
                    indikator_tidur_on.setVisibility(View.INVISIBLE);
                }
                if (lampu3==0){
                    indikator_dapur_on.setVisibility(View.VISIBLE);
                    indikator_dapur_off.setVisibility(View.INVISIBLE);
                }
                else {
                    indikator_dapur_off.setVisibility(View.VISIBLE);
                    indikator_dapur_on.setVisibility(View.INVISIBLE);
                }
                if (lampu4==0){
                    indikator_ruang_tamu_on.setVisibility(View.VISIBLE);
                    indikator_ruang_tamu_off.setVisibility(View.INVISIBLE);
                }
                else {
                    indikator_ruang_tamu_off.setVisibility(View.VISIBLE);
                    indikator_ruang_tamu_on.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });



        indikator_kamar_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indikator_kamar_on.setVisibility(View.VISIBLE);
                indikator_kamar_off.setVisibility(View.INVISIBLE);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS");
                myRef.setValue(0);
            }
        });

        indikator_kamar_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS");
                myRef.setValue(1);
                indikator_kamar_off.setVisibility(View.VISIBLE);
                indikator_kamar_on.setVisibility(View.INVISIBLE);
            }
        });

        indikator_tidur_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS_2");
                myRef.setValue(0);
                indikator_tidur_on.setVisibility(View.VISIBLE);
                indikator_tidur_off.setVisibility(View.INVISIBLE);
            }
        });

        indikator_tidur_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS_2");
                myRef.setValue(1);
                indikator_tidur_off.setVisibility(View.VISIBLE);
                indikator_tidur_on.setVisibility(View.INVISIBLE);
            }
        });

        indikator_dapur_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS_3");
                myRef.setValue(0);
                indikator_dapur_on.setVisibility(View.VISIBLE);
                indikator_dapur_off.setVisibility(View.INVISIBLE);
            }
        });

        indikator_dapur_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS_3");
                myRef.setValue(1);
                indikator_dapur_off.setVisibility(View.VISIBLE);
                indikator_dapur_on.setVisibility(View.INVISIBLE);
            }
        });
        indikator_ruang_tamu_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS_4");
                myRef.setValue(0);
                indikator_ruang_tamu_off.setVisibility(View.VISIBLE);
                indikator_ruang_tamu_on.setVisibility(View.INVISIBLE);
            }
        });

        indikator_ruang_tamu_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS_4");
                myRef.setValue(1);
                indikator_ruang_tamu_off.setVisibility(View.VISIBLE);
                indikator_ruang_tamu_on.setVisibility(View.INVISIBLE);
            }
        });

        return view;
    }

}
