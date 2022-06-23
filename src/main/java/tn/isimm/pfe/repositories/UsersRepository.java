package tn.isimm.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.isimm.pfe.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

	List<Users> findByEmailAndPassword(String email , String password);
}
