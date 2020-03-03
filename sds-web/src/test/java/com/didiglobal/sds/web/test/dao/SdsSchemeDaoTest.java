package com.didiglobal.sds.web.test.dao;

import com.alibaba.fastjson.JSON;
import com.didiglobal.sds.web.dao.SdsSchemeDao;
import com.didiglobal.sds.web.dao.bean.SdsSchemeDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yizhenqiang on 18/2/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SdsSchemeDaoTest {

    @Autowired
    private SdsSchemeDao sdsSchemeDao;

    @Test
    public void addSdsSchemeTest() {
        SdsSchemeDO sdsSchemeDO = new SdsSchemeDO();
        sdsSchemeDO.setAppGroupName("黑马");
        sdsSchemeDO.setAppName("bh-order");

        sdsSchemeDO.setSdsSchemeName("FIRST_GROUP");
        sdsSchemeDO.setCreatorName("易振强");
        sdsSchemeDO.setCreatorEmail("yizhenqiang@didichuxing.com");
        Assert.assertEquals(1, sdsSchemeDao.addSdsScheme(sdsSchemeDO));

        sdsSchemeDO.setSdsSchemeName("SECOND_GROUP");
        Assert.assertEquals(1, sdsSchemeDao.addSdsScheme(sdsSchemeDO));
    }

    @Test
    public void queryAllSdsSchemeTest() {
        System.out.println(JSON.toJSONString(sdsSchemeDao.queryAllSdsScheme("黑马", "mzz-study")));
    }

    @Test
    public void queryByGroupNameTest() {
        System.out.println(sdsSchemeDao.queryByGroupName("黑马", "bh-order", "FIRST_GROUP"));
    }

    @Test
    public void updateSdsSchemeTest() {
        System.out.println(sdsSchemeDao.updateSdsScheme("黑马", "bh-order", "FIRST_GROUP", "FIRST_GROUP1", "易振强",
                "yizhenqiang@didichuxing.com"));
    }

    @Test
    public void deleteSdsSchemeTest() {
        System.out.println(sdsSchemeDao.deleteSdsScheme("黑马", "bh-order", "FIRST_GROUP"));
    }

}
