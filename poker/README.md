哇再次恭喜你完成83行代码重构大师赛第2关密封舱重启，来到了第3关能量舱！

能量舱会有一些小挑战。它的性能通过德州扑克判大小的系统控制。

你的任务：重构德州扑克判大小的系统，以实现能量舱重启。
完成该任务即可重启能量舱，拿到歼星舰长能量水晶，还有机会抽取CHERRY机械键盘（限量1份）+CHERRY创意释压指尖轴（限量500份）。

德州扑克规则：
1. 使用52张扑克（去掉大小王），分为四个花色（红桃H，方块D，黑桃S，梅花C），每个花色13张牌，依次从 2 到 A。J，Q，K，A分别对应为11，12，13，14（A只作为14）。游戏过程玩家各随机抽取5张牌，比大小。 
2. 所有牌型如下：
* 同花顺(StraightFlush)：同一花色的顺子。（最大牌：A-K-Q-J-10 最小牌：2-3-4-5-6）  
* 四条(FourOfAKind)：四同张加单张。（最大牌：A-A-A-A-K 最小牌：2-2-2-2-3）  
* 葫芦(FullHouse)：三同张加对子。（最大牌：A-A-A-K-K 最小牌：2-2-2-3-3）
* 同花(Flush)：同一花色。（最大牌：A-K-Q-J-9 最小牌：2-3-4-5-7）
* 顺子(Straight)：花色不一样的顺子。（最大牌：A-K-Q-J-10 最小牌：2-3-4-5-6）
* 三条(ThreeOfAKind)：三同张加两单张。（最大牌：A-A-A-K-Q 最小牌：2-2-2-3-4）
* 两对(TwoPair)：（最大牌：A-A-K-K-Q 最小牌：2-2-3-3-4）
* 一对(OnePair)：（最大牌：A-A-K-Q-J 最小牌：2-2-3-4-5）
* 单牌(HighCard)：（最大牌：A-K-Q-J-9 最小牌：2-3-4-5-7） 
3. 牌型大小：
* 同花顺(StraightFlush) > 四条(FourOfAKind) > 葫芦(FullHouse) > 同花(Flush) > 顺子(Straight) > 三条(ThreeOfAKind) > 两对(TwoPair) > 一对(OnePair) > 单牌（HighCard）
* 牌点从大到小为：A、K、Q、J、10、9、8、7、6、5、4、3、2，各花色不分大小。   
* 同种牌型，对子时比对子的大小，其它牌型比最大的牌张，如最大牌张相同则比第二大的牌张，以此类推，都相同时为平手。
* 例：  
"3H 6H 2H 4H 5H" > "8S 8D 8H JH 8C"   
"2S 2D 2H 4H 4C" > "3S 2D 6C 4H 5H"  
"2S 2D 4C 4H 6C" = "2H 2C 4D 4S 6D"   
4. 比较程序输入2个玩家的牌，并返回比较结果。
*  会以字符串形式输入玩家的牌，如 "3H 6H TH 4H AH"。每张牌由：牌点+花色 组成。10、11、12、13、14 分别用 T、J、Q、K、A 表示。
* 输出格式：(请保证输出的内容符合格式要求，会用于单元测试做比较)
    * 牌型不同时：[player1/player2] wins - [牌型]；例：player1："3H 6H 2H 4H 5H"，player2："8S 8D 8H JH 8C"。输出：player1 wins - StraightFlush
    * 牌型相同时：[player1/player2] wins - high card:[牌点]；例：player1："3H 6H 2H 4H 5H"，player2："8D 9D TD JD QD"。输出：player2 wins - high card:Q
    * 平手时：输出：tie

### 注意：
后台会运行若干单测来验证程序的正确性，请不要修改提示了不允许修改的类或者方法的签名，以保证测试的正常运行。例如以下提示：     
// Please don't modify the signature of this method.   
// Please don't modify the class name.  
