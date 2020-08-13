package main.service.impl;

import main.model.Lecturer;
import main.model.MainGroup;
import main.service.LecturerService;
import main.dbconnection.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class LectureServiceImpl implements LecturerService {
    private Connection connection;

    public LectureServiceImpl() {
        connection = DBConnection.getInstance().getConnection();
    }
    @Override
    public boolean saveLecturer(Lecturer lecturer) throws SQLException {
        String SQL = "Insert into Lecturer  Values(?,?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, lecturer.getEmpId());
        stm.setObject(2, lecturer.getEmpName());
        stm.setObject(3, lecturer.getFaculty());
        stm.setObject(4, 1);
        stm.setObject(5, lecturer.getCenter());
        stm.setObject(6, 1);
        stm.setObject(7, lecturer.getLevel());
        stm.setObject(8, lecturer.getRank());
        int res = stm.executeUpdate();
        return res > 0;
    }

    @Override
    public ArrayList<Lecturer> getAllLecturerDetails() throws SQLException {
        String SQL = "Select * from lecturer";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<Lecturer> lecturers = new ArrayList<>();
        while(rst.next()){
            Lecturer lecturer = new Lecturer();
            lecturer.setEmpId(Integer.parseInt(rst.getString("employeeId")));
            lecturer.setEmpName(rst.getString("employeeName"));
            lecturer.setFaculty(rst.getString("faculty"));
            lecturer.setDepartment(rst.getString("departmentId"));
            lecturer.setCenter(rst.getString("center"));
            lecturer.setBuilding(rst.getString("buildingId"));
            lecturer.setLevel(Integer.parseInt(rst.getString("level")));
            lecturer.setRank(rst.getString("ranks"));
            lecturers.add(lecturer);
        }
        return lecturers;
    }

    @Override
    public ArrayList<Lecturer> searchLecturerDetails(String name) throws SQLException {
        String empName=name;
        String SQL = "Select * from lecturer where employeeName LIKE '%" + empName + "%'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<Lecturer> lecturers = new ArrayList<>();
        while(rst.next()){
            Lecturer lecturer = new Lecturer();
            lecturer.setEmpId(Integer.parseInt(rst.getString("employeeId")));
            lecturer.setEmpName(rst.getString("employeeName"));
            lecturer.setFaculty(rst.getString("faculty"));
            lecturer.setDepartment(rst.getString("departmentId"));
            lecturer.setCenter(rst.getString("center"));
            lecturer.setBuilding(rst.getString("buildingId"));
            lecturer.setLevel(Integer.parseInt(rst.getString("level")));
            lecturer.setRank(rst.getString("ranks"));
            lecturers.add(lecturer);
        }
        return lecturers;
    }

    @Override
    public void deleteLecturerDetails(int id) throws SQLException {
        String sql = "delete from lecturer where employeeId LIKE '%" + id + "%'";
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
    }

    @Override
    public boolean updateLecturer(Lecturer lecturer) throws SQLException {
        lecturer.setBuilding("1");
        lecturer.setDepartment("1");
        String SQL="Update lecturer set employeeName='"+lecturer.getEmpName()+"',faculty='"+lecturer.getFaculty()+"',departmentId='"+lecturer.getDepartment()+"' ,center='"+lecturer.getCenter()+"',buildingId='"+lecturer.getBuilding()+"',level='"+lecturer.getLevel()+"'" +
                "where employeeId='"+lecturer.getEmpId()+"'";
        Statement stm=connection.createStatement();
        return stm.executeUpdate(SQL)>0;
    }
}
