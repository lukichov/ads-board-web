package com.adsboard.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Project <b>Ads board</b>. 
 *
 * This Entity Class describes the Rubric entity
 *
 * @author Oleksandr Lukichov
 *
 * @since October 19, 2015
 *
 */
@Entity
@Table(name = "rubrics")
public class Rubric implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rubric_id")
    private Integer rubricId;
    @Column(name = "rubric_name")
    private String rubricName;

    public Rubric() {
    }

    public Rubric(Integer rubricId) {
        this.rubricId = rubricId;
    }

    public Integer getRubricId() {
        return rubricId;
    }

    public void setRubricId(Integer rubricId) {
        this.rubricId = rubricId;
    }

    public String getRubricName() {
        return rubricName;
    }

    public void setRubricName(String rubricName) {
        this.rubricName = rubricName;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rubricId == null) ? 0 : rubricId.hashCode());
		result = prime * result + ((rubricName == null) ? 0 : rubricName.hashCode());
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
		if (!(obj instanceof Rubric)) {
			return false;
		}
		Rubric other = (Rubric) obj;
		if (rubricId == null) {
			if (other.rubricId != null) {
				return false;
			}
		} else if (!rubricId.equals(other.rubricId)) {
			return false;
		}
		if (rubricName == null) {
			if (other.rubricName != null) {
				return false;
			}
		} else if (!rubricName.equals(other.rubricName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Rubric [rubricId=" + rubricId + ", rubricName=" + rubricName + "]";
	}

    
    
}
