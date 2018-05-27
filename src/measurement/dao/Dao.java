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
    boolean isInBase(Object object);

    // just saveAnyway object to db
    void saveAnyway(Object object);

    //create whole objesct by database id
    Object returnById(long id);
    
    //save only if is not saved yet
    void saveIfNew(Object object);
    

}
