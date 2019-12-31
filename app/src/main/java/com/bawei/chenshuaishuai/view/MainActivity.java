package com.bawei.chenshuaishuai.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.chenshuaishuai.R;
import com.bawei.chenshuaishuai.adapter.TuiAdapter;
import com.bawei.chenshuaishuai.base.BaseActivity;
import com.bawei.chenshuaishuai.contract.TuiContract;
import com.bawei.chenshuaishuai.model.entity.EntityBean;
import com.bawei.chenshuaishuai.presenter.TuiPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements TuiContract.IView {
    @BindView(R.id.tv_1)
    TextView tv_1;
    @BindView(R.id.recy)
    RecyclerView recy;


    @Override
    protected void initdata() {

    }

    @Override
    protected void initview() {
        TuiPresenter presenter=new TuiPresenter(this);
        recy.setLayoutManager(new LinearLayoutManager(this));

        presenter.getHome("http://blog.zhaoliang5156.cn/api/news/ranking.json");
        tv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecendActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected int layoutid() {
        return R.layout.activity_main;
    }

    @Override
    public void success(EntityBean bean) {
        List<EntityBean.RankingBean> ranking = bean.getRanking();
        TuiAdapter tuiAdapter = new TuiAdapter(this, ranking);
        recy.setAdapter(tuiAdapter);

    }

    @Override
    public void error(Throwable throwable) {

    }

}
