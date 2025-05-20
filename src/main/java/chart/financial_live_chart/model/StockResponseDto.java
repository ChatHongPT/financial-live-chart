//
package chart.financial_live_chart.model;

public class StockResponseDto {
    private String name;
    private String date;
    private int open;
    private int high;
    private int low;
    private int close;
    public StockResponseDto(String name, String date, int open, int high, int low, int close)
    {
        this.name = name;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    //Getters
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public int getOpen() {
        return open;
    }
    public int getHigh() {
        return high;
    }
    public int getLow() {
        return low;
    }
    public int getClose() {
        return close;
    }
}

