package org.bowling.bowling;

public class Frame
{
    private Integer throw1;
    private Integer throw2;
    private Integer throw3;

    public Integer getThrow1()
    {
        return throw1;
    }

    public void setThrow1(Integer throw1)
    {
        this.throw1 = throw1;
    }

    public Integer getThrow2()
    {
        return throw2;
    }

    public void setThrow2(Integer throw2)
    {
        this.throw2 = throw2;
    }

    public Integer getThrow3()
    {
        return throw3;
    }

    public void setThrow3(Integer throw3)
    {
        this.throw3 = throw3;
    }

    @Override
    public String toString()
    {
        return "Frame{" +
                "throw1=" + throw1 +
                ", throw2=" + throw2 +
                ", throw3=" + throw3 +
                '}';
    }
}
