package com.example.chapter2;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chapter2.recycler.LinearItemDecoration;
import com.example.chapter2.recycler.MyAdapter;
import com.example.chapter2.recycler.TestData;
import com.example.chapter2.recycler.TestDataSet;

public class RecyclerViewActivity extends AppCompatActivity implements MyAdapter.IOnItemClickListener {

    private static final String TAG = "TAG";

    private RecyclerView recyclerView,hrecyclerView;
    private MyAdapter mAdapter,hAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        Log.i(TAG, "RecyclerViewActivity onCreate");
        initView();

    }
    private int countView(ViewGroup vg){
        int n=vg.getChildCount();
        int tot=0;
        for(int i=0;i<n;i++){
            if(vg.getChildAt(i).getClass()==ViewGroup.class)tot+=countView((ViewGroup)vg.getChildAt(i));
            else tot+=1;
        }
        Log.i("countView","Total View Count ="+ tot);
        return tot;
    }
    private void initView() {
        recyclerView = findViewById(R.id.recycler);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(TestDataSet.getData());
        mAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(mAdapter);
        LinearItemDecoration itemDecoration = new LinearItemDecoration(Color.BLUE);
//        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//        DefaultItemAnimator animator = new DefaultItemAnimator();
//        animator.setAddDuration(3000);
//        recyclerView.setItemAnimator(animator);

        hrecyclerView = findViewById(R.id.horizontal_recycler);

        recyclerView.setHasFixedSize(true);

//        layoutManager = new LinearLayoutManager(this);
//        gridLayoutManager = new GridLayoutManager(this, 2);
//        recyclerView.setLayoutManager(layoutManager);

        hAdapter = new MyAdapter(TestDataSet.getData());
        hAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(hAdapter);
//        LinearItemDecoration itemDecoration = new LinearItemDecoration(Color.BLUE);
//        recyclerView.addItemDecoration(itemDecoration);
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "RecyclerViewActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "RecyclerViewActivity onResume");
    }

    private final String KEY="K1";
    @Override
    public void onItemCLick(int position, TestData data) {
        Intent icd=new Intent(this,ClickDestination.class);
//        icd.get
//        icd.getBundleExtra(""+position);
        icd.putExtra(KEY,""+position);
        startActivity(icd);
        Toast.makeText(RecyclerViewActivity.this, "点击了第" + position + "条", Toast.LENGTH_SHORT).show();
        //mAdapter.addData(position + 1, new TestData("", "0w"));
    }

    @Override
    public void onItemLongCLick(int position, TestData data) {
        Toast.makeText(RecyclerViewActivity.this, "长按了第" + position + "条", Toast.LENGTH_SHORT).show();
        mAdapter.removeData(position);
    }
}