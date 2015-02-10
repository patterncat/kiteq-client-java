package org.kiteq.commons.message;

import java.io.Serializable;

/**
 * @author gaofeihang
 * @since Feb 10, 2015
 */
public abstract class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String messageId;
    private String topic;
    private String messageType;
    private long expiredTime = -1; // -1 for never expired
    private int deliveryLimit = -1; // -1 for unlimited retry times
    private String groupId;
    private boolean committed;
    
    public String getMessageId() {
        return messageId;
    }
    
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
    
    public String getTopic() {
        return topic;
    }
    
    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    public String getMessageType() {
        return messageType;
    }
    
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    
    public long getExpiredTime() {
        return expiredTime;
    }
    
    public void setExpiredTime(long expiredTime) {
        this.expiredTime = expiredTime;
    }
    
    public int getDeliveryLimit() {
        return deliveryLimit;
    }
    
    public void setDeliveryLimit(int deliveryLimit) {
        this.deliveryLimit = deliveryLimit;
    }
    
    public String getGroupId() {
        return groupId;
    }
    
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    public boolean isCommitted() {
        return committed;
    }

    public void setCommitted(boolean commited) {
        this.committed = commited;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (committed ? 1231 : 1237);
        result = prime * result + deliveryLimit;
        result = prime * result + (int) (expiredTime ^ (expiredTime >>> 32));
        result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
        result = prime * result + ((messageId == null) ? 0 : messageId.hashCode());
        result = prime * result + ((messageType == null) ? 0 : messageType.hashCode());
        result = prime * result + ((topic == null) ? 0 : topic.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Message other = (Message) obj;
        if (committed != other.committed) {
            return false;
        }
        if (deliveryLimit != other.deliveryLimit) {
            return false;
        }
        if (expiredTime != other.expiredTime) {
            return false;
        }
        if (groupId == null) {
            if (other.groupId != null) {
                return false;
            }
        } else if (!groupId.equals(other.groupId)) {
            return false;
        }
        if (messageId == null) {
            if (other.messageId != null) {
                return false;
            }
        } else if (!messageId.equals(other.messageId)) {
            return false;
        }
        if (messageType == null) {
            if (other.messageType != null) {
                return false;
            }
        } else if (!messageType.equals(other.messageType)) {
            return false;
        }
        if (topic == null) {
            if (other.topic != null) {
                return false;
            }
        } else if (!topic.equals(other.topic)) {
            return false;
        }
        return true;
    }
    
}