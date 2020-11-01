package bowling;

// Please don't modify the class name.
public class Bowling {
    int score;

    //如果10轮下来，最多可以扔球的次数
    int rolls[] = new int[21];
    int rollsIndex = 0;

    // Please don't modify the signature of this method.
    public void roll(int n) {
        this.rolls[rollsIndex] = n;
        this.rollsIndex++;
    }
    //如果10轮下来我们最多可以投20个球 ，
    //1 8 , 2 6,20 , 10 1 ,1个球补充

    // Please don't modify the signature of this method.
    public int getScore() {
        if(this.score != 0) {
            this.score = 0;
        }

        //中间栈栏
        boolean midFrame = false;

        //表示是不是一次10球全倒
        boolean isStrike = false;

        for(int i = 0; i < this.rollsIndex; i++) {
            if(this.rolls[i] == 10 || midFrame) {
                //如果为true，表示上一球为strike
                if(isStrike) {
                    if(midFrame) {
                            this.score += this.rolls[i] + this.rolls[i - 1];
                    } else {
                        //如果不是栈栏&如果不是倒数第二个，说明这一轮滚了2次
                        if(i != this.rollsIndex - 3) {
                            //总共12个球分，前面10个球分的时候才会+1
                            this.score += this.rolls[i] + this.rolls[i + 1];
                        }else{
                            midFrame = true;
                        }
                    }
                    isStrike = false;
                }

                //当前球为strike，且不是中间栏
                if(this.rolls[i] == 10 && !midFrame) {
                    this.score += this.rolls[i];
                    isStrike = true;
                } else {
                    //就是spare
                    if((this.rolls[i-1] + this.rolls[i] == 10) && midFrame){
                        if(i != this.rollsIndex - 1) {
                            this.score += this.rolls[i + 1];
                        }
                    }

                    //要么是不等于10，要么是中间栏
                    this.score += this.rolls[i] + this.rolls[i-1];
                    if (midFrame) {
                        midFrame = false;
                    }
                }
            } else {
                //标志栈栏为ture
                midFrame = true;
            }
        }
        return this.score;
    }
}
