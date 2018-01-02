package com.simpleTinyURL.service.impl;

import com.simpleTinyURL.app.TinyURLGenerator;
import com.simpleTinyURL.dao.TinyURLDao;
import com.simpleTinyURL.model.TinyURL;
import com.simpleTinyURL.service.TinyURLService;

import java.util.List;

/**
 * Created by mrro1015 on 1/2/2018.
 */
public class TinyURLServiceImpl implements TinyURLService{

    private TinyURLDao tinyURLDao;

    private TinyURLGenerator tinyURLGenerator;

    public void create(TinyURL tinyURL) {
        tinyURL.setTinyUrl(tinyURLGenerator.generateTinyURL(tinyURL.getOriginalURL()));
        //TODO: Need to cache this result so get will be faster
        tinyURLDao.create(tinyURL);
    }

    public void update(TinyURL tinyURL) {
        tinyURLDao.update(tinyURL);
    }

    public void delete(TinyURL tinyURL) {
        tinyURLDao.delete(tinyURL);
    }

    public List<TinyURL> findAll() {
        return tinyURLDao.findAll();
    }

    public TinyURL find(TinyURL tinyURL) {
        return tinyURLDao.find(tinyURL);
    }

    public void deleteAll() {
        tinyURLDao.deleteAll();
    }

    public void setTinyURLDao(TinyURLDao tinyURLDao) {
        this.tinyURLDao = tinyURLDao;
    }

    public void setTinyURLGenerator(TinyURLGenerator tinyURLGenerator) {
        this.tinyURLGenerator = tinyURLGenerator;
    }
}
