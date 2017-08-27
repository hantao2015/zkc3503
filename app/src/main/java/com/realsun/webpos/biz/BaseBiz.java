package com.realsun.webpos.biz;

import com.alibaba.fastjson.JSON;

import com.realsun.finisar.bus.model.PersonBusLine;
import com.realsun.utils.WebClientConnection;
import com.realsun.webpos.webclient.DataResult;
import com.realsun.webpos.webclient.GetDatatableParm;
import com.realsun.webpos.webclient.SaveDataTableParm;
import com.realsun.webpos.webclient.WebDataNotifier;
import com.realsun.webpos.webclient.WebDataService;

/**
 * Created by hantao on 2017/8/27.
 */

public class BaseBiz {
    public   String resid="";
    public   String cmswhere="";

    public BaseBiz(String resid) {
        this.resid=resid;
    }

    public BaseBiz(String resid,String cmswhere) {
        this.resid=resid;
        this.cmswhere=cmswhere;
    }
    public void getWebDataByWhere(  WebClientConnection   wcc,WebDataNotifier wdn )
    {
        GetDatatableParm getDataParm=new GetDatatableParm();
        getDataParm.resid=this.resid;
        final WebDataService wds=new WebDataService();
        getDataParm.cmswhere=this.cmswhere;
        wds.retrieve(getDataParm, wcc, wdn);
    }
    public void getObjectByWhere(  WebClientConnection   wcc,final  Class clazz,final BaseObjectNotify bon )
    {
        GetDatatableParm getDataParm=new GetDatatableParm();
        getDataParm.resid=this.resid;
        final WebDataService wds=new WebDataService();
        getDataParm.cmswhere=this.cmswhere;

        wds.retrieve(getDataParm, wcc, new WebDataNotifier(){
            @Override
            public void result(DataResult result) {
                if (result.error==0)
                {
                    String str=result.data.get(0).toString();

                    bon.result(str);

                }
                else
                {
                    bon.result("{}");
                }
            }
        });
    }
}
