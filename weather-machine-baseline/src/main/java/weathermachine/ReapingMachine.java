package weathermachine;

/**
 * 收获的机器
 * 收获的机器以前只做收获这件事情，但是现在，他需要自己去根据收到的消息去判断做不做
 * @author Ron
 */
public class ReapingMachine extends BaseMachine{


    /**
     * 机器开始运转
     * @param temp  温度
     * @param humidity 湿度
     * @param windPower 风度
     * @return 状态
     */
    @Override
    public boolean start(int temp, int humidity, int windPower) {
        //收获
        return temp > NUM_5 && humidity > NUM_65;
    }
}