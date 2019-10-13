package dev.ateam.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "computer_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="quartermaster_id")
	private int qmId; //Quartermaster ID
	
	@Column(name="requester_id")
	private int	rId; //User requester ID
	
	@Column(name="assembler_id")
	private int aId; //Assembler ID
	
//	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)	
//	@JoinColumn(name ="build_id")
//	//@JoinColumn(name ="build.b_id")
//	private Build build;
	
	@Column(name="build")
	private String build;
	
	@Column(name="status")
	private String status;
	
	@Column(name="request_details")
	private String requestDetails;
	
	public Order(int orderId, int qmId, int rId, int aId, String build, String status, String requestDetails) {
		super();
		this.orderId = orderId;
		this.qmId = qmId;
		this.rId = rId;
		this.aId = aId;
		this.build = build;
		this.status = status;
		this.requestDetails = requestDetails;
	}
	public Order() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getQmId() {
		return qmId;
	}
	public void setQmId(int qmId) {
		this.qmId = qmId;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getBuild() {
		return build;
	}
	public void setBuild(String build) {
		this.build = build;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRequestDetails() {
		return requestDetails;
	}
	public void setRequestDetails(String requestDetails) {
		this.requestDetails = requestDetails;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", qmId=" + qmId + ", rId=" + rId + ", aId=" + aId + ", build=" + build
				+ ", status=" + status + ", requestDetails=" + requestDetails + "]";
	}

	
	
}
