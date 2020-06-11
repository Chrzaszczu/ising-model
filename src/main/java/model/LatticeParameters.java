package model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LatticeParameters
{
    private int size;
    private float exchangeCoupling;
    private float temperature;
    private int monteCarloCycles;

    public static class Builder
    {
        private int size;
        private float exchangeCoupling;
        private float temperature;
        private int monteCarloCycles;

        public Builder withSize(int size)
        {
            this.size = size;
            return this;
        }

        public Builder withExchangeCoupling(float exchangeCoupling)
        {
            this.exchangeCoupling = exchangeCoupling;
            return this;
        }

        public Builder atTemperature(float temperature)
        {
            this.temperature = temperature;
            return this;
        }

        public Builder withCycles(int monteCarloCycles)
        {
            this.monteCarloCycles = monteCarloCycles;
            return this;
        }

        public LatticeParameters build()
        {
            LatticeParameters latticeParameters = new LatticeParameters();
            latticeParameters.size = this.size;
            latticeParameters.exchangeCoupling = this.exchangeCoupling;
            latticeParameters.temperature = this.temperature;
            latticeParameters.monteCarloCycles = this.monteCarloCycles;

            return latticeParameters;
        }

        public Builder()
        {
        }
    }
}
