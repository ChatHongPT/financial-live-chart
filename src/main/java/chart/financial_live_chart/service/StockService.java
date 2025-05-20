package chart.financial_live_chart.service;

import chart.financial_live_chart.model.StockResponseDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    @Value("${stock.api.key}")
    private String serviceKey;  // 안전하게 외부 설정에서 주입받음

    private final RestTemplate restTemplate = new RestTemplate();

    public List<StockResponseDto> getStockData(String symbol, int days) throws ParseException {
        String url = buildUrl(symbol, days);
        String response = restTemplate.getForObject(url, String.class);
        return parseResponse(response);
    }

    private String buildUrl(String symbol, int days) {
        String baseUrl = "https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getStockPriceInfo";
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String prevDate = LocalDate.now().minusDays(days).format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        return baseUrl +
                "?serviceKey=" + serviceKey +
                "&numOfRows=400&pageNo=1" +
                "&resultType=json" +
                "&likeSrtnCd=" + symbol +
                "&beginBasDt=" + prevDate +
                "&endBasDt=" + today;
    }

    private List<StockResponseDto> parseResponse(String jsonData) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonData);
        JSONObject body = (JSONObject) ((JSONObject) jsonObject.get("response")).get("body");
        JSONArray items = (JSONArray) ((JSONObject) body.get("items")).get("item");

        List<StockResponseDto> result = new ArrayList<>();
        for (Object obj : items) {
            JSONObject item = (JSONObject) obj;

            result.add(new StockResponseDto(
                    (String) item.get("itmsNm"),
                    (String) item.get("basDt"),
                    Integer.parseInt((String) item.get("mkp")),
                    Integer.parseInt((String) item.get("clpr")),
                    Integer.parseInt((String) item.get("hipr")),
                    Integer.parseInt((String) item.get("lopr"))
            ));
        }

        return result;
    }
}
