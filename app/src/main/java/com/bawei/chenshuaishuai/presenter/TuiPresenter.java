package com.bawei.chenshuaishuai.presenter;

import com.bawei.chenshuaishuai.contract.TuiContract;
import com.bawei.chenshuaishuai.model.TuiModel;
import com.bawei.chenshuaishuai.model.entity.EntityBean;

/**
 * @author: asus
 * @date: 19/12/31
 */
public class TuiPresenter implements TuiContract.IPresenter {
    private TuiContract.IView iView;
    private TuiModel model;

    public TuiPresenter(TuiContract.IView iView) {
        this.iView = iView;
        model=new TuiModel();
    }

    @Override
    public void getHome(String url) {
    model.getHome(url, new TuiContract.IModel.ModelCallBack() {
        @Override
        public void success(EntityBean bean) {
            iView.success(bean);
        }

        @Override
        public void error(Throwable throwable) {
            iView.error(throwable);
        }
    });
    }
}
