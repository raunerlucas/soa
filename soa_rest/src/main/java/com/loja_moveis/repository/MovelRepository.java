package com.loja_moveis.repository;

import com.loja_moveis.domain.entity.Movel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovelRepository extends JpaRepository<Movel, Long> {
    List<Movel> findByNome(String nome);
}
