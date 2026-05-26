package uca.ncapas.parcial2_pnc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uca.ncapas.parcial2_pnc.domain.entities.MagicProvider;

@Repository
public interface MagicProviderRepository extends JpaRepository<MagicProvider, Long> {
}
