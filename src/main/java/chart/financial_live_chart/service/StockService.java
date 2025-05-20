package chart.financial_live_chart.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {

    @Value("${stock.api.key}")
    private String apiKey;

    public String fetchStockData(String symbol) {
        String url = "https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getStockPriceInfo"
                + "?serviceKey=" + apiKey
                + "&numOfRows=1"
                + "&pageNo=1"
                + "&resultType=json"
                + "&likeSrtnCd=" + symbol;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
