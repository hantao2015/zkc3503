package com.realsun.finisar.bus.model;

import com.alibaba.fastjson.annotation.JSONField;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * Created by hantao on 2017/8/27.
 */

public class PersonBusLine extends DataSupport {
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    @JSONField(name ="C3_555342037606")
    private String personid;
    private String image;

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    private String deptname;
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    private String name="未知";

    public String getBadgeno() {
        return badgeno;
    }

    public void setBadgeno(String badgeno) {
        this.badgeno = badgeno;
    }

    private String badgeno="未知";

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    @Column(unique = true,nullable = false)
    private String cardno="未知";

    public String getBusline() {
        return busline;
    }

    public void setBusline(String busline) {
        this.busline = busline;
    }

    private String busline="未知";

    public void setC3_546339713510(String c3_546339713510) {
        C3_546339713510 = c3_546339713510;
    }

    private String C3_546339713510;//员工编号

    public void setC3_546339679211(String c3_546339679211) {
        C3_546339679211 = c3_546339679211;
        setBusline(c3_546339679211);
    }

    private String C3_546339679211 ;//路线名称

    public void setC3_555342037832(String c3_555342037832) {
        C3_555342037832 = c3_555342037832;
        setName(  c3_555342037832);
    }

    private String C3_555342037832;// 员工姓名

    public void setC3_557158818161(String c3_557158818161) {
        C3_557158818161 = c3_557158818161;
        setCardno(c3_557158818161);
    }

    private String  C3_557158818161;// 卡号

    public void setC3_557158954884(String c3_557158954884) {
        C3_557158954884 = c3_557158954884;
        setImage(c3_557158954884);
    }

    public void setC3_557159185928(String c3_557159185928) {
        C3_557159185928 = c3_557159185928;
        setDeptname(c3_557159185928);
    }

    private String C3_557158954884 ;//头像

    private String C3_557159185928 ;//部门名称

    public void setC3_557158817655(String c3_557158817655) {
        C3_557158817655 = c3_557158817655;
        setBadgeno(c3_557158817655);
    }

    private String  C3_557158817655;// 员工工号

}
