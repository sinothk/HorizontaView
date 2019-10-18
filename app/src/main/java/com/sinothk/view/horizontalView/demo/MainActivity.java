package com.sinothk.view.horizontalView.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sinothk.view.horizontalView.HorizontalView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HorizontalView<String> horizontalView = findViewById(R.id.horizontalView);
        ArrayList<String> data = new ArrayList<>();
        data.add("全部分类");
        data.add("生活小记");
        data.add("绿植养殖");
        data.add("宠物喂养");
        data.add("生活小记");
        data.add("绿植养殖");
        data.add("宠物喂养");

//        data.add("A");
//        data.add("A");
//        data.add("A");
//        data.add("A");
//        data.add("A");
//        data.add("A");
//        data.add("A");
//        data.add("A");
//        data.add("A");
//        data.add("A");
//        data.add("A");


        horizontalView.setData(data, new HorizontalView.HolderView() {
            @Override
            public int getLayoutResId() {
                return R.layout.item_layout;
            }

            @Override
            public int getWidth() {
                return 250;
            }

            @Override
            public int getHeight() {
                return 250;
            }

            @Override
            public int getMargin() {
                return 16;
            }

            @Override
            public void bindingData(View view, Object obj) {
                TextView tv = view.findViewById(R.id.tv);
                String value = (String) obj;
                tv.setText(value);
            }

            @Override
            public void onItemClickListener(int position, Object obj) {
                String v = (String) obj;
                Toast.makeText(MainActivity.this, "v = " + v, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
