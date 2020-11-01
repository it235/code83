package test;

import weathermachine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: jianjun.ren
 * @date: Created in 2020/11/1 20:25
 */
public class Test {

    public static void main(String[] args) {
        BaseMachine seedingMachine = new SeedingMachine();
        BaseMachine reapingMachine = new ReapingMachine();
        BaseMachine wateringMachine = new WateringMachine();

        List<BaseMachine> machineList = new ArrayList<>();
        machineList.add(seedingMachine);
        machineList.add(reapingMachine);
        machineList.add(wateringMachine);

        WeatherData weatherData = new WeatherData(machineList);
        int temp = 28;
        int humidity = 43;
        int windPower = 2;
        weatherData.measurementsChanged(temp , humidity , windPower);
        System.out.println("播种：" + seedingMachine.getStatus());
        System.out.println("浇水：" + wateringMachine.getStatus());
        System.out.println("收获：" + reapingMachine.getStatus());
    }

}
