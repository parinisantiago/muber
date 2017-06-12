package bd2.Muber.dto;

import bd2.Muber.model.Score;

public class ScoreDTO {
	
	private String comment;
	private Integer score;
	private long id;
	
	public ScoreDTO(Score score){
		this.comment = score.getComment();
		this.score = score.getScore();
		this.id = score.getId();
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
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
}
