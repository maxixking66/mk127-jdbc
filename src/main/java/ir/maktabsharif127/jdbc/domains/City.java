package ir.maktabsharif127.jdbc.domains;

import ir.maktabsharif127.jdbc.domains.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class City extends BaseEntity<Integer> {

    public static final String TABLE_NAME = "city";

    public static final String NAME_COLUMN = "name";
    public static final String PROVINCE_ID_COLUMN = "province_id";

    private String name;

    private Integer provinceId;

    private Province province;

}
