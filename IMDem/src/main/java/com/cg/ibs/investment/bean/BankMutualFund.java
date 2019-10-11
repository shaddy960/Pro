package com.cg.ibs.investment.bean;

public class BankMutualFund {
	private int mfid;
	private String title;
	private double nav;

	public BankMutualFund(int mfid, String title, double nav) {
		super();
		this.mfid = mfid;
		this.title = title;
		this.nav = nav;
	}

	public BankMutualFund() {
		super();
	}

	public int getmfid() {
		return mfid;
	}

	public void setmfid(int mfid) {
		this.mfid = mfid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getNav() {
		return nav;
	}

	public void setNav(double nav) {
		this.nav = nav;
	}

	@Override
	public String toString() {
		return "Mfid=" + mfid + ", title=" + title + ", nav=" + nav + "";
	}

}