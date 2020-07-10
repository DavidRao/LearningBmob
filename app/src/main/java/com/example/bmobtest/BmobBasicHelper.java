package com.example.bmobtest;

import android.content.Context;
import android.widget.Toast;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

class BmobBasicHelper{

    private Context thisContext;

    BmobBasicHelper(Context context){
        this.thisContext = context;
    }

    private void toastShow(String msg){
        Toast.makeText(thisContext, msg, Toast.LENGTH_LONG).show();
    }

    public <T extends BmobObject> void addData(T t){
        t.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e!=null){
                    toastShow(e.getMessage());
                }else{
                    toastShow("Add data successfully！");
                }
            }
        });
    }

    public <P extends BmobObject> void queryData(String id, BmobQuery<P> query){
        query.getObject("f2bb1b36ac", new QueryListener<P>() {
            @Override
            public void done(P p, BmobException e) {
                if(e==null){
                    toastShow(p.toString());
                }
            }
        });
    }

    public <T extends BmobObject> void updateData(T t, String id){
        t.update(id, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    toastShow("Update successfully");
                }
            }
        });
    }

    public <T extends BmobObject> void deleteData(T t){
        t.delete(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    toastShow("Delete successfully!");
                }else{
                    toastShow("Fail to delete");
                }
            }
        });
    }

}
