package com.sinothk.view.horizontalView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class HorizontalView<T> extends HorizontalScrollView {

    Context mContext;

    public HorizontalView(Context context) {
        super(context);
        mContext = context;
    }

    public HorizontalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public HorizontalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public HorizontalView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
    }

    public void setData(final ArrayList<T> data, HolderView hView) {
        this.holderView = hView;

        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        for (int i = 0; i < data.size(); i++) {

            final T obj = data.get(i);

            final View itemView = LayoutInflater.from(mContext).inflate(holderView.getLayoutResId(), null);

            holderView.bindingData(itemView, obj);

            final int index = i;
            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    holderView.onItemClickListener(index, obj);
                }
            });

            // ====================================
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            if (i == 0) {
                lp.setMargins(20, 20, 20, 20);
            } else {
                lp.setMargins(0, 20, 20, 20);
            }
            itemView.setLayoutParams(lp);
            linearLayout.addView(itemView, i);
        }

        addView(linearLayout);
    }

    HolderView holderView;

    public interface HolderView {

        int getLayoutResId();

        void bindingData(View view, Object obj);

        void onItemClickListener(int position, Object obj);
    }
}
