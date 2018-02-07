package co.uk.moj.modal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Response {

	private Map<String,List> resultAnagrams = new HashMap<>();

	private String message;

	public Response(){}
	public Response(String msg){
		this.message = msg;
	}

	public Map<String, List> getResultAnagrams() {
		return resultAnagrams;
	}
}
