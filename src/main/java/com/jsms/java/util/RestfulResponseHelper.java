package com.jsms.java.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jsms.java.model.RestfulResponse;

@Component
public class RestfulResponseHelper {

	public List<RestfulResponse> constructRestfulResponse(RestfulResponse response){
		List<RestfulResponse> lstResponse = new ArrayList<RestfulResponse>();
		lstResponse.add(response);
		return lstResponse;
	}
}
