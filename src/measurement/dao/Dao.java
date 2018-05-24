/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package measurement.dao;

import pl.odczyty.DdgDay;

/**
 *
 * @author Łukasz Kowalczyk
 */
public interface Dao {

    // do object exist by customized criteria
    void isInBase(Object object);

    // just save object to db
    void save(Object object);

    //create whole objesct by database id
    Object returnById(long id);
    
    
    

}
