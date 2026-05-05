package splitStrategies;

import java.util.Collections;
import java.util.List;

import entities.Split;
import interfaces.SplitStrategy;

public class EqualSplitStrategy implements SplitStrategy{

	@Override
	public void validate(List<Split> splits, double totalAmount) {
		// TODO Auto-generated method stub
		if(splits == null ||splits.isEmpty()) {
			throw new RuntimeException("splits list cant be empty");
		}
		
	}

	@Override
	public void calculateSplits(List<Split> splits, double totalAmount) {
		// TODO Auto-generated method stub
		int count = splits.size();
		double equalShare= Math.round(totalAmount/count *100.0)/100.0;
		
		for(int i = 0;i<count-1;i++) {
			splits.get(i).setAmount(equalShare);
		}
		
		double remainder=totalAmount-(equalShare*(count-1));
		remainder=Math.round(remainder)*100.0/100.0;
		splits.get(count-1).setAmount(remainder);
	}

}
