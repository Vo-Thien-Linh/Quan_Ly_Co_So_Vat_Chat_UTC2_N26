package Model;

import java.util.Date;

public class UsageHistory {
    private String idHistory;
    private String idAsset;
    private String assetType;
    private String user;
    private Date startTime;
    private Date endTime;
    private String purpose;
    private String status;
    private static int idCounter = 0;

    public UsageHistory(String idHistory, String idAsset, String assetType, String user, Date startTime, Date endTime,
			String purpose, String status) {
		super();
		this.idHistory = idHistory;
		this.idAsset = idAsset;
		this.assetType = assetType;
		this.user = user;
		this.startTime = startTime;
		this.endTime = endTime;
		this.purpose = purpose;
		this.status = status;
	}

	public String getIdHistory() {
		return idHistory;
	}

	public void setIdHistory(String idHistory) {
		this.idHistory = idHistory;
	}

	public String getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}

	public String getAssetType() {
		return assetType;
	}


	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		UsageHistory.idCounter = idCounter;
	}

	public void addHistory() {
        System.out.println("Thêm lịch sử sử dụng: ID=" + idHistory + ", Vật chất=" + idAsset + ", Người dùng=" + user);
    }

    public void viewHistory() {
        System.out.println("Lịch sử sử dụng: ID=" + idHistory + ", Vật chất=" + idAsset + ", Loại=" + assetType + ", Người dùng=" + user + ", Mục đích=" + purpose);
    }

    public void updateHistory() {
        System.out.println("Cập nhật lịch sử sử dụng: ID=" + idHistory);
    }
}
