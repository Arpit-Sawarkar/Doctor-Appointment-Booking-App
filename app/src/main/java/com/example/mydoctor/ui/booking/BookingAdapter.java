package com.example.mydoctor.ui.booking;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mydoctor.R;
import com.example.mydoctor.model.Appointment;
import java.util.ArrayList;
public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {
    Context context;
    ArrayList<Appointment> list;
    public BookingAdapter(Context context, ArrayList<Appointment> list) {
        this.context = context;
        this.list = list;
    }@NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_booking, parent, false);
        return new ViewHolder(v);
    }@Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Appointment a = list.get(position);
        holder.tvDoctor.setText("Doctor: " + a.getDoctorName());
        holder.tvPatient.setText("Patient: " + a.getPatientName());
        holder.tvPhone.setText("Phone: " + a.getPhone());
        holder.tvDate.setText("Date: " + a.getDate());
        holder.tvTime.setText("Time: " + a.getTime());
        holder.tvDisease.setText("Disease: " + a.getDisease());
    }@Override
    public int getItemCount() {
        return list.size();
    }public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDoctor, tvPatient, tvPhone, tvDate, tvTime, tvDisease;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDoctor = itemView.findViewById(R.id.tvDoctor);
            tvPatient = itemView.findViewById(R.id.tvPatient);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvDisease = itemView.findViewById(R.id.tvDisease);
        }
    }
}
