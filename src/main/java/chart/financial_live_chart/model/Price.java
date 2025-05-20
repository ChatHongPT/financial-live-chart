package chart.financial_live_chart.model;

public class Price {
    private String itemId;   // 종목코드 (예: 005930)
    private String name;     // 종목명 (예: 삼성전자)
    private String date;     // 기준일 (예: 20250520)
    private int open;        // 시가
    private int close;       // 종가
    private int high;        // 고가
    private int low;         // 저가

    public Price() {
    }

    public Price(String itemId, String name, String date, int open, int close, int high, int low) {
        this.itemId = itemId;
        this.name = name;
        this.date = date;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    public int getClose() {
        return close;
    }

    public void setClose(int close) {
        this.close = close;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }
}
