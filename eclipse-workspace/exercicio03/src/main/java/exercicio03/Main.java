package exercicio03;

public class Main {
	package com.exemplo.produto;  

	import static spark.Spark.*;
	import com.google.gson.Gson;
	import java.util.HashMap;
	import java.util.Map;

	public class Main {
	    private static Gson gson = new Gson();
	    
	    public static void main(String[] args) {
	        port(4567);
	        staticFiles.location("/static");
	        
	        
	        Map<Integer, Map<String, Object>> produtos = new HashMap<>();
	        int nextId = 1;
	        
	        
	        options("/*", (request, response) -> {
	            response.header("Access-Control-Allow-Headers", "*");
	            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
	            return "OK";
	        });
	        
	        before((request, response) -> {
	            response.header("Access-Control-Allow-Origin", "*");
	            response.header("Content-Type", "application/json");
	        });
	        
	        
	        get("/api/produtos", (req, res) -> {
	            return gson.toJson(produtos.values());
	        });
	        
	        post("/api/produtos", (req, res) -> {
	            Map<String, Object> produto = gson.fromJson(req.body(), Map.class);
	            produto.put("id", nextId);
	            produtos.put(nextId, produto);
	            nextId++;
	            return gson.toJson(produto);
	        });
	        
	      
	        
	        System.out.println("🚀 Servidor rodando em http://localhost:4567");
	    }
	}

}
