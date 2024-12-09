package com.cisco.prj.dao;

import com.cisco.prj.entity.Mobile;

public class MobileDaoMongoImpl implements MobileDao{

    @Override
    public void addMobile(Mobile m) {
        System.out.println("Mongo store : " + m.getName());
    }
}
