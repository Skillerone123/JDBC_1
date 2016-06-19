package org.study.service.Impl;

import org.study.dao.Impl.TrainDaoImpl;
import org.study.dao.TrainDao;
import org.study.entity.Train;
import org.study.service.TrainService;

import java.util.List;

/**
 * Created by Skiller on 18.06.2016.
 */
public class TrainServiceImpl implements TrainService {

    public List<Train> getAllTrainsFromDB() {
        TrainDao trainDao = new TrainDaoImpl();
        return trainDao.getAllTrains();
    }

    @Override
    public void createTrain(Train train) {
        TrainDao trainDao = new TrainDaoImpl();
        trainDao.createTrain(train);
    }

    @Override
    public void deleteTrain(int numbOfTrain) {
        TrainDao trainDao = new TrainDaoImpl();
        trainDao.deleteTrain(numbOfTrain);
    }

    @Override
    public void updateTrain(int numbOfTrain, int numbVagon) {
        TrainDao trainDao = new TrainDaoImpl();
        trainDao.updateTrain(numbOfTrain, numbVagon);
    }

    @Override
    public void parseQuery(String query) {
        String firstWord = "";
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == ' ') break;
            else {
                firstWord += query.charAt(i);
            }
        }
        switch (firstWord.toUpperCase()) {
            case "SELECT":
                getAllTrainsFromDB();
                break;
            case "INSERT": {
                String par1 = "";
                String par2 = "";
                String par3 = "";
                String par4 = "";
                String query2 = "";
                for (int i = query.indexOf('(') + 1; i < query.indexOf(')'); i++) {
                    query2 += query.charAt(i);
                }
                for (int i = 0; i < query2.indexOf(','); i++) {
                    par1 += query2.charAt(i);
                }
                query2 = query2.substring(par1.length() + 1);
                for (int i = 0; i < query2.indexOf(','); i++) {
                    par2 += query2.charAt(i);
                }
                query2 = query2.substring(par2.length() + 1);
                for (int i = 0; i < query2.indexOf(','); i++) {
                    par3 += query2.charAt(i);
                }
                query2 = query2.substring(par3.length() + 1);
                par4 = query2;

                Train newtrain = new Train(Integer.parseInt(par1), par2, par3, Integer.parseInt(par4));
                createTrain(newtrain);
                break;
            }
            case "DELETE": {
                String par1 = "";
                for (int i = query.indexOf('=') + 1; i < query.length() - 1; i++) {
                    par1 += query.charAt(i);
                }
                deleteTrain(Integer.parseInt(par1));
                break;
            }
            case "UPDATE": {
                String par1 = "", par2 = "";
                for (int i = query.indexOf('=') + 1; i < query.indexOf(' ', query.indexOf('=')); i++) {
                    par1 += query.charAt(i);
                }
                for (int i = query.lastIndexOf('=') + 1; i < query.length() - 1; i++) {
                    par2 += query.charAt(i);
                }
                updateTrain(Integer.parseInt(par2), Integer.parseInt(par1));
                break;
            }
        }
    }
}
