package com.labisistemas.gestaofinanceiraapi.repository;

import com.labisistemas.gestaofinanceiraapi.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
