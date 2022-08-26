package Car;

public class Car {

    private void startElectricity(){ System.out.print("startElectricity");}

    private void startCommand(){ System.out.print("startCommand");}

    private void StartFuelSystem(){ System.out.print("StartFuelSystem");}

    public void start(){
        startElectricity();
        startCommand();
        StartFuelSystem();
    }

}
