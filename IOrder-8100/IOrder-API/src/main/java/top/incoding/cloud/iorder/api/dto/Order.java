package top.incoding.cloud.iorder.api.dto;

import top.incoding.cloud.igoods.api.dto.Item;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 
 * @TableName Order
 */
public class Order implements Serializable {
    /**
     * 
     */
    private String orderId;

    /**
     * 订单金额
     */
    private BigDecimal payment;

    /**
     * 订单类型
     */
    private Integer paymentType;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Date paymentTime;

    /**
     * 
     */
    private Date consignTime;

    /**
     * 
     */
    private Date endTime;

    /**
     * 
     */
    private Date closeTime;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private String uniquekey;

    private List<Item> goods;

    public List<Item> getGoods() {
        return goods;
    }

    public void setGoods(List<Item> goods) {
        this.goods = goods;
    }

    private List<Orderitem> orderItems;

    public List<Orderitem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Orderitem> orderItems) {
        this.orderItems = orderItems;
    }

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 订单金额
     */
    public BigDecimal getPayment() {
        return payment;
    }

    /**
     * 订单金额
     */
    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    /**
     * 订单类型
     */
    public Integer getPaymentType() {
        return paymentType;
    }

    /**
     * 订单类型
     */
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
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
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 
     */
    public Date getPaymentTime() {
        return paymentTime;
    }

    /**
     * 
     */
    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    /**
     * 
     */
    public Date getConsignTime() {
        return consignTime;
    }

    /**
     * 
     */
    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }

    /**
     * 
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 
     */
    public Date getCloseTime() {
        return closeTime;
    }

    /**
     * 
     */
    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    /**
     * 
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 
     */
    public String getUniquekey() {
        return uniquekey;
    }

    /**
     * 
     */
    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
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
        Order other = (Order) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getPayment() == null ? other.getPayment() == null : this.getPayment().equals(other.getPayment()))
            && (this.getPaymentType() == null ? other.getPaymentType() == null : this.getPaymentType().equals(other.getPaymentType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getPaymentTime() == null ? other.getPaymentTime() == null : this.getPaymentTime().equals(other.getPaymentTime()))
            && (this.getConsignTime() == null ? other.getConsignTime() == null : this.getConsignTime().equals(other.getConsignTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getCloseTime() == null ? other.getCloseTime() == null : this.getCloseTime().equals(other.getCloseTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUniquekey() == null ? other.getUniquekey() == null : this.getUniquekey().equals(other.getUniquekey()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getPayment() == null) ? 0 : getPayment().hashCode());
        result = prime * result + ((getPaymentType() == null) ? 0 : getPaymentType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getPaymentTime() == null) ? 0 : getPaymentTime().hashCode());
        result = prime * result + ((getConsignTime() == null) ? 0 : getConsignTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getCloseTime() == null) ? 0 : getCloseTime().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUniquekey() == null) ? 0 : getUniquekey().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", payment=").append(payment);
        sb.append(", paymentType=").append(paymentType);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", consignTime=").append(consignTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", closeTime=").append(closeTime);
        sb.append(", userId=").append(userId);
        sb.append(", uniquekey=").append(uniquekey);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}