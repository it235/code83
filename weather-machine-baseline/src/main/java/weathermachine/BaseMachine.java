package weathermachine;

/**
 * @description: 观察者抽象类，或者交抽象观察者 抽象机器
 * @author: jianjun.ren
 * @date: Created in 2020/11/1 20:34
 */
public abstract class BaseMachine {

    /**
     * 数字
     */
    public final static int NUM_4 = 4;
    public final static int NUM_5 = 5;
    public final static int NUM_55 = 55;
    public final static int NUM_10 = 10;
    public final static int NUM_65 = 65;
    /**
     * 状态
     */
    protected boolean status;

    /**
     * 获取一个当前机器的状态
     * @return 返回一个值
     */
    public boolean getStatus(){
        return status;
    }

    /**
     * 通知观察者
     * @param temp 温度
     * @param humidity 湿度
     * @param windPower 风度
     */
    public void watch(int temp, int humidity, int windPower){
        if(start(temp , humidity , windPower)){
            this.status = true;
        }
    }

    /**
     * 机器开始运转
     * @param temp  温度
     * @param humidity 湿度
     * @param windPower 风度
     * @return 状态
     */
    abstract boolean start(int temp, int humidity, int windPower);

}
