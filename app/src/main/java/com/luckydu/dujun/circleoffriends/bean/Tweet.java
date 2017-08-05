package com.luckydu.dujun.circleoffriends.bean;

import com.google.gson.annotations.SerializedName;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * @author dujun
 * @since 2017-08-02 11:30
 */

public class Tweet extends DataSupport {

    /**
     * comments : [{"content":"Good.","sender":{"avatar":"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJm8UXZ0mYtjv1a48RKkFkdyd4kOWLJB0o_l7GuTS8-q8VF64w","nick":"Super hero","username":"outman"}},{"content":"Like it too","sender":{"avatar":"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJm8UXZ0mYtjv1a48RKkFkdyd4kOWLJB0o_l7GuTS8-q8VF64w","nick":"Doggy Over","username":"inman"}}]
     * content : 沙发！
     * images : [{"url":"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRDy7HZaHxn15wWj6pXE4uMKAqHTC_uBgBlIzeeQSj2QaGgUzUmHg"},{"url":"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTlJRALAf-76JPOLohBKzBg8Ab4Q5pWeQhF5igSfBflE_UYbqu7"},{"url":"http://i.ytimg.com/vi/rGWI7mjmnNk/hqdefault.jpg"}]
     * sender : {"avatar":"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJm8UXZ0mYtjv1a48RKkFkdyd4kOWLJB0o_l7GuTS8-q8VF64w","nick":"Joe Portman","username":"jport"}
     * error : losted
     * unknown error : STARCRAFT2
     */

    private String content;
    private SenderBean sender;
    private String error;
    @SerializedName("unknown error")
    private String unknow_error;
    private List<CommentsBean> comments;
    private List<ImagesBean> images;

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public SenderBean getSender () {
        return sender;
    }

    public void setSender (SenderBean sender) {
        this.sender = sender;
    }

    public String getError () {
        return error;
    }

    public void setError (String error) {
        this.error = error;
    }

    public String getUnknow_error () {
        return unknow_error;
    }

    public void setUnknow_error (String unknow_error) {
        this.unknow_error = unknow_error;
    }

    public List<CommentsBean> getComments () {
        return comments;
    }

    public void setComments (List<CommentsBean> comments) {
        this.comments = comments;
    }

    public List<ImagesBean> getImages () {
        return images;
    }

    public void setImages (List<ImagesBean> images) {
        this.images = images;
    }

    @Override
    public String toString () {
        return "Tweet{" + "content='" + content + '\'' + ", sender=" + sender + ", error='" + error + '\'' + ", unknow_error='" + unknow_error + '\'' + ", comments=" + comments + ", images=" + images + '}';
    }
}
