package tn.isimm.pfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.isimm.pfe.entities.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

}
