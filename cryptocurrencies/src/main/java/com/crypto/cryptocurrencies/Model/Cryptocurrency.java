package com.crypto.cryptocurrencies.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cryptocurrency", uniqueConstraints = {@UniqueConstraint(columnNames = "symbol")})
public class Cryptocurrency {

    @Id
    @Column(length = 50)
    private String id; // VARCHAR(50) - UUID or manually assigned

    @Column(nullable = false, length = 10)
    @JsonProperty("symbol")
    private String symbol; // VARCHAR(10)

    @Column(nullable = false, length = 100)
    @JsonProperty("name")
    private String name; // VARCHAR(100)

    @Column(name = "current_price", precision = 15, scale = 2)
    @JsonProperty("current_price")
    private BigDecimal priceUSD; // DECIMAL(15,2)

    @Column(name = "market_cap")
    @JsonProperty("market_cap")//not mandatory
    private Long marketCap; // BIGINT

    @Column(name = "total_volume")
    @JsonProperty("total_volume")
    private Long volume24h; // BIGINT

    @Column(name = "high_24h", precision = 15, scale = 2)
    @JsonProperty("high_24h")
    private BigDecimal high24h; // DECIMAL(15,2)

    @Column(name = "low_24h", precision = 15, scale = 2)
    @JsonProperty("low_24h")
    private BigDecimal low24h; // DECIMAL(15,2)

//    @Column(name = "price_change_percentage_24h", precision = 5, scale = 4)
//    //@JsonProperty("price_change_percentage_24h")//not mandatory //dikkat de rha h
//    private BigDecimal priceChangePercentage24h; // DECIMAL(5,4)
//
//    @Column(name = "circulating_supply",  precision = 20, scale = 10)//gadbad h re baba
//    //@JsonProperty("circulating_supply")//not mandatory
//    private BigDecimal circulatingSupply; // DECIMAL(20,10)


    @Column(name = "last_updated",  columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated; // TIMESTAMP

}

