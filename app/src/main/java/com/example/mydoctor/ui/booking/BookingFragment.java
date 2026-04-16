package com.example.mydoctor.ui.booking;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mydoctor.R;
import com.example.mydoctor.database.DatabaseHelper;
import com.example.mydoctor.model.Appointment;
import java.util.ArrayList;
public class BookingFragment extends Fragment {
    RecyclerView recyclerView;
    BookingAdapter adapter;
    ArrayList<Appointment> appointmentList;
    DatabaseHelper dbHelper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_booking, container, false);
        if (getActivity() != null) {
            Window window = getActivity().getWindow();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(android.R.color.white));
            }if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }recyclerView = v.findViewById(R.id.recyclerViewBookings);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dbHelper = new DatabaseHelper(getContext());
        appointmentList = new ArrayList<>();
        Cursor cursor = dbHelper.getAllAppointments();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String datetime = cursor.getString(4);
                String date = "Unknown";
                String time = "00:00";
                if (datetime != null && datetime.contains(" ")) {
                    String[] parts = datetime.split(" ");
                    date = parts[0];
                    time = parts[1];
                } else if (datetime != null) {
                    date = datetime;
                }Appointment a = new Appointment(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        date,
                        time,
                        cursor.getString(5));
                appointmentList.add(a);
            } while (cursor.moveToNext());
        }if (cursor != null) cursor.close();
        adapter = new BookingAdapter(getContext(), appointmentList);
        recyclerView.setAdapter(adapter);
        return v;
    }
}
