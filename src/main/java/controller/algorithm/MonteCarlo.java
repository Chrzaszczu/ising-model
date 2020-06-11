package controller.algorithm;

import controller.lattice.LatticeDrawer;
import javafx.scene.layout.BorderPane;
import model.LatticeParameters;
import model.Spin;
import model.enums.State;

import java.util.LinkedList;
import java.util.List;

public class MonteCarlo
{
    private static final float EXTERNAL_FIELD_RANGE = 3;
    private static final int NUMBER_OF_SPINS_TO_ROTATE = 3;

    private LatticeParameters parameters;
    private List<Spin> spins;

    private Hamiltonian hamiltonian;

    public boolean active;

    public MonteCarlo(LatticeParameters parameters, List<Spin> spins)
    {
        this.parameters = parameters;
        this.spins = spins;
    }

    public void start()
    {
        int finishedCycles = 0;
        hamiltonian = new Hamiltonian(spins);
        active = true;

        while(finishedCycles < parameters.getMonteCarloCycles() && active)
        {
            cycle(hamiltonian);
            finishedCycles++;
        }
    }

    private void cycle(Hamiltonian hamiltonian)
    {
        float energy;
        float energyAfterRotation;
        List<Integer> randomSpins;

        energy = hamiltonian.obtainTotalEnergy(EXTERNAL_FIELD_RANGE);
        randomSpins = obtainRandomSpins();
        rotate(randomSpins);
        energyAfterRotation = hamiltonian.obtainTotalEnergy(EXTERNAL_FIELD_RANGE);

        verifyNewLatticeState(energy, energyAfterRotation, randomSpins);
    }

    private void verifyNewLatticeState(float energy, float energyAfterRotation, List<Integer> randomSpins)
    {
        if(energyAfterRotation - energy > 0)
        {
            if(!isNewStatePossible())
            {
                rotate(randomSpins);
            }
        }
    }

    private boolean isNewStatePossible()
    {
        return Math.exp(-hamiltonian.obtainTotalEnergy(EXTERNAL_FIELD_RANGE)/parameters.getTemperature()) < Math.random();
    }

    private List<Integer> obtainRandomSpins()
    {
        return rollSpins();
    }

    private void rotate(List<Integer> rotatedSpins)
    {
        rotatedSpins.forEach(index -> rotate(spins.get(index)));
    }

    private void rotate(Spin spin)
    {
        if(spin.getState() == State.UP)
        {
            spin.setState(State.DOWN);
        }
        else
        {
            spin.setState(State.UP);
        }
    }

    private List<Integer> rollSpins()
    {
        List<Integer> rotatedSpins = new LinkedList<>();
        for(int i = 0; i < NUMBER_OF_SPINS_TO_ROTATE; ++i)
        {
            rotatedSpins.add((int) (Math.random() * spins.size() - 1));
        }

        return rotatedSpins;
    }
}
