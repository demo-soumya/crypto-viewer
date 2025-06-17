package com.crypto.cryptocurrencies.Repository;

import com.crypto.cryptocurrencies.Model.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CryptoRepository extends JpaRepository<Cryptocurrency, Long> {
    Optional<Cryptocurrency> findBySymbol(String symbol);

}
