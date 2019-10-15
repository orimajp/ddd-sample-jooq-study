/*
 * This file is generated by jOOQ.
 */
package com.example.db.jooq.gen.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LocationVo implements Serializable {

    private static final long serialVersionUID = -1605475740;

    private final Integer id;
    private final String  unlocode;
    private final String  name;

    public LocationVo(LocationVo value) {
        this.id = value.id;
        this.unlocode = value.unlocode;
        this.name = value.name;
    }

    public LocationVo(
        Integer id,
        String  unlocode,
        String  name
    ) {
        this.id = id;
        this.unlocode = unlocode;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public String getUnlocode() {
        return this.unlocode;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final LocationVo other = (LocationVo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (unlocode == null) {
            if (other.unlocode != null)
                return false;
        }
        else if (!unlocode.equals(other.unlocode))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.unlocode == null) ? 0 : this.unlocode.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LocationVo (");

        sb.append(id);
        sb.append(", ").append(unlocode);
        sb.append(", ").append(name);

        sb.append(")");
        return sb.toString();
    }
}
