package com.cisco.prj.dao;

import com.cisco.prj.entity.Mobile;

// Realization
public class MobileDaoDbImpl implements  MobileDao{

    @Override
    public void addMobile(Mobile m) {
        System.out.println(m.getName() + " stored in database !!!");
    }
}
