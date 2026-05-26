package uca.ncapas.parcial2_pnc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uca.ncapas.parcial2_pnc.common.enums.Type;
import uca.ncapas.parcial2_pnc.domain.entities.MagicArticle;

@Repository
public interface MagicArticleRepository extends JpaRepository<MagicArticle, Long> {

    boolean existsByNameIgnoringCase(String name);
}
