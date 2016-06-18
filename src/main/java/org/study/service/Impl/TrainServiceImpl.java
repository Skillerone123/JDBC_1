package org.study.service.Impl;

import org.study.dao.Impl.TrainDaoImpl;
import org.study.dao.TrainDao;
import org.study.entity.Train;
import org.study.service.TrainService;

import java.util.List;

/**
 * Created by Skiller on 18.06.2016.
 */
public class TrainServiceImpl implements TrainService{

    public List<Train> getAllTrainsFromDB() {
        TrainDao trainDao = new TrainDaoImpl();
        return trainDao.getAllTrains();
    }
}
