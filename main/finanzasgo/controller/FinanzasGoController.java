package com.finanzasgo.controller;

import com.finanzasgo.model.Transaction;
import com.finanzasgo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FinanzasGoController {
    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("transactions", transactionRepository.findAll());
        return "index";
    }

    @PostMapping("/addTransaction")
    public String addTransaction(@RequestParam("amount") Double amount, @RequestParam("category") String category) {
        Transaction transaction = new Transaction(amount, category);
        transactionRepository.save(transaction);
        return "redirect:/";
    }
}
