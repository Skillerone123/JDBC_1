package org.study.dao;

import org.study.entity.Train;

import java.util.List;

/**
 * Created by Skiller on 17.06.2016.
 */
public interface TrainDao {

    List<Train> getAllTrains();
    void createTrain(Train train);
    void deleteTrain(int numbOfTrain);
    void updateTrain(int numbOfTrain, int numbVagon);
}
