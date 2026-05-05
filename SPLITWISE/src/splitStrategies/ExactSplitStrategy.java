package splitStrategies;

import java.util.List;

import entities.Split;
import interfaces.SplitStrategy;

public class ExactSplitStrategy implements SplitStrategy{

	@Override
	public void validate(List<Split> splits, double totalAmount) {
		// TODO Auto-generated method stub
		double sum =0.0;
		for(Split split:splits) {
			sum+=split.getAmount();
		}
		
		if(Math.abs(sum-totalAmount)>0.01) {
			throw new RuntimeException("exact split amounts dont sum up to total");
		}
		
	}

	@Override
	public void calculateSplits(List<Split> splits, double totalAmount) {
		// TODO Auto-generated method stub
		
	}

}
