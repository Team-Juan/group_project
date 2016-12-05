package Model.datastore.mysql;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Computer;
import Model.IComputerDAO;

public class ComputerDAO implements IComputerDAO {

	protected final static boolean DEBUG = true;

    @Override
    public void createData(Computer computer) {
        final String QUERY = "insert into computer "
                + "(compId, brand, model, features, location) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY);) {
        	stmt.setInt(1, computer.getCompId());
            stmt.setString(2, computer.getBrand());
            stmt.setString(3, computer.getModel());
            stmt.setString(4, computer.getFeatures());
            stmt.setString(5, computer.getLocation());
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("createRecord SQLException: " + ex.getMessage());
        }
    }
    
    @Override
    public List<Computer> searchData(String field, String search) {
    	final List<Computer> myList = new ArrayList<>();
    	final String QUERY = "SELECT * FROM computer WHERE " + field + " LIKE " + "'%" + search + "%'";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                myList.add(new Computer(
                        rs.getInt("compId"), 
                        rs.getString("brand"), 
                        rs.getString("model"),
                        rs.getString("features"), 
                        rs.getString("location")));
            }
        } catch (SQLException ex) {
            System.out.println("searchData SQLException: " + ex.getMessage());
        }

        return myList;
    }

    @Override
    public Computer retrieveDataById(int id) {
        final String QUERY = "select compId, brand, model, features, "
                + "location from computer where compId = " + id;
        Computer comp = null;

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            if (rs.next()) {
                comp = new Computer(
                        rs.getInt("compId"), 
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("features"), 
                        rs.getString("location"));
            }
        } catch (SQLException ex) {
            System.out.println("retrieveDataById SQLException: " 
                    + ex.getMessage());
        }

        return comp;
    }

    @Override
    public List<Computer> retrieveAllData() {
        final List<Computer> myList = new ArrayList<>();
        final String QUERY = "select compId, brand, model, features, "
                + "location from computer";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                myList.add(new Computer(
                        rs.getInt("compId"), 
                        rs.getString("brand"), 
                        rs.getString("model"),
                        rs.getString("features"), 
                        rs.getString("location")));
            }
        } catch (SQLException ex) {
            System.out.println("retrieveAllData SQLException: " + ex.getMessage());
        }

        return myList;
    }

    @Override
    public void updateData(Computer updatedComputer) {
        final String QUERY = "update computer set brand=?, model=?, "
                + "features=?, location=? where compId=?";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            stmt.setString(1, updatedComputer.getBrand());
            stmt.setString(2, updatedComputer.getModel());
            stmt.setString(3, updatedComputer.getFeatures());
            stmt.setString(4, updatedComputer.getLocation());
            stmt.setInt(5, updatedComputer.getCompId());
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("updateData SQLException: " + ex.getMessage());
        }
    }

    @Override
    public void deleteData(int id) {
        final String QUERY = "delete from computer where compId = ?";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            stmt.setInt(1, id);
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("deleteData SQLException: " + ex.getMessage());
        }
    }

    @Override
    public void deleteData(Computer computer) {
        final String QUERY = "delete from computer where compId = ?";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            stmt.setInt(1, computer.getCompId());
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("deleteData SQLException: " + ex.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Computer computer : retrieveAllData()) {
            sb.append(computer.toString()).append("\n");
        }

        return sb.toString();
    }
}
