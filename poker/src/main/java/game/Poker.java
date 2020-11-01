package game;

import java.util.*;

// Please don't modify the class name.
public class Poker {

    // Please don't modify the signature of this method.
    // Please keep the result output format.
    public String compairResult(String player1, String player2) {
        String winResult = "";

        String player1Type = judgeType(player1);
        String player2Type = judgeType(player2);
        String[] type = {"StraightFlush", "FourOfAKind", "FullHouse", "Flush", "Straight", "ThreeOfAKind", "TwoPair", "OnePair", "HighCard"};
        int[] player1Number = strNumber(player1);
        int[] player2Number = strNumber(player2);
        int player1Index = judgeIndex(player1Type);
        int player2Index = judgeIndex(player2Type);
        int[] player1ArraySort = arraySort(player1Number);
        int[] player2ArraySort = arraySort(player2Number);
        int[] player1Repeat = noOrRepeatNumber(player1Number, 0);
        int[] player2Repeat = noOrRepeatNumber(player2Number, 0);
        int[] player1NoRepeat = noOrRepeatNumber(player1Number, 1);
        int[] player2NoRepeat = noOrRepeatNumber(player2Number, 1);

        if (player1Index < player2Index) {
            winResult = "player1 wins - " + type[player1Index];
        } else if (player1Index > player2Index) {
            winResult = "player2 wins - " + type[player2Index];
        } else {
            if (player1Index == 0) {//同花顺
                if (player1Number[0] < player2Number[0]) {
                    String sig = intNumber(player2Number[0]);
                    winResult = "player2 wins - high card:" + sig;
                } else if (player1Number[0] > player2Number[0]) {
                    String sig = intNumber(player1Number[0]);
                    winResult = "player1 wins - high card:" + sig;
                } else {
                    winResult = "tie";
                }
            } else if (player1Index == 1) {//铁支
                if (player1ArraySort[0] < player2ArraySort[0]) {
                    String sig = intNumber(player2ArraySort[0]);
                    winResult = "player2 wins - high card:" + sig;
                } else {
                    String sig = intNumber(player1ArraySort[0]);
                    winResult = "player1 wins - high card:" + sig;
                }
            } else if (player1Index == 2) {//葫芦
                if (player1ArraySort[0] < player2ArraySort[0]) {
                    String sig = intNumber(player2ArraySort[0]);
                    winResult = "player2 wins - high card:" + sig;
                } else {
                    String sig = intNumber(player1ArraySort[0]);
                    winResult = "player1 wins - high card:" + sig;
                }
            } else if (player1Index == 3) {//同花
                for (int i = 0; i < 5; i++) {
                    if (player1Number[i] < player2Number[i]) {
                        String sig = intNumber(player2Number[i]);
                        winResult = "player2 wins - high card:" + sig;
                        break;
                    } else if (player1Number[i] > player2Number[i]) {
                        String sig = intNumber(player1Number[i]);
                        winResult = "player1 wins - high card:" + sig;
                        break;
                    } else {
                        winResult = "tie";
                    }
                }
            } else if (player1Index == 4) {//顺子
                if (player1Number[0] < player2Number[0]) {
                    String sig = intNumber(player2Number[0]);
                    winResult = "player2 wins - high card:" + sig;
                } else if (player1Number[0] > player2Number[0]) {
                    String sig = intNumber(player1Number[0]);
                    winResult = "player1 wins - high card:" + sig;
                } else {
                    winResult = "tie";
                }
            } else if (player1Index == 5) {//三条
                if (player1Repeat[0] < player2Repeat[0]) {
                    String sig = intNumber(player2Repeat[0]);
                    winResult = "player2 wins - high card:" + sig;
                } else {
                    String sig = intNumber(player1Repeat[0]);
                    winResult = "player1 wins - high card:" + sig;
                }
            } else if (player1Index == 6) {//两对
                for (int i = 0; i < 2; i++) {
                    if (player1Repeat[i] < player2Repeat[i]) {
                        String sig = intNumber(player2Repeat[i]);
                        winResult = "player2 wins - high card:" + sig;
                        break;
                    } else if (player1Repeat[i] > player2NoRepeat[i]) {
                        String sig = intNumber(player1Repeat[i]);
                        winResult = "player1 wins - high card:" + sig;
                        break;
                    }
                }
                if (winResult == "") {
                    if (player1NoRepeat[0] < player2NoRepeat[0]) {
                        String sig = intNumber(player2NoRepeat[0]);
                        winResult = "player2 wins - high card:" + sig;
                    } else if (player1NoRepeat[0] > player2NoRepeat[0]) {
                        String sig = intNumber(player1NoRepeat[0]);
                        winResult = "player1 wins - high card:" + sig;
                    } else {
                        winResult = "tie";
                    }
                }
            } else if (player1Index == 7) {//对子
                if (player1Repeat[0] < player2Repeat[0]) {
                    String sig = intNumber(player2Repeat[0]);
                    winResult = "player2 wins - high card:" + sig;
                } else if (player1Repeat[0] > player2Repeat[0]) {
                    String sig = intNumber(player1Repeat[0]);
                    winResult = "player1 wins - high card:" + sig;
                } else {
                    for (int i = 0; i < 3; i++) {
                        if (player1NoRepeat[i] < player2NoRepeat[i]) {
                            String sig = intNumber(player2NoRepeat[i]);
                            winResult = "player2 wins - high card:" + sig;
                            break;
                        } else if (player1NoRepeat[i] > player2NoRepeat[i]) {
                            String sig = intNumber(player1NoRepeat[i]);
                            winResult = "player1 wins - high card:" + sig;
                            break;
                        } else {
                            winResult = "tie";
                        }
                    }
                }
            } else {//散牌
                for (int i = 0; i < 5; i++) {
                    if (player1Number[i] < player2Number[i]) {
                        String sig = intNumber(player2Number[i]);
                        winResult = "player2 wins - high card:" + sig;
                        break;
                    } else if (player1Number[i] > player2Number[i]) {
                        String sig = intNumber(player1Number[i]);
                        winResult = "player1 wins - high card:" + sig;
                        break;
                    } else {
                        winResult = "tie";
                    }
                }
            }
        }
        return winResult;
    }

    private String intNumber(int i) {
        String[] strNumber = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        return strNumber[i - 2];
    }

    private int[] arraySort(int[] number) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < number.length; i++) {
            if (map.get(number[i]) != null) {
                map.put(number[i], map.get(number[i]) + 1);
            } else {
                map.put(number[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>();
        list.addAll(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> arg0, Map.Entry<Integer, Integer> arg1) {
                return arg1.getValue().compareTo(arg0.getValue());
            }
        });
        int[] arrayresult = new int[list.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            arrayresult[i] = entry.getKey();
            i++;
        }
        return arrayresult;
    }

    private int[] noOrRepeatNumber(int[] number, int flag) {//先获得数组中每个元素出现的次数，然后再进行计算出现次数大于1的和出现次数等于1的
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < number.length; i++) {
            if (map.get(number[i]) != null) {
                map.put(number[i], map.get(number[i]) + 1);
            } else {
                map.put(number[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>();
        list.addAll(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> arg0, Map.Entry<Integer, Integer> arg1) {
                return arg1.getValue().compareTo(arg0.getValue());
            }
        });
        int[] repeatnumber = new int[list.size()];
        int[] norepeatnumber = new int[list.size()];
        int i = 0;
        if (flag == 0) {
            for (Map.Entry<Integer, Integer> entry : list) {
                if (entry.getValue() > 1) {
                    repeatnumber[i] = entry.getKey();
                    i++;
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : list) {
                if (entry.getValue() == 1) {
                    norepeatnumber[i] = entry.getKey();
                    i++;
                }
            }
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        if (flag == 0) {
            for (i = 0; i < repeatnumber.length; i++) {
                hashSet.add(repeatnumber[i]);
            }
        } else {
            for (i = 0; i < norepeatnumber.length; i++) {
                hashSet.add(norepeatnumber[i]);
            }
        }
        hashSet.remove(0);
        int[] result = new int[hashSet.size()];
        i = 0;
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            result[i] = iterator.next();
            i++;
        }
        int[] reResult = new int[result.length];
        for (i = 0; i < result.length; i++) {
            reResult[i] = result[result.length - i - 1];
        }
        return reResult;
    }

    private int judgeIndex(String strType) {
        int index = -1;
        String[] type = {"StraightFlush", "FourOfAKind", "FullHouse", "Flush", "Straight", "ThreeOfAKind", "TwoPair", "OnePair", "HighCard"};
        for (int i = 0; i < 9; i++) {
            if (type[i].equals(strType)) {
                index = i;
            }
        }
        return index;
    }

    private String judgeType(String str) {//判断是什么牌
        String type = "";
        String[] strArray = str.split("");
        int[] number = strNumber(str);
        int i;
        String[] color = new String[5];
        for (i = 0; i < 5; i++) {
            color[i] = strArray[i * 3 + 1];
        }
        HashSet<Integer> hashSetNumber = new HashSet<Integer>();
        for (i = 0; i < 5; i++) {
            hashSetNumber.add(number[i]);
        }
        HashSet<String> hashSetType = new HashSet<String>();
        for (i = 0; i < 5; i++) {
            hashSetType.add(color[i]);
        }
        if (hashSetNumber.size() == 5) {
            if ((number[0] - number[4] == 4) && (hashSetType.size() == 1)) {//五个相邻的数字且花色一样——同花顺
                type = "StraightFlush";
            } else if (number[0] - number[4] == 4 ) {//五个相邻数字——顺子
                type = "Straight";
            } else if (hashSetType.size() == 1) {//同一花色——同花
                type = "Flush";
            } else {//五个不相邻的数字——散牌
                type = "HighCard";
            }
        } else if (hashSetNumber.size() == 4) {//一对相同，其余三个数字不同——对子
            type = "OnePair";
        } else if (hashSetNumber.size() == 3) {
            if ((number[0] == number[1] && number[2] == number[3]) || (number[1] == number[2] && number[3] == number[4]) || (number[0] == number[1] && number[3] == number[4])) {//两对
                type = "TwoPair";
            } else {//三个数字相同，另外两个数字不同——三条
                type = "ThreeOfAKind";
            }
        } else {
            if (number[0] != number[1] || number[3] != number[4]) {//四个数字相同——铁支
                type = "FourOfAKind";
            } else {//三个数字相同，另外两个数字相同——葫芦
                type = "FullHouse";
            }
        }
        return type;
    }

    private int[] strNumber(String str) {//数字转化并将其从大到小排序
        int[] number = new int[5];
        String[] strArray = str.split("");
        int i;
        for (i = 0; i < 5; i++) {
            String c = strArray[i * 3];
            switch (c) {
                case "T":
                    number[i] = 10;
                    break;
                case "J":
                    number[i] = 11;
                    break;
                case "Q":
                    number[i] = 12;
                    break;
                case "K":
                    number[i] = 13;
                    break;
                case "A":
                    number[i] = 14;
                    break;
                default:
                    number[i] = Integer.valueOf(c);
                    break;
            }
        }

        Arrays.sort(number);
        int[] renumber = new int[number.length];
        for (i = 0; i < number.length; i++) {
            renumber[i] = number[number.length - i - 1];
        }
        return renumber;
    }
}
