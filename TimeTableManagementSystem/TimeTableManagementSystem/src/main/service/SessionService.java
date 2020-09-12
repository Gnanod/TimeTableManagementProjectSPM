package main.service;

import main.model.ConsectiveSession;
import main.model.NotAvailableSession;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SessionService {

    int searchSession(int lecId, String subId, int tagId, int subGroupId, int mainGroupId) throws SQLException;

    boolean saveDetails(NotAvailableSession nas) throws SQLException;

    ArrayList<ConsectiveSession> getAllConsectiveSessions(String lecturer,String subject) throws SQLException;

    int getSessionIdForConsectiveSession(String groupId, String subject, String tagName) throws SQLException;

    boolean updateRowForConsectiveSession(int id) throws SQLException;

    boolean saveCosectiveSession(int id, int id1) throws SQLException;
}