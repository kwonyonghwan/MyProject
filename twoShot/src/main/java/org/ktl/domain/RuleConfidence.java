package org.ktl.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RuleConfidence {

	HashSet<Integer> start;
	HashSet<Integer> end;
	private Double confidence;
	
	// 규칙 및 신뢰도 저장
	public RuleConfidence() {
		
		this.start = new HashSet<Integer>();
		this.end = new HashSet<Integer>();
		this.confidence = 0.6;
	}

	// getter & setter
	public HashSet<Integer> getStart() {
		return start;
	}

	public void setStart(HashSet<Integer> start) {
		this.start = start;
	}

	public HashSet<Integer> getEnd() {
		return end;
	}

	public void setEnd(HashSet<Integer> end) {
		this.end = end;
	}

	public Double getConfidence() {
		return confidence;
	}

	public void setConfidence(Double confidence) {
		this.confidence = confidence;
	}

	@Override
	public String toString() {
		return "RuleConfidene [start=" + start + ", end=" + end + ", confidence=" + confidence + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RuleConfidence other = (RuleConfidence) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}
	
}
