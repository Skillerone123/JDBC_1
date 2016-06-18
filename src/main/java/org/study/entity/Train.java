package org.study.entity;

/**
 * Created by Skiller on 17.06.2016.
 */
public class Train {

    private int numbOfTrain;

    private String name;

    private String driver;

    private int numbVagon;

    public Train() {
    }

    public Train(int numbOfTrain, String name, String driver, int numbVagon) {
        this.numbOfTrain = numbOfTrain;
        this.name = name;
        this.driver = driver;
        this.numbVagon = numbVagon;
    }

    public int getNumbOfTrain() {
        return numbOfTrain;
    }

    public void setNumbOfTrain(int numbOfTrain) {
        this.numbOfTrain = numbOfTrain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getNumbVagon() {
        return numbVagon;
    }

    public void setNumbVagon(int numbVagon) {
        this.numbVagon = numbVagon;
    }

    @Override
    public String toString() {
        return "Train{" +
                "numbOfTrain=" + numbOfTrain +
                ", name='" + name + '\'' +
                ", driver='" + driver + '\'' +
                ", numbVagon=" + numbVagon +
                '}';
    }
}
