package vehicles;

import controllers.PIDController;

public class Car {
	private double targetVelocity;
	private double currVelocity;
	private double mass;
	private double pedalAngle;				// The depression of the pedal (degrees [0, 75])
	private PIDController pedalController;
	
	public Car(double initVelocity, double targetVelocity, double mass) {
		this.targetVelocity = targetVelocity;
		this.currVelocity = initVelocity;
		this.mass = mass;
		this.pedalAngle = 0;
		
		// Initialize the PID controller
		this.pedalController = new PIDController(targetVelocity, currVelocity);
		this.pedalController.setMaxCorrection(40.0);
		this.pedalController.setMinCorrection(0);
	}
	
	public void update() {
		pedalController.setCurrValue(currVelocity);
		pedalController.calculateCorrection();
	}
	
	public void printReadout() {
		System.out.printf("Velocity: %.2f\tTarget: %.2f\tError: %.2f", currVelocity, targetVelocity, pedalController.getError());
		System.out.println();
	}
}
