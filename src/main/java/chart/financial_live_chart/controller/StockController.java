package chart.financial_live_chart.controller;

import chart.financial_live_chart.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StockController {
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService)
    {
        this.stockService = stockService;
    }

    @GetMapping("/stock")
    public String getStock(@RequestParam String symbol)
    {
        return stockService.fetchStockData(symbol);
    }
}
