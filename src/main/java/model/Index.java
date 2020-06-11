package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Index
{
    private int i;
    private int j;

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Index index = (Index) o;
        return i == index.i &&
                j == index.j;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(i, j);
    }
}
