package com.simpleTinyURL.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by mrro1015 on 1/2/2018.
 */
@Document(collection = "tinyURLs")
public class TinyURL {

    @Id
    private String id;

    @Indexed(unique = true)
    private String tinyUrl;

    private String originalURL;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTinyUrl() {
        return tinyUrl;
    }

    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TinyURL{");
        sb.append("id='").append(id).append('\'');
        sb.append(", tinyUrl='").append(tinyUrl).append('\'');
        sb.append(", originalURL='").append(originalURL).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
