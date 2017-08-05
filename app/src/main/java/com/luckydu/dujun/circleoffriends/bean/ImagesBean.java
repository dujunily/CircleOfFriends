package com.luckydu.dujun.circleoffriends.bean;

import org.litepal.crud.DataSupport;

/**
 * @author dujun
 * @since 2017-08-02 13:49
 */
public class ImagesBean extends DataSupport {
    /**
     * url : https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRDy7HZaHxn15wWj6pXE4uMKAqHTC_uBgBlIzeeQSj2QaGgUzUmHg
     */

    private String url;

    public String getUrl () {
        return url;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    @Override
    public String toString () {
        return "ImagesBean{" + "url='" + url + '\'' + '}';
    }
}
