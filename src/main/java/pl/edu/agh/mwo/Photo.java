package pl.edu.agh.mwo;

import java.util.ArrayList;

public class Photo {
	private ArrayList<String> commentList = new ArrayList<>();
	


	public Photo(){}

	
	
	public ArrayList<String> getCommentList() {
		return commentList;
	}

	
	public void addComment(String comment) {
		
		StringBuilder s = new StringBuilder();
		s.append(comment);
		
		commentList.add(s.toString());
	}

}
