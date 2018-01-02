package com.simpleTinyURL.service;

import com.simpleTinyURL.model.TinyURL;

import java.util.List;

/**
 * Created by mrro1015 on 1/2/2018.
 */
public interface TinyURLService {

    public void create(TinyURL tinyURL);

    public void update(TinyURL tinyURL);

    public void delete(TinyURL tinyURL);

    public void deleteAll();

    public TinyURL find(TinyURL tinyURL);

    public List<TinyURL> findAll();
}
