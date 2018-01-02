package com.simpleTinyURL.dao.impl;

import com.simpleTinyURL.dao.TinyURLDao;
import com.simpleTinyURL.model.TinyURL;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by mrro1015 on 1/2/2018.
 */
public class TinyURLDaoImpl implements TinyURLDao {

    final String COLLECTION = "tinyURLs";

    private MongoTemplate mongoTemplate;

    @Override
    public void create(TinyURL tinyURL) {
        mongoTemplate.insert(tinyURL);
    }

    @Override
    public void update(TinyURL tinyURL) {
        mongoTemplate.save(tinyURL);
    }

    @Override
    public void delete(TinyURL tinyURL) {
        mongoTemplate.remove(tinyURL);
    }

    @Override
    public void deleteAll() {
        mongoTemplate.remove(new Query(), COLLECTION);
    }

    @Override
    public TinyURL find(TinyURL tinyURL) {
        Query query = new Query(Criteria.where("tinyUrl").is(tinyURL.getTinyUrl()));
        return mongoTemplate.findOne(query, TinyURL.class, COLLECTION);
    }

    @Override
    public List<TinyURL> findAll() {
        return (List<TinyURL>) mongoTemplate.findAll(TinyURL.class);
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
