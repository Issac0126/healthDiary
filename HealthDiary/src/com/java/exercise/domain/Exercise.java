package com.java.exercise.domain;

public class Exercise {
	private String exerciseName;
	
	public Exercise() {}
	
	public Exercise(String exerciseName) {
		super();
		this.exerciseName = exerciseName;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	@Override
	public String toString() {
		
		return super.toString();
	}
	
	
	
}
