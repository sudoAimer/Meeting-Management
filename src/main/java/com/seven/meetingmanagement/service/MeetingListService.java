package com.seven.meetingmanagement.service;

import com.seven.meetingmanagement.dao.MeetingListDao;
import com.seven.meetingmanagement.entity.MeetingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingListService {
    @Autowired
    private MeetingListDao dao;

    public void saveMeetingList(MeetingList meetingList) {dao.save(meetingList);};

    public Optional<MeetingList> findById(int id ){ return dao.findById(id);};

    public List<MeetingList> findAllByUsername(String username){ return dao.findAllByUsername(username);};

    public void deleteByMeetingId (int meetingid) {dao.deleteByMeetingId(meetingid);}

    public List<MeetingList> findAll(){ return dao.findAll();}
}
