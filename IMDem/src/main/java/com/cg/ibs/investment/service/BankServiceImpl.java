package com.cg.ibs.investment.service;

import com.cg.ibs.investment.bean.BankMutualFund;
import com.cg.ibs.investment.dao.BankDao;
import com.cg.ibs.investment.dao.InvestmentDaoImpl;
import com.cg.ibs.investment.exception.ErrorMessages;
import com.cg.ibs.investment.exception.IBSException;

public class BankServiceImpl implements BankService {
	BankDao daoObject = new InvestmentDaoImpl();

	public boolean isValidGoldSilver(double price) {
		boolean check = false;
		if (price > 0) {
			check = true;
		}
		return check;
	}

	public boolean isValidMutualFund(BankMutualFund mutualFund) {
		boolean check = false;
		if (mutualFund.getNav() > 0) {
			check = true;
		}
		return check;
	}

	public void updateGoldPrice(double goldPrice) throws IBSException {
		if (isValidGoldSilver(goldPrice)) {
			daoObject.updateGoldPrice(goldPrice);
		} else {
			throw new IBSException(ErrorMessages.INVALID_PRICE_MESSAGE);
		}
	}

	public void updateSilverPrice(double silverPrice) throws IBSException {
		if (isValidGoldSilver(silverPrice)) {
			daoObject.updateSilverPrice(silverPrice);
		} else {
			throw new IBSException(ErrorMessages.INVALID_PRICE_MESSAGE);
		}
	}

	public void addMF(BankMutualFund mutualFund) throws IBSException {
		if (isValidMutualFund(mutualFund)) {
			daoObject.addMF(mutualFund);
		} else {
			throw new IBSException(ErrorMessages.INVALID_MF_MESSAGE);
		}

	}

	@Override
	public boolean validateBank(String userId, String password) throws IBSException {

		if (daoObject.viewDetails(userId) != null) {
			if (userId.equals(daoObject.viewDetails(userId).getUserId())) {

				String correctPassword = daoObject.viewDetails(userId).getPassword();
				if (password.equals(correctPassword)) {
					return true;
				} else {
					throw new IBSException(ErrorMessages.INVALID_PASSWORD_MESSAGE);
				}
			}
		} else {
			throw new IBSException(ErrorMessages.INVALID_USERNAME_MESSAGE);
		}
		return false;

	}
}