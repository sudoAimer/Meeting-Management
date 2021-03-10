package com.seven.meetingmanagement.dao;

import com.seven.meetingmanagement.entity.MeetingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface MeetingListDao extends JpaRepository<MeetingList,String> {
    @Query(value = "select * from meetinglist where meetingid = ?" , nativeQuery = true)
    Optional<MeetingList> findById (int meetingid);
    @Query(value = "select * from meetinglist where username = ?" ,nativeQuery = true)
    List<MeetingList> findAllByUsername (String username);
    @Modifying
    @Transactional
    @Query(value = "delete from meetinglist where meetingid = ?",nativeQuery = true)
    void deleteByMeetingId(int meetingid);
}
