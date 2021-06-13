package org.bowling.bowling;

public class ScoredFrame extends Frame
{
    public ScoredFrame(Frame frame)
    {
        this.setThrow1(frame.getThrow1());
        this.setThrow2(frame.getThrow2());
        this.setThrow3(frame.getThrow3());
    }

    private int index;
    private int score;
    private int totalScore;
    private boolean strike;
    private boolean spare;
    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getTotalScore()
    {
        return totalScore;
    }

    public void setTotalScore(int totalScore)
    {
        this.totalScore = totalScore;
    }

    public boolean isStrike()
    {
        return strike;
    }

    public void setStrike(boolean strike)
    {
        this.strike = strike;
    }

    public boolean isSpare()
    {
        return spare;
    }

    public void setSpare(boolean spare)
    {
        this.spare = spare;
    }
}
