package com.sinothk.view.horizontalView;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

            // ==================================== ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(holderView.getWidth(), holderView.getHeight());
            if (i == 0) {
                lp.setMargins(holderView.getMargin(), holderView.getMargin(), holderView.getMargin(), holderView.getMargin());
            } else {
                lp.setMargins(0, holderView.getMargin(), holderView.getMargin(), holderView.getMargin());
            }
            itemView.setLayoutParams(lp);
            linearLayout.addView(itemView, i);
        }

        addView(linearLayout);
    }

    HolderView holderView;

    public interface HolderView {

        int getLayoutResId();

        int getWidth();

        int getHeight();

        int getMargin();

        void bindingData(View view, Object obj);

        void onItemClickListener(int position, Object obj);
    }
}
