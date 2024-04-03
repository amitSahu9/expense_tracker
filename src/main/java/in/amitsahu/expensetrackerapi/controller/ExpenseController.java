package in.amitsahu.expensetrackerapi.controller;
import in.amitsahu.expensetrackerapi.entity.Expense;
import in.amitsahu.expensetrackerapi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Expense> getAllExpenses(Pageable page)
    {
        return expenseService.getAllExpenses(page).toList();
    }

    @GetMapping("/expenses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Expense getExpenseById(@PathVariable Long id)
    {
        return expenseService.getExpenseById(id);
    }

    @DeleteMapping("/expenses")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteExpenseById(@RequestParam("id") Long id)
    {
        expenseService.deleteExpenseById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/expenses")
    @ResponseStatus(HttpStatus.CREATED)
    public Expense saveExpenseDetails(@RequestBody Expense expense)
    {
        Expense e = expenseService.addExpense(expense);
        return e;
    }

    @PutMapping("/expenses/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable Long id)
    {
        return expenseService.updateExpense(id, expense);
    }
}
