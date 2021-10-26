package mx.uv;


import static spark.Spark.*;
import com.google.gson.*;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Map;
import java.util.UUID;
import java.util.HashMap;

public class App 
{
    private static Gson gson = new Gson();
    private static Map<String, Usuario> usuarios = new HashMap<>();
    public static void main( String[] args )
    {

        

        System.out.println( "Hello World!" );

        staticFiles.location("/");
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "respuesta");
        get("/hola", (req, res) -> "Hola mundo");
        get("/pagina", (req, res) -> {
            res.redirect("pagina.html");
            return null;
        });

        post("/usuario", (req, res) -> {
            String payload = req.body();
            String id = UUID.randomUUID().toString();
            Usuario u = gson.fromJson(payload, Usuario.class);
            u.setId(id);
            
            usuarios.put(id, u);

            JsonObject objetoJson = new JsonObject();
            objetoJson.addProperty("status", "ok");
            objetoJson.addProperty("id", id);
                        
            return objetoJson;
        });

        get("/usuarios", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("usuarios", usuarios.values());
            return new VelocityTemplateEngine().render(new ModelAndView(model, "velocity.vm"));
        });
        
            
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    
}
