package controller.lattice;

import controller.MainController;
import model.LatticeParameters;

public class LatticeParametersObtainer
{
    MainController controller;

    public LatticeParametersObtainer(MainController controller)
    {
        this.controller = controller;
    }

    public LatticeParameters obtainLatticeParameters()
    {
        return new LatticeParameters.Builder()
                .withSize(obtainLatticeSize())
                .withExchangeCoupling(obtainExchangeCoupling())
                .atTemperature(obtainTemperature())
                .withCycles(obtainMonteCarloCycles())
                .build();
    }

    private int obtainLatticeSize() throws IllegalArgumentException
    {
        try
        {
            return Integer.parseInt(controller.getWidthTextField().getText());
        }
        catch(Exception e)
        {
            throw new IllegalArgumentException("wrong format");
        }
    }

    private float obtainExchangeCoupling() throws IllegalArgumentException
    {
        try
        {
            return Float.parseFloat(controller.getExchangeCouplingTextField().getText());
        }
        catch(Exception e)
        {
            throw new IllegalArgumentException("wrong format");
        }
    }

    private float obtainTemperature() throws IllegalArgumentException
    {
        try
        {
            return Float.parseFloat(controller.getTemperatureTextField().getText());
        }
        catch(Exception e)
        {
            throw new IllegalArgumentException("wrong format");
        }
    }

    private int obtainMonteCarloCycles() throws IllegalArgumentException
    {
        try
        {
            return Integer.parseInt(controller.getMonteCarloCyclesTextField().getText());
        }
        catch(Exception e)
        {
            throw new IllegalArgumentException("wrong format");
        }
    }
}
