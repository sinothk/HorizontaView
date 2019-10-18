# horizontalView
HorizontalSubView: 为RecycleView中的Item横滑制定！


# 引入
  Step 1. Add the JitPack repository to your build file
  Add it in your root build.gradle at the end of repositories:

      allprojects {
        repositories {
          ...
          maven { url 'https://www.jitpack.io' }
        }
      }

## Step 2. Add the dependency
    dependencies {
            implementation 'com.github.sinothk:HorizontaView:1.x.1018'
    }

# 使用

  xml:
  
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="200dp"
    android:layout_height="200dp"
    android:background="@drawable/bg"
    android:gravity="center"
    android:orientation="vertical">
    <TextView
        android:id="@+id/tv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="SINOTHK"
        android:textColor="#FFFFFF"
        android:textSize="18sp" />
    </LinearLayout>
    
   Java：
    
        HorizontalView<String> horizontalView = findViewById(R.id.horizontalView);
        ArrayList<String> data = new ArrayList<>();
        data.add("全部分类");
        data.add("生活小记");
        data.add("绿植养殖");
        data.add("宠物喂养");
        data.add("生活小记");
        data.add("绿植养殖");
        data.add("宠物喂养");

        horizontalView.setData(data, new HorizontalView.HolderView() {
            @Override
            public int getLayoutResId() {
                return R.layout.item_layout;
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
