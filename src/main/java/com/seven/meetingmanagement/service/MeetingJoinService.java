package com.seven.meetingmanagement.service;

import com.seven.meetingmanagement.dao.MeetingJoinDao;
import com.seven.meetingmanagement.entity.MeetingJoin;
import com.seven.meetingmanagement.entity.MeetingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MeetingJoinService {
    @Autowired
    private MeetingJoinDao dao;

    public void saveMeetingJoin(MeetingJoin meetingJoin) {dao.save(meetingJoin);};

    public void addMeetingJoin(int meetingid, String username, String name, String workplace, String identitycard, String phone, String time, String meetingname, String meetingdesc, String room, Timestamp meetingtime)
    {
        dao.addMeetingJoin(meetingid, username, name, workplace, identitycard, phone, time, meetingname, meetingdesc, room,meetingtime);
    };
    public List<MeetingJoin> findAllByUserName(String username)
    {
        return dao.findAllByUserName(username);
    };

    public void deleteAllByMeetingId(int meetingid)
    {
        dao.deleteAllByMeetingId(meetingid);
    }

    public void deleteByMeetingIdAndUserName(int meetingid,String username)
    {
        dao.deleteByMeetingIdAndUserName(meetingid,username);
    }

    public List<MeetingJoin> findAllByMeetingId(int meetingid)
    {
        return dao.findAllByMeetingId(meetingid);
    }
}
