package bowling;

// Please don't modify the class name.
public class Bowling {
    int score;
    int rolls[] = new int[21];
    int rollsIndex = 0;

    // Please don't modify the signature of this method.
    public void roll(int n) {
        this.rolls[rollsIndex] = n;
        this.rollsIndex++;
    }

    // Please don't modify the signature of this method.
    public int getScore() {
        if(this.score != 0) {
            this.score = 0;
        }

        boolean midFrame = false;
        boolean isStrike = false;

        for(int i = 0; i < this.rollsIndex; i++) {
            if(this.rolls[i] == 10 || midFrame) {
                if(isStrike) {
                    if(midFrame) {
                            this.score += this.rolls[i] + this.rolls[i - 1];
                    } else {
                        if(i != this.rollsIndex - 1) {
                            this.score += this.rolls[i] + this.rolls[i + 1];
                        }
                    }
                    isStrike = false;
                }

                if(this.rolls[i] == 10 && !midFrame) {
                    this.score += this.rolls[i];
                    isStrike = true;
                } else {
                    if((this.rolls[i-1] + this.rolls[i] == 10) && midFrame){
                        if(i != this.rollsIndex - 1) {
                            this.score += this.rolls[i + 1];
                        }
                    }
                    this.score += this.rolls[i] + this.rolls[i-1];
                    if (midFrame) {
                        midFrame = false;
                    }
                }
            } else {
                    midFrame = true;
            }
        }
        return this.score;
    }
}
