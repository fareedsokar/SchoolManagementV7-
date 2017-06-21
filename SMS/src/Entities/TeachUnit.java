package Entities;

import java.io.Serializable;

public class TeachUnit implements Serializable {
	
	private int TeachUnit_ID;
	private String TeachUnit_Name;
	
	public TeachUnit(int TeachUnit_ID,String TeachUnit_Name)
	{
		setTeachUnit_ID(TeachUnit_ID);
		setTeachUnit_Name(TeachUnit_Name);
	}
	
	public int getTeachUnit_ID() {
		return TeachUnit_ID;
	}
	public void setTeachUnit_ID(int teachUnit_ID) {
		TeachUnit_ID = teachUnit_ID;
	}
	public String getTeachUnit_Name() {
		return TeachUnit_Name;
	}
	public void setTeachUnit_Name(String teachUnit_Name) {
		TeachUnit_Name = teachUnit_Name;
	}

}
