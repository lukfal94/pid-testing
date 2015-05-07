package controllers;

public class PIDController {
	private double pGain;
	private double iGain;
	private double dGain;
	
	private double currValue;
	private double error;
	private double prevError;
	private double cummulativeError;
	
	private double pCorrection;
	private double iCorrection;
	private double dCorrection;
	
	private double correction;
	private double maxCorrection;
	private double minCorrection;
	private double setPoint;
	
	// Simple constructor that create a PID with default values -
	//
	public PIDController(double target, double currValue){
		this.setPoint = target;
		this.currValue = currValue;
		
		setDefaultValues();
	}
	
	// Give the P, I, and D gain values
	//
	public PIDController(double target, double currValue, double pGain, double iGain, double dGain){
		this.setPoint = target;
		this.currValue = currValue;
		
		setDefaultValues();
		
		this.pGain = pGain;
		this.iGain = iGain;
		this.dGain = dGain;
	}
	
	private void setDefaultValues()
	{
		this.pGain = 1;
		this.iGain = 1;
		this.dGain = 1;
		this.error = this.setPoint - this.currValue;
		this.prevError = this.error;
		
		this.pCorrection = 0;
		this.iCorrection = 0;
		this.dCorrection = 0;
		
		this.correction = 0;
		
		this.maxCorrection = 0.20 * this.error;
		this.minCorrection = 0.01 * this.error;
	}
	
	public double calculateCorrection() {
		this.error = this.setPoint - this.currValue;
		this.correction = pCorrection() + iCorrection() + dCorrection();
		
		// Assure correction is within bounds
		if(this.correction > this.maxCorrection)
			this.correction = this.maxCorrection;
		else if(this.correction < this.minCorrection) 
			this.correction = this.minCorrection;
		
		return this.correction;
	}
	private double pCorrection()
	{
		return this.pGain * this.error;
	}
	private double iCorrection()
	{
		return 0;
	}
	private double dCorrection()
	{
		return 0;
	}
	public double getpGain() {
		return pGain;
	}
	public void setpGain(double pGain) {
		this.pGain = pGain;
	}
	public double getiGain() {
		return iGain;
	}
	public void setiGain(double iGain) {
		this.iGain = iGain;
	}
	public double getdGain() {
		return dGain;
	}
	public void setdGain(double dGain) {
		this.dGain = dGain;
	}
	public double getCurrValue() {
		return currValue;
	}

	public void setCurrValue(double currValue) {
		this.currValue = currValue;
	}

	public double getError() {
		return error;
	}
	public void setError(double error) {
		this.error = error;
	}
	public double getPrevError() {
		return prevError;
	}
	public void setPrevError(double prevError) {
		this.prevError = prevError;
	}
	public double getCummulativeError() {
		return cummulativeError;
	}

	public void setCummulativeError(double cummulativeError) {
		this.cummulativeError = cummulativeError;
	}

	public double getpCorrection() {
		return pCorrection;
	}
	public void setpCorrection(double pCorrection) {
		this.pCorrection = pCorrection;
	}
	public double getiCorrection() {
		return iCorrection;
	}
	public void setiCorrection(double iCorrection) {
		this.iCorrection = iCorrection;
	}
	public double getdCorrection() {
		return dCorrection;
	}
	public void setdCorrection(double dCorrection) {
		this.dCorrection = dCorrection;
	}
	public double getCorrection() {
		return correction;
	}
	public void setCorrection(double correction) {
		this.correction = correction;
	}
	public double getMaxCorrection() {
		return maxCorrection;
	}
	public void setMaxCorrection(double maxCorrection) {
		this.maxCorrection = maxCorrection;
	}
	public double getMinCorrection() {
		return minCorrection;
	}
	public void setMinCorrection(double minCorrection) {
		this.minCorrection = minCorrection;
	}
	public double getSetPoint() {
		return setPoint;
	}
	public void setSetPoint(double setPoint) {
		this.setPoint = setPoint;
	}
	
}
