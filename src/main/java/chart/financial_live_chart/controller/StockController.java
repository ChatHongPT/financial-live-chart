package chart.financial_live_chart.controller;

import chart.financial_live_chart.model.StockResponseDto;
import chart.financial_live_chart.service.StockService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stock")
    public List<StockResponseDto> getStock(@RequestParam String symbol, @RequestParam int days) throws ParseException {
        return stockService.getStockData(symbol, days);
    }
}
