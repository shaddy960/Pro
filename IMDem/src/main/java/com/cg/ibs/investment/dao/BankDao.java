package com.cg.ibs.investment.dao;

import com.cg.ibs.investment.bean.*;

public interface BankDao {
	void updateGoldPrice(double x);

	void updateSilverPrice(double y);

	void addMF(BankMutualFund mutualFund);

	InvestmentBean viewDetails(String userId);
}
