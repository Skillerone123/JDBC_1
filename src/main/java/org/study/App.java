package org.study;

import org.study.entity.Train;
import org.study.service.Impl.TrainServiceImpl;
import org.study.service.TrainService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TrainService trainService = new TrainServiceImpl();
        for (Train train : trainService.getAllTrainsFromDB()) {
            System.out.println(train);
        }
        Train newtrain = new Train(34, "Dalekiy", "Viktor", 18);
        trainService.createTrain(newtrain);
        System.out.println("Added train!");
        for (Train train : trainService.getAllTrainsFromDB()) {
            System.out.println(train);
        }
        trainService.deleteTrain(34);
        System.out.println("Deleted train!");
        for (Train train : trainService.getAllTrainsFromDB()) {
            System.out.println(train);
        }
        trainService.updateTrain(48, 44);
        System.out.println("Updated train!");
        for (Train train : trainService.getAllTrainsFromDB()) {
            System.out.println(train);
        }
    }
}
