package com.bawei.chenshuaishuai.contract;

import com.bawei.chenshuaishuai.model.entity.EntityBean;

/**
 * @author: asus
 * @date: 19/12/31
 */
public interface TuiContract {
    interface IModel{
        void getHome(String url,ModelCallBack modelCallBack);
        interface ModelCallBack{
            void success(EntityBean bean);
            void error(Throwable throwable);
        }
    }
    interface IView{
        void success(EntityBean bean);
        void error(Throwable throwable);
    }
    interface IPresenter{
        void getHome(String url);
    }
}
