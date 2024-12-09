package com.cisco.prj.client;

import com.cisco.prj.dao.MobileDao;
import com.cisco.prj.dao.MobileDaoDbImpl;
import com.cisco.prj.dao.MobileDaoFactory;
import com.cisco.prj.dao.MobileDaoMongoImpl;
import com.cisco.prj.entity.Mobile;

public class MobileClient {
    public static void main(String[] args) {
        Mobile m = new Mobile(41, "Samsung Fold", 154000.00, "5G");
        // always program to interface
//        MobileDao mobileDao = new MobileDaoDbImpl();
//        MobileDao mobileDao = new MobileDaoMongoImpl();
        MobileDao mobileDao = MobileDaoFactory.getMobileDao();
        mobileDao.addMobile(m);
    }
}
