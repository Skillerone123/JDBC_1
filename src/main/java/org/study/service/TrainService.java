package org.study.service;

import org.study.entity.Train;

import java.util.List;

/**
 * Created by Skiller on 18.06.2016.
 */
public interface TrainService {

    List<Train> getAllTrainsFromDB();
    void createTrain(Train train);
    void deleteTrain(int numbOfTrain);
    void updateTrain(int numbOfTrain, int numbVagon);
    void parseQuery(String query);
}
