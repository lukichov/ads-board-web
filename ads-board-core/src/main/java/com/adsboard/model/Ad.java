package com.adsboard.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Project <b>Ads board</b>.
 *
 * This Entity Class describes the Ad entity
 *
 * @author Oleksandr Lukichov
 *
 * @since October 19, 2015
 *
 */
@Entity
@Table(name = "ads")
public class Ad implements Serializable, Comparable<Ad> {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ad_id")
	private Integer adId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "ad_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date adDate;

	@ManyToOne
	@JoinColumn(name = "rubric_id")
	private Rubric rubric;

	@Transient
	private Integer rubricId;

	@NotNull
	@Size(min = 10, max = 30, message = "Заголовок должен быть длиной от 10 до 30 символов!")
	@Column(name = "ad_header")
	private String adHeader;

	@NotNull
	@Size(min = 20, max = 400, message = "Текст объявления должен быть длиной от 20 до 400 символов!")
	@Column(name = "ad_text")
	private String adText;

	public Ad() {
	}

	public Ad(Integer adId) {
		this.adId = adId;
	}

	public Ad(Integer adId, User user, Rubric rubric) {
		this.adId = adId;
		this.user = user;
		this.rubric = rubric;
	}

	public Ad(Integer adId, User user, Date adDate, Rubric rubric, String adHeader, String adText) {
		super();
		this.adId = adId;
		this.user = user;
		this.adDate = adDate;
		this.rubric = rubric;
		this.adHeader = adHeader;
		this.adText = adText;
	}

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getAdDate() {
		return adDate;
	}

	public void setAdDate(Date adDate) {
		this.adDate = adDate;
	}

	public Rubric getRubric() {
		return rubric;
	}

	public void setRubric(Rubric rubric) {
		this.rubric = rubric;
	}

	public String getAdHeader() {
		return adHeader;
	}

	public void setAdHeader(String adHeader) {
		this.adHeader = adHeader;
	}

	public String getAdText() {
		return adText;
	}

	public void setAdText(String adText) {
		this.adText = adText;
	}

	public Integer getRubricId() {
		return rubricId;
	}

	public void setRubricId(Integer rubricId) {
		this.rubricId = rubricId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adDate == null) ? 0 : adDate.hashCode());
		result = prime * result + ((adHeader == null) ? 0 : adHeader.hashCode());
		result = prime * result + ((adId == null) ? 0 : adId.hashCode());
		result = prime * result + ((adText == null) ? 0 : adText.hashCode());
		result = prime * result + ((rubric == null) ? 0 : rubric.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ad))
			return false;
		Ad other = (Ad) obj;
		if (adDate == null) {
			if (other.adDate != null)
				return false;
		} else if (!adDate.equals(other.adDate))
			return false;
		if (adHeader == null) {
			if (other.adHeader != null)
				return false;
		} else if (!adHeader.equals(other.adHeader))
			return false;
		if (adId == null) {
			if (other.adId != null)
				return false;
		} else if (!adId.equals(other.adId))
			return false;
		if (adText == null) {
			if (other.adText != null)
				return false;
		} else if (!adText.equals(other.adText))
			return false;
		if (rubric == null) {
			if (other.rubric != null)
				return false;
		} else if (!rubric.equals(other.rubric))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ad [adId=" + adId + ", user=" + user + ", adDate=" + adDate + ", rubric=" + rubric + ", rubricId="
				+ rubricId + ", adHeader=" + adHeader + ", adText=" + adText + "]";
	}

	public int compareTo(Ad o) {
		if (this.adDate.before(o.adDate)) {
			return -1;
		} else if (this.adDate.after(o.adDate)) {
			return 1;
		}
		return 0;
	}

}
