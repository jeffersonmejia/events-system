package model;

import org.bson.Document;
import model.InterfaceEvents;

//PATRÓN TEMPLATE
//... DEFINE ESTRUCTURA EN INTERFACE, IMPLEMENTA EN CLASE PADRE
//PRINCIPIO SO(L)ID: LISKOK SUSTITUTION
//... CLASE PADRE PUEDE SER INSTANCIADA POR CLASE HIJA
public abstract class Events implements InterfaceEvents {

    protected Document document;

    public Events(Document document) {
        this.document = document;
    }

    //POLIMORFISMO SOBRESCRITURA
    @Override
    public abstract boolean validationFields();
}
