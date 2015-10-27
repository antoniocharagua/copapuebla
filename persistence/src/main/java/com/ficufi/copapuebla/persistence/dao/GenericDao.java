package com.ficufi.copapuebla.persistence.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interfaz generica para la capa de persistencia
 * @author Antonio Francisco Alonso Valerdi
 * @param <T> Tipo generco para la capa de persistencia
 * @param <PK> Llave primaria del tipo Serializable 
 */
public interface GenericDao<T, PK extends Serializable> {
    
    /**
     * Persiste en la tabla una nueva columna
     * @param t Objecto a persistir
     * @return Objecto persistido
     */
    PK create(T t);
    
    /**
     * Borra una columna representada por el objeto
     * @param t Objecto a ser borrado
     */
    void delete(T t);
    
    /**
     * Busca en la tabla a partir de una llave primaria
     * @param primaryKey LLave primaria
     * @return Si es encontrado Regresa el objecto con los valores de la tabla, en
     * caso contrario regresa null
     */
    T find(PK primaryKey);
    
    /**
     * Recupera todos los elementos de una tabla
     * @return Lista con los elementos encontrado
     */
    List<T> find();
    
    /**
     * Actualiza una columna a partir de los datos de un objeto
     * @param t Objeto con los datos a actualizar en la tabla
     */
    void update(T t);
    
    /**
     * Crear o actualiza una columna a partir de los datos de un objecto
     * @param t Objeto con los datos a actualizar en la tabla
     */
    void saveOrUpdate(T t);

}
