package com.sinothk.view.horizontalView.demo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HorizontalView extends HorizontalScrollView {

    public HorizontalView(Context context) {
        super(context);
    }

    public HorizontalView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HorizontalView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void initView(Context context) {

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        for (int i = 0; i < 15; i++) {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(200, 200);

            TextView textView = new TextView(context);
            textView.setBackgroundColor(Color.BLUE);

            if (i == 0) {
                lp.setMargins(20, 20, 20, 20);
            } else {
                lp.setMargins(0, 20, 20, 20);
            }
            textView.setLayoutParams(lp);
            linearLayout.addView(textView, i);
        }

        addView(linearLayout);
    }
}
