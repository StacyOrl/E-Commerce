package com.stasyorl.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.stasyorl.e_commerce.adapters.CategoryAdapter;
import com.stasyorl.e_commerce.adapters.CourseAdapter;
import com.stasyorl.e_commerce.model.Categorie;
import com.stasyorl.e_commerce.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Categorie> categoryList = new ArrayList<>();
        categoryList.add(new Categorie(1,"Игры"));
        categoryList.add(new Categorie(2,"Сайты"));
        categoryList.add(new Categorie(3,"Языки"));
        categoryList.add(new Categorie(4,"Прочее"));

        setCategoryRecycler(categoryList);

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(1,"java_course", "Профессия Java\nразработчик", "1 января", "начальный", "#424345"));
        courseList.add(new Course(2,"python", "Профессия Python\nразработчик", "19 января", "начальный", "#9FA52D"));


        setCourseRecycler(courseList);
    }

    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Categorie> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }
}