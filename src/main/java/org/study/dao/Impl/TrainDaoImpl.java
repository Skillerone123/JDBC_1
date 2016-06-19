package org.study.dao.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.study.connection.ConnectionManager;
import org.study.dao.TrainDao;
import org.study.entity.Train;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skiller on 17.06.2016.
 */
public class TrainDaoImpl implements TrainDao {
    public static final Logger LOGGER = LoggerFactory.getLogger(TrainDaoImpl.class);

    public List<Train> getAllTrains() {
        List<Train> trains = new ArrayList<Train>();
        String query = "Select * from trains;";
        try(Connection connection = new ConnectionManager().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Train train = new Train();
                train.setNumbOfTrain(rs.getInt("numb_of_train"));
                train.setName(rs.getString("name"));
                train.setDriver(rs.getString("driver"));
                train.setNumbVagon(rs.getInt("numb_vagon"));
                trains.add(train);
            }
        } catch (SQLException e) {
            LOGGER.warn("Wrong SQL!", e);
        }
        return trains;
    }

    @Override
    public void createTrain(Train train) {
        String query = "Insert into trains(numb_of_train, name, driver, numb_vagon) Values (?,?,?,?);";
        try(Connection connection = new ConnectionManager().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, train.getNumbOfTrain());
            preparedStatement.setString(2, train.getName());
            preparedStatement.setString(3, train.getDriver());
            preparedStatement.setInt(4, train.getNumbVagon());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.warn("Wrong SQL!", e);
        }
    }

    @Override
    public void deleteTrain(int numbOfTrain) {
        String query = "Delete from trains WHERE numb_of_train=?";
        try(Connection connection = new ConnectionManager().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, numbOfTrain);
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.warn("Wrong SQL!", e);
        }
    }

    @Override
    public void updateTrain(int numbOfTrain, int numbVagon) {
        String query = "Update trains SET numb_vagon=? WHERE numb_of_train=?";
        try(Connection connection = new ConnectionManager().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, numbVagon);
            preparedStatement.setInt(2, numbOfTrain);
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.warn("Wrong SQL!", e);
        }
    }
}
