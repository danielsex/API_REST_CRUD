package com.example.rest.model;
import java.io.Serializable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;


@SuppressWarnings("serial")   //jdk gera um serial para vc quando a classe e compilada tira o erro pq a classe pede um id serial
@MappedSuperclass
public abstract class AbstractEntity <ID extends Serializable> implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // geração da chave primária
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractEntity<?> other = (AbstractEntity<?>) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }
}
