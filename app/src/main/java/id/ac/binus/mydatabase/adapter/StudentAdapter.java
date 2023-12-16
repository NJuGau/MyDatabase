package id.ac.binus.mydatabase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

import id.ac.binus.mydatabase.R;
import id.ac.binus.mydatabase.model.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    Context context;
    Vector<Student> studentList;

    public StudentAdapter(Context context, Vector<Student> studentList){
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.student_adapter, parent, false);
        return new StudentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.nameTxt.setText(student.getName());
        holder.emailTxt.setText(student.getEmail());
        holder.phoneTxt.setText(student.getPhone());
        holder.nimTxt.setText(student.getNim());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
