package dev.ateam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="build")
public class Build {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="b_id")
	private int b_Id;
	
	@Column(name="part_list")
	private String partList;
	
	//private List<Parts> partsList = new ArrayList<Parts>();

//	public Build(int b_Id, String partList, List<Parts> partsList) {
//		super();
//		this.b_Id = b_Id;
//		this.partList = partList;
//		this.partsList = partsList;
//	}
	
	
	

	public Build(int b_Id, String partList) {
		super();
		this.b_Id = b_Id;
		this.partList = partList;
	}

	public Build() {
		super();
	}

	public int getB_Id() {
		return b_Id;
	}

	public void setB_Id(int b_Id) {
		this.b_Id = b_Id;
	}

	public String getPartList() {
		return partList;
	}
//
	public void setPartList(String partList) {
		this.partList = partList;
	}
//
//	public List<Parts> getPartsList() {
//		return partsList;
//	}
//
//	public void setPartsList(List<Parts> partsList) {
//		this.partsList = partsList;
//	}
//
//	@Override
//	public String toString() {
//		return "Build [b_Id=" + b_Id + ", partList=" + partList + ", partsList=" + partsList + "]";
//	}

	
	
	
	
	
	
}
