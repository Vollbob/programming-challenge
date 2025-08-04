package model;

public class WeatherData {
	private int day;
	private double mxT;
	private double mnT;
	private double avT;
	private double avDP;
	private double oneHrP_TPcpn;
	private double pDir;
	private double avSp;
	private double dir;
	private double mxS;
	private double skyC;
	private double mxR;
	private double mn;
	private double r_AvSLP;
	
	public WeatherData(int day, double mxT, double mnT, double avT, 
			double avDP, double oneHrP_TPcpn, double pDir, double avSp, double dir, double mxS, double skyC, double mxR, 
			double mn, double r_AvSLP){
		this.setDay(day);
		this.setMxT(mxT);
		this.setMnT(mnT);
		this.setAvT(avT);
		this.setAvDP(avDP);
		this.setOneHrP_TPcpn(oneHrP_TPcpn);
		this.setpDir(pDir);
		this.setAvSp(avSp);
		this.setDir(dir);
		this.setMxS(mxS);
		this.setSkyC(skyC);
		this.setMxR(mxR);
		this.setMn(mn);
		this.setR_AvSLP(r_AvSLP);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public double getMxT() {
		return mxT;
	}

	public void setMxT(double mxT) {
		this.mxT = mxT;
	}

	public double getMnT() {
		return mnT;
	}

	public void setMnT(double mnT) {
		this.mnT = mnT;
	}
	
	public double getAvT() {
		return avT;
	}

	public void setAvT(double avT) {
		this.avT = avT;
	}

	public double getAvDP() {
		return avDP;
	}

	public void setAvDP(double avDP) {
		this.avDP = avDP;
	}

	public double getOneHrP_TPcpn() {
		return oneHrP_TPcpn;
	}

	public void setOneHrP_TPcpn(double oneHrP_TPcpn) {
		this.oneHrP_TPcpn = oneHrP_TPcpn;
	}

	public double getpDir() {
		return pDir;
	}

	public void setpDir(double pDir) {
		this.pDir = pDir;
	}

	public double getAvSp() {
		return avSp;
	}

	public void setAvSp(double avSp) {
		this.avSp = avSp;
	}

	public double getDir() {
		return dir;
	}

	public void setDir(double dir) {
		this.dir = dir;
	}

	public double getMxS() {
		return mxS;
	}

	public void setMxS(double mxS) {
		this.mxS = mxS;
	}

	public double getSkyC() {
		return skyC;
	}

	public void setSkyC(double skyC) {
		this.skyC = skyC;
	}

	public double getMxR() {
		return mxR;
	}

	public void setMxR(double mxR) {
		this.mxR = mxR;
	}

	public double getMn() {
		return mn;
	}

	public void setMn(double mn) {
		this.mn = mn;
	}

	public double getR_AvSLP() {
		return r_AvSLP;
	}

	public void setR_AvSLP(double r_AvSLP) {
		this.r_AvSLP = r_AvSLP;
	}

}
