package main.service.impl;

import main.dbconnection.DBConnection;
import main.model.Building;
import main.model.Department;
import main.service.BuildingService;

import java.sql.*;
import java.util.ArrayList;

public class BuildingServiceImpl implements BuildingService {
    private Connection connection;
    static String buldingName;
    public BuildingServiceImpl() {
        connection = DBConnection.getInstance().getConnection();
    }

    @Override
    public ArrayList<Building> searchBuildingDetailsByCenter(String center) throws SQLException {
        System.out.println(center);
        String SQL = "Select * from building where center LIKE '%" + center + "%'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<Building> buildingsList = new ArrayList<>();
        while(rst.next()){
            Building building= new Building(Integer.parseInt(rst.getString("bid")),
                    rst.getString("building"),rst.getString("center"));
            buildingsList.add(building);
        }
        return buildingsList;
    }

    @Override
    public String searchBuildingName(int id) throws SQLException {
        String SQL = "select building  from building where bId = '" + id + "' ";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);

        while(rst.next()) {

            buldingName=rst.getString("building");
            System.out.println(buldingName);
        }
        return buldingName;
    }



    @Override
    public boolean saveBuildings(Building building) throws SQLException {

        String SQL = "Insert into building Values(?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, 0);
        stm.setObject(2, building.getCenter());
        stm.setObject(3, building.getBuilding());

        int res = stm.executeUpdate();
        return res > 0;

    }

    @Override
    public boolean searchBuilding(String center, String building) throws SQLException {

        String SQL = "select bid from building where center = '" + center + "' " +
                "&& building='" + building + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        boolean result = false;
        if (rst.next()) {
            if (rst.getString("bid") != null) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;

    }

    @Override
    public ArrayList<Building> getAllDetails() throws SQLException {
        String SQL ="Select * from building";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<Building> buildingList = new ArrayList<>();
        while(rst.next()){
            Building buildingRows = new Building(Integer.parseInt(rst.getString("bid")),
                    rst.getString("building"),
                    rst.getString("center"));
            buildingList.add(buildingRows);
        }
        return buildingList;
    }

    @Override
    public boolean deleteBuilding(int key) throws SQLException {
        String SQL = "Delete From building where bid = '"+key+"'";
        Statement stm = connection.createStatement();
        return stm.executeUpdate(SQL)>0;
    }

    @Override
    public boolean updateBuildingDetails(Building building12) throws SQLException {
        String SQL="Update building set center='"+building12.getCenter()+"'," +
                "building='"+building12.getBuilding()+"'  " +
                "where bid='"+building12.getBid()+"'";
        Statement stm=connection.createStatement();
        return stm.executeUpdate(SQL)>0;
    }

    @Override
    public ArrayList<Building> searchBuildingDetailsByUsingCenter(String center) throws SQLException {
        String SQL = " Select * from building where center LIKE '%" + center + "%'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);

        ArrayList<Building> buildingsList = new ArrayList<>();

        while(rst.next()){
            Building building= new Building(Integer.parseInt(rst.getString("bid")),
                    rst.getString("building"),
                    rst.getString("center"));
            buildingsList.add(building);
        }
        return buildingsList;
    }

    @Override
    public ArrayList<Building> getAllAllRoomDetails() throws SQLException {
        String SQL ="Select * from building";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<Building> buildings = new ArrayList<>();
        while(rst.next()){
            Building r1 = new Building(Integer.parseInt(rst.getString("bid")),
                    rst.getString("building"),
                    rst.getString("center"));
            buildings.add(r1);
        }
        return buildings;
    }

    @Override
    public ArrayList<Building> getAllDetailsForSearch(String bcenter, String bbuilding) throws SQLException {
        String buildingsql = "";
        String centerSql = "";

        Statement stm = null;
        String SQL = "";


        ArrayList<Building> buildingA = new ArrayList<>();
        try {
            stm = connection.createStatement();

            if(bbuilding == null && bcenter == null ) {
                 SQL = "select * " +
                        "from building ";
            }

            if (bbuilding != null) {
                buildingsql = " building LIKE '%" + bbuilding + "%'";
                SQL = "select * " +
                        "from building "+
                "where "+buildingsql;
            }
            if (bcenter != null) {
                centerSql = " center LIKE '%" + bcenter + "%'";
                SQL = "select * " +
                        "from building "+
                        "where "+centerSql;
            }


            ResultSet rst = stm.executeQuery(SQL);
            while(rst.next()){
                Building building = new Building(Integer.parseInt(rst.getString("bid")),
                        rst.getString("building"),
                        rst.getString("center"));
                buildingA.add(building);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return buildingA;
    }

}
