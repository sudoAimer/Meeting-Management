package com.seven.meetingmanagement.entity;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "meetinglist")
public class MeetingList {
    @Id
    @Column(name = "meetingid")
    private int meetingid;

    @Column(name = "username")
    private String username;

    @Column(name = "meetingtime")
    private Timestamp meetingtime;

    @Column(name = "name")
    private int name;

    @Column(name = "workplace")
    private int workplace;

    @Column(name = "identitycard")
    private int identitycard;

    @Column(name = "phone")
    private int phone;

    @Column(name = "time")
    private int time;

    @Column(name = "room")
    private String room;

    @Column(name = "meetingname")
    private String meetingname;

    @Column(name = "meetingdesc")
    private String meetingdesc;

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

    public int getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(int meetingid) {
        this.meetingid = meetingid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getMeetingtime() {
        return meetingtime;
    }

    public void setMeetingtime(Timestamp meetingtime) {
        this.meetingtime = meetingtime;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getWorkplace() {
        return workplace;
    }

    public void setWorkplace(int workplace) {
        this.workplace = workplace;
    }

    public int getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(int identitycard) {
        this.identitycard = identitycard;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
