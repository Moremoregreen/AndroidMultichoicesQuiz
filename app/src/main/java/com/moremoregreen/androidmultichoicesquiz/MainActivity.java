package com.moremoregreen.androidmultichoicesquiz;

import android.icu.text.DisplayContext;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;

import com.moremoregreen.androidmultichoicesquiz.Adapter.CategoryAdapter;
import com.moremoregreen.androidmultichoicesquiz.DBHelper.DBHelper;
import com.moremoregreen.androidmultichoicesquiz.Model.Category;
import com.moremoregreen.androidmultichoicesquiz.common.SpaceDecoration;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recycelr_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("MMG Quiz 2019");
        setSupportActionBar(toolbar);
        recycelr_category = findViewById(R.id.recycler_category);
        recycelr_category.setHasFixedSize(true);
        recycelr_category.setLayoutManager(new GridLayoutManager(this,2));

        //Get Screen height
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int height = displayMetrics.heightPixels / 8; //Max size of item in Category
        CategoryAdapter adapter = new CategoryAdapter(MainActivity.this,DBHelper.getInstance(this).getAllCategories());
        int spaceInPixel = 4;
        recycelr_category.addItemDecoration(new SpaceDecoration(spaceInPixel));
        recycelr_category.setAdapter(adapter);

    }
}
