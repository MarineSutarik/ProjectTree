/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.membre.repo;

import api.membre.plongee.domain.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Marine
 */
public interface MembreRepo extends JpaRepository<Membre, Integer> {
    
}
