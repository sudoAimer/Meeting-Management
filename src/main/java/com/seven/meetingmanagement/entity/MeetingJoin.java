package com.seven.meetingmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "meetingjoin")
public class MeetingJoin {
    @Id
    @Column(name = "meetingid")
    private int meetingid;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "workplace")
    private String workplace;

    @Column(name = "identitycard")
    private String identitycard;

    @Column(name = "phone")
    private String phone;

    @Column(name = "time")
    private String time;

    @Column(name = "meetingname")
    private String meetingname;

    @Column(name = "meetingdesc")
    private String meetingdesc;

    @Column(name = "room")
    private String room;

    @Column(name = "meetingtime")
    private Timestamp meetingtime;

    public Timestamp getMeetingtime() {
        return meetingtime;
    }

    public void setMeetingtime(Timestamp meetingtime) {
        this.meetingtime = meetingtime;
    }

    public int getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(int meetingid) {
        this.meetingid = meetingid;
    }

    public String getMeetingname() {
        return meetingname;
    }

    public void setMeetingname(String meetingname) {
        this.meetingname = meetingname;
    }

    public String getMeetingdesc() {
        return meetingdesc;
    }

    public void setMeetingdesc(String meetingdesc) {
        this.meetingdesc = meetingdesc;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(String identitycard) {
        this.identitycard = identitycard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
