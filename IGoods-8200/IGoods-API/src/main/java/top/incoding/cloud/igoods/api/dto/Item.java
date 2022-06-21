package top.incoding.cloud.igoods.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName item
 */
public class Item implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String sellPoint;

    /**
     * 
     */
    private BigDecimal price;

    /**
     * 
     */
    private Integer num;

    /**
     * 
     */
    private Integer limitNum;

    /**
     * 
     */
    private String image;

    /**
     * 
     */
    private Long cid;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private Date created;

    /**
     * 
     */
    private Date updated;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     */
    public String getSellPoint() {
        return sellPoint;
    }

    /**
     * 
     */
    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    /**
     * 
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 
     */
    public Integer getLimitNum() {
        return limitNum;
    }

    /**
     * 
     */
    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }

    /**
     * 
     */
    public String getImage() {
        return image;
    }

    /**
     * 
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 
     */
    public Long getCid() {
        return cid;
    }

    /**
     * 
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }

    /**
     * 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * 
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Item other = (Item) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSellPoint() == null ? other.getSellPoint() == null : this.getSellPoint().equals(other.getSellPoint()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getLimitNum() == null ? other.getLimitNum() == null : this.getLimitNum().equals(other.getLimitNum()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
            && (this.getUpdated() == null ? other.getUpdated() == null : this.getUpdated().equals(other.getUpdated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSellPoint() == null) ? 0 : getSellPoint().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getLimitNum() == null) ? 0 : getLimitNum().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        result = prime * result + ((getUpdated() == null) ? 0 : getUpdated().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", sellPoint=").append(sellPoint);
        sb.append(", price=").append(price);
        sb.append(", num=").append(num);
        sb.append(", limitNum=").append(limitNum);
        sb.append(", image=").append(image);
        sb.append(", cid=").append(cid);
        sb.append(", status=").append(status);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}