package com.ssd.esprithub.Services;

import java.util.List;
import com.ssd.esprithub.entity.Response;








public interface IResponseService {
	
	Response addResponse (Response r);
	List<Response> retrieveResponses();

	

	void deleteResponse(Long id);

	Response updateResponse(Response u);

	Response retrieveResponse(Long id);

}
