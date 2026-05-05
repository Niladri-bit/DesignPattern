package interfaces;

import entities.Expense;

public interface ExpenseObserver {
	void onExpenseAdded(Expense expense);
	void onSettlement(String fromUserId,String toUser,double amount);
}
