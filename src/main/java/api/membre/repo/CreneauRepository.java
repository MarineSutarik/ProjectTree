/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.membre.repo;

import api.membre.plongee.domain.Creneau;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Marine
 */

public interface CreneauRepository extends MongoRepository<Creneau, Integer> {
    
}
