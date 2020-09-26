package main.service;

import main.model.Session;
import main.model.SessionArray;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TimeTableGenerateService {

    ArrayList<Integer> getSubjectPreferedRoom(String subjectId,int tagId) throws SQLException;

    ArrayList<Integer> getLecturersAccordingToSessionId(int sessionId)throws SQLException;

    ArrayList<Integer> getLecturerPrefferedList(int i)throws SQLException;

    ArrayList<Integer> getPreferredRoomListForGroup(int groupId) throws SQLException;

    ArrayList<Integer> getPreferredRoomListForSession(int sessionId) throws SQLException;

    boolean getNotAvailableGroupStaus(String toTime, String fromTime, Integer spr, String day) throws SQLException;

    boolean getNotAvailableSessionStatus(int sessionId, String day, String toTime, String fromTime) throws SQLException;

    boolean getNotAvailableLectureStatus(String toTime, String fromTime, String day, Integer lec) throws SQLException;

    int getRoomSize(int roomId) throws SQLException;

    boolean getNotAvailableSubGroupStaus(String toTime, String fromTime, int parseInt, String day) throws SQLException;

    double getConsectiveSessionHourAccordingToSession(int sessionId) throws SQLException;

    int getConsectiveSessionIdAccordingToSession(int sessionId) throws SQLException;

    ArrayList<Integer> getPreferredRoomListForSubGroup(int parseInt) throws SQLException;

    Integer getBuilidingForLecturer(Integer i) throws SQLException;

    ArrayList<Integer> getRoomsAccordingToBuilding(Integer i) throws SQLException;

    SessionArray getSessionDetailsAccordingToSessionId(String s) throws SQLException;

    ArrayList<String> getLecturerNamesAccordingTo(String s) throws SQLException;

    String getRoomNumberAccordingToRoomId(String s) throws SQLException;

    String getSubgroupIdAccordingToSession(String s) throws SQLException;
}
