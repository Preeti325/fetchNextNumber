package com.preeti.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preeti.dao.INumberDAO;
import com.preeti.entity.NumberEntity;

@Service
public class NumberService implements INumberService {
	
	@Autowired
	private INumberDAO myNumberDAO;

	public NumberService() {
	}

	public int sumFunction(int n) {
		int s = 0;
		while(n!=0) {
			s += n % 10;
			n /= 10;
		}
		
		return s;
	}
	
	public int findNextNumber(int n) {
		int value = 0;
		for(int i=n+1;i<=Integer.MAX_VALUE;i++) {
			if(sumFunction(i)==n) {
				value = i;
				break;
			}
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	@Override
	public Map<String,Integer> updateMyNumber(String categoryCode) {
		HashMap<String,Integer> result = new HashMap<String,Integer>();
		NumberEntity myNumber = myNumberDAO.getById(categoryCode);
		int oldValue = myNumber.getValue();
		result.put("Old value", oldValue);
		int newValue = findNextNumber(oldValue);
		myNumber.setValue(newValue);
		result.put("New value", newValue);
		return result;
	}
}
