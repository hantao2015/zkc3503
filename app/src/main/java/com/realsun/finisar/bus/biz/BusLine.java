package com.realsun.finisar.bus.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.realsun.finisar.bus.model.PersonBusLine;
import com.realsun.utils.WebClientConnection;
import com.realsun.webpos.biz.BaseBiz;
import com.realsun.webpos.biz.BaseObjectNotify;
import com.realsun.webpos.model.同步监控表;
import com.realsun.webpos.webclient.DataResult;
import com.realsun.webpos.webclient.GetDatatableParm;
import com.realsun.webpos.webclient.WebDataNotifier;

/**
 * Created by hantao on 2017/8/27.
 */

public class BusLine  extends BaseBiz {


    public BusLine(String resid) {
        super(resid);
    }

    public BusLine(String resid, String cmswhere) {
        super(resid, cmswhere);
    }
    public   void getPersonBusLineByWhere(WebClientConnection wcc ,Class clazz,BaseObjectNotify bon  ){


        this.getObjectByWhere(wcc, clazz, bon);


    }
    public   void getPersonBusLineByWhere(WebClientConnection wcc ,final   PersonBusLine  personBusLine  ){



        this.getWebDataByWhere(wcc,new WebDataNotifier(){
            @Override
            public void result(DataResult result) {
                if (result.error==0)
                {
                    String str=result.data.get(0).toString();
                    PersonBusLine   busline=new PersonBusLine();
                    busline=JSON.parseObject(str, PersonBusLine.class);

                    personBusLine.setBadgeno(busline.getBadgeno());
                    personBusLine.setBusline(busline.getBusline());

                }
            }
        });



    }
}
