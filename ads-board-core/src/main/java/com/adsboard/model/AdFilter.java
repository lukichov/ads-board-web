package com.adsboard.model;

/**
 * Project <b>Ads board</b>.
 *
 * This Class describes the AdFilter 
 * The AdFilter is using for filtering lists of ads
 *
 * @author Oleksandr Lukichov
 *
 * @since October 19, 2015
 *
 */

public class AdFilter  {
	
	private String username;

	private Integer rubricId;
	
	private Boolean checked;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getRubricId() {
		return rubricId;
	}

	public void setRubricId(Integer rubricId) {
		this.rubricId = rubricId;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "AdFilter [username=" + username + ", rubricId=" + rubricId + ", checked=" + checked + "]";
	}

	
}
