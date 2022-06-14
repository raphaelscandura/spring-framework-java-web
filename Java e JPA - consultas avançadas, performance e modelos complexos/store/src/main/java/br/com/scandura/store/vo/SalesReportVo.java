package br.com.scandura.store.vo;

import java.time.LocalDateTime;

public class SalesReportVo {
    private String productName;
    private Long quantitySold;
    private LocalDateTime date;

    public SalesReportVo(String productName, Long quantitySold, LocalDateTime date) {
        this.productName = productName;
        this.quantitySold = quantitySold;
        this.date = date;
    }

    public String getProductName() {
        return productName;
    }

    public Long getQuantitySold() {
        return quantitySold;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "SalesReportVo{" +
                "productName='" + productName + '\'' +
                ", quantitySold=" + quantitySold +
                ", date=" + date +
                '}';
    }
}
