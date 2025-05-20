package chart.financial_live_chart.model;

public class StockRequestDto {
    private String symbol;
    private int days;

    // 기본 생성자 (Spring이 JSON을 객체로 변환할 때 필요)
    public StockRequestDto() {
    }

    // 모든 필드를 초기화하는 생성자
    public StockRequestDto(String symbol, int days) {
        this.symbol = symbol;
        this.days = days;
    }

    // Getter
    public String getSymbol() {
        return symbol;
    }

    public int getDays() {
        return days;
    }

    // Setter
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
