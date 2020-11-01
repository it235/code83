package weathermachine;

import java.util.List;

/**
 * 天气数据类
 * @author Ron
 */
public class WeatherData {

    //订阅者列表
    List<BaseMachine> machineList = null;


    public WeatherData(List<BaseMachine> machineList){
        this.machineList = machineList;
    }

    /**
     *
     * @param temp 温度
     * @param humidity 湿度
     * @param windPower 风
     */
    public void measurementsChanged(int temp, int humidity, int windPower) {
        //你需要将你的情况告诉每一个关注你的用户
        //一堆机器在看着你，你做的每一步操作都要告诉给一个订阅列表
        for (BaseMachine baseMachine : machineList) {
            baseMachine.watch(temp,humidity,windPower);
        }

    }
}
