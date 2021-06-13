package org.bowling.bowling;

import java.util.List;

public class Bowling {

    public static void main(String[] args)
    {
        try
        {
            List<Frame> frames = ParametersParser.parseParams(args);
            //System.out.println(frames);
            Counter counter = new Counter(frames);
            List<ScoredFrame> scoredFrames = counter.scoreFrames();
            Score score = new Score(scoredFrames);
            System.out.println(Formatter.formatScore(score));
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        System.exit(0);
    }
}
