package tn.isimm.pfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.isimm.pfe.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {

}
