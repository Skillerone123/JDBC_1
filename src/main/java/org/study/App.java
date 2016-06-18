package org.study;

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
        System.out.println(trainService.getAllTrainsFromDB());
    }
}
