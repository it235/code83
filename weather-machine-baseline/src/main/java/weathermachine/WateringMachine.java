package weathermachine;

public class WateringMachine {
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