package controller.algorithm;

import model.Index;
import model.Spin;

import java.util.LinkedList;
import java.util.List;

public class Hamiltonian
{
    private List<Spin> spins;

    public Hamiltonian(List<Spin> spins)
    {
        this.spins = spins;
    }

    public float obtainTotalEnergy(float externalField)
    {
        return obtainExchangeEnergy() + obtainExternalFieldEnergy(externalField);
    }

    public float obtainExchangeEnergy()
    {
        float energy = 0;
        for(Spin spin: spins)
        {
            Index index = spin.getIndex();
            for(Index i: closestSpinIndexes(index))
            {
                energy += getSpinState(index) * getSpinState(i);
            }
        }

        return energy;
    }

    public float obtainExternalFieldEnergy(float externalField)
    {
        float energy = 0;
        for(Spin spin: spins)
        {
            energy += spin.getState().getValue() * externalField;
        }

        return energy;
    }

    private List<Index> closestSpinIndexes(Index index)
    {
        List<Index> neighbours = new LinkedList<>();

        neighbours.add(new Index(periodic(index.getI() + 1), index.getJ()));
        neighbours.add(new Index(periodic(index.getI() - 1), index.getJ()));
        neighbours.add(new Index(index.getI(), periodic(index.getJ() + 1)));
        neighbours.add(new Index(index.getI(), periodic(index.getJ() - 1)));

        return neighbours;
    }

    private int periodic(int x)
    {
        int latticeSize = (int) Math.sqrt(spins.size()) - 1;
        if(x < 0)
        {
            x = latticeSize;
        }
        if(x > latticeSize)
        {
            x = 0;
        }

        return x;
    }

    private int getSpinState(Index index)
    {
        return spins.stream()
                .filter(spin -> spin.getIndex().equals(index))
                .findFirst()
                .get()
                .getState()
                .getValue();
    }
}
