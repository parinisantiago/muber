package model;

public final class Score {
	
	private Long id;
	private String comment;
	private Integer score;
	
	public Score(Long id, String comment, Integer score) {
		super();
		this.id = id;
		this.comment = comment;
		this.score = score;
	}

	public Score() {
		super();
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
}
