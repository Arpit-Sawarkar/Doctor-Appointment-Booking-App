package adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mydoctor.R;
import com.example.mydoctor.ui.doctor.Doctor;
import com.example.mydoctor.ui.doctor.DoctorDetailActivity;
import java.util.List;
public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {
    Context context;
    List<Doctor> list;
    public DoctorAdapter(Context context, List<Doctor> list) {
        this.context = context;
        this.list = list;
    }@NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_doctor, parent, false);
        return new ViewHolder(view);
    }@Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Doctor doctor = list.get(position);
        holder.tvDoctorName.setText(doctor.name);
        holder.tvDoctorEducation.setText(doctor.qualification);
        holder.imgDoctor.setImageResource(doctor.photoResId);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DoctorDetailActivity.class);
            intent.putExtra("doctor", doctor); // FULL doctor object
            context.startActivity(intent);
        });
    }@Override
    public int getItemCount() {
        return list.size();
    }static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDoctor;
        TextView tvDoctorName, tvDoctorEducation;
        ViewHolder(View itemView) {
            super(itemView);
            imgDoctor = itemView.findViewById(R.id.imgDoctor);
            tvDoctorName = itemView.findViewById(R.id.tvDoctorName);
            tvDoctorEducation = itemView.findViewById(R.id.tvDoctorEducation);
        }
    }
}