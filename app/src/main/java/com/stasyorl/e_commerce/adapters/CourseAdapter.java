package com.stasyorl.e_commerce.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stasyorl.e_commerce.R;
import com.stasyorl.e_commerce.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context;
    List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }
//создание дизайна
    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItems = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new CourseAdapter.CourseViewHolder(courseItems);
    }
 //подставление значений
    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.courseBg.setBackgroundColor(Color.parseColor(courses.get(position).getColor()));
        //нахождение и вставка картинки
        int imageId=context.getResources().getIdentifier("ic_"+courses.get(position).getImg(), "drawable", context.getPackageName());
        holder.courseImage.setImageResource(imageId);

        holder.courseTitle.setText((courses.get(position).getTitle()));
        holder.courseDate.setText((courses.get(position).getDate()));
        holder.courseLevel.setText((courses.get(position).getLevel()));

    }
//длина списка
    @Override
    public int getItemCount() {
        return courses.size();
    }
//присвоение значений вьюшкам
    public static final class CourseViewHolder extends RecyclerView.ViewHolder{

        LinearLayout courseBg;
        ImageView courseImage;
        TextView courseTitle, courseDate, courseLevel;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            courseBg = itemView.findViewById(R.id.courseBg);
            courseImage = itemView.findViewById(R.id.courseImage);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            courseDate = itemView.findViewById(R.id.courseDate);
            courseLevel = itemView.findViewById(R.id.courseLevel);



        }
    }
}
