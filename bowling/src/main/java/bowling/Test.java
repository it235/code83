package bowling;

/**
 * @description:
 * @author: jianjun.ren
 * @date: Created in 2020/11/1 22:16
 */
public class Test {
    public static void main(String[] args) {
        //默认程序有bug
        String str1 = "10 10 10 10 10 10 10 10 10 10 10 10";
        String[] s = str1.split(" ");
        Bowling bowling = new Bowling();
        for (String t : s) {
            bowling.roll(Integer.parseInt(t));
        }
        int score = bowling.getScore();
        System.out.println(score);
    }
}
