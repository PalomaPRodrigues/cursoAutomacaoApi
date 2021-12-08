package api;

import io.restassured.response.Response;
import org.json.JSONObject;
import utils.LogUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApiUtils extends LogUtils {

    protected static Response response;
    protected static JSONObject body;
    protected static String uri;
    protected static Map<String, String> hearders = new HashMap<>();
    protected static Map<String, String> params = new HashMap<>();
    protected static String token;

    public void log (String verbo){

        super.logInfo(" ******* Dados enviados no request *******");
        super.logInfo(verbo + "" + uri);
        super.logInfo("Body : \n" + body);
        super.logInfo("Headers : " + hearders);
        super.logInfo(" Params :" + params);

        super.logInfo(" ******* Dados enviados no request *******");
        super.logInfo("Status code" + response.statusCode());
        super.logInfo("Payload recebido : \n" + response.asPrettyString());
        super.logInfo("Headers : " + response.timeIn(TimeUnit.MILLISECONDS));

    }



}
