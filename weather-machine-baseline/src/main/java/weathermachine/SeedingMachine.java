package weathermachine;

/**
 * 播种机器
 * @author Ron
 */
public class SeedingMachine extends BaseMachine{


    /**
     * 机器开始运转
     * @param temp  温度
     * @param humidity 湿度
     * @param windPower 风度
     * @return 状态
     */
    @Override
    public boolean start(int temp, int humidity, int windPower) {
        //播种机器
        return temp > NUM_5;
    }
}
