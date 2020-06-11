package controller.lattice;

import model.Index;
import model.Spin;
import model.enums.GenerationType;
import model.enums.State;

import java.util.LinkedList;
import java.util.List;

public abstract class LatticeObtainer
{
    public static List<Spin> obtainLattice(GenerationType generator, int size)
    {
        switch(generator)
        {
            case RANDOM: return generateRandomLattice(size);
        }

        throw new IllegalArgumentException("unsupported generator type!");
    }

    private static List<Spin> generateRandomLattice(int size)
    {
        List<Spin> spins= new LinkedList<>();

        for(int i = 0; i < size; ++i)
        {
            for(int j = 0; j < size; ++j)
            {
                spins.add(new Spin(rollState(), new Index(i ,j)));
            }
        }

        return spins;
    }

    private static State rollState()
    {
        if(Math.random() < 0.5)
        {
            return State.UP;
        }

        return State.DOWN;
    }
}
