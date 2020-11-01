package weathermachine;

public class SeedingMachine {
    private boolean status;

    public boolean getStatus()
    {
        return status;
    }

    public void start()
    {
        status = true;
    }
}