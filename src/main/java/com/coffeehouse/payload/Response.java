package com.coffeehouse.payload;

import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
public class Response {
    private boolean success = false;
    private String message = "";
    private Object data;

    public Response() {

    }

    public Response(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static ResponseEntity<Response> response(boolean success, String message, Object data) {
        return ResponseEntity.ok(new Response(success, message, data));
    }
}

