package weathermachine;

public class WeatherData {
    private SeedingMachine seedingMachine;
    private ReapingMachine reapingMachine;
    private WateringMachine wateringMachine;

    public WeatherData(SeedingMachine seedingMachine, ReapingMachine reapingMachine, WateringMachine wateringMachine)
    {
        this.seedingMachine = seedingMachine;
        this.reapingMachine = reapingMachine;
        this.wateringMachine = wateringMachine;
    }

    public void measurementsChanged(int temp, int humidity, int windPower)
    {
        if (temp > 5)
        {
            seedingMachine.start();

            if (humidity > 65)
                reapingMachine.start();
        }

        if (temp > 10 && humidity < 55 && windPower < 4)
            wateringMachine.start();
    }
}