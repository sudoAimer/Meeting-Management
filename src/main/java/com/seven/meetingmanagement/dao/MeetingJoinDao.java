package com.seven.meetingmanagement.dao;

import com.seven.meetingmanagement.entity.MeetingJoin;
import com.seven.meetingmanagement.entity.MeetingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface MeetingJoinDao extends JpaRepository<MeetingJoin,String> {
    @Modifying
    @Transactional
    @Query(value = "insert meetingjoin(meetingid, username, name, workplace, identitycard, phone, time, meetingname, meetingdesc, room, meetingtime) values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9,?10, ?11)",nativeQuery = true)
    void addMeetingJoin(int meetingid, String username, String name, String workplace, String identitycard, String phone, String time, String meetingname, String meetingdesc, String room, Timestamp meetingtime);

    @Query(value = "select * from meetingjoin where username = ?",nativeQuery = true)
    List<MeetingJoin> findAllByUserName(String username);

    @Modifying
    @Transactional
    @Query(value = "delete from meetingjoin where meetingid = ?",nativeQuery = true)
    void deleteAllByMeetingId(int meetingid);

    @Modifying
    @Transactional
    @Query(value = "delete from meetingjoin where meetingid = ?1 and username = ?2",nativeQuery = true)
    void deleteByMeetingIdAndUserName(int meetingid,String username);

    @Query(value = "select * from meetingjoin where meetingid = ?",nativeQuery = true)
    List<MeetingJoin> findAllByMeetingId(int meetingid);

}
