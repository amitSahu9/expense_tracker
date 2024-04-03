package in.amitsahu.expensetrackerapi.service;

import in.amitsahu.expensetrackerapi.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {
    public Page<Expense> getAllExpenses(Pageable page);

    public Expense getExpenseById(Long id);

    public void deleteExpenseById(Long id);

    public Expense addExpense(Expense expense);

    public Expense updateExpense(Long id, Expense expense);
}
