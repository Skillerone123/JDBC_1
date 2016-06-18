package org.study.dao.Impl;

import org.study.connection.ConnectionManager;
import org.study.dao.TrainDao;
import org.study.entity.Train;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skiller on 17.06.2016.
 */
public class TrainDaoImpl implements TrainDao {

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
            e.printStackTrace();
        }
        return trains;
    }
}
