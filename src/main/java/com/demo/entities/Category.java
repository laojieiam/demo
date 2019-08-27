package com.demo.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author jieyingjian
 * @since 2019-08-23
 */
public class Category extends Model<Category> {

    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    /**
     * 分类名称
     */
    private String cname;

    /**
     * 父级id
     */
    private Integer pid;

    /**
     * 他的孩子
     */
    @TableField(exist = false)
    private List<Category> children;

    public List<Category> getChildren() {
        return this.children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    protected Serializable pkVal() {
        return this.cid;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname=" + cname +
                ", pid=" + pid +
                ",list="+children+"}";
    }
}
