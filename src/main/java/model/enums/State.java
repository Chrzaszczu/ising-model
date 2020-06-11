package model.enums;

public enum State
{
    UP(1),
    DOWN(-1);

    private int value;

    State(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
