package cn.wangye.ioc3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoldierService implements cn.wangye.ioc3.Service {

    @Autowired
    private SoldierDao soldierDao;

    public void getMessage() {
        soldierDao.getMessage();
    }
}