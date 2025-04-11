package ir.maktabsharif127.jdbc.domains.base;

import lombok.ToString;

@ToString
public abstract class BaseEntity<ID> {

    public static final String ID_COLUMN = "id";

    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
