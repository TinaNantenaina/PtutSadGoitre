/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.entity;

/**
 *
 * @author agath
 */
public enum Type_sf {
    HYPOTHYROIDE,
    HYPERTHYROIDE,
    EUTHYROIDE;
    
    public String getValue(){
        return this.toString();
    }
}
