package org.bowling.bowling;

public class Formatter
{
    public static String formatScoredFrame(ScoredFrame frame, boolean unfinished)
    {
        String ret = frame.getIndex() + ": " ;
        if(frame.getThrow1() == 10)
        {
            ret += "X";
        }
        else if(frame.getThrow1() == 0)
        {
            ret += "-";
        }
        else
        {
            ret += frame.getThrow1().toString();
        }
        if(frame.getThrow2() != null)
        {
            if(frame.getThrow2() == 10)
            {
                ret += ", X";
            }
            else if (frame.getThrow2() == 0)
            {
                ret += ", -";
            }
            else if (frame.getThrow1() + frame.getThrow2() == 10)
            {
                ret += ", /";
            }
            else
            {
                ret += ", " + frame.getThrow2().toString();
            }
        }
        if(frame.getThrow3() != null)
        {
            if(frame.getThrow3() == 10)
            {
                ret += ", X";
            }
            else if(frame.getThrow3() == 0)
            {
                ret += ", -";
            }
            else
            {
                ret += ", " + frame.getThrow3().toString();
            }

        }
        ret += " = ";
        if(frame.isSpare() || frame.isStrike())
        {
            ret += unfinished ? "-" : frame.getTotalScore();
        }
        else
        {
            ret += frame.getTotalScore();
        }
        return ret;
    }

    public static String formatScore(Score score)
    {
        String ret = "";
        for(int i = 0; i < score.getFrames().size(); i++)
        {
            ScoredFrame frame = score.getFrames().get(i);
            ret += formatScoredFrame(frame, i == score.getFrames().size() - 1) + "\n";
        }
        ret += "---------\n";
        ret += score.getFrames().get(score.getFrames().size() - 1).getTotalScore();
        return ret;
    }
}
