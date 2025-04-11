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
public class Province extends BaseEntity<Integer> {

    public static final String TABLE_NAME = "province";

    public static final String NAME_COLUMN = "name";
    public static final String PRE_CODE_COLUMN = "pre_code";

    private String name;

    private String preCode;

}
