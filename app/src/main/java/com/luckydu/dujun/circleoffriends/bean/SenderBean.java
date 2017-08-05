package com.luckydu.dujun.circleoffriends.bean;

import com.google.gson.annotations.SerializedName;

import org.litepal.crud.DataSupport;

/**
 * @author dujun
 * @since 2017-08-02 13:48
 */
public class SenderBean extends DataSupport {
    /**
     * avatar : https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJm8UXZ0mYtjv1a48RKkFkdyd4kOWLJB0o_l7GuTS8-q8VF64w
     * nick : Joe Portman
     * username : jport
     *
     */

    private String avatar;
    private String nick;
    private String username;
    /**
     * profile-image : http://img2.findthebest.com/sites/default/files/688/media/images/Mingle_159902_i0.png
     */

    @SerializedName("profile-image")
    private String profileimage;

    public String getAvatar () {
        return avatar;
    }

    public void setAvatar (String avatar) {
        this.avatar = avatar;
    }

    public String getNick () {
        return nick;
    }

    public void setNick (String nick) {
        this.nick = nick;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getProfileimage () {
        return profileimage;
    }

    public void setProfileimage (String profileimage) {
        this.profileimage = profileimage;
    }

    @Override
    public String toString () {
        return "SenderBean{" + "avatar='" + avatar + '\'' + ", nick='" + nick + '\'' + ", username='" + username + '\'' + ", profileimage='" + profileimage + '\'' + '}';
    }
}
