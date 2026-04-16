package com.example.mydoctor.ui.home;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.mydoctor.R;
import com.example.mydoctor.ui.doctor.DoctorListActivity;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
public class HomeFragment extends Fragment {
    AutoCompleteTextView atvSpecialty;
    ImageView imgDentist, imgEye, imgGynaecologist, imgGeneral,
            imgENT, imgCardiologist, imgDermatologist, imgOrthopadic;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        if (getActivity() != null) {
            Window window = getActivity().getWindow();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(
                        getResources().getColor(R.color.blue));
            }if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.getDecorView().setSystemUiVisibility(0);
            }}
        atvSpecialty = view.findViewById(R.id.atvSpecialty);
        imgDentist = view.findViewById(R.id.dentist);
        imgEye = view.findViewById(R.id.eye);
        imgGynaecologist = view.findViewById(R.id.gynaecologist);
        imgGeneral = view.findViewById(R.id.imgGeneral);
        imgENT = view.findViewById(R.id.imgENT);
        imgCardiologist = view.findViewById(R.id.imgCardiologist);
        imgDermatologist = view.findViewById(R.id.imgDermatologist);
        imgOrthopadic = view.findViewById(R.id.imgOrthopadic);
        ArrayList<String> specialties = new ArrayList<>();
        specialties.add("Dentist");
        specialties.add("Eye Surgeon");
        specialties.add("Gynaecologist");
        specialties.add("General Physician");
        specialties.add("ENT");
        specialties.add("Cardiologist");
        specialties.add("Dermatologist");
        specialties.add("Orthopedaic");
        Set<String> set = new LinkedHashSet<>(specialties);
        specialties.clear();
        specialties.addAll(set);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                specialties
        );
        atvSpecialty.setAdapter(adapter);
        atvSpecialty.setThreshold(1);
        atvSpecialty.setOnEditorActionListener((v, actionId, event) -> {
            String text = atvSpecialty.getText().toString().trim();
            if (!text.isEmpty()) {
                openDoctorList(text);
                return true;
            }return false;
        });
        imgDentist.setOnClickListener(v -> openDoctorList("Dentist"));
        imgEye.setOnClickListener(v -> openDoctorList("Eye Surgeon"));
        imgGynaecologist.setOnClickListener(v -> openDoctorList("Gynaecologist"));
        imgGeneral.setOnClickListener(v -> openDoctorList("General Physician"));
        imgENT.setOnClickListener(v -> openDoctorList("ENT"));
        imgCardiologist.setOnClickListener(v -> openDoctorList("Cardiologist"));
        imgDermatologist.setOnClickListener(v -> openDoctorList("Dermatologist"));
        imgOrthopadic.setOnClickListener(v -> openDoctorList("Orthopedaic"));
        return view;
    }private void openDoctorList(String specialty) {
        Intent intent = new Intent(getActivity(), DoctorListActivity.class);
        intent.putExtra("specialty", specialty);
        startActivity(intent);
    }}
