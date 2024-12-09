package com.cisco.prj.dao;

import java.util.ResourceBundle;

public class MobileDaoFactory {
    private  static String DAO_CLASS = "";
    // static block gets invoked as soon as the class is loaded
    // right place for reading config / loading drivers ...
    static  {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        DAO_CLASS = resourceBundle.getString("MOBILE_DAO");
        //com.cisco.prj.dao.MobileDaoDbImpl
    }

    public static MobileDao getMobileDao() {
//        return  new MobileDaoMongoImpl();
       // return  new MobileDaoDbImpl();
        try {
            return (MobileDao) Class.forName(DAO_CLASS).getConstructor().newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  null;
    }

}
