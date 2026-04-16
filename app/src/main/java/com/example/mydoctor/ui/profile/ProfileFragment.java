package com.example.mydoctor.ui.profile;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.mydoctor.R;
import com.example.mydoctor.database.DatabaseHelper;
import com.example.mydoctor.ui.auth.LoginActivity;
import com.example.mydoctor.ui.auth.SignupActivity;
public class ProfileFragment extends Fragment {
    private LinearLayout layoutLoggedIn, layoutLoggedOut;
    private TextView tvName, tvMobile, tvEmail, tvAge, tvGender, tvCity;
    private ImageView imgProfile;
    private Button btnLogout, btnLogin, btnSignup;
    private DatabaseHelper dbHelper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        if (getActivity() != null) {
            Window window = getActivity().getWindow();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(android.R.color.white));
            }if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }}
        layoutLoggedIn = view.findViewById(R.id.layoutLoggedIn);
        layoutLoggedOut = view.findViewById(R.id.layoutLoggedOut);
        tvName = view.findViewById(R.id.tvName);
        tvMobile = view.findViewById(R.id.tvMobile);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvAge = view.findViewById(R.id.tvAge);
        tvGender = view.findViewById(R.id.tvGender);
        tvCity = view.findViewById(R.id.tvCity);
        imgProfile = view.findViewById(R.id.imgProfile);
        btnLogout = view.findViewById(R.id.btnLogout);
        btnLogin = view.findViewById(R.id.btnLogin);
        btnSignup = view.findViewById(R.id.btnSignup);
        dbHelper = new DatabaseHelper(requireContext());
        btnLogin.setOnClickListener(v ->
                startActivity(new Intent(getContext(), LoginActivity.class)));
        btnSignup.setOnClickListener(v ->
                startActivity(new Intent(getContext(), SignupActivity.class)));
        btnLogout.setOnClickListener(v -> {
            SharedPreferences sp = requireContext()
                    .getSharedPreferences("auth", Context.MODE_PRIVATE);
            sp.edit().clear().apply();
            requireActivity().recreate(); // refresh fragment
        });
        return view;
    }@Override
    public void onResume() {
        super.onResume();
        SharedPreferences sp = requireContext()
                .getSharedPreferences("auth", Context.MODE_PRIVATE);
        boolean isLogin = sp.getBoolean("logged_in", false);
        if(isLogin){
            layoutLoggedIn.setVisibility(View.VISIBLE);
            layoutLoggedOut.setVisibility(View.GONE);
            String mobile = sp.getString("mobile","");
            if(!mobile.isEmpty()){
                Cursor c = dbHelper.getUserByMobile(mobile);
                if(c!=null && c.moveToFirst()){
                    tvName.setText("Name: "+c.getString(c.getColumnIndexOrThrow("name")));
                    tvMobile.setText("Mobile: "+c.getString(c.getColumnIndexOrThrow("mobile")));
                    tvEmail.setText("Email: "+c.getString(c.getColumnIndexOrThrow("email")));
                    tvAge.setText("Age: "+c.getInt(c.getColumnIndexOrThrow("age")));
                    tvGender.setText("Gender: "+c.getString(c.getColumnIndexOrThrow("gender")));
                    tvCity.setText("City: "+c.getString(c.getColumnIndexOrThrow("city")));
                }if(c!=null) c.close();
            }
        } else{
            layoutLoggedIn.setVisibility(View.GONE);
            layoutLoggedOut.setVisibility(View.VISIBLE);
        }}}