package com.aws.connectinssh;

import java.io.IOException;



import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

public class GetAccSummary {
	String res="";
	public String getAccountSummary(String ip) throws JSONException {
		// TODO Auto-generated method stub
//		String URL ="";
//Client client = ClientBuilder.newClient();
//WebTarget target = client.target("https://vptko29mdl.execute-api.us-east-2.amazonaws.com/cmdTest2/?user_instance=13.59.96.118&instance_user=ubuntu&user_input=help");
//	System.out.println(target.request(MediaType.APPLICATION_JSON).get(String.class));
JSONObject jsonString = new JSONObject()
	.put("user_instance", ip)
	.put("instance_user", "ubuntu")
	.put("method", "summary");
System.out.println(jsonString);
//System.out.println(target.request(MediaType.APPLICATION_JSON).post(Entity.json(jsonString)));
//Response response = target.request().post(Entity.json(jsonString));
//System.out.println(response.toString());
  /* String response = target.request()
             .post(Entity.entity(jsonString, MediaType.APPLICATION_JSON)
                       , String.class);
   System.out.println(response);*/
HttpClient httpClient = new DefaultHttpClient(); //Use this instead 

try {

    HttpPost request = new HttpPost("https://0z116z3019.execute-api.us-east-2.amazonaws.com/finassist");
    StringEntity params =new StringEntity(jsonString.toString());
    request.addHeader("content-type", "application/x-www-form-urlencoded");
    request.setEntity(params);
    HttpResponse response = httpClient.execute(request);
    res = new BasicResponseHandler().handleResponse(response);
    System.out.println(res+"00000000000000000000000000000");
    JSONObject jo = new JSONObject(res);
System.out.println(jo+"11111111111111111");
System.out.println(jo.sortedKeys().next()+"3333333333333");

    //handle response here...

}catch (Exception ex) {

    //handle exception here

} finally {
    //Deprecated
    //httpClient.getConnectionManager().shutdown(); 
}
return res;
	
	}

}