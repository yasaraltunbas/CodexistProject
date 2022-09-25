package com.project.CodexistProject.entity;

import java.util.ArrayList;


public class Places {

	
	
	
	
	 public ArrayList<Object> html_attributions;
	    public ArrayList<Result> results;
	    public String status;
		public ArrayList<Object> getHtml_attributions() {
			return html_attributions;
		}
		public void setHtml_attributions(ArrayList<Object> html_attributions) {
			this.html_attributions = html_attributions;
		}
		public ArrayList<Result> getResults() {
			return results;
		}
		public void setResults(ArrayList<Result> results) {
			this.results = results;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Places(ArrayList<Object> html_attributions, ArrayList<Result> results, String status) {
			super();
			this.html_attributions = html_attributions;
			this.results = results;
			this.status = status;
		}
		public Places() {
			super();
		}
	    
	
}

