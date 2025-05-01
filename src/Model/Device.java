package Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Device {
    private String id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String deviceName;
    private String deviceType;
    private LocalDate purchaseDate;
    private String supplier;
    private BigDecimal price;
    private DeviceStatus status;
    private Room room;
    private int quantity;
    private boolean deleted;

    // Constructor
    public Device(String id, LocalDate createdAt, LocalDate updatedAt, String deviceName, String deviceType,
                  LocalDate purchaseDate, String supplier, BigDecimal price, DeviceStatus status, Room room,
                  int quantity, boolean deleted) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.purchaseDate = purchaseDate;
        this.supplier = supplier;
        this.price = price;
        this.status = status;
        this.room = room;
        this.quantity = quantity;
        this.deleted = deleted;
    }

    public Device() {}

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
    public LocalDate getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDate updatedAt) { this.updatedAt = updatedAt; }
    public String getDeviceName() { return deviceName; }
    public void setDeviceName(String deviceName) { this.deviceName = deviceName; }
    public String getDeviceType() { return deviceType; }
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public DeviceStatus getStatus() { return status; }
    public void setStatus(DeviceStatus status) { this.status = status; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public boolean isDeleted() { return deleted; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }
}