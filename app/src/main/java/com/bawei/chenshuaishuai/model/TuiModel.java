package com.bawei.chenshuaishuai.model;

import com.bawei.chenshuaishuai.contract.TuiContract;
import com.bawei.chenshuaishuai.model.entity.EntityBean;
import com.bawei.chenshuaishuai.utils.OkHttpUtils;
import com.google.gson.Gson;

/**
 * @author: asus
 * @date: 19/12/31
 */
public class TuiModel implements TuiContract.IModel {
    @Override
    public void getHome(String url, ModelCallBack modelCallBack) {
        OkHttpUtils.getInstance().doGet(url, new OkHttpUtils.OkHttpCallBack() {
            @Override
            public void scuuess(String string) {
                EntityBean entityBean = new Gson().fromJson(string, EntityBean.class);
                modelCallBack.success(entityBean);
            }
            @Override
            public void error(Throwable throwable) {
                modelCallBack.error(throwable);
            }
        });
    }
}
