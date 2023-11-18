package cn.wangye.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName teacher
 */
@Data
public class Teacher implements Serializable {
    private String tId;

    private String tName;

    public Teacher() {
    }

    public Teacher(String tId, String tName) {
        this.tId = tId;
        this.tName = tName;
    }

    private static final long serialVersionUID = 1L;


}