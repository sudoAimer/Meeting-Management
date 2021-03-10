package com.seven.meetingmanagement.controller;

import com.seven.meetingmanagement.entity.MeetingJoin;
import com.seven.meetingmanagement.service.MeetingJoinService;
import com.seven.meetingmanagement.utils.ExcelUtil;
import com.seven.meetingmanagement.utils.QRcode;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/join")
public class MeetingJoinController{
    @Autowired
    private MeetingJoinService service;

    @PostMapping(value = "/save")
    public void saveMeetingJoin(MeetingJoin meetingJoin) {service.saveMeetingJoin(meetingJoin);}

    @PostMapping(value = "/insert")
    public void addMeetingJoin(int meetingid, String username, String name, String workplace, String identitycard, String phone, String time, String meetingname, String meetingdesc, String room, Timestamp meetingtime)
    {service.addMeetingJoin(meetingid, username, name, workplace, identitycard, phone, time, meetingname, meetingdesc, room, meetingtime);}

    @RequestMapping(value = "/request",method = RequestMethod.GET)
    public List<MeetingJoin> findAllByUserName(@RequestParam(value = "username") String username) { return service.findAllByUserName(username);}

    @PostMapping(value = "/delete")
    public void deleteAllByMeetingId(int meetingid)
    {
        service.deleteAllByMeetingId(meetingid);
    }

    @PostMapping(value = "/deleteByMeetingIdAndUsername")
    public void deleteByMeetingIdAndUserName(int meetingid, String username)
    {
        service.deleteByMeetingIdAndUserName(meetingid,username);
    }

    @RequestMapping(value = "/QRcode",method = RequestMethod.GET)
    public void getQrCode(@RequestParam(value = "meetingid") int meetingid, HttpServletResponse response)
    {
        QRcode.createQrCode(String.valueOf(meetingid),200,200,response);
    }

    @RequestMapping(value = "/excel",method = RequestMethod.GET)
    public void export(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "meetingid") int meetingid) throws Exception {
        List<MeetingJoin> list = service.findAllByMeetingId(meetingid);
        String[] title = {"用户名","姓名","工作场所","身份证号","电话号码","参会时间","会议名称","会议描述","会议室","会议时间"};
        String fileName = "meetingid=" + String.valueOf(meetingid) + "参会人员信息表.xls";
        String sheetName = "会议信息表";
        String[][] content = new String[list.size()][title.length];
        for(int i = 0 ; i < list.size(); i++)
        {
            MeetingJoin obj = list.get(i);
            content[i][0] = obj.getUsername().toString();
            content[i][1] = obj.getName();
            content[i][2] = obj.getWorkplace();
            content[i][3] = obj.getIdentitycard();
            content[i][4] = obj.getPhone();
            content[i][5] = obj.getTime();
            content[i][6] = obj.getMeetingname();
            content[i][7] = obj.getMeetingdesc();
            content[i][8] = obj.getRoom();
            content[i][9] = obj.getMeetingtime().toString();
        }
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName,title,content,null);
        try{
                    this.setResponseHeader(response, fileName);
                    OutputStream os = response.getOutputStream();
                    wb.write(os);
                    os.flush();
                    os.close();
        }catch (Exception e){
                    e.printStackTrace();
        }

    }
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {

                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
