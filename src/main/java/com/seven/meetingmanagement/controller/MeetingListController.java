package com.seven.meetingmanagement.controller;

import com.seven.meetingmanagement.entity.MeetingList;
import com.seven.meetingmanagement.service.MeetingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/meeting")
public class MeetingListController {
    @Autowired
    private MeetingListService service;

    @PostMapping(value = "")
    public void saveMeetingList(MeetingList meetingList)
    {
        service.saveMeetingList(meetingList);
    }
    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public Optional<MeetingList> findById( @RequestParam(value = "meetingid") int id)
    {
        return service.findById(id);
    }
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<MeetingList> findAllByUsername(@RequestParam(value = "username") String username)
    {
        return service.findAllByUsername(username);
    }
    @PostMapping(value = "/delete")
    public void deleteByMeetingId(int meetingid){ service.deleteByMeetingId(meetingid);}

    @RequestMapping(value = "/findAll")
    public List<MeetingList> findAll(){ return service.findAll();};
}
