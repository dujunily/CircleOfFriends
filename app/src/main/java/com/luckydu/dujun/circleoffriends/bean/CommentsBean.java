package com.luckydu.dujun.circleoffriends.bean;

import org.litepal.crud.DataSupport;

/**
 * @author dujun
 * @since 2017-08-02 13:49
 */
public class CommentsBean extends DataSupport {
    /**
     * content : Good.
     * sender : {"avatar":"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJm8UXZ0mYtjv1a48RKkFkdyd4kOWLJB0o_l7GuTS8-q8VF64w","nick":"Super hero","username":"outman"}
     */

    private String content;
    private SenderBean sender;

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

    @Override
    public String toString () {
        return "CommentsBean{" + "content='" + content + '\'' + ", sender=" + sender + '}';
    }
}
