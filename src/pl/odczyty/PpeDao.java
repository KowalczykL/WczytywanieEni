/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.util.List;

/**
 *
 * @author Łukasz Kowalczyk
 */
public interface PpeDao {
    void save(Ppe ppe);
    void delete(Ppe ppe);
    void update (Ppe ppe);
    
    Ppe findByPpeId(Long ppeId);
    Ppe findByPpe(String ppe);
    List<Ppe> findSubordinatesByManagerId(Long managerId);
    
}
